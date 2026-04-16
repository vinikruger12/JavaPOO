import json

class Filme:
    def __init__(self):
        self.titulo = ""
        self.ano = 0
        self.classificacao = ""
        self.nota = 0.0

    def carregar_do_json(self, dados_json):
        self.titulo = dados_json['titulo']
        self.ano = dados_json['ano']
        self.classificacao = dados_json['classificacao']
        self.nota = dados_json['nota']

    def __str__(self):
        return f"{self.titulo} ({self.ano}) | Classificação: {self.classificacao} | Nota: {self.nota}"


string_json = """
[
    {
        "titulo": "A Rainy Day in New York",
        "ano": 2019,
        "classificacao": "PG-13",
        "nota": 6.6
    },
    {
        "titulo": "Jurassic World: Fallen Kingdom",
        "ano": 2018,
        "classificacao": "PG-13",
        "nota": 6.2
    },
    {
        "titulo": "2001: A Space Odyssey",
        "ano": 1968,
        "classificacao": "G",
        "nota": 8.3
    },
    {
        "titulo": "Toy Story 4",
        "ano": 2019,
        "classificacao": "G",
        "nota": 7.8
    }
]
"""

lista_dicionarios = json.loads(string_json)

lista_filmes = []

for dicionario in lista_dicionarios:
    filme = Filme()
    filme.carregar_do_json(dicionario)
    lista_filmes.append(filme) 

lista_filmes.sort(key=lambda f: f.nota, reverse=True)

print("--- RANKING DE FILMES ---")
for filme in lista_filmes:
    print(filme)