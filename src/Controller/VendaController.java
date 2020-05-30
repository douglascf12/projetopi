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
        try {

            retorno = VendaDAO.ConsultaClienteVenda(cpf);
            return retorno;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VendaController.class.getName()).log(Level.SEVERE, null, ex);
            retorno = null;
            return retorno;
        }

    }

    public static  Produto PesquisarProdutosVendas(int idProduto) {
        Produto p = new Produto();
        try {
            p = VendaDAO.ConsultDadosProduto(idProduto);
            return p;

        } catch (Exception ex) {
            Logger.getLogger(VendaController.class.getName()).log(Level.SEVERE, null, ex);
            p = null;
            return p;

        }

    }

}
