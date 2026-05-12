package dados;
import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private String nomeCliente;
    private String telefone;
    private String data;
    private String hora;
    private int numeroPessoas;
    private String observacoes;
    private StatusReserva status;
    private List<Mesa> mesas = new ArrayList<>();


    public String getNomeCliente(){
        return nomeCliente; 
    }
    public void setNomeCliente(String nomeCliente){
        this.nomeCliente = nomeCliente; 
    }

    public String getTelefone(){
        return telefone; 
    }
    public void setTelefone(String telefone){
        this.telefone = telefone; 
    }

    public String getData(){
        return data; 
    }
    public void setData(String data){
        this.data = data; 
    }

    public String getHora(){
        return hora;
    }
    public void setHora(String hora){
        this.hora = hora;
    }

    public int getNumeroPessoas(){
        return numeroPessoas;
    }
    public void setNumeroPessoas(int numeroPessoas){
        this.numeroPessoas = numeroPessoas;
    }

    public String getObservacoes(){
        return observacoes; 
    }
    public void setObservacoes(String observacoes){
        this.observacoes = observacoes; 
    }

    public StatusReserva getStatus(){
        return status; 
    }
    public void setStatus(StatusReserva status){
        this.status = status; 
    }

    public List<Mesa> getMesas(){ 
        return mesas; 
    }
    public void setMesas(List<Mesa> mesas){
        this.mesas = mesas; 
    }

    public String toString() {
        return "RESERVA \n" + "CLIENTE: " + this.nomeCliente + "\n" + 
        "TELEFONE: " + this.telefone + "\n" + "DATA: " + this.data + "\n" + 
        "HORA: " + this.hora + "\n" + "PESSOAS: " + this.numeroPessoas + "\n" + 
        "STATUS: " + this.status.getStatusReserva();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Reserva) {
            Reserva r = (Reserva) obj;
            if (this.nomeCliente.equals(r.getNomeCliente())
                && this.data.equals(r.getData())
                && this.hora.equals(r.getHora())
                && this.status == r.getStatus()) return true;
        }
        return false;
    }
}