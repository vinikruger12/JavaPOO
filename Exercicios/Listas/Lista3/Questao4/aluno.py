from pessoa import Pessoa

class Aluno(Pessoa):
    def __init__(self, nome):
        super().__init__(nome)
        self.notas = []

    def incluirNota(self, nota):
        self.notas.append(nota)
    
    def calcularMedia(self):
        media = 0.0
        for i in self.notas:
            media += i
        return media/len(self.notas)

    def __repr__(self):
        return 'Nome Aluno: {} - Media: {}'. format(self.nome, self.calcularMedia()) 