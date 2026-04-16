package Exercicio4;
import java.util.ArrayList;
import java.util.List;


public class Turma {
    private List<Aluno> listaAlunos = new ArrayList<>();
    private int quantidade = 0;

    public void adicionarAluno(Aluno aluno){
        this.listaAlunos.add(aluno);
        this.quantidade++;
    }

    private void ordenaAlunosPorMedia(){
        for(int i = 0;i < this.quantidade;i++){
            for(int j = i;j < this.quantidade;j++){
                if(this.listaAlunos.get(i).calcularMedia() > this.listaAlunos.get(j).calcularMedia()){
                    Aluno aux = this.listaAlunos.get(i);
                    this.listaAlunos.set(i, listaAlunos.get(j));
                    this.listaAlunos.set(j, aux);
                }
            }
        }
    }

    public List<Equipe<Aluno>> separarEmEquipes(){
        ordenaAlunosPorMedia();
        List<Equipe<Aluno>> equipes = new ArrayList<>();
        int l = 0, r = quantidade-1;
        int numero = 1;
        
        while(l <= r){
            
            Equipe<Aluno> equipe = new Equipe<>();
            equipe.setName("Equipe " + numero);
            equipe.adicionarMembro(listaAlunos.get(r));

            if(l != r) equipe.adicionarMembro(listaAlunos.get(l));
            r--;
            l++;
            
            if(l <= r){
                equipe.adicionarMembro(listaAlunos.get(r));
                if(l != r) equipe.adicionarMembro(listaAlunos.get(l));
                r--;
                l++;
            }

            equipes.add(equipe);
            numero++;
        }

        return equipes;

    }


}
