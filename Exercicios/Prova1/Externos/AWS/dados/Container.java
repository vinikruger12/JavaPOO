package Exercicios.Prova1.Externos.AWS.dados;

public class Container extends MaquinaVirtual{
    private String orquestrador;
    
    public String getOrquestrador() {
        return orquestrador;
    }
    public void setOrquestrador(String orquestrador) {
        this.orquestrador = orquestrador;
    }

    public float calularCustoMensal(){
        return super.vCpus * 8.5;
    }

}
