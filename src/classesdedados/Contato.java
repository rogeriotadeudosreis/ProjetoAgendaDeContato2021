package classesdedados;

public class Contato implements Comparable<Contato>{

    private String nomeCompleto = "";
    private String telefone = "";
    private String email = "";
    private Endereco enderecoResidencial = null;

    public Contato() {

    }

    public Contato(String nomeCompleto, String telefone, String email,
            String logradouro, int numero) {

        this.nomeCompleto = nomeCompleto;
        this.telefone = telefone;
        this.email = email;
        //Endereco objetoEnd = new Endereco(logradouro,  numero);
        this.enderecoResidencial = new Endereco(logradouro, numero);
    }

    public Contato(String nomeCompleto, String telefone, String email,
            Endereco enderecoResidencial) {
        this.nomeCompleto = nomeCompleto;
        this.telefone = telefone;
        this.email = email;
        this.enderecoResidencial = new Endereco(enderecoResidencial.getLogradouro(), enderecoResidencial.getNumero());

    }

    public Contato(Contato objeto) {
        this.nomeCompleto = objeto.nomeCompleto;
        this.telefone = objeto.telefone;
        this.email = objeto.email;
        this.enderecoResidencial = new Endereco(objeto.enderecoResidencial.getLogradouro(),
                objeto.enderecoResidencial.getNumero());
    }
    
    public Contato(String strDados)throws Exception{
        String vetorString[] = strDados.split(";");
        if (vetorString.length < 5){
        throw new Exception("Faltam dados na String");
        }    
        nomeCompleto = vetorString[0];
        telefone = vetorString[1];
        email = vetorString[2];
        enderecoResidencial = new Endereco(vetorString[3],
                Integer.parseInt(vetorString[4]));        
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEnderecoResidencial() {
        return enderecoResidencial;
    }

    public void setEnderecoResidencial(Endereco enderecoResidencial) {
        this.enderecoResidencial = enderecoResidencial;
    }

    @Override
    public String toString() {
        String saida = nomeCompleto + ";";
        saida += telefone + ";";
        saida += email + ";";
        saida += enderecoResidencial.getLogradouro() + ";";
        saida += enderecoResidencial.getNumero() + ";";
        return saida;
    }    

    // Método para ordenar uma ArrayList
    @Override
    public int compareTo(Contato objeto) {
        return nomeCompleto.compareToIgnoreCase(objeto.getNomeCompleto());
    }

}
