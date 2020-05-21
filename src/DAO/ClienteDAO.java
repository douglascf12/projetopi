/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import model.Cliente;
import utils.ConexaoMySql;

/**
 *
 * @author andre
 */
public class ClienteDAO {
    PreparedStatement addSQL = null;
    private static Connection conexao;
    
    public static boolean Cadastrar (Cliente c){
         boolean retorno = false;
        Connection conexao = null;
        PreparedStatement addSQL = null;
        
        try{
            
            conexao = ConexaoMySql.getConexaoMySQL();
            
            addSQL = conexao.prepareStatement("INSERT INTO cliente (cpf,nome,dataNascimento,telefone,endereco) VALUES( ?, ?, ?,?,?);",
                    Statement.RETURN_GENERATED_KEYS);
            
            addSQL.setString(1, c.getCPF());
            addSQL.setString(2, c.getNome());
            addSQL.setString(3, c.getDataNascimento());
            addSQL.setString(4, c.getTelefone());
            addSQL.setString(5, c.getEndereco());
           
            
             int linhasAfetadas = addSQL.executeUpdate();
                        

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }return retorno;

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
        
       try{
            
            conexao = ConexaoMySql.getConexaoMySQL();
            
            addSQL = conexao.prepareStatement("INSERT INTO cliente (cpf,nome,dataNascimento,telefone,endereco,sexo,estadoCivil) VALUES( ?, ?, ?,?,?,?,?);",
                    Statement.RETURN_GENERATED_KEYS);
            
            addSQL.setString(1, c.getCPF());
            addSQL.setString(2, c.getNome());
            addSQL.setString(3, c.getDataNascimento());
            addSQL.setString(4, c.getTelefone());
            addSQL.setString(5, c.getEndereco());
            addSQL.setString(6, c.getSexo());
            addSQL.setString(7, c.getEstadoCivil());
            
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

            addSQL.setString(1,cpf);

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
    }

