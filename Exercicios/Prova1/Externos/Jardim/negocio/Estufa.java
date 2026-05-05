package Exercicios.Prova1.Externos.Jardim.negocio;
import dados.*;

public class Estufa extends Canteiro{
    private Clima climaInterno;

    public Clima getClimaInterno() {
        return climaInterno;
    }
    public void setClimaInterno(Clima climaInterno) {
        this.climaInterno = climaInterno;
    }

    public boolean adicionarPlanta(Planta planta){
        if(planta.getClima() != this.climaInterno) return false;
        super.plantas.add(planta);
        return true;
    }
}
