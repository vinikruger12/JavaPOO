class Seguro:
    def __init__(self, tipo: str, valor: float, ativo: bool):
        self.tipo = tipo
        self.valor = valor
        self.ativo = ativo

    def __str__(self):
        return "Tipo: {} - Valor: {} - Ativo: {}".format(self.tipo, self.valor, self.ativo)
        
    