package dados;

public enum Clima {
    TROPICAL("Tropical"), TEMPERADO("Temperado"), ARIDO("Arido");

    private String clima;
    private Clima(String clima){
        this.clima = clima;
    }

    public String getClima(){
        return this.clima;
    }
}
