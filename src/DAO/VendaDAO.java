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
 * @author Usuário
 */
public class VendaDAO {

    public static String ConsultaClienteVenda(String cpf) {

        String retorno = null;
        ResultSet rs = null;
        Connection conexao;
        PreparedStatement instrucaoSQL = null;

        try {

            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = ConexaoMySql.getConexaoMySQL();

            instrucaoSQL = conexao.prepareStatement("SELECT nome FROM cliente where cpf LIKE ?");
            instrucaoSQL.setString(1, "%" + cpf + '%');

            rs = instrucaoSQL.executeQuery();

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
        return retorno;
    }

    public static Produto ConsultDadosProduto(int codProd) {

        Produto p = new Produto();

        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {

            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = ConexaoMySql.getConexaoMySQL();
            if (codProd != 0) {
                instrucaoSQL = conexao.prepareStatement("SELECT nome_produto,preco FROM produto where cod_produto LIKE ?");  //Caso queira retornar o ID
                instrucaoSQL.setString(1, "%" + codProd + '%');
            }

            rs = instrucaoSQL.executeQuery();

            if (rs.next()) {
                p.setNome(rs.getString("nome_produto"));
                p.setValorUnit(rs.getDouble("preco"));
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

        return p;
    }

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

            //Exercuto a Instrução SQL
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

    public static boolean CadastrarDetalheVenda(Venda pVenda) {
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        boolean retorno = false;
        ResultSet rs = null;
        try {
            conexao = ConexaoMySql.getConexaoMySQL();

            instrucaoSQL = conexao.prepareStatement("INSERT INTO detalhe_venda(cpf,cod_produto,id_venda,qtd_vendida) VALUES(?,?,?,?)");
            instrucaoSQL.setString(1, pVenda.getCpf());
            instrucaoSQL.setString(2, pVenda.getCodigo());
            instrucaoSQL.setInt(3, pVenda.getIdVenda());
            instrucaoSQL.setString(4, pVenda.getQtdVendida());
            //Exercuto a Instrução SQL
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
