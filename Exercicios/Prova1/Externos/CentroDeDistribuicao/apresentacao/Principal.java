package Exercicios.Prova1.Externos.CentroDeDistribuicao.apresentacao;

import java.util.Scanner;

import dados.*;
import negocios.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Principal {
    
    Scanner in = new Scanner(System.in);
    CentroDeDistribuicao centro = new CentroDeDistribuicao();

    public void run(){
        boolean flag = true;
        while(flag){
            menu();
            int opcao = Integer.parseInt(in.nextLine());
            switch (opcao) {
                case 0:
                    flag = false;
                    break;
                case 1:
                    adicionarSetor();
                    break;
                case 2:
                    adicionarCamaraFria();
                    break;
                case 3:
                    adicionarCargaComum();
                    break;
                case 4:
                    adicionarCargaRefrigerada();
                    break;
                case 5:
                    mostrarTodos();
                    break;
                default:
                    break;
            }
        }
    }   

    public void menu(){
        System.out.println("Digite 0 para sair");
        System.out.println("Digite 1 para adicionar setor");
        System.out.println("Digite 2 para adicionar camara fria");
        System.out.println("Digite 3 para adicionar carga comum");
        System.out.println("Digite 4 para adicionar carga refrigerada");
        System.out.println("Digite 5 para mostrar todos");
    }

    public void adicionarSetor(){
        System.out.println("Digite o ID do Centro de Distribuicao");
        String id = in.nextLine();
        
        Setor s = new Setor();
        System.out.println("Digite o nome do setor");
        s.setNome(in.nextLine());
        System.out.println("Digite o comprimento do setor");
        s.setComprimento(Float.parseFloat(in.nextLine()));
        System.out.println("Digite a largura do setor");
        s.setLargura(Float.parseFloat(in.nextLine()));

        centro.cadastrarSetor(id, s);
    }

    public void adicionarCamaraFria(){
        System.out.println("Digite o ID do Centro de Distribuicao");
        String id = in.nextLine();
        
        CamaraFria c = new CamaraFria();
        System.out.println("Digite o nome da camara fria");
        c.setNome(in.nextLine());
        System.out.println("Digite o comprimento da camara fria");
        c.setComprimento(Float.parseFloat(in.nextLine()));
        System.out.println("Digite a largura da camara fria");
        c.setLargura(Float.parseFloat(in.nextLine()));
        System.out.println("Digite a altura da camara fria");
        c.setAltura(Float.parseFloat(in.nextLine()));
        System.out.println("Digite a temperatura da camara fria");
        c.setTemperatura(Float.parseFloat(in.nextLine()));

        centro.cadastrarSetor(id, c);
    }

    public void adicionarCargaComum(){
        
        for(String s : centro.getSetores().keySet()){
            System.out.println("ID: " + s);
        }
        System.out.println("Digite o id que voce quer adicionar a carga comum");
        String id = in.nextLine();

        CargaComum carga = new CargaComum();
        System.out.println("Digite o id da carga");
        carga.setIdCarga(in.nextLine());
        System.out.println("Digite a largura da carga");
        carga.setLargura(Float.parseFloat(in.nextLine()));
        System.out.println("Digite o comprimento da carga");
        carga.setComprimento(Float.parseFloat(in.nextLine()));
        System.out.println("Digite o peso da carga");
        carga.setPeso(Float.parseFloat(in.nextLine()));
        System.out.println("Digite se é frágil ou não true/false");
        carga.setEhFragil(Boolean.parseBoolean(in.nextLine()));

        centro.alocarCarga(id, carga);
    }

    public void adicionarCargaRefrigerada(){
        
        for(String s : centro.getSetores().keySet()){
            System.out.println("ID: " + s);
        }

        System.out.println("Digite o id que voce quer adicionar a carga refrigerada");
        String id = in.nextLine();

        CargaRefrigerada carga = new CargaRefrigerada();
        System.out.println("Digite o id da carga");
        carga.setIdCarga(in.nextLine());
        System.out.println("Digite a largura da carga");
        carga.setLargura(Float.parseFloat(in.nextLine()));
        System.out.println("Digite o comprimento da carga");
        carga.setComprimento(Float.parseFloat(in.nextLine()));
        System.out.println("Digite a altura da carga");
        carga.setAltura(Float.parseFloat(in.nextLine()));
        System.out.println("Digite o peso da carga");
        carga.setPeso(Float.parseFloat(in.nextLine()));
        System.out.println("Digite a temperatura ideal");
        carga.setTemperaturaIdeal(Float.parseFloat(in.nextLine()));

        centro.alocarCarga(id, carga);
    }

    public void mostrarTodos(){
        for(String s : centro.getSetores().keySet()){
            System.out.println("ID: " + s);
            for(int i = 0;i < centro.getSetores().get(s).getCargas().size();i++){
                System.out.println(centro.getSetores().get(s).getCargas().get(i));
            }
        }
    }

    public static void main(String[] args){
        Principal princ = new Principal();
        princ.run();
    }
}
