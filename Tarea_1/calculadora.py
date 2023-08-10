import re
import math

#lo cambie ahora xd

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
    print(suma_t)

ANS = 0

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
        suma_t = 0
        numeros = (re.findall(num,x))
        print(numeros,"suma xd")
        op_suma(numeros)
        
    elif res:
        numeros = (re.findall(num,x))
        #numero_int = int(numeros)
        print(numeros, "resta xd")

    elif x == "\n":
        print("se acaba")
        ANS = 0
    


   



#def op_resta(x,y):


#def op_mult(x,y):


#def op_div(x,y):





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
    




    



