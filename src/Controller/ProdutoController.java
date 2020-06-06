package Controller;

import DAO.ProdutoDAO;
import java.util.ArrayList;
import model.Produto;

/**
 * A classe <b>ProdutoController</b> é usada para intermediar as informações entre a model e view
 * @author Andrea Pereira dos Santos
 * @author Carlos Eduardo Silva
 * @author Débora Ramos Teixeira Souza
 * @author Douglas Cardoso Ferreira
 * @author Francisco Washigton Almeida de Oliveira
 *  
 */

public class ProdutoController {
/**
 * O método <b>Cadastrar</b> recebe as informações de cadastro contidas na View e manda gravar no banco de dados
 * @param codigo
 * @param nome
 * @param descricao
 * @param valorUnit
 * @param qtdEstoque
 * @param setor
 * @return boolean true:ação cadastrar executada - false:falha no cadastro
 */    
    public static boolean Cadastrar(int codigo, String nome, String descricao, double valorUnit, int qtdEstoque, String setor) {
        //criando um objeto do tipo Produto
        Produto objProduto = new Produto();
        //o objeto criado recebe as informações adicionadas na CadastrarProdutoView
        objProduto.setCodigo(codigo);
        objProduto.setNome(nome);
        objProduto.setDescricao(descricao);
        objProduto.setValorUnit(valorUnit);
        objProduto.setQtdEstoque(qtdEstoque);
        objProduto.setSetor(setor);
        
        //grava as informação no banco de dados
        boolean retorno = ProdutoDAO.Cadastrar(objProduto);

        return retorno;
    }
/**
 * O método <b>ConsultarProduto</b> recebe o código do produto da classe CadastrarProdutoView e chama 
 * a classe ProdutoDAO que faz a requisão do produto no Banco de Dados e retorna um Array com os atributos do produto
 * @param codigo
 * @@return Array - retorno
 */ 
    public static ArrayList<String[]> ConsultarProduto(String codigo) {
        //Criando um Array de tipo Produto que receberá os atributos do produto
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        //Passa o codigo do produto para ProdutoDAO que retorna um Array com os atributos do produto
        //que são passado pro Array listaProdutos criado antes
        listaProdutos = ProdutoDAO.ConsultarProduto(codigo);

        ArrayList<String[]> retorno = new ArrayList<>();
        //Pega todos os atributos do Array listaProdutos e adiciona no Array de tipo String
        for(Produto produto : listaProdutos) {
            retorno.add(new String[]{
                String.valueOf(produto.getCodigo()),
                String.valueOf(produto.getNome()),
                String.valueOf(produto.getDescricao()),
                String.valueOf(produto.getValorUnit()),
                String.valueOf(produto.getQtdEstoque()),
                String.valueOf(produto.getSetor()),});
        }
        //retorna um Array do tipo String com todas as informações do produto
        return retorno;
    }
/**
 * O método <b>Atualizar</b> recebe as informações de cadastro e atualiza os dados alterados no cadastro
 * @param codigo
 * @param nome
 * @param descricao
 * @param valorUnit
 * @param qtdEstoque
 * @param setor
 * @return boolean true: ação atualizar executada - false: falha na atualização
 */
    public static boolean Atualizar(int codigo, String nome, String descricao, double valorUnit, int qtdEstoque, String setor) {
        //criando um objeto do tipo Produto
        Produto objProduto = new Produto();
        //o objeto criado recebe as informações adicionadas na CadastrarClienteView
        objProduto.setCodigo(codigo);
        objProduto.setNome(nome);
        objProduto.setDescricao(descricao);
        objProduto.setValorUnit(valorUnit);
        objProduto.setQtdEstoque(qtdEstoque);
        objProduto.setSetor(setor);
        
        //grava as informação no banco de dados
        boolean retorno = ProdutoDAO.Atualizar(objProduto);

        return retorno;
    }
/**
 * O método <b>Excluir</b> recebe o código do produto e passa para classe ProdutoDAO, que faz a exclusão no Banco de Dados.
 * @param codigo
 * @return boolean true: ação excluir executada - false: falha na exclusão
 */
    public static boolean Excluir(int codigo) {
        boolean retorno = ProdutoDAO.Excluir(codigo);
        return retorno;
    }
}