package dados;
import java.util.Random;



public class Fabricar {
    Random r = new Random();

    public Veiculo fabricar(){
        if(r.nextInt(2) == 1){
            Carro c = new Carro();
            c.setCombustivel(Combustivel.values()[r.nextInt(4)]);
            c.setCor(Cor.values()[r.nextInt(5)]);
            c.setNumeroPortas(2 + 2*r.nextInt(2));
            return c;
        }
        else{
            
        }
        
    }

    public static void main(String[] args){
        Fabricar f = new Fabricar();
        Veiculo v = f.fabricar();
        System.out.println(v.info());
    }

}
