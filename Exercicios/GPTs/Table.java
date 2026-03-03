import java.util.Scanner;

public class Table {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um valor: ");
        int number = scanner.nextInt();

        for(int i = 1;i <= 10;i++){
            System.out.println(i*number);
        }
        
        scanner.close();

    }    
}
