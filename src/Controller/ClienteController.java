/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ClienteDAO;
import java.util.ArrayList;
import model.Cliente;

/**
 *
 * @author andre
 */
public class ClienteController {

    public static boolean Cadastrar(String nome, String cpf, String dataNascimento, String telefone, String endereco) {
        Cliente objCliente = new Cliente();
        objCliente.setCpf(nome);
        objCliente.setNome(cpf);
        objCliente.setDataNascimento(dataNascimento);
        objCliente.setTelefone(telefone);
        objCliente.setEndereco(endereco);

        boolean retorno = ClienteDAO.Cadastrar(objCliente);

        return retorno;
    }

    public static boolean Atualizar(String cpf,String nome, /*String dataNascimento,*/ String telefone, String endereco) {
        Cliente objCliente = new Cliente();
        objCliente.setCpf(cpf);
        objCliente.setNome(nome);
       // objCliente.setDataNascimento(dataNascimento);
        objCliente.setTelefone(telefone);
        objCliente.setEndereco(endereco);

        boolean retorno = ClienteDAO.Atualizar(objCliente);

        return retorno;
    }

    public static boolean Excluir(String cpf) {

        boolean retorno = ClienteDAO.Excluir(cpf);

        return retorno;
    }

    public static ArrayList<String[]> ConsultarCliente(String nome) {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        listaClientes = ClienteDAO.ConsultarCliente(nome);

        ArrayList<String[]> retorno = new ArrayList<>();

        for (Cliente cliente : listaClientes) {
            retorno.add(new String[]{
                String.valueOf(cliente.getCpf()),
                String.valueOf(cliente.getNome()),
                String.valueOf(cliente.getDataNascimento()),
                String.valueOf(cliente.getTelefone()),
                String.valueOf(cliente.getEndereco()),});
        }
        return retorno;
    }
}
