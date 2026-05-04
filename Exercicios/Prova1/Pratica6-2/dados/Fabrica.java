package dados;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;


public class Fabrica {
    public Veiculo fabricar(){
        Random r = new Random();
        if(r.nextInt(2) == 1){
            Carro c = new Carro();
            c.setCor(Cor.values()[r.nextInt(Cor.values().length)]);
            c.setNumeroPortas(2 + 2*r.nextInt(2));
            c.setCombustivel(Combustivel.values()[r.nextInt(Combustivel.values().length)]);
            return c;
        }
        else{
            Bicicleta b = new Bicicleta();
            b.setCor(Cor.values()[r.nextInt(Cor.values().length)]);
            b.setNumMarchas(r.nextInt(5));
            return b;
        }
    }

    public static void main(){
        Fabrica fab = new Fabrica();
        List<Veiculo> veiculos = new ArrayList<>();
        for(int i = 0;i < 10;i++){
            veiculos.add(fab.fabricar());
        }
        for(int i = 0;i < 10;i++){
            System.out.println(veiculos.get(i).info());
            System.out.println();
        }
    }
}
