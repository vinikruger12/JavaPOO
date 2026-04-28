class Pagamento:
    def __init__(self, metodo: str, valor: float, pago: bool):
        self.metodo = metodo
        self.valor = valor
        self.pago = pago
    
    def __str__(self):
        return "Metodo: {} - Valor: {} - Pago: {}".format(self.metodo, self.valor, self.pago)
        