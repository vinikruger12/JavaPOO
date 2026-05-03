package apresentacao;
import dados.Naturais;
import dados.Abundantes;
import dados.Fatorial;
import dados.Gerador;
import java.util.ArrayList;
import java.util.List;
import dados.Fibonacci;
import dados.Fatorial;
import dados.Primos;
import dados.Quadrados;
import dados.Perfeitos;


public class Principal {

    public void naturais(){
        Gerador naturais = new Naturais();
        naturais.gerar(5);
        List<Integer> nat = naturais.getSequencia();
        for(int i = 0;i < nat.size();i++){
            System.out.print(nat.get(i) + " ");
        }
        System.out.println();
    }

    public void abundantes(){
        Gerador abundantes = new Abundantes();
        abundantes.gerar(5);
        List<Integer> abu = abundantes.getSequencia();
        for(int i = 0;i < abu.size();i++){
            System.out.print(abu.get(i) + " ");
        }
        System.out.println();
    }

    public void fibonacci(){
        Gerador fibonacci = new Fibonacci();
        fibonacci.gerar(7);
        List<Integer> fib = fibonacci.getSequencia();
        for(int i = 0;i < fib.size();i++){
            System.out.print(fib.get(i) + " ");
        }
        System.out.println();
    }

    public void fatorial(){
        Gerador fatorial = new Fatorial();
        fatorial.gerar(6);
        List<Integer> fat = fatorial.getSequencia();
        for(int i = 0;i < fat.size();i++){
            System.out.print(fat.get(i) + " ");
        }
        System.out.println();
    }

    public void primos(){
        Gerador primos = new Primos();
        primos.gerar(6);
        List<Integer> pri = primos.getSequencia();
        for(int i = 0;i < pri.size();i++){
            System.out.print(pri.get(i) + " ");
        }
        System.out.println();
    }

    public void quadrados(){
        Gerador quadrados = new Quadrados();
        quadrados.gerar(6);
        List<Integer> qua = quadrados.getSequencia();
        for(int i = 0;i < qua.size();i++){
            System.out.print(qua.get(i) + " ");
        }
        System.out.println();
    }

    public void perfeitos(){
        Gerador perfeitos = new Perfeitos();
        perfeitos.gerar(3);
        List<Integer> per = perfeitos.getSequencia();
        for(int i = 0;i < per.size();i++){
            System.out.print(per.get(i) + " ");
        }
        System.out.println();
    }

    

    public static void main(String[] args){
        Principal prin = new Principal();
        prin.naturais();
        prin.abundantes();
        prin.fibonacci();
        prin.fatorial();
        prin.primos();
        prin.quadrados();
        prin.perfeitos();
    }
    
}
