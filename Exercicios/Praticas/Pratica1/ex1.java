package Exercicios.Praticas.Pratica1;
import java.util.Scanner;

public class ex1{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] x = new int[5];
        for(int i = 0;i < 5;i++){
            x[i] = in.nextInt();
        }
        int media = 0;
        for(int i = 0;i < 5;i++){
            media += x[i];
        }

        System.out.println((double)media/5);
    }
}