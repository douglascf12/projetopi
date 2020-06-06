package Controller;

import DAO.VendaDAO;
import model.Produto;
import model.Venda;

/**
 * A classe <b>VendaControler</b> é usada para intermediar as informações entre a model e view
 * @author Andrea Pereira dos Santos
 * @author Carlos Eduardo Silva
 * @author Débora Ramos Teixeira Souza
 * @author Douglas Cardoso Ferreira
 * @author Francisco Washigton Almeida de Oliveira
 *  
 */




public class VendaController {
    
    /**
     *Método <b>CadastrarVenda</b> recebe as informações de cadastro contidas na View e manda gravar na base de dados
     *@param cpf 
     *@param datavenda
     *@param valortotal
     *@return retorna um inteiro informando a quantidade de linahs afetadas
     */

    public static int CadastrarVenda(String cpf, String datadavenda,Double valorTotal) {
        int retorno=1;
        //Criando objeto da classe Venda
        Venda pVenda = new Venda();
        //o objeto criado recebe as informações adicionadas na TelaVendasView
        pVenda.setCpf(cpf);
        pVenda.setDatadavenda(datadavenda);
        pVenda.setValorTotal(valorTotal);
        retorno=VendaDAO.CadastrarVenda(pVenda);
        //retorno=true;
        return retorno;
    }
    
    /**
     *Método <b>CadastrarDetalheVenda</b> recebe as informações de cadastro contidas na View e manda gravar na base de dados
     *@param cpf 
     *@param id_venda
     *@param cod_produto
     *@param qtdVendida
     * @return boolean true: Detalhe da Venda Cadastrado false: falha no Cadastro
     */
    public static boolean CadastrarDetalheVenda(String cpf, int id_venda, String cod_produto, String qtdVendida){
        boolean retorno=false;
        //cria um objeto da classe Venda 
        Venda pVenda = new Venda();
        // o objeto criado recebe as informações adicionadas na TelaVendasView
        pVenda.setCpf(cpf);
        pVenda.setIdVenda(id_venda);
        pVenda.setCodigo(cod_produto);
        pVenda.setQtdVendida(qtdVendida);
       //grava a informação na base de dados
        retorno = VendaDAO.CadastrarDetalheVenda(pVenda);
        return retorno;
    }
/**
 *Metódo <b>PesquisarNomeVenda</b> recebe o cpf do lceinte da View
 *@param cpf
 *@return retorna uma String obtida da base de dados Contendo o nome do cliente 
 * 
 */
    public static String PesquisarNomeVenda(String cpf) {
        String retorno;
        //chama função da classe VendaDAO passando o cpf como parametro
        retorno = VendaDAO.ConsultaClienteVenda(cpf);
        return retorno;

    }
    
 /**
 *Metódo <b>PesquisarProdutosVenda</b> recebe o cpf do lceinte da View
 *@param idProduto
 *@return Objeto preenchido da classe Produto
 * 
 */

    public static Produto PesquisarProdutosVendas(int idProduto) {
        // Cria um onjeto da classe Produto
        Produto p = new Produto();
        // Preenche o objeto com os dados referentes ao do idPorduto
        p = VendaDAO.ConsultDadosProduto(idProduto);

        return p;
    }

}
