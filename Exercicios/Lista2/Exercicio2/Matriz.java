package Exercicio2;
import java.util.ArrayList;
import java.util.List;

enum Quadrante {
    PRIMEIRO, 
    SEGUNDO, 
    TERCEIRO, 
    QUARTO
};

public class Matriz<T>{
    private int n;
    private int m;
    private List<List<T>> matriz;

    public Matriz(int n, int m){
        this.n = n;
        this.m = m;
        this.matriz = new ArrayList<>(n);

        for(int i = 0;i < n;i++){
            List<T> linha = new ArrayList<>(m);
            for(int j = 0;j < m;j++){
                linha.add(null);
            }
            this.matriz.add(linha);
        }

    }

    public boolean set(T objeto, int i, int j){
        if(i >= n || j >= m || j < 0 || i < 0) return false;
        matriz.get(i).set(j, objeto);
        return true;
    }

    public T get(int i, int j){
        if(i >= n || j >= m || j < 0 || i < 0) return null;
        return matriz.get(i).get(j);
    }

    public List<T> getLinha(int i){
        if(i < 0 || i >= n) return new ArrayList<>();
        
        return new ArrayList<>(matriz.get(i));
    }


    public List<T> getColuna(int j){
        List<T> listaColuna = new ArrayList<>();
        if(j < 0 || j >= m) return listaColuna;
        
        for(int i = 0;i < n;i++){
            listaColuna.add(matriz.get(i).get(j));
        }
        return listaColuna;
    }

    public List<T> getElementosQuadrante(Quadrante quadrante) {
        List<T> elementos = new ArrayList<>();
        
        int divLinha = (n + 1) / 2; 
        int divColuna = (m + 1) / 2;
        
        int inicioLinha = 0, fimLinha = 0;
        int inicioColuna = 0, fimColuna = 0;

        switch (quadrante) {
            case PRIMEIRO:
                inicioLinha = 0;          
                fimLinha = divLinha;
                inicioColuna = 0;         
                fimColuna = divColuna;
                break;
            case SEGUNDO:
                inicioLinha = 0;          
                fimLinha = divLinha;
                inicioColuna = divColuna; 
                fimColuna = m;
                break;
            case TERCEIRO:
                inicioLinha = divLinha;   
                fimLinha = n;
                inicioColuna = 0;         
                fimColuna = divColuna;
                break;
            case QUARTO:
                inicioLinha = divLinha;   
                fimLinha = n;
                inicioColuna = divColuna; 
                fimColuna = m;
                break;
        }

        for(int i = inicioLinha; i < fimLinha; i++){
            for(int j = inicioColuna; j < fimColuna; j++){
                elementos.add(matriz.get(i).get(j));
            }
        }

        return elementos;
    }
    
}
