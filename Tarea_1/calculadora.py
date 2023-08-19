import re
import math
from collections import deque

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
    

problemas = open("problemas.txt", "r")
desarollo_txt = open("desarollo.txt", "w")
lineas = problemas.readlines()
print(lineas)

digito = r'[1-9]' 
digito_o_zero = rf'{digito}|0'
entero = r'(?:[1-9][0-9]*|0)'
espacio = r'‘ ‘' 
operador = r'\s*([-+*]|//)\s*'
s_ans = r'ANS\s*'
operacion = rf'({s_ans}|{entero})\s*({operador})\s*({s_ans}|{entero})'
sentencia = r'^\s*(ANS|[1-9][0-9]*|0)\s*(-|\+|\*|//)\s*((?:[1-9][0-9]*|0)|(?:ANS))\s*(?:(-|\+|\*|//)\s*((?:[1-9][0-9]*|0)|(?:ANS))\s*)*$'
salto = r"\n"
suma_ex = r'\+'
multi_ex = r'\*'
resta_ex = r'-'
busca_op = r's|\-|m|//'
cola_numero= deque()
cola_operacion = deque()
resultados_finales = deque()

ANS = 0

def resolver(linea):
#‘’’
#***
#* parametro_1: linea, es el string reconocido por la expresion regular 
#* 
#* …
#***
#Breve descripción de qué hace la función y qué retorna.
#Esta funcion lo que hace es que resuelve la linea identificada con los calculos necesarios y los escribe en el archivo de texto desarrollos.txt
#No retorna nada
#‘’’

    linea_inicial = ""
    linea_error = ""
    global ANS
    string_ans = str(ANS)
    total = 0
    numero_final = ""
    flag_error = False

    for lineas in linea:
        suma_cambio = re.sub(suma_ex,"s",linea)
        ans_cambio = re.sub(s_ans, string_ans, suma_cambio)
        nueva_linea = re.sub(multi_ex,"m",ans_cambio)
    
    numeros = (re.findall(entero,nueva_linea))
 
    for valor in numeros:
        valor = int(valor)
        cola_numero.append(valor)
    print(cola_numero,"cola numero")
    

    if re.search(busca_op, nueva_linea) is not None:
        operaciones = re.findall(busca_op, nueva_linea)
        for x in operaciones:
                cola_operacion.append(x)
                

    print(cola_operacion, "cola operacion antes de entrar")
    while len(cola_operacion) != 0 and flag_error is False:
        if ANS == "error":
            for x in linea:
                if x != "\n":
                    linea_error += x

            desarollo_txt.write(linea_error)
            desarollo_txt.write(" = ")
            desarollo_txt.write("Sin resolver")
            desarollo_txt.write("\n")


            while cola_operacion:
                oper = cola_operacion.popleft()
            break
        oper = cola_operacion.popleft()

        if len(resultados_finales) != 0 :
            numero_1 = resultados_finales.popleft()
            numero_2 = cola_numero.popleft()
            
        else:
            numero_1 = cola_numero.popleft()
            
            numero_2 = cola_numero.popleft()
        print(cola_operacion, "cola operacion")
        print(oper,"oper")
        if oper == "m":
            print(resultados_finales,"resultado finales")
            print(cola_numero,"cola numero en m")
            print(cola_operacion, "cola operacion")
            numero = numero_1 * numero_2
            print(numero,"numero")
            if numero < 0:
                numero = 0
            resultados_finales.append(numero)


            if len(cola_operacion) != 0:
                oper = cola_operacion.popleft()
            else:
                break
            
            if len(resultados_finales) != 0 :
                numero_1 = resultados_finales.popleft()
                
                numero_2 = cola_numero.popleft()
            else:
                numero_1 = cola_numero.popleft()
                
                numero_2 = cola_numero.popleft()
                
            if oper == "s":
                numero = numero_1 + numero_2
                if numero < 0:
                    numero = 0
                resultados_finales.append(numero)
            elif oper == "-":
                numero = numero_1 - numero_2
                if numero < 0:
                    numero = 0
                resultados_finales.append(numero)

        elif oper == "//":
            if numero_2 != 0:
                numero = int(numero_1/numero_2)
                if numero < 0:
                    numero = 0
                resultados_finales.append(numero)
                if len(cola_operacion) != 0:
                    oper = cola_operacion.popleft()
                else:
                    break
            
                if len(resultados_finales) != 0 :
                    numero_1 = resultados_finales.popleft()
                
                    numero_2 = cola_numero.popleft()
                else:
                    numero_1 = cola_numero.popleft()
                
                    numero_2 = cola_numero.popleft()
                
                if oper == "s":
                    numero = numero_1 + numero_2
                    if numero < 0:
                        numero = 0
                    resultados_finales.append(numero)
                elif oper == "-":
                    numero = numero_1 - numero_2
                    if numero < 0:
                        numero = 0
                    resultados_finales.append(numero)
            else:
                for x in linea:
                    if x != "\n":
                        linea_error += x

                desarollo_txt.write(linea_error)
                desarollo_txt.write(" = ")
                desarollo_txt.write("Error")
                desarollo_txt.write("\n")
                ANS = "error"
                while cola_operacion:
                    oper = cola_operacion.popleft()
                    print(cola_operacion,"dentro del while")
                    
                flag_error = True

            
        elif oper == "s":
            numero = numero_1 + numero_2
            if numero < 0:
                numero = 0
            resultados_finales.append(numero)

        elif oper == "-":
            numero = numero_1 - numero_2
            if numero < 0:
                numero = 0
            resultados_finales.append(numero)


    for x in linea:
        if x != "\n":
            linea_inicial += x

    if len(resultados_finales) != 0:    
        ANS = resultados_finales.popleft()
        string_ans = str(ANS)
        print(ANS, 'resultado final de la operacion')
        desarollo_txt.write(linea_inicial)
        desarollo_txt.write(" = ")
        desarollo_txt.write(string_ans)
        desarollo_txt.write("\n")
        
    while resultados_finales:
        elemento = resultados_finales.popleft()
    while cola_numero:
        elemento = cola_numero.popleft()



for x in lineas:
    resultado = re.search(sentencia, x)
    salto_encontrado = re.search(salto,x)
    if resultado:
        elemento = resultado.group()
        print(elemento,"aqui elemento")
        resolver(elemento)
        print('termine una linea')

    elif salto:
        desarollo_txt.write("\n")
        print("salto xd")
        ANS = 0


problemas.close()
desarollo_txt.close()

