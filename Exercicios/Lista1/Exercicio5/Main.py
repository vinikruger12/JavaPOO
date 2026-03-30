from Seguro import Seguro
from Pagamento import Pagamento

seguro1 = Seguro("Contra danos leve", 600.0, True)
pagamento1 = Pagamento("Debito", 600.0, True)

seguro2 = Seguro("Contra danos pesados", 1200.0, False)
pagamento2 = Pagamento("Dinheiro a vista", 200.0, True)

print(seguro1)
print(pagamento1)
print("\n")
print(seguro2)
print(pagamento2)