package persistencias;

import interfaces.ICRUD;
import classesdedados.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author roger
 */
public class ContatoPersistencia implements ICRUD {

    private String nomeDoArquivoNoDisco = "";

    public ContatoPersistencia(String nomeDoArquivo) {
        nomeDoArquivoNoDisco = nomeDoArquivo;
    }

    @Override
    public void incluir(Contato objeto) throws Exception {
        try {
            // A classe FileWriter instancia a referência "fr", com
            // o construtor que recebe o nome do arquivo como parâmetro
            // o true indica se o arquivo existe, é apenas gravado os dados
            // caso contrário, é criado o arquivo
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco, true);
            // A classe BufferedWriter controla a gravação e instancia uma referência
            BufferedWriter bw = new BufferedWriter(fw);
            // o objeto "gravar", grava os dados de um objeto do tipo Contato
            bw.write(objeto.toString() + "\n");
            //fecha o arquivo
            bw.close();

        } catch (Exception erro) {
            throw erro;
        }
    }

    // Método recuperar, apresentar a lista de contatos na grid
    @Override
    public ArrayList<Contato> recuperar() throws Exception {
        try {
            // Aqui é criado a referência "ListaDeContatos" ArrayList do tipo Contato
            // Com construtor padrão
            ArrayList<Contato> ListaDeContatos = new ArrayList<Contato>();
            // A classe FileReader faz a leitura do arquivo já existente
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            // A classe BufferedReader faz o controle na leitura
            BufferedReader br = new BufferedReader(fr);
            // Abaixo criamos uma variável "linha" do tipo String , que
            // irá receber os dados de uma linha do arquivo;
            String linha = "";
            // Abaixo um laço de repetição. Enquanto a linha for diferente de vazia
            // ou seja, enquanto a linha tiver algum conteúdo, repita o laço 
            // enquanto o br faz a leitura de cada linha           
            while ((linha = br.readLine()) != null) {
                // Criando uma referência "objetoContato" do tipo Contato,
                // recebendo os dados da linha como parâmetro
                Contato objetoContato = new Contato(linha);
                // Abaixo, a referência "ListaDeContatos", adiciona
                // dentro da ArrayList (ListaDeContatos) os dados de um objetoContato do tipo Contato
                ListaDeContatos.add(objetoContato);
            }
            br.close();
            // Método para ordenar a lista de contatos 
            Collections.sort(ListaDeContatos);
            // O return apresenta o vetor (arraylist) já ordenado
            return ListaDeContatos;

        } catch (Exception erro) {
            throw erro;
        }
    }

    // Método excluir semelhante ao método recuperar
    @Override
    public void excluir(String nome) throws Exception {
        try {
            ArrayList<Contato> ListaDeContatos = recuperar();

            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
            BufferedWriter bw = new BufferedWriter(fw);

            // Laço de repetição 
            for (int pos = 0; pos < ListaDeContatos.size(); pos++) {
                // Referência "aux" do tipo Contato, recebendo a lista
                // de contatos(posição por posição)
                Contato aux = new Contato();
                aux = ListaDeContatos.get(pos);

                if (!nome.equalsIgnoreCase(aux.getNomeCompleto())) {
                    // Abaixo é gravado novamente todas as posições do arquivo
                    bw.write(aux.toString() + "\n");
                }
            }

            bw.close();
        } catch (Exception erro) {
            throw erro;
        }

    }

    @Override
    public void alterar(Contato contatoAntigo, Contato contatoNovo) throws Exception {

        try {
            ArrayList<Contato> ListaDeContatos = recuperar();

            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int pos = 0; pos < ListaDeContatos.size(); pos++) {
                Contato aux = ListaDeContatos.get(pos);

                if (!contatoAntigo.getNomeCompleto().equalsIgnoreCase(aux.getNomeCompleto())) {
                    bw.write(aux.toString() + "\n");
                }else {
                    bw.write(contatoNovo.toString() + "\n");
                }
            }
            bw.close();

        } catch (Exception erro) {
            throw erro;
        }
    }
}
