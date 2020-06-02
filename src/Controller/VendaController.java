package Controller;

import DAO.VendaDAO;
import model.Produto;
import model.Venda;
public class VendaController {

    public static boolean CadastrarVenda(String cpf,String codigo, String datadavenda,Double valorTotal ,String qtdVendida) {
        boolean retorno;
        Venda pVenda = new Venda();
        pVenda.setCpf(cpf);
        pVenda.setCodigo(codigo);
        pVenda.setDatadavenda(datadavenda);
        pVenda.setValorTotal(valorTotal);
        pVenda.setQtdVendida(qtdVendida);
        retorno=VendaDAO.CadastrarVenda(pVenda);
        //retorno=true;
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
