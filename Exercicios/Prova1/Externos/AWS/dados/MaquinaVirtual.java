package Exercicios.Prova1.Externos.AWS.dados;

import dados.TipoOS;

public abstract class MaquinaVirtual {
    protected String idMaquina;
    protected int vCpus;
    private TipoOS os;

    public String getIdMaquina() {
        return idMaquina;
    }
    public void setIdMaquina(String idMaquina) {
        this.idMaquina = idMaquina;
    }

    public TipoOS getOs() {
        return os;
    }
    public void setOs(TipoOS os) {
        this.os = os;
    }

    public int getvCpus() {
        return vCpus;
    }
    public void setvCpus(int vCpus) {
        this.vCpus = vCpus;
    }

    public abstract float calularCustoMensal();

    public boolean equals(Object o){
        if(o instanceof MaquinaVirtual){
            MaquinaVirtual m = (MaquinaVirtual) o;
            if(this.idMaquina.equals(m.getIdMaquina())
                && this.os.equals(m.getOs())
                && this.vCpus == m.getvCpus()) return true;
        }
        return false;
    }

    public String toString(){
        return "ID: " + this.idMaquina + ", OS: " + this.os + ", vCpus: " + this.vCpus;
    }
}
