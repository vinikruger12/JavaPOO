package Exercicios.Prova1.Externos.AWS.negocio;

import Exercicios.Prova1.Externos.AWS.dados.MaquinaVirtual;
import dados.*;

public class ZonaSegura extends ZeroDisponibilidade{
    private TipoOs osPermitido;
    
    public TipoOs getOsPermitido() {
        return osPermitido;
    }
    public void setOsPermitido(TipoOs osPermitido) {
        this.osPermitido = osPermitido;
    }

    public boolean alocarMaquina(MaquinaVirtual m){
        if(this.osPermitido.equals(m.getOs())){
            return super.alocarMaquina(m);
        }
        return false;
    }


}
