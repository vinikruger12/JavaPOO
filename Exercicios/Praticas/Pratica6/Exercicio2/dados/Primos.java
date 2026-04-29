package dados;
import java.util.ArrayList;
import java.util.List;
import dados.Gerador;

public class Primos extends Gerador{
    
    public void gerar(int quantidade){
        int k = 0;
        for(int i = 2;k < quantidade;i++){
            boolean flag = true;
            for(int j = 2;j < i;j++){
                if(i % j == 0) flag = false;
            }
            if(flag){
                sequencia.add(i);
                k++;
            }
        }
        
    }
}
