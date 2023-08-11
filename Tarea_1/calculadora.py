import re
import math
ANS = 0


#re.search(pattern, string): Busca el patrón en toda la cadena y devuelve un objeto Match si encuentra una coincidencia, o None si no la encuentra.
#
#re.match(pattern, string): Comprueba si el patrón coincide al principio de la cadena y devuelve un objeto Match o None.
#
#re.fullmatch(pattern, string): Comprueba si el patrón coincide con toda la cadena y devuelve un objeto Match o None.

#re.findall(pattern, string): Encuentra todas las ocurrencias del patrón en la cadena y devuelve una lista de coincidencias.
#
#re.finditer(pattern, string): Encuentra todas las ocurrencias del patrón en la cadena y devuelve un iterador de objetos Match.
#
#re.sub(pattern, replacement, string): Reemplaza todas las ocurrencias del patrón en la cadena con la cadena de reemplazo.
#
#re.split(pattern, string): Divide la cadena en partes utilizando el patrón como delimitador y devuelve una lista de partes.
#
#re.compile(pattern): Compila el patrón en un objeto de expresión regular, lo que permite mejorar el rendimiento al reutilizar el patrón en múltiples operaciones.
#
#Match objects: Los objetos devueltos por las funciones anteriores contienen información sobre la coincidencia, como el texto coincidente, la posición y otros detalles.

def op_suma(numeros):
    suma_t = 0
    for i in numeros:
        numero_int = int(i)
        suma_t += numero_int
    print(suma_t," suma_t")
    return suma_t

def op_resta(numeros):
    resta_t = 0
    for i in numeros:
        numero_int = int(i)
        resta_t -= numero_int
    print(resta_t," resta_t")
    return resta_t


#def op_mult(x,y):


#def op_div(x,y):



problemas = open("problemas (EJEMPLO).txt", "r")
desarollo_txt = open("desarollo.txt", "w")
lineas = problemas.readlines()
print(lineas)

salto = r"\n"
suma = r"\+"
resta = r"-"
mult = r"\*"
div = r"//"
num = r'\d+' #Encontrar digitos
s_ans = r"ANS"
parentesis_1 = r"("

for x in lineas:
    multi = re.search(mult,x)
    divi = re.search(div,x)
    sum = re.search(suma,x)
    res = re.search(resta,x)
    ans_buscar = re.search(s_ans,x)
    if multi:
        numeros = (re.findall(num,x))
        #numero_int = int(numeros)
        print(numeros, "multi xd")
        sum = re.search(suma,x)
        res = re.search(resta,x)
        if sum:
            numeros2 = (re.findall(num,x))
            #numero_int = int(numeros)
            print(numeros2,"suma en multi xd")
        if res:
            numeros2 = (re.findall(num,x))
            #numero_int = int(numeros)
            print(numeros2, "resta en multi xd")

    elif divi:
        numeros = (re.findall(num,x))
        #numero_int = int(numeros)
        print(numeros, "divi xd")
        sum = re.search(suma,x)
        res = re.search(resta,x)
        if sum:
            numeros2 = (re.findall(num,x))
            #numero_int = int(numeros)
            print(numeros2,"suma en multi xd")
        if res:
            numeros2 = (re.findall(num,x))
            #numero_int = int(numeros)
            print(numeros2, "resta en multi xd")
    elif sum:
        res = re.search(resta,x)
        numeros = (re.findall(num,x))
        print(numeros,"suma xd")
        ANS+=op_suma(numeros)
        print(ANS," ans suma")
        if res:
            numeros2 = (re.findall(num,x))
            if ans_buscar:
                numeros2.insert(0,ANS)
            print(numeros2, "resta en sum xd")
            ANS -= op_resta(numeros2)
        
    elif res:
        numeros = (re.findall(num,x))
        #numero_int = int(numeros)
        print(numeros, "resta xd")
        sum = re.search(suma,x)
        if sum:
            numeros2 = (re.findall(num,x))
            #numero_int = int(numeros)
            print(numeros2,"suma en resta xd")

    elif x == "\n":
        print("se acaba")
        print(ANS, "ans xdd")
        ANS = 0
    


   








def CUPON(x):
    resultado = x*0.20
    resultado = {math.trunc(resultado)}
    return resultado 

def CUPON(x,y):
    if y < 100:
        resultado = x*(y*100)
        resultado = {math.trunc(resultado)}
        return resultado
    else:
        return "error"
    