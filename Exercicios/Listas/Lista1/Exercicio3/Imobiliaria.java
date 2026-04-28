package Exercicios.Lista1.Exercicio3;

public class Imobiliaria {
    private String nome;
    private Imovel[] imoveis = new Imovel[10];
    private int numeroImoveis = 0;

    public Imobiliaria(){}
    public Imobiliaria(String nome, Imovel[] imoveis){
        this.nome = nome;
        this.imoveis = imoveis;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setImoveis(Imovel[] imoveis) {
        this.imoveis = imoveis;
    }
    public Imovel[] getImoveis() {
        return this.imoveis;
    }

    public void addImovel(Imovel imovel){
        this.imoveis[this.numeroImoveis] = imovel;
        this.numeroImoveis++;
    }

    public String toString(){
        String s = "Imobiliaria: " + this.nome + "\n";

        for(int i = 0; i < this.numeroImoveis; i++){
            s += "Imovel " + (i+1) + ": " + this.imoveis[i].toString() + "\n";
        }

        return s;
    }

    public Imovel[] filtrarPorArea(float x){
        int tamanho = 0;
        Imovel[] imoveis = new Imovel[100];
        for(int i = 0;i < this.numeroImoveis;i++){
            if(this.imoveis[i].areaTotal() >= x){
                imoveis[tamanho] = this.imoveis[i];
                tamanho++;
            }
        }

        for(int i = 0;i < (tamanho - 1);i++){
            for(int j = (i+1);j < tamanho;j++){
                if(imoveis[i].getPreco() > imoveis[j].getPreco()){
                    Imovel aux = imoveis[i];
                    imoveis[i] = imoveis[j];
                    imoveis[j] = aux;
                }
            }
        }

        Imovel[] resultado = new Imovel[tamanho];
        for(int i = 0; i < tamanho; i++){
            resultado[i] = imoveis[i];
        }
        return resultado;
    }


}
