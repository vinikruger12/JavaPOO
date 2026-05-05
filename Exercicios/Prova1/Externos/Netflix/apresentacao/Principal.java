package Exercicios.Prova1.Externos.Netflix.apresentacao;
import java.util.Scanner;
import dados.*;
import negocios.*;

import java.util.List;
import java.util.ArrayList;

public class Principal {
    
    Scanner in = new Scanner(System.in);
    PlataformaStreaming plataforma = new PlataformaStreaming();

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
                    cadastrarMidia();
                    break;
                case 2:
                    removerMidia();
                    break;
                case 3:
                    mostrarPorGenero();
                    break;
                case 4:
                    mostrarTodos();
                    break;
                default:
                    break;
            }
        }
    }

    public void menu(){
        System.out.println("Digite 0 para sair");
        System.out.println("Digite 1 para cadastrar mídia");
        System.out.println("Digite 2 para remover mídia");
        System.out.println("Digite 3 para mostrar por gênero");
        System.out.println("Digite 4 para mostrar todos");

    }


    public void cadastrarMidia(){
        System.out.println("Digite 1 para adiconar um filme e 2 para adicionar série");
        int x = Integer.parseInt(in.nextLine());
        if(x == 1){
            Filme filme = new Filme();

            System.out.println("Escolha digite o indíce para escolher o gênero");
            for(int i = 0;i < Genero.values().length;i++){
                System.out.println("[" + i + "]" + Genero.values()[i]);
            }
            int indice = Integer.parseInt(in.nextLine());
            filme.setGenero(Genero.values()[indice]);
            System.out.println("Digite o nome do filme");
            filme.setTitulo(in.nextLine());
            System.out.println("Digite a data de lancamento do filme");
            filme.setAnoLancamento(Integer.parseInt(in.nextLine()));
            System.out.println("Digite a duracao em minutos do filme");
            filme.setDuracaoMinutos(Integer.parseInt(in.nextLine()));

            plataforma.adicionarMidia(filme);
        }
        else if(x == 2){
            Serie serie = new Serie();
            System.out.println("Escolha digite o indíce para escolher o gênero");
            for(int i = 0;i < Genero.values().length;i++){
                System.out.println("[" + i + "]" + Genero.values()[i]);
            }
            int indice = Integer.parseInt(in.nextLine());
            serie.setGenero(Genero.values()[indice]);

            System.out.println("Digite o nome da série");
            serie.setTitulo(in.nextLine());

            System.out.println("Digite a data de lancamento da série");
            serie.setAnoLancamento(Integer.parseInt(in.nextLine()));

            System.out.println("Digite a quantidade de temporadas");
            serie.setQuantTemporadas(Integer.parseInt(in.nextLine()));

            System.out.println("Digite a quantidade de episodios por temporada");
            serie.setEpisodiosPorTemp(Integer.parseInt(in.nextLine()));

            System.out.println("Digite a quantidade média de minutos por episódio");
            serie.setDuracaoMedia(Integer.parseInt(in.nextLine()));

            plataforma.adicionarMidia(serie);

        }
    }

    public void removerMidia(){
        
        System.out.println("Escolha digite o indíce para escolher o gênero");
        for(int i = 0;i < Genero.values().length;i++){
            System.out.println("[" + i + "]" + Genero.values()[i]);
        }
        int indice = Integer.parseInt(in.nextLine());

        if(plataforma.buscarPorGenero(Genero.values()[indice]) == null){
            System.out.println("Nenhum filme desse gênero");
            return;
        }

        List<Midia> midias = plataforma.buscarPorGenero(Genero.values()[indice]);

        for(int i = 0;i < midias.size();i++){
            System.out.println("[" + i + "] " + midias.get(i));
        }

        System.out.println("Escolha o indíce de qual voce quer remover");
        int outro = Integer.parseInt(in.nextLine());
        plataforma.removerMidia(midias.get(outro));
    }

    public void mostrarPorGenero(){
        System.out.println("Escolha digite o indíce para escolher o gênero");
        for(int i = 0;i < Genero.values().length;i++){
            System.out.println("[" + i + "]" + Genero.values()[i]);
        }
        int indice = Integer.parseInt(in.nextLine());
        if(plataforma.buscarPorGenero(Genero.values()[indice]) == null){
            System.out.println("Nenhum filme desse gênero");
            return;
        }
        
        List<Midia> midias = plataforma.buscarPorGenero(Genero.values()[indice]);

        for(int i = 0;i < midias.size();i++){
            System.out.println("[" + i + "] " + midias.get(i));
        }
    }

    public void mostrarTodos(){
        plataforma.mostrarCatalogo();
    }


    public static void main(String[] args){
        Principal princ = new Principal();
        princ.run();
    }
}
