package Exercicios.Prova1.Externos.AWS.dados;

public class InstanciaEC2 extends MaquinaVirtual{
    private boolean ipDedicado;

    public void setIpDedicado(boolean ipDedicado) {
        this.ipDedicado = ipDedicado;
    }
    public boolean getIpDedicado(){
        return this.ipDedicado;
    }

    public float calularCustoMensal(){
        float add = 0;
        if(this.ipDedicado) add = 15;
        return (super.vCpus * 20) + add;
    }

}
