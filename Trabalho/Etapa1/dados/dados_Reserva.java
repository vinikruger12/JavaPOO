package dados;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Reserva {
    private String nomeCliente;
    private String telefone;
    private LocalDate data;
    private LocalTime hora;
    private int numeroPessoas;
    private String observacoes;
    private StatusReserva status;
    private List<Mesa> mesas;

    public Reserva(String cliente, LocalDate data, LocalTime hora, List<Mesa> mesas) {
        this.nomeCliente = cliente;
        this.data = data;
        this.hora = hora;
        this.mesas = mesas;
        this.status = StatusReserva.PENDENTE;
    }

    public String getNomeCliente() { return nomeCliente; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }
    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }
    public int getNumeroPessoas() { return numeroPessoas; }
    public void setNumeroPessoas(int numeroPessoas) { this.numeroPessoas = numeroPessoas; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
    public StatusReserva getStatus() { return status; }
    public void setStatus(StatusReserva status) { this.status = status; }
    public List<Mesa> getMesas() { return mesas; }
    public void setMesas(List<Mesa> mesas) { this.mesas = mesas; }
}