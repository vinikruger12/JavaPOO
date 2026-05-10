package dados;

public class Mesa {
    private int numero;
    private int capacidadePessoas;
    private LocalizacaoMesa localizacao;

    public Mesa(int numero, int capacidade, LocalizacaoMesa loc) {
        this.numero = numero;
        this.capacidadePessoas = capacidade;
        this.localizacao = loc;
    }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    public int getCapacidadePessoas() { return capacidadePessoas; }
    public void setCapacidadePessoas(int capacidadePessoas) { this.capacidadePessoas = capacidadePessoas; }
    public LocalizacaoMesa getLocalizacao() { return localizacao; }
    public void setLocalizacao(LocalizacaoMesa loc) { this.localizacao = loc; }
}