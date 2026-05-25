package dados;
import java.lang.Math;

public class Losango extends FormaGeometrica{
    
    public void setD(int valor){
        super.medida1 = valor;
    }

    public void setd(int valor){
        super.medida2 = valor;
    }

    public int calcularArea(){
        return (int)(medida1*medida2)/2;
    }

    public int calcularPerimetro(){
        return (int)(4 * Math.sqrt(((medida1*medida1)/4.0) + ((medida2*medida2)/4.0)));    
    }

    public String toString() {
        return "Losango - Area: " + this.calcularArea() + ", Perimetro: "+ this.calcularPerimetro();
    }
}
