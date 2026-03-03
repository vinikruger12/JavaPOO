import java.util.Scanner;


public class Hello{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite seu nome: ");
        String user = scanner.nextLine();

        System.out.println("Olá, " + user + "! Seja bem-vindo ao Java!");
        scanner.close();
    }

}
