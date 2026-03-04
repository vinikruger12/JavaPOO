import java.util.Scanner;

public class Reading {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        String s = in.nextLine();
        System.out.println(("Seja bem-vindo " + s + "!"));

        in.close();
    }
}
