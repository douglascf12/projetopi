/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ClienteDAO;
import model.Cliente;

/**
 *
 * @author andre
 */
public class ClienteController {
    
    public static boolean Cadastrar(String nome, String cpf, String dataNascimento,String telefone,String endereco)
    {
        Cliente objCliente = new Cliente();
        objCliente.setNome(nome);
        objCliente.setcpf(cpf);
        objCliente.setDataNascimento(dataNascimento);
        objCliente.setTelefone(telefone);
        objCliente.setEndereco(endereco);
        
        
        boolean retorno = ClienteDAO.Cadastrar(objCliente);
        
        return retorno;
    }
}
