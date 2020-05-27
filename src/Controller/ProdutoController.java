package Controller;

import DAO.ProdutoDAO;
import java.util.ArrayList;
import model.Produto;

public class ProdutoController {
    
    public static boolean Cadastrar(int codigo, String nome, String descricao, double valorUnit, int qtdEstoque, String setor) {
        Produto objProduto = new Produto();
        objProduto.setCodigo(codigo);
        objProduto.setNome(nome);
        objProduto.setDescricao(descricao);
        objProduto.setValorUnit(valorUnit);
        objProduto.setQtdEstoque(qtdEstoque);
        objProduto.setSetor(setor);

        boolean retorno = ProdutoDAO.Cadastrar(objProduto);

        return retorno;
    }

    public static ArrayList<String[]> ConsultarProduto(String codigo) {
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        listaProdutos = ProdutoDAO.ConsultarProduto(codigo);

        ArrayList<String[]> retorno = new ArrayList<>();

        for(Produto produto : listaProdutos) {
            retorno.add(new String[]{
                String.valueOf(produto.getCodigo()),
                String.valueOf(produto.getNome()),
                String.valueOf(produto.getDescricao()),
                String.valueOf(produto.getValorUnit()),
                String.valueOf(produto.getQtdEstoque()),
                String.valueOf(produto.getSetor()),});
        }
        return retorno;
    }

    public static boolean Atualizar(int codigo, String nome, String descricao, double valorUnit, int qtdEstoque, String setor) {
        Produto objProduto = new Produto();
        objProduto.setCodigo(codigo);
        objProduto.setNome(nome);
        objProduto.setDescricao(descricao);
        objProduto.setValorUnit(valorUnit);
        objProduto.setQtdEstoque(qtdEstoque);
        objProduto.setSetor(setor);

        boolean retorno = ProdutoDAO.Atualizar(objProduto);

        return retorno;
    }
    
    public static boolean Excluir(int codigo) {
        boolean retorno = ProdutoDAO.Excluir(codigo);
        return retorno;
    }
}