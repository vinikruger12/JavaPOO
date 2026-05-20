package dados;


public class Fatorial extends Gerador{
    
    public void gerar(int quantidade){
        
        for(int i = 0;i < quantidade;i++){
            int valor = 1;
            for(int j = 1;j <= i;j++){
                valor *= j;
            }
            sequencia.add(valor);
        }
        
    }
}
