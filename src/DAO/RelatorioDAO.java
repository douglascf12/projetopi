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
 * @author User
 */
public class RelatorioDAO {
    private static Connection conexao;

    public static ArrayList<Venda> RelatorioVenda(Relatorio obj) {
        boolean retorno = false;
        ArrayList<Venda> listaVenda = new ArrayList<>();

        ResultSet rs = null;
        PreparedStatement addSQL = null;

        try {
             conexao = ConexaoMySql.getConexaoMySQL();
             
            if (obj != null) {

                addSQL = conexao.prepareStatement("Select id_venda,cpf,valor_compra,datavenda from venda where datavenda BETWEEN (?) and (?);  ");

                addSQL.setString(1,  obj.getDataInicio() );
                addSQL.setString(2,  obj.getDataFim());
            }

            rs = addSQL.executeQuery();
            while (rs.next()) {
                Venda r = new Venda();
                r.setCodigo(rs.getString("id_venda"));
                r.setCpf(rs.getString("cpf"));
                r.setValorTotal(rs.getDouble("valor_compra"));
                r.setDatadavenda(rs.getString("datavenda"));
                
                listaVenda.add(r);

            }
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            listaVenda = null;
        } finally {

            try {
                if (addSQL != null) {
                    addSQL.close();
                }

                if (rs != null) {
                    rs.close();
                }

                ConexaoMySql.FecharConexao();

            } catch (SQLException ex) {
            }
        }

        return listaVenda;
    }
    
    public static ArrayList<Venda> RelatorioDetalheVenda(int idVenda) {
        boolean retorno = false;
        ArrayList<Venda> listaVenda = new ArrayList<>();

        ResultSet rs = null;
        PreparedStatement addSQL = null;

        try {
             conexao = ConexaoMySql.getConexaoMySQL();
             
             addSQL = conexao.prepareStatement("select venda.cpf, venda.id_venda,cod_produto,qtd_vendida,datavenda from detalhe_venda\n" +
"inner join venda on venda.id_venda = detalhe_venda.id_venda\n" +
"WHERE venda.id_venda = (?);");
             
             addSQL.setInt(1,  idVenda );
             
              rs = addSQL.executeQuery();
            while (rs.next()) {
                Venda r = new Venda();
                r.setCpf(rs.getString("cpf"));
                r.setIdVenda(rs.getInt("id_venda"));
                r.setCodigo(rs.getString("cod_produto"));
                r.setQtdVendida(rs.getString("qtd_vendida"));
                r.setDatadavenda(rs.getString("datavenda"));

                listaVenda.add(r);

            }
             
        }catch(SQLException ex) {

            System.out.println(ex.getMessage());
            listaVenda = null;
        } finally {

            try {
                if (addSQL != null) {
                    addSQL.close();
                }

                if (rs != null) {
                    rs.close();
                }

                ConexaoMySql.FecharConexao();

            } catch (SQLException ex) {
            }
        }

        return listaVenda;
                }
}
