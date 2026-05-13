from abc import ABC

class Pessoa(ABC):
    def __init__(self, nome):
        self.nome = nome
    def __repr__(self):
        return 'Pessoa: {}'.format(self.nome)
