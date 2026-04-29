package dados;
import java.util.ArrayList;
import java.util.List;
import dados.Gerador;

public class Quadrado extends Gerador{
    
    public void gerar(int quantidade){
        for(int i = 1;i <= quantidade;i++){
            sequencia.add(i*i);
        }
    }
}

