package dados;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public abstract class Gerador implements iSequencia {
    protected List<Integer> sequencia = new ArrayList<>();
    
    public List<Integer> getSequencia() {
        return this.sequencia;
    }
    public abstract void gerar(int quantidade);


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
        return (this.somatorio()/sequencia.size());
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
