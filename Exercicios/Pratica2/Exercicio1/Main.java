public class Main {
    public static void main(String[] args){

        Grupo g = new Grupo();

        Pessoa p1 = new Pessoa();
        p1.setNome("Vinicius");
        p1.setIdade(18);
        p1.setMassa(70);
        p1.setAltura(1.83);

        Pessoa p2 = new Pessoa();
        p2.setNome("Joao");
        p2.setIdade(30);
        p2.setMassa(100);
        p2.setAltura(1.50);

        Pessoa p3 = new Pessoa();
        p3.setNome("Maria");
        p3.setIdade(25);
        p3.setMassa(60);
        p3.setAltura(1.65);

        Pessoa p4 = new Pessoa();
        p4.setNome("Carlos");
        p4.setIdade(40);
        p4.setMassa(85);
        p4.setAltura(1.75);

        Pessoa p5 = new Pessoa();
        p5.setNome("Ana");
        p5.setIdade(22);
        p5.setMassa(55);
        p5.setAltura(1.60);
                

        g.setPessoa(p1);
        g.setPessoa(p2);
        g.setPessoa(p3);
        g.setPessoa(p4);
        g.setPessoa(p5);
        
        g.ordena();
        g.getPessoa();
    }    
}
