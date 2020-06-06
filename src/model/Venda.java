
package model;

/**
 *Esta classe contem a estrutura de dados para cadastrar/Alterar/exluir e pesquisar Cliente;
 * @author Andrea Pereira dos Santos
 * @author Carlos Eduardo Silva
 * @author Débora Ramos Teixeira Souza
 * @author Douglas Cardoso Ferreira
 * @author Francisco Washigton Almeida de Oliveira
 *  
 */
//Definindo os atributos 
public class Venda {
    private String cpf;
    private String codigo;
    private String datadavenda;
    private Double valorTotal;
    private String qtdVendida;
    private int idVenda;


    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDatadavenda() {
        return datadavenda;
    }

    public void setDatadavenda(String datadavenda) {
        this.datadavenda = datadavenda;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getQtdVendida() {
        return qtdVendida;
    }

    public void setQtdVendida(String qtdVendida) {
        this.qtdVendida = qtdVendida;
    }
    

    
    
}

