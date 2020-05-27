package Controller;

import DAO.ProdutoDAO;
import java.util.ArrayList;
import model.Produto;

public class ProdutoController {
    
    public static boolean Cadastrar(int codPro, String nomePro, String descricao, double precoUnit, int qtdEstoque, String setor) {
        Produto objProduto = new Produto();
        objProduto.setCodPro(codPro);
        objProduto.setNomePro(nomePro);
        objProduto.setDescricao(descricao);
        objProduto.setPrecoUnit(precoUnit);
        objProduto.setQtdEstoque(qtdEstoque);
        objProduto.setSetor(setor);

        boolean retorno = ProdutoDAO.Cadastrar(objProduto);

        return retorno;
    }

    public static ArrayList<String[]> ConsultarProduto(String codPro) {
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        listaProdutos = ProdutoDAO.ConsultarProduto(codPro);

        ArrayList<String[]> retorno = new ArrayList<>();

        for(Produto produto : listaProdutos) {
            retorno.add(new String[]{
                String.valueOf(produto.getCodPro()),
                String.valueOf(produto.getNomePro()),
                String.valueOf(produto.getDescricao()),
                String.valueOf(produto.getPrecoUnit()),
                String.valueOf(produto.getQtdEstoque()),
                String.valueOf(produto.getSetor()),});
        }
        return retorno;
    }

    public static boolean Atualizar(int codPro, String nomePro, String descricao, double precoUnit, int qtdEstoque, String setor) {
        Produto objProduto = new Produto();
        objProduto.setCodPro(codPro);
        objProduto.setNomePro(nomePro);
        objProduto.setDescricao(descricao);
        objProduto.setPrecoUnit(precoUnit);
        objProduto.setQtdEstoque(qtdEstoque);
        objProduto.setSetor(setor);

        boolean retorno = ProdutoDAO.Atualizar(objProduto);

        return retorno;
    }
    
    public static boolean Excluir(int codPro) {
        boolean retorno = ProdutoDAO.Excluir(codPro);
        return retorno;
    }
}