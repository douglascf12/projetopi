/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @Débora Ramos Teixeira Souza
 * @Andrea Pereira dos Santos
 * @Carlos Eduardo
 * @Douglas Cardoso
 * @Francisco W
 * @see model.Relatorio
 */
    
    
public class Relatorio {
    /**
     * @param dataInicio objeto do tipo Relatorio
     * @param dataFim objeto do tipo Relatorio
     */
    
    
    private String dataInicio;
    private String dataFim;
    
    //Criação dos getteres e setteres dos objetos
     public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

     public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }
}
