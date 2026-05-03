package dados;
import java.util.ArrayList;
import java.util.List;

public abstract class Gerador {
    protected List<Integer> sequencia = new ArrayList<>();

    public List<Integer> getSequencia(){
        return sequencia;
    }

    public abstract void gerar(int quantidade);

}
