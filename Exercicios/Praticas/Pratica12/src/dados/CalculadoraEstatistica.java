package dados;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class CalculadoraEstatistica implements iSequencia{
    private static CalculadoraEstatistica instance = null;
    protected List<Integer> sequencia = new LinkedList<Integer>();

    private CalculadoraEstatistica(){

    }

    public static CalculadoraEstatistica getInstance(){
        if(instance == null){
            instance = new CalculadoraEstatistica();
        }
        return instance;
    }

    public List<Integer> getValores(){
        return sequencia;
    }

    public void adicionarValores(int valor){
        sequencia.add(valor);
    }

    public void limparValores(){
        sequencia.clear();
    }

    public void tirarUltimoValor(){
        if(sequencia.size() > 0) sequencia.remove(sequencia.size()-1);
    }

    public int sortear(){
        Random r = new Random();
        return sequencia.get(r.nextInt(sequencia.size()));
    }

    public long somatorio(){
        long soma = 0;
        for(int i = 0;i < sequencia.size();i++){
            soma += sequencia.get(i);
        }
        return soma;
    }

    public double mediaAritmetica(){
        return (this.somatorio()/(double)sequencia.size());
    }

    public double mediaGeometrica(){
        double soma = 1;
        for(int i = 0;i < sequencia.size();i++){
            soma *= sequencia.get(i);
        }
        return Math.pow(soma, 1.0/sequencia.size());
    }

    public double variancia(){
        double var = 0;
        for(int i = 0;i < sequencia.size();i++){
            var += (sequencia.get(i) - this.mediaAritmetica()) * (sequencia.get(i) - this.mediaAritmetica());
        }
        return (var/(sequencia.size() + 1));
    }

    public double desvioPadrao(){
        return Math.pow(this.variancia(), 1.0/2);
    }

    public long amplitude(){
        long maior = sequencia.get(0);
        long menor = sequencia.get(0);

        for(int i = 0;i < sequencia.size();i++){
            if(sequencia.get(i) > maior) maior = sequencia.get(i);
            if(sequencia.get(i) < maior) maior = sequencia.get(i);
        }

        return (maior - menor);
    }
}