/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cliente;
import model.Venda;
import utils.ConexaoMySql;
import model.Produto;

/**
 *
 * @author Usuário
 */
public class VendaDAO {

    public static String ConsultaClienteVenda(String cpf) throws ClassNotFoundException {

        String retorno = null;
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = ConexaoMySql.getConexaoMySQL();

            instrucaoSQL = conexao.prepareStatement("select nome from Cliente where cpf = ?");
            instrucaoSQL.setString(1, cpf);
            rs = instrucaoSQL.executeQuery();
            retorno = rs.getString("nome");

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            retorno = null;

        }

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

        return retorno;

    }

    public static Produto ConsultDadosProduto(int codProd) {

        Produto p = new Produto();
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = ConexaoMySql.getConexaoMySQL();

            instrucaoSQL = conexao.prepareStatement("select nome_produto, preco ,qtd_estoque from produto where cod_produto = ?");
            instrucaoSQL.setInt(1, codProd);
            rs = instrucaoSQL.executeQuery();
            
            p.setNome(rs.getString("nome_produto"));
            p.setValorUnit(rs.getDouble("preco"));
           
           

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            return p;

        }

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

        return p;

        }

    }


