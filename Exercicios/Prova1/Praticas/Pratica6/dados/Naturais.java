package Exercicios.Prova1.Praticas.Pratica6.dados;
import dados.Gerador;

public class Naturais extends Gerador{
    
    public void gerar(int quantidade){
        for(int i = 0;i < quantidade;i++){
            sequencia.add(i);
        }
    }

}
