package dados;
import java.lang.Math;

public class Circulo extends FormaGeometrica{
    
    public void setRaio(int valor){
        super.medida1 = valor;
    }

    public int calcularArea(){
        return (int)((medida1*medida1)*Math.PI);
    }

    public int calcularPerimetro(){
        return (int)(Math.PI*2);
    }

    public String toString() {
        return "Circulo - Area: " + this.calcularArea() + ", Perimetro: "+ this.calcularPerimetro();
    }
}
