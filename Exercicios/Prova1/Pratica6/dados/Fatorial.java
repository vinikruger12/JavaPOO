package dados;

public class Fatorial extends Gerador{
    public void gerar(int quantidade){
        sequencia.add(1);
        for(int i = 1;i < quantidade;i++){
            int soma = 1;
            for(int j = i;j >= 1;j--){
                soma *= j;
            }
            sequencia.add(soma);
        }
    }
}
