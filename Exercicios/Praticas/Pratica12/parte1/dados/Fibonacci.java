package Exercicios.Praticas.Pratica12.parte1.dados;


public class Fibonacci extends Gerador{
    public void gerar(int quantidade){
        sequencia.add(0);
        sequencia.add(1);
        for(int i = 2;i < quantidade;i++){
            sequencia.add(sequencia.get(i-2) + sequencia.get(i-1));
        }
    }
}
