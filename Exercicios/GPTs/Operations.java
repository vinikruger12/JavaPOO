import java.util.Scanner;

public class Operations {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o primeiro número");
        int firstDigit = scanner.nextInt();

        System.out.println("Digite o segundo número");
        int secondDigit = scanner.nextInt();

        System.out.println("Soma: " + (firstDigit + secondDigit));
        System.out.println("Subtração: " + (firstDigit - secondDigit));
        System.out.println("Multiplicação: " + (firstDigit * secondDigit));
        System.out.println("Divisão: " + (secondDigit == 0? 0: (double)(firstDigit / secondDigit)));

        scanner.close();

    }
}
