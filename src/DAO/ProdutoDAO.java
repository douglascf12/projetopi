package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Produto;
import utils.ConexaoMySql;

public class ProdutoDAO {
    
    PreparedStatement addSQL = null;
    private static Connection conexao;
    
    public static boolean Cadastrar(Produto produto) {
        boolean retorno = false;
        PreparedStatement addSQL = null;

        try {
            conexao = ConexaoMySql.getConexaoMySQL();
            addSQL = conexao.prepareStatement("INSERT INTO Produto (cod_produto,nome_produto,descricao,preco,qtd_estoque,setor) VALUES(?,?,?,?,?,?);",
                    Statement.RETURN_GENERATED_KEYS);
            
            addSQL.setInt(1, produto.getCodigo());
            addSQL.setString(2, produto.getNome());
            addSQL.setString(3, produto.getDescricao());
            addSQL.setDouble(4, produto.getValorUnit());
            addSQL.setInt(5, produto.getQtdEstoque());
            addSQL.setString(6, produto.getSetor());

            int linhasAfetadas = addSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }
            return retorno;

        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally {
            try {
                if(addSQL != null) {
                    addSQL.close();
                } 
            } catch(SQLException ex) {
            }
        }
        return retorno;
    }
    
    public static ArrayList<Produto> ConsultarProduto(String codigo) {
        boolean retorno = false;
        ArrayList<Produto> listaProduto = new ArrayList<>();

        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = ConexaoMySql.getConexaoMySQL();
            if(codigo != null) {
                instrucaoSQL = conexao.prepareStatement("SELECT * FROM produto where cod_produto LIKE ?");  //Caso queira retornar o ID
                instrucaoSQL.setString(1, "%" + codigo + '%');
            } else {
                instrucaoSQL = conexao.prepareStatement("SELECT * FROM produto");  //Caso queira retornar o ID
            }

            rs = instrucaoSQL.executeQuery();

            while(rs.next()) {
                Produto produto = new Produto();
                produto.setCodigo(rs.getInt("cod_produto"));
                produto.setNome(rs.getString("nome_produto"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setValorUnit(rs.getDouble("preco"));
                produto.setQtdEstoque(rs.getInt("qtd_estoque"));
                produto.setSetor(rs.getString("setor"));
                listaProduto.add(produto);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            listaProduto = null;
        } finally {
            //Libero os recursos da memória
            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }
                if (rs != null) {
                    rs.close();
                }
                ConexaoMySql.FecharConexao();
            } catch (SQLException ex) {
            }
        }
        return listaProduto;
    }
    
    public static boolean Atualizar(Produto produto) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement addSQL = null;

        try {
            conexao = ConexaoMySql.getConexaoMySQL();
            
            addSQL = conexao.prepareStatement("UPDATE produto SET nome_produto=?, descricao=?, preco=?, qtd_estoque=?, setor=? WHERE cod_produto=?;");
            
            addSQL.setString(1, produto.getNome());
            addSQL.setString(2, produto.getDescricao());
            addSQL.setDouble(3, produto.getValorUnit());
            addSQL.setInt(4, produto.getQtdEstoque());
            addSQL.setString(5, produto.getSetor());
            addSQL.setInt(6, produto.getCodigo());

            int linhasAfetadas = addSQL.executeUpdate();
            
            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally {
            try {
                if (addSQL != null) {
                    addSQL.close();
                } 
            } catch (SQLException ex) {
            }
        }
        return retorno;
    }
    
    public static boolean Excluir(int codigo) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement addSQL = null;

        try {
            conexao = ConexaoMySql.getConexaoMySQL();
            addSQL = conexao.prepareStatement("DELETE FROM produto WHERE cod_produto=?");
            addSQL.setInt(1, codigo);
            int linhasAfetadas = addSQL.executeUpdate();
            if(linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally {
            try {
                if (addSQL != null) {
                    addSQL.close();
                }
                conexao.close();
            } catch (SQLException ex) {
            }
        }
        return retorno;
    }
}