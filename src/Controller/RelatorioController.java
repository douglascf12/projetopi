/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import DAO.RelatorioDAO;
import java.util.ArrayList;
import model.Relatorio;
import model.Venda;

/**
 *
 * @author User
 */
public class RelatorioController {
    public static ArrayList<String[]> SalvarRelatorio(String dataInicio, String dataFim) {

        Relatorio obj = new Relatorio();
        obj.setDataInicio(dataInicio);
        obj.setDataFim(dataFim);

        ArrayList<Venda> listaVenda = new ArrayList<>();
        listaVenda = RelatorioDAO.RelatorioVenda(obj);

        ArrayList<String[]> retorno = new ArrayList<>();

        for (Venda venda : listaVenda) {
            retorno.add(new String[]{
                String.valueOf(venda.getCodigo()),
                String.valueOf(venda.getCpf()),
                String.valueOf(venda.getValorTotal()),
                String.valueOf(venda.getDatadavenda())});
        }
        return retorno;
    }

    public static ArrayList<String[]> RelatorioDetalheVenda(int idVenda){
        
        ArrayList<Venda> listaDetalhe = new ArrayList<>();
        listaDetalhe = RelatorioDAO.RelatorioDetalheVenda(idVenda);
        
        ArrayList<String[]> retorno = new ArrayList<>();

        for (Venda venda : listaDetalhe) {
            retorno.add(new String[]{
                String.valueOf(venda.getCpf()),
                String.valueOf(venda.getIdVenda()),
                String.valueOf(venda.getCodigo()),
                String.valueOf(venda.getQtdVendida()),
                String.valueOf(venda.getDatadavenda()),
            
            });
        }
        return retorno;
    }
}
