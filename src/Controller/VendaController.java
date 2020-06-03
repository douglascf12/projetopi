package Controller;

import DAO.VendaDAO;
import model.Produto;
import model.Venda;
public class VendaController {

    public static int CadastrarVenda(String cpf, String datadavenda,Double valorTotal) {
        int retorno=1;
        Venda pVenda = new Venda();
        pVenda.setCpf(cpf);
        pVenda.setDatadavenda(datadavenda);
        pVenda.setValorTotal(valorTotal);
        retorno=VendaDAO.CadastrarVenda(pVenda);
        //retorno=true;
        return retorno;
    }
    public static boolean CadastrarDetalheVenda(String cpf, int id_venda, String cod_produto, String qtdVendida){
        boolean retorno=false;
        Venda pVenda = new Venda();
        pVenda.setCpf(cpf);
        pVenda.setIdVenda(id_venda);
        pVenda.setCodigo(cod_produto);
        pVenda.setQtdVendida(qtdVendida);
        retorno=VendaDAO.CadastrarDetalheVenda(pVenda);
        return retorno;
    }

    public static String PesquisarNomeVenda(String cpf) {
        String retorno;
        retorno = VendaDAO.ConsultaClienteVenda(cpf);
        return retorno;

    }

    public static Produto PesquisarProdutosVendas(int idProduto) {
        Produto p = new Produto();
        p = VendaDAO.ConsultDadosProduto(idProduto);

        return p;
    }

}
