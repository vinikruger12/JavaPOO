package dados;

import java.util.ArrayList;
import java.util.List;

public class Digrafo {
    private List<List<Integer>> matrizAdjacencia;

    public Digrafo() {
        this.matrizAdjacencia = new ArrayList<>();
    }

    public void adicionarVertice() {
        int novoTamanho = matrizAdjacencia.size() + 1;

        for (List<Integer> linha : matrizAdjacencia) {
            linha.add(0);
        }

        List<Integer> novaLinha = new ArrayList<>();
        for (int i = 0; i < novoTamanho; i++) {
            novaLinha.add(0);
        }
        
        matrizAdjacencia.add(novaLinha);
    }

    public void adicionarAresta(int origem, int destino) {
        if (origem >= 0 && origem < matrizAdjacencia.size() && destino >= 0 && destino < matrizAdjacencia.size()) {
            matrizAdjacencia.get(origem).set(destino, 1);
        }
    }

    public String toString() {
        String res = "  ";
        int tamanho = matrizAdjacencia.size();
        
        for (int i = 0;i < tamanho;i++) {
            res += i + " ";
        }
        res += "\n";

        for (int i = 0;i < tamanho;i++) {
            res += i + " ";
            for(int j = 0; j < tamanho; j++){
                res += matrizAdjacencia.get(i).get(j) + " ";
            }
            res += "\n";
        }
        
        return res;
    }
}