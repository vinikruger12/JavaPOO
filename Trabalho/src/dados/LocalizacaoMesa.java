package dados;

public enum LocalizacaoMesa {
    SALAO("Salão"), VARANDA("Varanda"),
    MEZANINO("Mezanino");

    private String localizacaoMesa;
    private LocalizacaoMesa(String localizacaoMesa){
        this.localizacaoMesa = localizacaoMesa;
    }

    public String getLocalizacaoMesa() {
        return localizacaoMesa;
    }
}