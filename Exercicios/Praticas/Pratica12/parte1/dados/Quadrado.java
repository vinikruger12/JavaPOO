package Exercicios.Praticas.Pratica12.parte1.dados;


public class Quadrado extends Gerador{
    
    public void gerar(int quantidade){
        for(int i = 1;i <= quantidade;i++){
            sequencia.add(i*i);
        }
    }
}

