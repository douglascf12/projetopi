/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import utils.ConexaoMySql;
import model.Produto;
import model.Venda;
/**
 *
 *@author Andrea Pereira dos Santos
 * @author Carlos Eduardo Silva
 * @author Débora Ramos Teixeira Souza
 * @author Douglas Cardoso Ferreira
 * @author Francisco Washigton Almeida de Oliveira
 *@see DAO.VendaDAO
 * 
 * Está Classe Realiza Consultas de cliente , consulta de produto e 
 * determina a quantidade de produtos , cadastrando assim a venda
 * 
 */

public class VendaDAO {
/**
 *Metódo ConsultasClienteVenda faz a consulta de um cliente já cadastrado no banco
 *@param cpf
 * @return String com o nome do cliente, caso cpf estiver na base de dados.
 */
    public static String ConsultaClienteVenda(String cpf) {

        String retorno = null;
        ResultSet rs = null;
        Connection conexao;
        PreparedStatement instrucaoSQL = null;

        try {

            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = ConexaoMySql.getConexaoMySQL();
            // Instrução SQL 
            instrucaoSQL = conexao.prepareStatement("SELECT nome FROM cliente where cpf LIKE ?");
            // Consultando Parametros do Comando SQL
            instrucaoSQL.setString(1, "%" + cpf + '%');
            // Exucutando a instrução SQL
            rs = instrucaoSQL.executeQuery();
            //  se o nome estiver na base da dados retorna o mesmo
            if (rs.next()) {
                retorno = rs.getString("nome");
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            retorno = null;
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
        // caso não tenha na base de dados retorna valor nulo
        return retorno;
    }
/**
 *Metodo ConsultDadosProduto consulta produtos existentes na base de dados
 * codPord codigo do produto
 * @return Objeto da classe Produto portando os dados equivalentes a view
 */
    public static Produto ConsultDadosProduto(int codProd) {
        // cria objeto para portar dados os necessarios 
        Produto p = new Produto();

        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {

            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = ConexaoMySql.getConexaoMySQL();
            if (codProd != 0) {
                // Instrução SQL consultando os dados necessarios para a view 
                instrucaoSQL = conexao.prepareStatement("SELECT nome_produto,preco, qtd_estoque FROM produto where cod_produto LIKE ?");  //Caso queira retornar o ID
                instrucaoSQL.setString(1, "%" + codProd + '%');
            }
            
            // Executa a instrução SQL
            rs = instrucaoSQL.executeQuery();
         
            if (rs.next()) { 
                // Adiciona nomedoproduto e o preço ai objeto
                p.setNome(rs.getString("nome_produto"));
                p.setValorUnit(rs.getDouble("preco"));
                p.setQtdEstoque(rs.getInt("qtd_estoque"));
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            p = null;
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
        // Retorno Objeto preenchido ou não
        return p;
    }
/**
 *Método CadastrarVenda cadastra a venda na base de dados
 * @param pVenda //objeto da classe venda preenchido com cpf , valordacompra , datadavenda
 * @return retorna um inteiro informando a numero de linhas afetadas
 * 
 */
    public static int CadastrarVenda(Venda pVenda) {
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        int retorno = -1;
        ResultSet rs = null;

        try {
            conexao = ConexaoMySql.getConexaoMySQL();

            //Adiciono informações na tabela Venda
            instrucaoSQL = conexao.prepareStatement("INSERT INTO Venda(cpf,valor_compra,datavenda) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            instrucaoSQL.setString(1, pVenda.getCpf());
            instrucaoSQL.setDouble(2, pVenda.getValorTotal());
            instrucaoSQL.setString(3, pVenda.getDatadavenda());

            //Executo a Instrução SQL
            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys();
                if (generatedKeys.next()) {
                    retorno = generatedKeys.getInt(1);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            retorno = -1;
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
                System.out.println(ex.getMessage());
            }
        }

        return retorno;
    }
/**
 *Método CadastrarDetalheVenda cadastra na base de dados os detalhes da venda
 *@param pVenda //objeto da classe venda preenchido para inserção no banco
 *@return boolean treu: venda cadastrada false :erro ao cadastrar relatorio
 */
    public static boolean CadastrarDetalheVenda(Venda pVenda) {
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        boolean retorno = false;
        ResultSet rs = null;
        try {
            conexao = ConexaoMySql.getConexaoMySQL();
             //Adiciono informações na tabela detalhe_venda

            instrucaoSQL = conexao.prepareStatement("INSERT INTO detalhe_venda(cpf,cod_produto,id_venda,qtd_vendida) VALUES(?,?,?,?)");
            instrucaoSQL.setString(1, pVenda.getCpf());
            instrucaoSQL.setString(2, pVenda.getCodigo());
            instrucaoSQL.setInt(3, pVenda.getIdVenda());
            instrucaoSQL.setString(4, pVenda.getQtdVendida());
            //Executo a Instrução SQL
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Venda cadastrada!");
                return true;
            } else {
                JOptionPane.showConfirmDialog(null, "Erro ao cadastrar Relatório!");
                return false;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            retorno = false;
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
                System.out.println(ex.getMessage());
            }
        }
        return retorno;
    }

}
