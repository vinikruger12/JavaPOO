package dados;

public abstract class Veiculo {
    protected Cor cor;
    public abstract String info();

    public Cor getCor() {
        return this.cor;
    }
    public void setCor(Cor cor) {
        this.cor = cor;
    }
}
