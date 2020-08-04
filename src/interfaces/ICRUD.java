
package interfaces;
import classesdedados.*;
import java.util.ArrayList;

public interface ICRUD {
    
    void incluir(Contato objeto)throws Exception;
    public ArrayList<Contato> recuperar()throws Exception;
    void excluir(String nome)throws Exception;
    void alterar(Contato contatoAntigo, Contato contatoNovo)throws Exception;
}
