package apresentacao;

import dados.Animal;
import dados.Cachorro;
import dados.Gato;
import dados.Pato;

public class Main {
    public static void main(String[] args){
        Animal cachorro1 = new Cachorro();
        cachorro1.setNome("Roberto");
        Animal cachorro2 = new Cachorro();
        cachorro2.setNome("Rex");

        
        Animal gato1 = new Gato();
        gato1.setNome("Rodrigo");
        Animal gato2 = new Gato();
        gato2.setNome("Mingau");

        
        Animal pato1 = new Pato();
        pato1.setNome("Felipe");
        Animal pato2 = new Pato();
        pato2.setNome("Donald");

        System.out.println(cachorro1.emitirSom());
        System.out.println(cachorro2.emitirSom());
        System.out.println(gato1.emitirSom());
        System.out.println(gato2.emitirSom());
        System.out.println(pato1.emitirSom());
        System.out.println(pato2.emitirSom());
    }
}
