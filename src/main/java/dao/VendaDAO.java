package dao;

import bd.ConexaoDB;
import entidade.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Servlet;

public class VendaDAO {

    public static Venda GerarPedidoVenda(Venda venda) throws SQLException, ParseException {

        PreparedStatement ps = null;
        Connection con = ConexaoDB.getConexao();

        try {
            

            ps = con.prepareStatement("insert into venda (cpf_cliente,cod_filial,data_venda) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, venda.getCpf_cliente());
            ps.setInt(2, venda.getCod_filial());

            Date date = venda.getData_venda();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String strDate = dateFormat.format(date);

            ps.setString(3, strDate);
            ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                venda.setId_venda(generatedKeys.getInt(1));
            } else {
                throw new SQLException("Erro: Não foi possivel pegar o id da venda");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return venda;
    }
    
    public static void finalizarVenda(double valorTotal, int codVenda) {
        try {
            Connection con = ConexaoDB.getConexao();
            String query = "update venda set total_venda = ? where id_venda=?";
            PreparedStatement ps = con.prepareStatement(query);
            System.out.println(valorTotal);
            System.out.println(codVenda);
            ps.setDouble(1, valorTotal);
            ps.setInt(2, codVenda);
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
