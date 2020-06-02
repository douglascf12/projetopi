
package model;


public class Venda {
    private String cpf;
    private String codigo;
    private String datadavenda;
    private Double valorTotal;
    private String qtdVendida;

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

