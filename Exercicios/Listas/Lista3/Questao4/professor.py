from pessoa import Pessoa

class Professor(Pessoa):
    def __init__(self, nome, salario):
        super().__init__(nome)
        self.salario = salario

    def __repr__(self):
        return 'Nome: {} - Salário: {}'. format(self.nome, self.salario) 