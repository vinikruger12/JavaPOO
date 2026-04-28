package Exercicio1;

import java.util.Scanner;

import Exercicio1.Fabrica;

public class Main {
    public static void main(String[] args){
        int fim = -1;
        Fabrica fabrica = new Fabrica();
        Scanner in = new Scanner(System.in);

        do{
            System.out.println(fabrica.fabricar().info());
            System.out.println("Digite 0 para parar");
            System.out.println("Digite qualquer outro núero para gerar outro veículo");
            fim = in.nextInt();

        } while(fim != 0);
    }
}
