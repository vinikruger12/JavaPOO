package dados;

public class Pagamento {
    private FormaPagamento formaUtilizada;
    private double valorPago;
    private String dataHora;


    public FormaPagamento getFormaUtilizada(){
        return formaUtilizada; 
    }
    public void setFormaUtilizada(FormaPagamento forma){
        this.formaUtilizada = forma; 
    }
    public double getValorPago(){
        return valorPago; 
    }
    public void setValorPago(double valor){
        this.valorPago = valor; 
    }
    public String getDataHora(){
        return dataHora; 
    }
    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String toString() {
        return "PAGAMENTO \n" + "FORMA: " + this.formaUtilizada.getFormaPagamento() + "\n" + 
        "VALOR: " + this.valorPago + "\n" + "DATA/HORA: " + this.dataHora;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Pagamento) {
            Pagamento p = (Pagamento) obj;
            if (this.formaUtilizada == p.getFormaUtilizada()
                && this.valorPago == p.getValorPago()
                && this.dataHora.equals(p.getDataHora())) return true;
        }
        return false;
    }
}