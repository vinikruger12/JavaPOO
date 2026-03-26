public class Main {

    public static void main(String[] args){
        Pessoa p1 = new Pessoa("Vinicius");
        Pessoa p2 = new Pessoa("Carol");
        Pessoa p3 = new Pessoa("Lucas");
        Pessoa p4 = new Pessoa("Caio");
        Pessoa p5 = new Pessoa("Pedro");
        
        Sorteador roleta = new Sorteador();
        roleta.addPessoas(p1);
        roleta.addPessoas(p2);
        roleta.addPessoas(p3);
        roleta.addPessoas(p4);
        roleta.addPessoas(p5);

        for(int i = 0;i < 5;i++){
            System.out.println((i+1) + ". " + roleta.sortearProximo().getNome());
        }
        
    }
     
}