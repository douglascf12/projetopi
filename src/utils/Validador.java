/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Color;
import java.util.InputMismatchException;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Andrea Pereira dos Santos
 * @author Carlos Eduardo Silva
 * @author Débora Ramos Teixeira Souza
 * @author Douglas Cardoso Ferreira
 * @author Francisco Washigton Almeida de Oliveira
 *
 */
public class Validador {
/**
 * Verifica se o nome digitado não é Nulo e não contem números
 * @param nomeTxt
 * @return true: Nome preenchido, false: Nome não preenchido
 */
    public static boolean ValidaNomes(JTextField nomeTxt) {

        if (nomeTxt.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Verifique se o campo " + nomeTxt.getName() + " está preenchido.");
            nomeTxt.setBackground(Color.red);
            return false;
        } else {
            nomeTxt.setBackground(Color.white);
            return true;
        }
    }
/**
 * Verifica se o número digitado é inteiro
 * @param pTxt
 * @return true: número é inteiro, false: não é um inteiro
 */
    public static boolean ValidarNumeros(JTextField pTxt) {
        try {
            if (pTxt.getText().trim().equals("")) {
                throw new IllegalArgumentException();
            }
            int numero = Integer.parseInt(pTxt.getText());
            pTxt.setBackground(Color.white);
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Falha ao converter o campo " + pTxt.getName() + " em inteiro.");
            pTxt.setBackground(Color.red);
            return false;
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Digite um valor para o campo " + pTxt.getName());
            pTxt.setBackground(Color.red);
            return false;
        }
    }
/**
 * Verifica se o SEXO do cliente estás selecionado
 * @param txtCombo
 * @return true: SEXO selecionado, false: SEXO não selecionado
 */
    public static boolean ValidaComboBox(JComboBox txtCombo) {
        String setor = (String) txtCombo.getSelectedItem();
        if (setor == "Nenhum") {
            JOptionPane.showMessageDialog(null, "Selecione o Setor do Produto");
            return false;
        }
        return true;
    }

    public static boolean ValidarDecimais(JTextField decimalTxt) {
        try {
            if (decimalTxt.getText().trim().equals("")) {
                throw new IllegalArgumentException();
            }
            double numero = Double.parseDouble(decimalTxt.getText());
            decimalTxt.setBackground(Color.white);
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Falha ao converter o campo " + decimalTxt.getName() + " em decimal.");
            decimalTxt.setBackground(Color.red);
            return false;
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Digite um valor para o campo " + decimalTxt.getName());
            decimalTxt.setBackground(Color.red);
            return false;
        }
    }
/**
 * Retorno se o CPF é válido
 * @param pCpf
 * @return true: CPF válido, false: CPF Inválido.
 */
    public static boolean ValidaCPF(JFormattedTextField pCpf) {
        String cpf = pCpf.getText().replace(".", "").replace("-", "");
        if (cpf.equals("00000000000")
                || cpf.equals("11111111111")
                || cpf.equals("22222222222") || cpf.equals("33333333333")
                || cpf.equals("44444444444") || cpf.equals("55555555555")
                || cpf.equals("66666666666") || cpf.equals("77777777777")
                || cpf.equals("88888888888") || cpf.equals("99999999999")
                || (cpf.length() != 11)) {
            pCpf.setBackground(Color.red);
            return (false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0         
                // (48 eh a posicao de '0' na tabela ASCII)         
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48); // converte no respectivo caractere numerico
            }
            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))) {
                pCpf.setBackground(Color.white);
                return (true);
            } else {
                pCpf.setBackground(Color.red);
                return (false);
            }
        } catch (InputMismatchException erro) {
            pCpf.setBackground(Color.red);
            return (false);
        }
    }
/**
 * Retorno o CPF digitado somente com os números
 * @param pCpf
 * @return 
 */
    public static String getCpfSomenteNumeros(JFormattedTextField pCpf) {
        String cpf = pCpf.getText().replace(".", "").replace("-", "");
        return cpf;
    }
    /**
     * Função que verifica se o produto tem em estoque na Quantidade solicitada
     * @param qtdVentida
     * @param txtEstoque
     * @return 
     */
    public static boolean ValidaEstoque(JTextField qtdVentida, int txtEstoque) {        
        if (Integer.parseInt(qtdVentida.getText())<=txtEstoque) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Produto possui apenas " + txtEstoque + " unidades em Estoque");
            return false;
        }
    }

}
