package Exercicios.Prova1.Externos.Netflix.dados;

public class Serie extends Midia{
    private int quantTemporadas;
    private int episodiosPorTemp;
    private int duracaoMedia;

    public void setQuantTemporadas(int quantTemporadas) {
        this.quantTemporadas = quantTemporadas;
    }
    public int getQuantTemporadas() {
        return this.quantTemporadas;
    }

    public void setDuracaoMedia(int duracaoMedia) {
        this.duracaoMedia = duracaoMedia;
    }
    public int getDuracaoMedia() {
        return this.duracaoMedia;
    }
    
    public void setEpisodiosPorTemp(int episodiosPorTemp) {
        this.episodiosPorTemp = episodiosPorTemp;
    }
    public int getEpisodiosPorTemp() {
        return this.episodiosPorTemp;
    }

    public int calcularTempoMaratona(){
        return this.quantTemporadas*this.episodiosPorTemp*this.duracaoMedia;
    }

}
