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
import model.Relatorio;
import model.Venda;
import utils.ConexaoMySql;

/**
 *
 * @Débora Ramos Teixeira Souza
 * @Andrea Pereira dos Santos
 * @Carlos Eduardo
 * @Douglas Cardoso
 * @Francisco W
 * @see DAO.RelatorioDAO
 */
public class RelatorioDAO {

    private static Connection conexao;

    public static ArrayList<Venda> RelatorioVenda(Relatorio obj) {
        boolean retorno = false;
        //Cria Array de objeto Venda em listaVenda
        ArrayList<Venda> listaVenda = new ArrayList<>();

        ResultSet rs = null;
        PreparedStatement addSQL = null;

        try {//Abrindo conexao com banco de dados
            conexao = ConexaoMySql.getConexaoMySQL();

            if (obj != null) {
                //Comando de execução para banco de dados
                addSQL = conexao.prepareStatement("Select id_venda,cpf,valor_compra,datavenda from venda where datavenda BETWEEN (?) and (?);  ");
                //Passando para o banco valores recebidos como parâmetro
                addSQL.setString(1, obj.getDataInicio());
                addSQL.setString(2, obj.getDataFim());
            }
            //executando a ação de banco passando para rs
            rs = addSQL.executeQuery();
            //laço que percorre a variável rs que tem como resposta a execução do banco de dados
            while (rs.next()) {
                Venda r = new Venda();
                r.setCodigo(rs.getString("id_venda"));
                r.setCpf(rs.getString("cpf"));
                r.setValorTotal(rs.getDouble("valor_compra"));
                r.setDatadavenda(rs.getString("datavenda"));
                //adiciona r em listaVenda 
                listaVenda.add(r);

            }
            //Caso ocorra exeções listaVenda recebe null
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            listaVenda = null;
        } finally {
            //Liberando espaço na memoria 
            try {
                if (addSQL != null) {
                    addSQL.close();
                }

                if (rs != null) {

                    rs.close();
                }
                //fecha conexão com banco de dados
                ConexaoMySql.FecharConexao();

            } catch (SQLException ex) {
            }
        }
        // retorna listaVenda Array de objeto Venda
        return listaVenda;
    }

    public static ArrayList<Venda> RelatorioDetalheVenda(int idVenda) {
        boolean retorno = false;
        //Cria Array de objeto Venda em listaVenda
        ArrayList<Venda> listaVenda = new ArrayList<>();

        ResultSet rs = null;
        PreparedStatement addSQL = null;

        try {//Abrindo conexao com banco de dados
            conexao = ConexaoMySql.getConexaoMySQL();
            //Comando de execução para banco de dados
            addSQL = conexao.prepareStatement("select venda.cpf, venda.id_venda,cod_produto,qtd_vendida,datavenda from detalhe_venda\n"
                    + "inner join venda on venda.id_venda = detalhe_venda.id_venda\n"
                    + "WHERE venda.id_venda = (?);");
            //Passando para o banco valor recebido como parâmetro
            addSQL.setInt(1, idVenda);
            //executando a ação de banco passando para rs
            rs = addSQL.executeQuery();
            //laço que percorre a variável rs que tem como resposta a execução do banco de dados
            while (rs.next()) {
                Venda r = new Venda();
                r.setCpf(rs.getString("cpf"));
                r.setIdVenda(rs.getInt("id_venda"));
                r.setCodigo(rs.getString("cod_produto"));
                r.setQtdVendida(rs.getString("qtd_vendida"));
                r.setDatadavenda(rs.getString("datavenda"));
                //adiciona r em listaVenda 
                listaVenda.add(r);

            }
            //Caso ocorra exeções listaVenda recebe null
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            listaVenda = null;
        } finally {
            //Liberando espaço na memoria 
            try {
                if (addSQL != null) {
                    addSQL.close();
                }

                if (rs != null) {
                    rs.close();
                }
                //fecha conexão com banco de dados
                ConexaoMySql.FecharConexao();

            } catch (SQLException ex) {
            }
        }
        // retorna listaVenda Array de objeto Venda
        return listaVenda;
    }
}
