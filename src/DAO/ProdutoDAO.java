package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Produto;
import utils.ConexaoMySql;

/**
 * A classe <b>ProdutoDAO</b> recebe, lê e grava os dados de acordo com o Banco de Dados
 * @author Andrea Pereira dos Santos
 * @author Carlos Eduardo Silva
 * @author Débora Ramos Teixeira Souza
 * @author Douglas Cardoso Ferreira
 * @author Francisco Washigton Almeida de Oliveira
 */
public class ProdutoDAO {
    PreparedStatement addSQL = null;
    private static Connection conexao;
/**
 * O método <b>Cadastrar</b> faz a inclusão de um novo produto no Banco de Dados
 * @param produto
 * @return bolean true: inclusão de produto realizado - false: falha na inclusão do produto
 */
    public static boolean Cadastrar(Produto produto) {
        boolean retorno = false;
        PreparedStatement addSQL = null;
        
        try {
            //Abrindo a conexão com o banco de dados
            conexao = ConexaoMySql.getConexaoMySQL();
            //Instrução SQL
            addSQL = conexao.prepareStatement("INSERT INTO Produto (cod_produto,nome_produto,descricao,preco,qtd_estoque,setor) VALUES(?,?,?,?,?,?);",
                    Statement.RETURN_GENERATED_KEYS);
            //Adicionando parâmetros ao comando SQL
            addSQL.setInt(1, produto.getCodigo());
            addSQL.setString(2, produto.getNome());
            addSQL.setString(3, produto.getDescricao());
            addSQL.setDouble(4, produto.getValorUnit());
            addSQL.setInt(5, produto.getQtdEstoque());
            addSQL.setString(6, produto.getSetor());
            //Executando a instrução SQL
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
/**
 * O método <b>ConsultarProduto</b> faz a consulta do produto no Banco de Dados, através do seu código e retorna um Array com todas as informações do produto
 * @param codigo
 * @return Array - listaProduto
 */
    public static ArrayList<Produto> ConsultarProduto(String codigo) {
        //Criando um Array de tipo Produto que receberá os atributos do produto
        ArrayList<Produto> listaProduto = new ArrayList<>();

        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = ConexaoMySql.getConexaoMySQL();
            if(codigo != null) {
                //Caso queira retornar o ID
                instrucaoSQL = conexao.prepareStatement("SELECT * FROM produto where cod_produto LIKE ?");
                instrucaoSQL.setString(1, "%" + codigo + '%');
            } else {
                //Caso queira retornar o ID
                instrucaoSQL = conexao.prepareStatement("SELECT * FROM produto");
            }
            
            rs = instrucaoSQL.executeQuery();
            
            //Pega todos os atributos de produto e adiciona no Array de tipo Produto
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
            //Libera os recursos da memória
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
/**
* O método <b>Atualizar</b> faz a alteração de dados do produto no Banco de Dados
* @param produto
* @return bolean true: produto alterado com sucesso - false: falha ao alterar produto
*/
    public static boolean Atualizar(Produto produto) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement addSQL = null;

        try {
            //Abrindo a conexão com o Banco de Dados
            conexao = ConexaoMySql.getConexaoMySQL();
            //Instrução SQL
            addSQL = conexao.prepareStatement("UPDATE produto SET nome_produto=?, descricao=?, preco=?, qtd_estoque=?, setor=? WHERE cod_produto=?;");
            //Adicionando parâmetros ao comando SQL
            addSQL.setString(1, produto.getNome());
            addSQL.setString(2, produto.getDescricao());
            addSQL.setDouble(3, produto.getValorUnit());
            addSQL.setInt(4, produto.getQtdEstoque());
            addSQL.setString(5, produto.getSetor());
            addSQL.setInt(6, produto.getCodigo());
            //Executando a isntrução SQL
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
/**
* O método <b>Excluir</b> faz a exclusão do produto no Banco de Dados pelo seu código
* @param codigo
* @return bolean true: produto excluido com sucesso - false: falha ao excluir produto
*/
    public static boolean Excluir(int codigo) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement addSQL = null;

        try {
            //Abrindo a conexão com o Banco de Dados
            conexao = ConexaoMySql.getConexaoMySQL();
            //Instrução SQL para excluir produto do Banco de Dados pelo seu código
            addSQL = conexao.prepareStatement("DELETE FROM produto WHERE cod_produto=?");
            addSQL.setInt(1, codigo);
            //Executando a isntrução SQL
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