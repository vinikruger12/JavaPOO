package Exercicio2;
import java.util.Scanner;
import Exercicio2.Matriz;
import java.util.List;

public class Exercicio3 {

    public static void main(String[] args){
    
        Scanner in = new Scanner(System.in);
        Matriz<Integer> matriz = new Matriz<>(5, 5);
        boolean flag = true;
        
        System.out.println("A seguir digite os próximos 25 elementos");

        for(int i = 0;i < 5;i++){
            if(!flag) break;
            for(int j = 0;j < 5;j++){
                int x = Integer.parseInt(in.nextLine());
                if(x == -1){
                    flag = false;
                    break;
                }
                matriz.set(x, i, j);
            }
        }

        Integer menorElemento = 100000;
    
        for(Quadrante q : Quadrante.values()){
            List<Integer> elementosDoQuadrante = matriz.getElementosQuadrante(q);
        
            Integer menorQuadrante = null;

            for(Integer valor : elementosDoQuadrante){
                if(valor != null){
                    if(menorQuadrante == null || valor < menorQuadrante){
                        menorQuadrante = valor;
                    }
                }
            }

            System.out.println("O menor elemento do quadrante " + q + " é o " + menorQuadrante);
            if(menorQuadrante != null){
                if(menorQuadrante < menorElemento || menorElemento == null) menorElemento = menorQuadrante;
            }
        }

        System.out.println("O menor elemento é o " + menorElemento);
    
    }
}
