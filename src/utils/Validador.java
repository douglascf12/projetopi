/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Color;
import java.util.InputMismatchException;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author w_olv
 */
public class Validador {

    public static void ValidaNomes(JTextField nomeTxt) {

        if (nomeTxt.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Verifique se o campo " + nomeTxt.getName() + " está preenchido.");
            nomeTxt.setBackground(Color.red);
        } else {
            nomeTxt.setBackground(Color.white);
        }
    }

    public static void ValidarNumeros(JTextField pTxt) {
        try {
            if (pTxt.getText().trim().equals("")) {
                throw new IllegalArgumentException();
            }
            int numero = Integer.parseInt(pTxt.getText());
            pTxt.setBackground(Color.white);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Falha ao converter o campo " + pTxt.getName() + " em inteiro.");
            pTxt.setBackground(Color.red);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Digite um valor para o campo " + pTxt.getName());
            pTxt.setBackground(Color.red);
        }
    }

    public static void ValidarDecimais(JTextField decimalTxt) {
        try {
            if (decimalTxt.getText().trim().equals("")) {
                throw new IllegalArgumentException();
            }
            double numero = Double.parseDouble(decimalTxt.getText());
            decimalTxt.setBackground(Color.white);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Falha ao converter o campo " + decimalTxt.getName() + " em decimal.");
            decimalTxt.setBackground(Color.red);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Digite um valor para o campo " + decimalTxt.getName());
            decimalTxt.setBackground(Color.red);
        }
    }

    public static boolean ValidaCPF(JFormattedTextField pCpf) {
        String cpf = pCpf.getText().replace(".", "").replace("-", "");
        if (cpf.equals("00000000000")
                || cpf.equals("11111111111")
                || cpf.equals("22222222222") || cpf.equals("33333333333")
                || cpf.equals("44444444444") || cpf.equals("55555555555")
                || cpf.equals("66666666666") || cpf.equals("77777777777")
                || cpf.equals("88888888888") || cpf.equals("99999999999")
                || (cpf.length() != 11)) {
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
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    

}

