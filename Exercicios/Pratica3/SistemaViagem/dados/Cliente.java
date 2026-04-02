public class Cliente{
    private String cpf;
    private String nome;
    private String endereco;
    private String telefone;
    private Reserva[] reservas = new Reserva[100];
    private int quantReservas = 0;

    public Cliente(){}

    public String getCpf() {
        return this.cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return this.endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return this.telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getQuantReservas() {
        return this.quantReservas;
    }

    public boolean cadastrarReservas(Reserva reserva){
        if(quantReservas < reservas.length){
            reservas[quantReservas] = reserva;
            quantReservas++;
            return true;
        }
        return false;
    }

    public void reservaIda(Reserva reserva){

    }

    public void reservarVolta(Reserva ida, Reserva volta){

    }

    public String toString(){
        return "CPF: " + this.cpf + ", Nome: " + this.cpf + ", Endereço: " + this.endereco + ", Telefone: " + this.telefone + "Reservas " + this.reservas;
    }


}