package Exercicios.Lista1.Exercicio1e2;
public class Main {
    public static void main(String[] args) {


        Endereco e1 = new Endereco("A", 1, "Joinville", "SC");
        Endereco e2 = new Endereco();
        e2.setRua("B");
        e2.setNumero(2);
        e2.setCidade("Floripa");
        e2.setEstado("SC");

        System.out.println(e1);
        System.out.print("\n");
        System.out.println(e2);
        
        System.out.println("\n");
        System.out.println("\n");



        Cliente c1 = new Cliente("Joao", 30, e1, new Veiculo[10]);
        Cliente c2 = new Cliente();
        c2.setNome("Maria");
        c2.setIdade(25);
        c2.setEndereco(e2);

        System.out.println(c1);
        System.out.print("\n");
        System.out.println(c2);

        System.out.println("\n");
        System.out.println("\n");


        Veiculo v1 = new Veiculo("Civic", "Preto", "Honda", 2020);
        Veiculo v2 = new Veiculo();
        v2.setNome("Camaro");
        v2.setCor("Amarelo");
        v2.setMarca("Fiat");
        v2.setAno(2014);

        System.out.println(v1);
        System.out.print("\n");
        System.out.println(v2);

        System.out.println("\n");
        System.out.println("\n");


        Vendedor ven1 = new Vendedor("Carlos", 40, 3000, e1);
        Vendedor ven2 = new Vendedor();
        ven2.setNome("Ana");
        ven2.setIdade(35);
        ven2.setSalario(3500);
        ven2.setEndereco(e2);

        System.out.println(ven1);
        System.out.print("\n");
        System.out.println(ven2);

        System.out.println("\n");
        System.out.println("\n");


        Aluguel a1 = new Aluguel(c1, ven1, 500, v1);
        Aluguel a2 = new Aluguel();
        a2.setCliente(c2);
        a2.setVendedor(ven2);
        a2.setValor(300);
        a2.setVeiculo(v2);

        System.out.println(a1);
        System.out.print("\n");
        System.out.println(a2);
    }
}    

