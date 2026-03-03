import java.util.Scanner;

public class EvenOrOdd {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número que você quer saber se é ímpar ou par: ");
        int num = scanner.nextInt();

        if(num % 2 == 0){
            System.out.println("O número " + num + " é par!");
        }
        else{
            System.out.println("O número " + num + " é ímpar!");
        }

        scanner.close();
    }
}
