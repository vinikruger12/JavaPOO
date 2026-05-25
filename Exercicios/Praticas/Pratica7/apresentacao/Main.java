package apresentacao;
import java.util.List;
import java.util.Scanner;

import dados.Abundantes;
import dados.Fatorial;
import dados.Fibonacci;
import dados.Gerador;
import dados.Naturais;
import dados.Perfeitos;
import dados.Primos;
import dados.Quadrado;

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
        System.out.println("-----------------");
        System.out.println("Número sorteado: " + geradorPerfeito.sortear());
        System.out.println("-----------------");
        System.out.println("Seu somatório é " + geradorPerfeito.somatorio());
        System.out.println("-----------------");
        System.out.println("Sua média aritmética é " + geradorPerfeito.mediaAritmetica());
        System.out.println("-----------------");
        System.out.println("Sua média geométrica é " + geradorPerfeito.mediaGeometrica());
        System.out.println("-----------------");
        System.out.println("Sua variancia é " + geradorPerfeito.variancia());
        System.out.println("-----------------");
        System.out.println("Sua desvio padrão é " + geradorPerfeito.desvioPadrao());
        System.out.println("-----------------");
        System.out.println("Sua amplitude é " + geradorPerfeito.amplitude());


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
        System.out.println("-----------------");
        System.out.println("Número sorteado: " + geradorAbundantes.sortear());
        System.out.println("-----------------");
        System.out.println("Seu somatório é " + geradorAbundantes.somatorio());
        System.out.println("-----------------");
        System.out.println("Sua média aritmética é " + geradorAbundantes.mediaAritmetica());
        System.out.println("-----------------");
        System.out.println("Sua média geométrica é " + geradorAbundantes.mediaGeometrica());
        System.out.println("-----------------");
        System.out.println("Sua variancia é " + geradorAbundantes.variancia());
        System.out.println("-----------------");
        System.out.println("Sua desvio padrão é " + geradorAbundantes.desvioPadrao());
        System.out.println("-----------------");
        System.out.println("Sua amplitude é " + geradorAbundantes.amplitude());
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
        System.out.println("-----------------");
        System.out.println("Número sorteado: " + geradorPrimos.sortear());
        System.out.println("-----------------");
        System.out.println("Seu somatório é " + geradorPrimos.somatorio());
        System.out.println("-----------------");
        System.out.println("Sua média aritmética é " + geradorPrimos.mediaAritmetica());
        System.out.println("-----------------");
        System.out.println("Sua média geométrica é " + geradorPrimos.mediaGeometrica());
        System.out.println("-----------------");
        System.out.println("Sua variancia é " + geradorPrimos.variancia());
        System.out.println("-----------------");
        System.out.println("Sua desvio padrão é " + geradorPrimos.desvioPadrao());
        System.out.println("-----------------");
        System.out.println("Sua amplitude é " + geradorPrimos.amplitude());
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
        System.out.println("-----------------");
        System.out.println("Número sorteado: " + geradorNaturais.sortear());
        System.out.println("-----------------");
        System.out.println("Seu somatório é " + geradorNaturais.somatorio());
        System.out.println("-----------------");
        System.out.println("Sua média aritmética é " + geradorNaturais.mediaAritmetica());
        System.out.println("-----------------");
        System.out.println("Sua média geométrica é " + geradorNaturais.mediaGeometrica());
        System.out.println("-----------------");
        System.out.println("Sua variancia é " + geradorNaturais.variancia());
        System.out.println("-----------------");
        System.out.println("Sua desvio padrão é " + geradorNaturais.desvioPadrao());
        System.out.println("-----------------");
        System.out.println("Sua amplitude é " + geradorNaturais.amplitude());
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
        System.out.println("-----------------");
        System.out.println("Número sorteado: " + geradorFibonnaci.sortear());
        System.out.println("-----------------");
        System.out.println("Seu somatório é " + geradorFibonnaci.somatorio());
        System.out.println("-----------------");
        System.out.println("Sua média aritmética é " + geradorFibonnaci.mediaAritmetica());
        System.out.println("-----------------");
        System.out.println("Sua média geométrica é " + geradorFibonnaci.mediaGeometrica());
        System.out.println("-----------------");
        System.out.println("Sua variancia é " + geradorFibonnaci.variancia());
        System.out.println("-----------------");
        System.out.println("Sua desvio padrão é " + geradorFibonnaci.desvioPadrao());
        System.out.println("-----------------");
        System.out.println("Sua amplitude é " + geradorFibonnaci.amplitude());
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
        System.out.println("-----------------");
        System.out.println("Número sorteado: " + geradorFatorias.sortear());
        System.out.println("-----------------");
        System.out.println("Seu somatório é " + geradorFatorias.somatorio());
        System.out.println("-----------------");
        System.out.println("Sua média aritmética é " + geradorFatorias.mediaAritmetica());
        System.out.println("-----------------");
        System.out.println("Sua média geométrica é " + geradorFatorias.mediaGeometrica());
        System.out.println("-----------------");
        System.out.println("Sua variancia é " + geradorFatorias.variancia());
        System.out.println("-----------------");
        System.out.println("Sua desvio padrão é " + geradorFatorias.desvioPadrao());
        System.out.println("-----------------");
        System.out.println("Sua amplitude é " + geradorFatorias.amplitude());
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
        System.out.println("-----------------");
        System.out.println("Número sorteado: " + geradorQuadrados.sortear());
        System.out.println("-----------------");
        System.out.println("Seu somatório é " + geradorQuadrados.somatorio());
        System.out.println("-----------------");
        System.out.println("Sua média aritmética é " + geradorQuadrados.mediaAritmetica());
        System.out.println("-----------------");
        System.out.println("Sua média geométrica é " + geradorQuadrados.mediaGeometrica());
        System.out.println("-----------------");
        System.out.println("Sua variancia é " + geradorQuadrados.variancia());
        System.out.println("-----------------");
        System.out.println("Sua desvio padrão é " + geradorQuadrados.desvioPadrao());
        System.out.println("-----------------");
        System.out.println("Sua amplitude é " + geradorQuadrados.amplitude());
    }


    public static void main(String[] args){
        Main f = new Main();
        f.run();
    }
}
