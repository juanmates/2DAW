print("NACHO ERES GILIPOLLAS");

suma = 0;

# EJERCICIO 1 CALCULAR LA MEDIA
print("CÁLCULO DE LA MEDIA DE DOS NÚMEROS")
num1 = float(input("Escriba un número:"))
num2 = float(input("Escriba un segundo número:"))
def media(num1, num2):
    return (num1 + num2)/2

print(f"La media aritmética de   {num1}   y   {num2}  es  {media(num1, num2)}")

# EJERCICIO 2 
print("---------------------------------")
print("CÁLCULO DEL ÍNDICE DE MASA CORPORAL (IMC)")
peso = int(input("¿Cuánto pesa?"))
talla = float(input("¿Cuánto mide en metros?"))

def calculoIMC(a, b):
    total = a/(b*b)
    return total

print(f"Su imc es {calculoIMC(peso, talla):.1f}")