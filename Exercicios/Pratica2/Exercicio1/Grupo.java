
public class Grupo {
    private Pessoa[] pessoas = new Pessoa[5];
    private int numeroPessoas = 0;

    public Grupo(){}

    public void setPessoa(Pessoa pessoa){
        if(this.numeroPessoas < 5){
            pessoas[this.numeroPessoas] = pessoa;
            this.numeroPessoas++;
        }
    }

    public void getPessoa(){
        for(int i = 0;i < this.numeroPessoas;i++){
            System.out.println("O nome da pessoa é " + this.pessoas[i].getNome());
            System.out.println("A altura da pessoa é " + this.pessoas[i].getAltura());
            System.out.println("O peso da pessoa é de " + this.pessoas[i].getMassa() + " kilogramas");
            System.out.println("A idade da pessoa é " + this.pessoas[i].getIdade() + " anos");
            System.out.println("O IMC da pessoa é " + this.pessoas[i].calculaIMC() + "\n");
        }
    }

    public void ordena(){
        for(int i = 0;i < this.numeroPessoas - 1;i++){
            for(int j = (i + 1); j < this.numeroPessoas;j++){
                if(this.pessoas[i].calculaIMC() < this.pessoas[j].calculaIMC()){
                    Pessoa aux = this.pessoas[i];
                    this.pessoas[i] = this.pessoas[j];
                    this.pessoas[j] = aux;
                }
            }
        }
    }

}
