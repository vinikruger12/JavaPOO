package Exercicios.Prova1.Externos.Jardim.dados;

public abstract class Planta {
    protected String nome;
    protected float espacoNescessario;
    private Clima clima;

    public Clima getClima() {
        return clima;
    }
    public void setClima(Clima clima) {
        this.clima = clima;
    }
    
    public float getEspacoNescessario() {
        return espacoNescessario;
    }
    public void setEspacoNescessario(float espacoNescessario) {
        this.espacoNescessario = espacoNescessario;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract float calcularAguaDiaria();

    public boolean equals(Object o){
        if(o instanceof Planta){
            Planta p = (Planta) o;
            if(this.nome.equals(p.getNome())
                && this.clima.equals(p.getClima())
                && this.espacoNescessario == p.espacoNescessario
                && this.calcularAguaDiaria() == p.calcularAguaDiaria()) return true;
        }
        return false;
    }

    public String toString(){
        return "Planta: " + this.nome 
        + " Clima: " + this.clima
        + " Espaco nescessario: " + this.espacoNescessario
        + " Agua diaria: " + this.calcularAguaDiaria();
    }
}
