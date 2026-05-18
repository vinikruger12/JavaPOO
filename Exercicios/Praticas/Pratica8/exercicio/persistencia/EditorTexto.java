package persistencia;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class EditorTexto{
    
    public List<String> leTexto(String caminho){
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
            System.err.println("Erro na leitura do arquivo.");
        }
        return dados;
    }

    public void gravaTexto(String caminho, List<String> dados){
        Writer arquivo;

        try{
            arquivo = new FileWriter(caminho);
            for(String i : dados){
                arquivo.write(i + "\n");
            }
            arquivo.close();
        }
        catch(IOException e){
            System.err.println("Erro na escrita do arquivo.");
        }
    }

}
