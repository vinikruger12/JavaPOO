package Pratica5;
import java.util.*;


public class Colecoes {
    public static List<Integer> tabuada (int n){
        List<Integer> tabuada = new ArrayList<Integer>();

        for(int i = 1;i <= 10;i++){
            tabuada.add(i * n);
        }
        return tabuada;
    }

    public static void main(String[] args){
        Map<Integer, List<Integer>> tabuadas = new HashMap<Integer, List<Integer>>();
        for(int i = 1;i <= 10;i++){
            tabuadas.put(i, tabuada(i));
        }
        
        for(List<Integer> lista : tabuadas.values()){
            System.out.println(lista);
        }
    }
}
