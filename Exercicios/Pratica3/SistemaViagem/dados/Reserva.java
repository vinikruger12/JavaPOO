package dados;

public class Reserva {
    private int numReserva;
    private String dataVoo;
    private String horaVoo;
    private float preco;
    private String classeVoo;
    private Boolean idaEvolta = false;
    private int poltrona;
    private Reserva volta;
    private Cidade origem;
    private Cidade destino;

    public Reserva(){}

    public String getClasseVoo() {
        return this.classeVoo;
    }
    public void setClasseVoo(String classeVoo) {
        this.classeVoo = classeVoo;
    }
    
    public String getDataVoo() {
        return this.dataVoo;
    }
    public void setDataVoo(String dataVoo) {
        this.dataVoo = dataVoo;
    }

    public String getHoraVoo() {
        return this.horaVoo;
    }
    public void setHoraVoo(String horaVoo) {
        this.horaVoo = horaVoo;
    }

    public int getNumReserva() {
        return this.numReserva;
    }
    public void setNumReserva(int numReserva) {
        this.numReserva = numReserva;
    }

    public void setPoltrona(int poltrona) {
        this.poltrona = poltrona;
    }
    public int getPoltrona() {
        return this.poltrona;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    public float getPreco() {
        return this.preco;
    }

    public Cidade getDestino() {
        return this.destino;
    }
    public void setDestino(Cidade destino) {
        this.destino = destino;
    }

    public Cidade getOrigem() {
        return this.origem;
    }
    public void setOrigem(Cidade origem) {
        this.origem = origem;
    }

    public Reserva getVolta() {
        return this.volta;
    }
    public void setVolta(Reserva volta) {
        this.volta = volta;
        this.idaEvolta = true;
    }

    public boolean isIdaEVolta(){
        return this.idaEvolta;
    }

    public String toString(){
        return "Número reserva: " + this.numReserva + ", Data do voo: " + this.dataVoo + ", Hora do voo: " + this.horaVoo + ", Preco: " + this.preco + ", Classe do voo: " + this.classeVoo + ", Ida e Volta: " + this.idaEvolta + ", Poltrona: " + this.poltrona + ", Cidade de origem: " + this.origem + ", Cidade de destino: " + this.destino + ", Volta: " + this.volta;
    }


}   
