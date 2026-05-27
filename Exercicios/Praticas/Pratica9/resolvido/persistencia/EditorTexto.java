package persistencia;

import java.util.List;
import java.util.Scanner;

import exceptions.*;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class EditorTexto{
    
    public List<String> leTexto(String caminho) throws ErroNaLeituraException {
        List<String> dados = new ArrayList<>();

        Reader arquivo;
        Scanner in;

        try{
            arquivo = new FileReader(caminho);
            in = new Scanner(arquivo);

            while(in.hasNextLine()){
                dados.add(in.nextLine());
            }
            arquivo.close();
        }
        catch(IOException e){
            ErroNaLeituraException el = new ErroNaLeituraException("Não foi possível abrir o arquivo!");
            el.setCaminho(caminho);
            throw el;
        }
        return dados;
    }

    public void gravaTexto(String caminho, List<String> dados) throws ErroNaEscritaException {
        Writer arquivo;

        try{
            arquivo = new FileWriter(caminho);
            for(String i : dados){
                arquivo.write(i + "\n");
            }
            arquivo.close();
        }
        catch(IOException e){
            ErroNaEscritaException eg = new ErroNaEscritaException("Não foi possível abrir o arquivo!");
            eg.setCaminho(caminho);
            throw eg;
        }
    }

}
