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
import java.util.ArrayList;
import model.Cliente;
import utils.ConexaoMySql;
import model.Produto;

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
        p.setNome("Fran");
        p.setValorUnit(200.10);
        
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

}
