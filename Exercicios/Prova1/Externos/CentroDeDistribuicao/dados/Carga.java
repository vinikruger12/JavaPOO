package Exercicios.Prova1.Externos.CentroDeDistribuicao.dados;

public abstract class Carga {
    protected String idCarga;
    protected float comprimento;
    protected float largura;
    private float peso;

    public float getComprimento() {
        return comprimento;
    }
    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public String getIdCarga() {
        return idCarga;
    }
    public void setIdCarga(String idCarga) {
        this.idCarga = idCarga;
    }

    public float getLargura() {
        return largura;
    }
    public void setLargura(float largura) {
        this.largura = largura;
    }

    public float getPeso() {
        return peso;
    }
    public void setPeso(float peso){
        this.peso = peso;
    }

    public abstract float calculaEspacoOcupado();

    public boolean equals(Object o){
        if(o instanceof Carga){
            Carga c = (Carga) o;
            if(this.comprimento == c.getComprimento()
                && this.idCarga.equals(c.getIdCarga())
                && this.largura == c.getLargura() 
                && this.peso == c.getPeso()) return true;
        }
        return false;
    }

    public String toString(){
        return "Id: " + this.idCarga +
        ", Largura: " + this.largura +
        ", Peso: " + this.peso + 
        ", Comprimento: " + this.comprimento;
    }

}
