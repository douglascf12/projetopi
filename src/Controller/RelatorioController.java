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
 * @Débora Ramos Teixeira Souza
 * @Andrea Pereira dos Santos
 * @Carlos Eduardo
 * @Douglas Cardoso
 * @Francisco W
 * @see controller.RelatorioController
 */
public class RelatorioController {

    /**
     *
     * @param dataInicio
     * @param dataFim
     * @return boolean - true: lista preenchida, false: falha
     */
    public static ArrayList<String[]> SalvarRelatorio(String dataInicio, String dataFim) {

        Relatorio obj = new Relatorio();
        obj.setDataInicio(dataInicio);
        obj.setDataFim(dataFim);
        //Cria Array do objeto Venda em listaVenda
        ArrayList<Venda> listaVenda = new ArrayList<>();
        //listaVenda recebe Array do RelatorioDAO passando obj como parÂmetro 
        listaVenda = RelatorioDAO.RelatorioVenda(obj);
        //Cria Array de String - retorno
        ArrayList<String[]> retorno = new ArrayList<>();
        //laço percorre Array de objeto venda colocando em retorno(Array de String)
        for (Venda venda : listaVenda) {
            retorno.add(new String[]{
                String.valueOf(venda.getCodigo()),
                String.valueOf(venda.getCpf()),
                String.valueOf(venda.getValorTotal()),
                String.valueOf(venda.getDatadavenda())});
        }//retorna Array retorno de String com valores da tabela Venda
        return retorno;

        /**
         * Método de controle
         */
    }

    public static ArrayList<String[]> RelatorioDetalheVenda(int idVenda) {
        //Cria Array de Objeto Venda em listaDetalheVenda
        ArrayList<Venda> listaDetalhe = new ArrayList<>();
        //listDetalheVenda chama RelatorioDao passado idVenda como parâmetro
        listaDetalhe = RelatorioDAO.RelatorioDetalheVenda(idVenda);
        //Cria Array de String - retorno
        ArrayList<String[]> retorno = new ArrayList<>();
        //laço percorre Array de objeto venda colocando em retonro(Array de String)
        for (Venda venda : listaDetalhe) {
            retorno.add(new String[]{
                String.valueOf(venda.getCpf()),
                String.valueOf(venda.getIdVenda()),
                String.valueOf(venda.getCodigo()),
                String.valueOf(venda.getQtdVendida()),
                String.valueOf(venda.getDatadavenda()),});
        }//retorna Array retorno de String com valores da tabela Venda
        return retorno;
    }
    /**
     * Método de controle
     */
}
