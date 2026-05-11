package persistencia;

import java.util.*;
import java.io.*;

public class EditorTexto {
    public void gravaTexto(String caminho, List<String> dados) {
        Writer arquivo;

        try {
            arquivo = new FileWriter(caminho);
            for (String i : dados) {
                arquivo.write(i + "\n");
            }
            arquivo.close();
        }
        catch (IOException e) {
            System.err.println("Erro na escrita do arquivo.");
        }
    }

    public void gravaTexto (String caminho, String linha) {
        Writer arquivo;
        try {
            arquivo = new FileWriter(caminho, true);
            arquivo.write(linha + "\n");
            arquivo.close();        
        }
        catch (IOException e) {
            System.err.println("Erro na escrita do arquivo");
        }
    }

    public List<String> leTexto (String caminho) {
        List<String> dados = new ArrayList<String>();

        Reader arquivo;
        Scanner r;

        try {
            arquivo = new FileReader(caminho);
            r = new Scanner(arquivo);

            while (r.hasNextLine()) {
                dados.add(r.nextLine());
            }

            arquivo.close();
        }
        catch (IOException e) {
            System.err.println("Erro na leitura do arquivo.");
        }

        return dados;
    }
}
