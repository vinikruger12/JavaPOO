import java.util.Scanner;
import java.util.InputMismatchException;

public class ReadingInteger {
    public static void main(String[] args){
        Scanner in = new Scanner((System.in));
        System.out.println("Introduza um inteiro");
        int num = 1;

        while(num != -1){
            try{
                num = in.nextInt();
                System.out.println("Seu número é " + num);
            }
            catch(InputMismatchException e){
                System.out.println(("Voce deve digitar um inteiro"));
                in.next();
            }
        }
        
        

        in.close();
    }
}
