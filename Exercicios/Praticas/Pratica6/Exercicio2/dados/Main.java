package dados;
import java.util.List;
import java.util.Scanner;
import dados.Abundantes;
import dados.Fatorial;
import dados.Fibonacci;
import dados.Naturais;
import dados.Primos;
import dados.Quadrado;
import java.util.ArrayList;
import dados.Perfeitos;

public class Main {

    Scanner in = new Scanner(System.in);

    public void run(){
        boolean ok = true;
        while(ok){
            menu();
            int opcao = in.nextInt();
            switch (opcao) {
                case 0:
                    perfeitos();
                    break;
                case 1:
                    abundantes();
                    break;
                case 2:
                    primos();
                    break;
                case 3:
                    naturais();
                    break;
                case 4:
                    fibonacci();
                    break;
                case 5:
                    fatorial();
                    break;
                case 6:
                    quadrados();
                    break;
                case -1:
                    ok = false;
                    break;    
                default:
                    break;
            }
        }
    }

    public void menu(){
        System.out.println("Digite qual sequência você quer imprimir");
        System.out.println("[0] Perfeitos");
        System.out.println("[1] Abundantes");
        System.out.println("[2] Primos");
        System.out.println("[3] Naturias");
        System.out.println("[4] Fibonacci");
        System.out.println("[5] Fatorial");
        System.out.println("[6] Quadrados Perfeitos");
        System.out.println("[-1] Sair");
    }

    public void perfeitos(){
        System.out.println("Digite a quantidade de números");
        int fortnite = in.nextInt();
        Gerador geradorPerfeito = new Perfeitos();
        geradorPerfeito.gerar(fortnite);
        List<Integer> sequenciaPerfeita = geradorPerfeito.getSequencia();
        
        System.out.println("Sequencia dos Perfeitos");
        for(int i = 0;i < sequenciaPerfeita.size();i++){
            System.out.print(sequenciaPerfeita.get(i) + " ");
        }
        System.out.println();
    }

    public void abundantes(){
        System.out.println("Digite a quantidade de números");
        int fortnite = in.nextInt();
        Gerador geradorAbundantes = new Abundantes();
        geradorAbundantes.gerar(fortnite);
        List<Integer> sequenciaAbundantes = geradorAbundantes.getSequencia();
        
        System.out.println("Sequencia dos Abundantes");
        for(int i = 0;i < sequenciaAbundantes.size();i++){
            System.out.print(sequenciaAbundantes.get(i) + " ");
        }
        System.out.println();
    }


    public void primos(){
        System.out.println("Digite a quantidade de números");
        int fortnite = in.nextInt();
        Gerador geradorPrimos = new Primos();
        geradorPrimos.gerar(fortnite);
        List<Integer> sequenciaPrimos = geradorPrimos.getSequencia();
        
        System.out.println("Sequencia dos Primos");
        for(int i = 0;i < sequenciaPrimos.size();i++){
            System.out.print(sequenciaPrimos.get(i) + " ");
        }
        System.out.println();
    }

    public void naturais(){
        System.out.println("Digite a quantidade de números");
        int fortnite = in.nextInt();
        Gerador geradorNaturais = new Naturais();
        geradorNaturais.gerar(fortnite);
        List<Integer> sequenciaNaturais = geradorNaturais.getSequencia();
        
        System.out.println("Sequencia dos Naturais");
        for(int i = 0;i < sequenciaNaturais.size();i++){
            System.out.print(sequenciaNaturais.get(i) + " ");
        }
        System.out.println();
    }

    public void fibonacci(){
        System.out.println("Digite a quantidade de números");
        int fortnite = in.nextInt();
        Gerador geradorFibonnaci = new Fibonacci();
        geradorFibonnaci.gerar(fortnite);
        List<Integer> sequenciaFibonnaci = geradorFibonnaci.getSequencia();
        
        System.out.println("Sequencia dos Fibonacci");
        for(int i = 0;i < sequenciaFibonnaci.size();i++){
            System.out.print(sequenciaFibonnaci.get(i) + " ");
        }
        System.out.println();
    }

    public void fatorial(){
        System.out.println("Digite a quantidade de números");
        int fortnite = in.nextInt();
        Gerador geradorFatorias = new Fatorial();
        geradorFatorias.gerar(fortnite);
        List<Integer> sequenciaFatorias = geradorFatorias.getSequencia();
        
        System.out.println("Sequencia dos Fatorial");
        for(int i = 0;i < sequenciaFatorias.size();i++){
            System.out.print(sequenciaFatorias.get(i) + " ");
        }
        System.out.println();
    }

    public void quadrados(){
        System.out.println("Digite a quantidade de números");
        int fortnite = in.nextInt();
        Gerador geradorQuadrados = new Quadrado();
        geradorQuadrados.gerar(fortnite);
        List<Integer> sequenciaQuadrados = geradorQuadrados.getSequencia();
        
        System.out.println("Sequencia dos Quadrados Perfeitos");
        for(int i = 0;i < sequenciaQuadrados.size();i++){
            System.out.print(sequenciaQuadrados.get(i) + " ");
        }
        System.out.println();
    }


    public static void main(String[] args){
        Main f = new Main();
        f.run();
    }
}
