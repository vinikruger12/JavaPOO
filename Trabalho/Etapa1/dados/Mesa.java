package dados;

public class Mesa {
    private int numero;
    private int capacidadePessoas;
    private LocalizacaoMesa localizacao;

    public int getNumero(){
        return numero;
    }
    public void setNumero(int numero){
        this.numero = numero; 
    }

    public int getCapacidadePessoas(){
        return capacidadePessoas; 
    }
    public void setCapacidadePessoas(int capacidadePessoas){
        this.capacidadePessoas = capacidadePessoas; 
    }
    
    public LocalizacaoMesa getLocalizacao(){
        return localizacao; 
    }
    public void setLocalizacao(LocalizacaoMesa loc){
        this.localizacao = loc; 
    }

    public String toString() {
        return "MESA \n" + "NÚMERO: " + this.numero + "\n" + 
        "CAPACIDADE: " + this.capacidadePessoas + "\n" + 
        "LOCALIZAÇÃO: " + this.localizacao.getLocalizacaoMesa();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Mesa) {
            Mesa m = (Mesa) obj;
            if (this.numero == m.getNumero()
                && this.capacidadePessoas == m.getCapacidadePessoas()
                && this.localizacao == m.getLocalizacao()) return true;
        }
        return false;
    }
}