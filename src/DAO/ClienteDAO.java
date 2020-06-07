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
 * @author Andrea Pereira dos Santos
 * @author Carlos Eduardo Silva
 * @author Débora Ramos Teixeira Souza
 * @author Douglas Cardoso Ferreira
 * @author Francisco Washigton Almeida de Oliveira
 * 
 * Está classe recebe, lê e grava os dados de acordo com o banco de dados
 */
public class ClienteDAO {
    PreparedStatement addSQL = null;
    private static Connection conexao;
/**
 * Método cadastrar faz a inclusão de um novo cliente no banco de dados
 * @param c
 * @return bolean true:inclusão de casdastro realizado - false: falha na inclusão
 */
    public static boolean Cadastrar(Cliente c) {
        boolean retorno = false;
        PreparedStatement addSQL = null;

        try {
           //Abrindo a conexão com o banco de dados
            conexao = ConexaoMySql.getConexaoMySQL();
            //Instrução SQL
            addSQL = conexao.prepareStatement("INSERT INTO Cliente (cpf,nome,dataNascimento,telefone,endereco, email, sexo) VALUES(?, ?, ?, ?, ?,?,?);",
                    Statement.RETURN_GENERATED_KEYS);
           
            //Adicionando parâmetros ao comando SQL
            addSQL.setString(1, c.getCpf());
            addSQL.setString(2, c.getNome());
            addSQL.setString(3, c.getDataNascimento());
            addSQL.setString(4, c.getTelefone());
            addSQL.setString(5, c.getEndereco());
            addSQL.setString(6, c.getEmail());
            addSQL.setString(7, c.getSexo());
            //Executando a instrução SQL
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
            } catch (SQLException ex) {
            }
        }
        return retorno;
    }
    /**
     * Método <b>Atualizar</b> faz a alteração de dados do cliente no banco de dados
     * @param c
     * @return bolean true:alteração realizada - false: falha ao alterar
     */
    public static boolean Atualizar(Cliente c) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement addSQL = null;

        try {
            //Abri a conexão com o banco de dados 
            conexao = ConexaoMySql.getConexaoMySQL();
            //instrução SQL
            addSQL = conexao.prepareStatement("UPDATE cliente SET nome = ?, telefone=?, endereco=?, dataNascimento=?, email=?, sexo=?  WHERE cpf = ?;");
            //Adicionando parâmetros ao comando SQL
            addSQL.setString(1, c.getNome());
            addSQL.setString(2, c.getTelefone());
            addSQL.setString(3, c.getEndereco());
            addSQL.setString(4, c.getDataNascimento() );
            addSQL.setString(5, c.getEmail() );
            addSQL.setString(6, c.getSexo() );
            addSQL.setString(7, c.getCpf());
            //Executando a instrução SQL
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
            } catch (SQLException ex) {
            }
        }

        return retorno;
    }
    /**
     * O método <b>Excluir</b> faz a exclusão dos dados do cliente no Banco de Dados pelo seu código
     * @param cpf
     * @return bolean true: cliente excluido com sucesso - false: falha ao excluir cliente
     */
    public static boolean Excluir(String cpf) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement addSQL = null;

        try {
            //Abri a conexão com o banco de dados
            conexao = ConexaoMySql.getConexaoMySQL();
            //instrução SQL
            addSQL = conexao.prepareStatement("DELETE FROM cliente WHERE cpf = ?");

            addSQL.setString(1, cpf);
            //Executando a isntrução SQL
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
    /**
     * O método <b>Consultar</b> realiza a consunta de clientes cadastrados no Banco de Dados
     * @param nome - nome a ser buscado no Banco (recebido da controller).
     * @return ArrayList<Cliente>: Lista de clientes do banco, se não houver clientes retorna null;
     */

    public static ArrayList<Cliente> ConsultarCliente(String nome) {

        ArrayList<Cliente> listaCliente = new ArrayList<>();

        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {

            //Obs: A classe GerenciadorConexao já carrega o Driver e define os parâmetros de conexão
            conexao = ConexaoMySql.getConexaoMySQL();
            if (nome != null) {
                //Instrução SQL
                instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente where nome LIKE ?");  //Caso queira retornar o ID
                instrucaoSQL.setString(1, "%" + nome + '%');
            } else {
                instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente");  //Caso queira retornar o ID
            }

            rs = instrucaoSQL.executeQuery();
            //Enquanto houver clientes no Banco, passo eles para um objeto e adiciono no ArrayList
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
