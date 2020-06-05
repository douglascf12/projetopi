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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Cliente;
import utils.ConexaoMySql;

/**
 *
 * @author andre
 */
public class ClienteDAO {

    PreparedStatement addSQL = null;
    private static Connection conexao;

    public static boolean Cadastrar(Cliente c) {
        boolean retorno = false;
        PreparedStatement addSQL = null;

        try {

            conexao = ConexaoMySql.getConexaoMySQL();

            addSQL = conexao.prepareStatement("INSERT INTO Cliente (cpf,nome,dataNascimento,telefone,endereco, email, sexo) VALUES(?, ?, ?, ?, ?,?,?);",
                    Statement.RETURN_GENERATED_KEYS);

            addSQL.setString(1, c.getCpf());
            addSQL.setString(2, c.getNome());
            addSQL.setString(3, c.getDataNascimento());
            addSQL.setString(4, c.getTelefone());
            addSQL.setString(5, c.getEndereco());
            addSQL.setString(6, c.getEmail());
            addSQL.setString(7, c.getSexo());

            int linhasAfetadas = addSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }
            return retorno;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally {
            try {
                if (addSQL != null) {
                    addSQL.close();
                }

//                
            } catch (SQLException ex) {
            }
        }

        return retorno;
    }

    public static boolean Atualizar(Cliente c) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement addSQL = null;

        try {

            conexao = ConexaoMySql.getConexaoMySQL();

            addSQL = conexao.prepareStatement("UPDATE cliente SET nome = ?, telefone=?, endereco=?, dataNascimento=?, email=?, sexo=?  WHERE cpf = ?;");

            addSQL.setString(1, c.getNome());
            addSQL.setString(2, c.getTelefone());
            addSQL.setString(3, c.getEndereco());
            addSQL.setString(4, c.getDataNascimento() );
            addSQL.setString(5, c.getEmail() );
            addSQL.setString(6, c.getSexo() );
            addSQL.setString(7, c.getCpf());
            

            int linhasAfetadas = addSQL.executeUpdate();

            if (linhasAfetadas > 0) {
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

//                
            } catch (SQLException ex) {
            }
        }

        return retorno;
    }

    public static boolean Excluir(String cpf) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement addSQL = null;

        try {
            conexao = ConexaoMySql.getConexaoMySQL();

            addSQL = conexao.prepareStatement("DELETE FROM cliente WHERE cpf = ?");

            addSQL.setString(1, cpf);

            int linhasAfetadas = addSQL.executeUpdate();

            if (linhasAfetadas > 0) {
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

    public static ArrayList<Cliente> ConsultarCliente(String nome) {

        boolean retorno = false;
        ArrayList<Cliente> listaCliente = new ArrayList<>();

        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {

            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = ConexaoMySql.getConexaoMySQL();
            if (nome != null) {
                instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente where nome LIKE ?");  //Caso queira retornar o ID
                instrucaoSQL.setString(1, "%" + nome + '%');
            } else {
                instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente");  //Caso queira retornar o ID
            }

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente();
                cliente.setCpf(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                Date data = rs.getDate("dataNascimento");              
                SimpleDateFormat formatdata = new SimpleDateFormat("dd/MM/yyyy");
                String dataNascimento = formatdata.format(data);
                cliente.setDataNascimento(dataNascimento);
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSexo(rs.getString("sexo"));
                listaCliente.add(cliente);

            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            listaCliente = null;
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

        return listaCliente;
    }
}
