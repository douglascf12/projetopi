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
 * A classe <b>ClienteController</b> é usada para intermediar as informações entre a model e view
 * @author Andrea Pereira dos Santos
 * @author Carlos Eduardo Silva
 * @author Débora Ramos Teixeira Souza
 * @author Douglas Cardoso Ferreira
 * @author Francisco Washigton Almeida de Oliveira
 *  
 */
public class ClienteController {
/**
 * 
 * O método <b>Cadastrar</b> recebe as informações de cadastro contidas na View e manda gravar no banco de dados
 * @param nome
 * @param cpf
 * @param dataNascimento
 * @param telefone
 * @param endereco
 * @param email
 * @param sexo 
 * @return boolean true:ação cadastrar executada - false:falha no cadastro
 */
    public static boolean Cadastrar(String nome, String cpf, String dataNascimento, String telefone, String endereco, String email, String sexo) {
        //criando um objeto da classe Cliente 
        Cliente objCliente = new Cliente();
        //o objeto criado recebe as informações adicionadas na CadastrarClienteView
        objCliente.setCpf(nome);
        objCliente.setNome(cpf);
        objCliente.setDataNascimento(dataNascimento);
        objCliente.setTelefone(telefone);
        objCliente.setEndereco(endereco);
        objCliente.setEmail(email);
        objCliente.setSexo(sexo);
        
        //grava a informação no banco de dados
        boolean retorno = ClienteDAO.Cadastrar(objCliente);
        
        return retorno;
    }
/**
 * este método recebe as informações de cadastro e atualiza os dados alterados no cadastro
 * @param cpf
 * @param nome
 * @param dataNascimento
 * @param telefone
 * @param endereco
 * @param email
 * @param sexo
 * @return boolean true:ação atualizar executada - false:falha na atualização
 */
    public static boolean Atualizar(String cpf,String nome, String dataNascimento, String telefone, String endereco, String email,String sexo) {
        //criando um objeto da classe Cliente
        Cliente objCliente = new Cliente();
        //o objeto criado recebe as informações adicionadas na CadastrarClienteView
        objCliente.setCpf(cpf);
        objCliente.setNome(nome);
        objCliente.setDataNascimento(dataNascimento);
        objCliente.setTelefone(telefone);
        objCliente.setEndereco(endereco);
        objCliente.setEmail(email);
        objCliente.setSexo(sexo);
        
         //grava a informação no banco de dados
       boolean retorno = ClienteDAO.Atualizar(objCliente);
        return retorno;
    }
    /**
     * O método <b>Excluir</b> recebe o cpf do cliente e passa para classe ClienteDAO, que faz a exclusão no Banco de Dados.
     * @param cpf
     * @return boolean true: ação excluir executada - false: falha na exclusão 
     */
    public static boolean Excluir(String cpf) {
        boolean retorno = ClienteDAO.Excluir(cpf);
        return retorno;
    }
    
    /**
     * O método <b>ConsultarCliente</b> faz a consulta dos dados do cliente no Banco de Dados pelo seu nomr
     * @param nome 
     * @return ArrayList<String[]>: clientes cadastrados no sistema - : se não houver clientes retorna null
     */
    public static ArrayList<String[]> ConsultarCliente(String nome) {
        //Criando um Array de Cliente que receberá os dados ClienteDao
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        //Chamo a ConsultarClienteDAO passando o nome do cliente
        listaClientes = ClienteDAO.ConsultarCliente(nome);

        ArrayList<String[]> retorno = new ArrayList<>();
        //Passo o cliente para um vetor de String
        for (Cliente cliente : listaClientes) {
            retorno.add(new String[]{
                String.valueOf(cliente.getCpf()),
                String.valueOf(cliente.getNome()),
                String.valueOf(cliente.getDataNascimento()),
                String.valueOf(cliente.getTelefone()),
                String.valueOf(cliente.getEndereco()),
                String.valueOf(cliente.getEmail()),
                String.valueOf(cliente.getSexo()),});
        }
        return retorno;
    }
}
