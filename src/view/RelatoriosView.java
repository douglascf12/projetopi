package view;

import Controller.RelatorioController;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Débora Ramos Teixeira Souza
 * @Andrea Pereira dos Santos
 * @Carlos Eduardo
 * @Douglas Cardoso
 * @Francisco W
 *
 * @see View.RelatorioView
 */
public class RelatoriosView extends javax.swing.JFrame {

    /**
     *
     * Creates new form RelatoriosView
     */
    public RelatoriosView() { // Construtor Relatorio
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalheVenda = new javax.swing.JTable();
        btnSair = new javax.swing.JButton();
        cltDataInicio = new com.toedter.calendar.JDateChooser();
        cltDataFim = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVendas = new javax.swing.JTable();
        btnDetalheVenda = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("De:");

        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tblDetalheVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CPF. do Cliente", "Cód.  Venda", "Cód. Produto", "Quantidade", "Data "
            }
        ));
        jScrollPane1.setViewportView(tblDetalheVenda);

        btnSair.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Pictures\\icons8-excluir-24 (3).png")); // NOI18N
        btnSair.setText("Sair");
        btnSair.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Até");

        tblVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod. Venda", "CPF. Do Cliente", "Valor ", "Data"
            }
        ));
        jScrollPane2.setViewportView(tblVendas);

        btnDetalheVenda.setText("Exibir Detalhes");
        btnDetalheVenda.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnDetalheVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalheVendaActionPerformed(evt);
            }
        });

        jLabel1.setText("Detalhes Venda");

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Pictures\\icons8-pesquisar-24 (1).png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDetalheVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cltDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(cltDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jLabel4)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(btnDetalheVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cltDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cltDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSair, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(59, 59, 59))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();//Fechar tela
    }//GEN-LAST:event_btnSairActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            
            //Valida se os campos datas estão preenchidos
        if (cltDataInicio.getDate() != null && cltDataFim.getDate() != null) {
            //Formata data para modelo de reconhecimento do banco de dados
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            String dataInicio = formato.format(cltDataInicio.getDate());
            String dataFim = formato.format(cltDataFim.getDate());
            //Cria Array de String 
            ArrayList<String[]> listaVenda = new ArrayList();
            // Este Array criado chama a controller passado as datas como parâmetro
            listaVenda = RelatorioController.SalvarRelatorio(dataInicio, dataFim);
            DefaultTableModel modelo = (DefaultTableModel) tblVendas.getModel();
            modelo.setRowCount(0);
            //ListaVenda tem como retorno um vetor de String  
            //Percorremos o vetor e colocamos ele na tabela tblVendas
            for (String[] venda : listaVenda) {
                modelo.addRow(new String[]{
                    venda[0],
                    venda[1],
                    venda[2],
                    venda[3]
                });
            }

        } else {// Campos não preenchidos
            JOptionPane.showMessageDialog(null, "Preencha os campos de data.");
            cltDataInicio.setBackground(Color.red);
            cltDataFim.setBackground(Color.red);

        }

         /**
          * Método de preenchimento do Relatório analitico 
          */
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnDetalheVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalheVendaActionPerformed
         //Valida se a foi selecionado alguma linha
        if (tblVendas.getSelectedRow() >= 0) {

            int numeroLinha = tblVendas.getSelectedRow();
            //Variavel idVenda recebe 1ºCampo preenchido da tabela Vendas campo(Cod_Venda)
            int idVenda = Integer.parseInt(tblVendas.getModel().getValueAt(numeroLinha, 0).toString());
            //Cria Array de String - listaDetalhe
            ArrayList<String[]> listaDetalhe = new ArrayList();
            //Lista detalhe chama a RelatorioController passando o idVenda
            listaDetalhe = RelatorioController.RelatorioDetalheVenda(idVenda);
            DefaultTableModel modelo = (DefaultTableModel) tblDetalheVenda.getModel();
            modelo.setRowCount(0);
            //ListaDetalhe tem como retorno um vetor de String  
            //Percorremos o vetor e colocamos ele na tabela tblDetalheVenda
            for (String[] venda : listaDetalhe) {
                modelo.addRow(new String[]{
                    venda[0],
                    venda[1],
                    venda[2],
                    venda[3],
                    venda[4]
                });
            }
        } else {// Linha não selecionada
            JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela para ver os detalhes");
        }

    }//GEN-LAST:event_btnDetalheVendaActionPerformed

         /**
          * Método de preenchimento do Relatório Sintético 
          */
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RelatoriosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatoriosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatoriosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatoriosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatoriosView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetalheVenda;
    private javax.swing.JButton btnSair;
    private com.toedter.calendar.JDateChooser cltDataFim;
    private com.toedter.calendar.JDateChooser cltDataInicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDetalheVenda;
    private javax.swing.JTable tblVendas;
    // End of variables declaration//GEN-END:variables
}
