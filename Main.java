package AD2;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Estou criando minha Lista Circular
        ListaCircular minhaLista = new ListaCircular();

        // Criando um file para ter o controle do arquivo
        File f = new File("teste.txt");
        String caminho = f.getAbsolutePath(); //pegando o caminho absoluto do arquivo
        String passo = "";
        int passoInt = 0;  // essa variavel que vai guardar o passo para a morte de quem esta no circulo

       // bloco de Excessão para qualquer problema na leitura do arquivo
        try {
            // usando o BufferedReader para ler o Arquivo
            BufferedReader br = new BufferedReader(new FileReader(caminho));

            String linha = br.readLine();

            do {
                if (!(linha.isEmpty())) {

                    minhaLista.add(linha);
                    linha = br.readLine();
                }

                if (linha.equalsIgnoreCase("fim")){

                    passo = br.readLine();
                    passoInt = Integer.parseInt(passo);
                }

            }while(!(linha.equalsIgnoreCase("fim")));
            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("Verifique o nome do Arquivo");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Erro inexperado Contate o Suporte");
            System.out.println(e.getMessage());
        }
        // para pegar a posição que eu deveria estar para ficar vivo
        // ele passa o passo que foi lido no arquivo texto
        System.out.print("Posição que eu deveria estar para " +
                "permanecer vivo: ");
        System.out.print(minhaLista.pegaPosicao(passoInt));
    }
}
