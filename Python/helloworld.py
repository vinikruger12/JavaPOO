def mul(x,y):
    return x*y

def oMundoVaiAcabarHoje() -> str:
    return "Acho que não"

print("Hello World")
a = int(input())
if(a > 5):
    print(str(a) + ' é maior que 5')
else:
    print(str(a) + " não é maior que 5")

nomes = ["Vinicius", "Kruger"]

for nome in nomes:
    print(nome)

print(mul(a,10))
s = oMundoVaiAcabarHoje()
print(s)


