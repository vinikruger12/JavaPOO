package dados;
import java.lang.Math;

public class TrianguloEquilatero extends FormaGeometrica{
    
    public void setLado(int valor){
        super.medida1 = valor;
    }

    public int calcularArea(){
        return (int)(Math.sqrt(3)*(medida1*medida1)/4);
    }

    public int calcularPerimetro(){
        return 3*medida1;
    }

    public String toString() {
        return "Triangulo Equilatero - Area: " + this.calcularArea() + ", Perimetro: "+ this.calcularPerimetro();
    }
}
