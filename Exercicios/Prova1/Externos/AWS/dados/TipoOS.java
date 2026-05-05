package Exercicios.Prova1.Externos.AWS.dados;

public enum TipoOS {
    LINUX("Linux"), WINDOWS("Windows"), MACOS("MacOs");

    private String tipoOs;
    private TipoOS(String tipoOs){
        this.tipoOs = tipoOs;
    }

    public String getTipoOs() {
        return tipoOs;
    }
    
}
