import java.util.Scanner;

public class ex2{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] nomes = new String[5];
        int[] idades = new int[5];

        for(int i = 0;i < 5;i++){
            System.out.println("Digite o nome:");
            nomes[i] = in.nextLine();

            System.out.println("Digite a idade dessa pessoa:");
            idades[i] = in.nextInt();
            in.nextLine();
        }

        for(int i = 0;i < 4;i++){
            for(int j = (i+1);j < 5;j++){
                if(idades[i] < idades[j]){
                    int aux = idades[i];
                    idades[i] = idades[j];
                    idades[j] = aux;

                    String s = nomes[i];
                    nomes[i] = nomes[j];
                    nomes[j] = s;
                }
            }   
        }

        for(int i = 0;i < 5;i++){
            System.out.println(nomes[i] + " tem " + idades[i] + " anos!");
        }

    }
}