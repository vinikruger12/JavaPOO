package persistencia;

import java.util.ArrayList;
import java.util.List;

import dados.*;

public class ArquivoPessoaDAO {
    private final String caminho = "/Users/viniciuskruger/Documents/Estudos/JavaPOO/Exercicios/Praticas/Pratica8/pessoas.txt";
    private EditorTexto editarTexto = new EditorTexto();

    private String toCSV(Pessoa pessoa){
        String p = pessoa.getNome() + ",";
        p += pessoa.getIdade() + ",";
        p += pessoa.getAltura() + ",";
        p += pessoa.getMassa();

        return p;
    }

    private Pessoa fromCSV(String linhaCSV){
        String atributos[] = linhaCSV.split(",");

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(atributos[0]);
        pessoa.setIdade(Integer.parseInt(atributos[1]));
        pessoa.setAltura(Float.parseFloat(atributos[2]));
        pessoa.setMassa(Float.parseFloat(atributos[3]));

        return pessoa;
    }


    private List<String> listaPessoaToString(List<Pessoa> pessoas){
        List<String> listaPessoas = new ArrayList<>();

        for(Pessoa p : pessoas){
            listaPessoas.add(toCSV(p));
        }
        return listaPessoas;
    }

    private List<Pessoa> stringToListaPessoa(List<String> listaPessoas){
        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        for(String s : listaPessoas){
            pessoas.add(fromCSV(s));
        }

        return pessoas;
    }

    public List<Pessoa> lePessoaArquivo(){
        return stringToListaPessoa(editarTexto.leTexto(caminho));
    }

    public void salvaPessoaArquivo(Pessoa pessoa){
        editarTexto.gravaTexto(caminho, toCSV(pessoa));
    }

    public void salvaPessoasArquivo(List<Pessoa> pessoas){
        editarTexto.gravaTexto(caminho, listaPessoaToString(pessoas));
    }

}
