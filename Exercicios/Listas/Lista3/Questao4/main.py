from pessoa import Pessoa
from aluno import Aluno
from professor import Professor

pessoa = Pessoa('Pessoa Teste')

print(pessoa.__repr__())

aluno = Aluno('Aluno Teste')
aluno.incluirNota(10)
aluno.incluirNota(5)
print(aluno)

professor = Professor('Professor Teste', 3500)
print(professor)