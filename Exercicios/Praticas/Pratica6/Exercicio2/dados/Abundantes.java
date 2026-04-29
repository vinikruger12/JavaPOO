package dados;
import java.util.ArrayList;
import java.util.List;

public class Abundantes extends Gerador{
    public void gerar(int quantidade){
        int k = 0;
        for(int i = 1;k < quantidade;i++){
            int somatorio = 0;
            for(int j = 1;j < i;j++){
                if(i % j == 0) somatorio += j;
            }
            if(i < somatorio){
                sequencia.add(i);
                k++;
            }
            }
    }
}
