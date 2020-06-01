package Controller;

import DAO.VendaDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Produto;

public class VendaController {

    public static boolean CadastrarVenda(int idproduto, int idcliente, String datadavenda) {
        return false;
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
