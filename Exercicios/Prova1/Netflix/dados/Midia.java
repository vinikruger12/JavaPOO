package dados;

public abstract class Midia {
    protected String titulo;
    protected int anoLancamento;
    private Genero genero;

    public int getAnoLancamento() {
        return this.anoLancamento;
    }
    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Genero getGenero() {
        return this.genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    
    public String getTitulo() {
        return this.titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public abstract int calcularTempoMaratona();

    public String toString(){
        return "Título: " + this.titulo 
        + ", Ano de lançamento: " + this.anoLancamento 
        + ", Genero " + this.genero
        + ", Duracao total: " + this.calcularTempoMaratona();
    }

    public boolean equals(Object obj){
        if(obj instanceof Midia){
            Midia m = (Midia) obj;
            if((this.anoLancamento) == m.getAnoLancamento()
                && (this.genero.equals(m.getGenero()))
                && (this.titulo.equals(m.getTitulo()))
                && (this.calcularTempoMaratona()) == m.calcularTempoMaratona()) return true;
        }
        return false;
    }

}
