package dados;
import java.util.ArrayList;
import java.util.List;
import dados.Gerador;

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
