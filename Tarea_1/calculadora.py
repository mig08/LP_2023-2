import re
import math
from collections import deque



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
    


   

#def op_resta(x,y):


#def op_mult(x,y):


#def op_div(x,y):

ANS = 0

problemas = open("problemas (EJEMPLO).txt", "r")
desarollo_txt = open("desarollo.txt", "w")
lineas = problemas.readlines()
print(lineas)

digito = r'[1-9]' 
digito_o_zero = rf'{digito}|0'
entero = r'(?:[1-9][0-9]*|0)'
espacio = r'‘ ‘' 
operador = r'\s*([-+*/]{1,2})\s*'
s_ans = r'ANS\s*'
#operacion = r'(\d+)\s*([+-/*])\s*(\d+)\n'
operacion = rf'({s_ans}|{entero})\s*({operador})\s*({s_ans}|{entero})'
#operacion = r'^(ANS|\d+)\s*([-+*/]{1,2})\s*(ANS|\d+)$'
sentencia = rf'({operacion})(?:{operador}({s_ans}|{entero})*)'
#sentencia = r'^\s*(ANS|\d+)\s*([-+*/]{1,2})\s*((\d+)|(ANS))\s*$'
sentencia = r'^\s*(ANS|\d+)\s*([-+*/]{1,2})\s*((?:\d+)|(?:ANS))\s*(?:([-+*/]{1,2})\s*((?:\d+)|(?:ANS))\s*)*$'
#sentencia = r'\s*(ANS|\d+)\s*([-+*/]{1,2})\s*((?:\d+)|(?:ANS))\s*'
#sentencia = rf'{operacion}(?:({operador}({entero}|{s_ans}))*)'
#sentencia = rf'{operacion}({operador}(({entero})|({s_ans})))*'
salto = r"\n"
sent = re.compile(sentencia)
operador_str = re.compile(operador)
suma_ex = r'\+'
multi_ex = r'\*'
resta_ex = r'-'
busca_su_res = r's|\-'
busca_multi = r'm'
busca_resta = r'resta'
busca_divi = r'divi'
cola_numero= deque()
cola_operacion = deque()
resultados_finales = deque()
# Expresión regular compuesta
#expresion_completa = rf'({numero_expresion})\s*({apple_expresion})'

def resolver(linea):
    mini_ans = r'A'
    total = 0
    numero_final = ""
    num = 0
    num_ant = 0
    n = 1
    lista_num = []
    linea = linea
    #print(linea, 'esto quiero ver')
    for lineas in linea:
        suma_cambio = re.sub(suma_ex,"s",linea)
        nueva_linea = re.sub(multi_ex,"m",suma_cambio)
    
   # for x in nueva_linea:
    numeros = (re.findall(entero,nueva_linea))
    #print(numeros, 'aaaaa')
    while n != 0:
        for valor in numeros:
            valor = int(valor)
            cola_numero.append(valor)
        if len(resultados_finales) != 0 :
            numero_1 = resultados_finales.popleft()
        else:
            numero_1 = cola_numero.popleft()
        nuemero_2 = cola_numero.popleft()
        if re.search(busca_su_res, nueva_linea) is not None:
            operaciones = re.findall(busca_su_res, nueva_linea)
            for x in operaciones:
                cola_operacion.append(x)
            if len(cola_operacion) != 0:
                oper = cola_operacion.popleft()
                if oper == 's':
                    numero = numero_1 + nuemero_2
                    resultados_finales.append(numero)
                elif oper == "-":
                    numero = numero_1 - nuemero_2
                    resultados_finales.append(numero)
            elif len(cola_operacion) == 0:
                print(resultados_finales, 'resultado final')
                n = 0            
    #ans_encontrado = re.match(mini_ans,x)

    #if ans_encontrado:                           #añadir valor de ans a la lista
    #    lista_num.append(ANS)

    if len(numeros) == 0 and numero_final != '': #agregar numeros a la lista
        num = int(numero_final)
        lista_num.append(num)
        if len(lista_num) != 0:
            num_ant = lista_num[len(lista_num)-2]
        numero_final = ""

    for digito in numeros:
        numero_final += digito

    #for ope in x:
    #    if ope == "s":
    #        #print(num_ant,"num ant en suma")
    #        total += num_ant
    #        #print("entre en suma")
#
    #    elif ope == "-":
    #        #print(num_ant, "num ant en resta")
    #        total -= num_ant
     #       #print("entre en resta")
    WA = resultados_finales.popleft()
    print(WA, 'ressultado final de la operacion')



for x in lineas:
    resultado = re.search(sentencia, x)
    salto_encontrado = re.search(salto,x)
    if resultado:
        elemento1 = resultado.group()
        elemento_lista = re.finditer(sentencia,x)
        resolver(elemento1)
        print('termine una linea')
    elif salto:
        print("salto xd")
        ANS = 0




















#for x in lineas:
#    multi = re.search(mult,x)
#    divi = re.search(div,x)
#    sum = re.search(suma,x)
#    res = re.search(resta,x)
#    if multi:
#        numeros = (re.findall(num,x))
#        #numero_int = int(numeros)
#        print(numeros, "multi xd")
#        sum = re.search(suma,x)
#        res = re.search(resta,x)
#        if sum:
#            numeros2 = (re.findall(num,x))
#            #numero_int = int(numeros)
#            print(numeros2,"suma en multi xd")
#        if res:
#            numeros2 = (re.findall(num,x))
#            #numero_int = int(numeros)
#            print(numeros2, "resta en multi xd")
#
#    elif divi:
#        numeros = (re.findall(num,x))
##        #numero_int = int(numeros)
#        print(numeros, "divi xd")
#        sum = re.search(suma,x)
#        res = re.search(resta,x)
#        if sum:
#            numeros2 = (re.findall(num,x))
#            #numero_int = int(numeros)
#            print(numeros2,"suma en multi xd")
#        if res:
#            numeros2 = (re.findall(num,x))
#            #numero_int = int(numeros)
#            print(numeros2, "resta en multi xd")
#    elif sum:
#        numeros = (re.findall(num,x))
#        print(numeros,"suma xd")
##       op_suma(numeros)
#        
##    elif res:
##        numeros = (re.findall(num,x))
#        #numero_int = int(numeros)
##        print(numeros, "resta xd")
#
#    elif x == "\n":
#        print("se acaba")
#        ANS = 0
    


   













    



