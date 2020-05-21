/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author andre
 */
public class Cliente {
    
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String telefone;
    private String endereco;
    private String sexo;
    private String estadoCivil;

    public Cliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public String getCPF() {
        return getCpf();
    }

    public String getCPFSomenteNumeros() {
        return getCpf().replace(".", "").replace("-", "");
    }
    
    public void setCPF(String pCPF) {
        this.setCpf(pCPF);
    }
       
    public Cliente(String nome, String cpf, String dataNascimento,String telefone,String endereco,String sexo,String estadoCivil ) {
           
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.endereco = endereco;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
    }

   
    public String getNome() {
        return nome;
    }

    
    public void setNome(String nome) {
        this.nome = nome;
    }

  
    public String getCpf() {
        return cpf;
    }

    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

   
    public String getDataNascimento() {
        return dataNascimento;
    }

   
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    
    public String getTelefone() {
        return telefone;
    }

  
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    
    public String getEndereco() {
        return endereco;
    }

    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    
    public String getSexo() {
        return sexo;
    }

   
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

   
    public String getEstadoCivil() {
        return estadoCivil;
    }

   
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public void setcpf(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       

}

