import java.util.Scanner;

public class Bigger {

    public static int max(int a, int b){
        if(a > b) return a;
        return b;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o primeiro número: ");
        int firstDigit = scanner.nextInt();

        System.out.println("Digite o segundo número: ");
        int secondDigit = scanner.nextInt();

        System.out.println("Digite o terceiro número: ");
        int thirdDigit = scanner.nextInt();

        System.out.println("O maior entre " + firstDigit + ", " + secondDigit + ", " + thirdDigit + " é " + max(firstDigit, max(secondDigit, thirdDigit)));

        scanner.close();
    }
}
