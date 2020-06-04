/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Controller.ClienteController;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import utils.Validador;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.Cliente;

/**
 *
 * @author User
 */
public class CadastrarClienteView extends javax.swing.JFrame {

    /**
     * Creates new form cliente
     */
    Cliente objCliente;
    public String modoTela = "Criação";

    public CadastrarClienteView() {
        initComponents();
        CarregaTabela();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPsqNomeCli = new javax.swing.JTextField();
        bntPsqCli = new javax.swing.JButton();
        tabCli = new javax.swing.JScrollPane();
        tblPesquisar = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNomeCliente = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtEnderecoCliente = new javax.swing.JTextField();
        txtTelefoneCliente = new javax.swing.JFormattedTextField();
        txtCpfCli = new javax.swing.JFormattedTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        btnCadastrarCliente = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnAtualizarCliente = new javax.swing.JButton();
        btnExcluirCliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar clientes"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Nome:");

        txtPsqNomeCli.setName("Nome do Cliente"); // NOI18N
        txtPsqNomeCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPsqNomeCliActionPerformed(evt);
            }
        });

        bntPsqCli.setText("Pesquisar");
        bntPsqCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntPsqCliActionPerformed(evt);
            }
        });

        tblPesquisar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CPF", "Nome", "Data de Nasc.", "Telefone", "Endereço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabCli.setViewportView(tblPesquisar);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtPsqNomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(bntPsqCli, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(tabCli, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPsqNomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntPsqCli))
                .addGap(26, 26, 26)
                .addComponent(tabCli, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados clientes"));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("CPF:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Nome:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Telefone:");

        txtNomeCliente.setName("Nome"); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Data de Nasc.");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Endereço:");

        txtEnderecoCliente.setName("Endereço"); // NOI18N

        try {
            txtTelefoneCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtCpfCli.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpfCli.setName("CPF"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCpfCli, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefoneCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEnderecoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 24, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCpfCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel9))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTelefoneCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtEnderecoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnCadastrarCliente.setText("Cadastrar");
        btnCadastrarCliente.setBorder(null);
        btnCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarClienteActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.setBorder(null);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCadastrarCliente, btnSair});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCadastrarCliente, btnSair});

        jLabel5.setFont(new java.awt.Font("Viner Hand ITC", 1, 11)); // NOI18N
        jLabel5.setText("TLG Admin");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnAtualizarCliente.setText("Editar");
        btnAtualizarCliente.setBorder(null);
        btnAtualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarClienteActionPerformed(evt);
            }
        });

        btnExcluirCliente.setText("Excluir");
        btnExcluirCliente.setBorder(null);
        btnExcluirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnExcluirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtualizarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnAtualizarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnExcluirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarClienteActionPerformed

        //Resgato as informações da linha para passar a tela de Cadastro/Alteração
        if (tblPesquisar.getRowCount() > 0) {
            //Resgato o número da linha pelo JTable
            int numeroLinha = tblPesquisar.getSelectedRow();

            String cpf = tblPesquisar.getModel().getValueAt(numeroLinha, 0).toString();
            String nome = tblPesquisar.getModel().getValueAt(numeroLinha, 1).toString();
            String dataNascimento = tblPesquisar.getModel().getValueAt(numeroLinha, 2).toString();
            String telefone = tblPesquisar.getModel().getValueAt(numeroLinha, 3).toString();
            String endereco = tblPesquisar.getModel().getValueAt(numeroLinha, 4).toString();
            txtCpfCli.setText(cpf);
            txtNomeCliente.setText(nome);
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
                Date date = (Date) formatter.parse(dataNascimento);
                jDateChooser1.setDate(date);
            } catch (ParseException ex) {
                Logger.getLogger(CadastrarClienteView.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtTelefoneCliente.setText(telefone);
            txtEnderecoCliente.setText(endereco);
            modoTela = "Alteração";
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um cliente da tabela!");
        }

    }//GEN-LAST:event_btnAtualizarClienteActionPerformed

    private void btnExcluirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirClienteActionPerformed
        String nome = (this.txtNomeCliente.getText());

        if (tblPesquisar.getRowCount() > 0) {
            int numeroLinha = tblPesquisar.getSelectedRow();
            String cpf = tblPesquisar.getModel().getValueAt(numeroLinha, 0).toString();
            //Chamando Controller
            boolean retorno = ClienteController.Excluir(cpf);
            if (retorno == true) {
                JOptionPane.showMessageDialog(null, "Cliente excluido com Sucesso", "Exclusão realizada", JOptionPane.INFORMATION_MESSAGE);
                CarregaTabela();
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao excluir cliente!", "Falha", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Selecione um cliente da tabela para excluir!");
        }


    }//GEN-LAST:event_btnExcluirClienteActionPerformed

    private void txtPsqNomeCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPsqNomeCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPsqNomeCliActionPerformed

    private void btnCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarClienteActionPerformed
        boolean cpfValido = Validador.ValidaCPF(txtCpfCli);
        boolean nomeValido = Validador.ValidaNomes(txtNomeCliente);
        boolean enderecoValido = Validador.ValidaNomes(txtEnderecoCliente);
        if (modoTela == "Criação") {
            if (cpfValido && nomeValido && enderecoValido) {
                //Verifica se o CPF informado é válido para prosseguir com o cadastramento
                if (Validador.ValidaNomes(txtNomeCliente)) {
                    //Capturando Informações Da View
                    String cpf = Validador.getCpfSomenteNumeros(txtCpfCli);
                    String nome = (txtNomeCliente.getText());
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String dataNascimento = sdf.format(jDateChooser1.getDate());
                    String telefone = (txtTelefoneCliente.getText());
                    String endereco = (txtEnderecoCliente.getText());

                    //Chamando Controller
                    boolean retorno = ClienteController.Cadastrar(cpf, nome, dataNascimento, telefone, endereco);
                    if (retorno == true) {
                        JOptionPane.showMessageDialog(null, "Cliente cadastrado com Sucesso", "Cadastro realizado", JOptionPane.INFORMATION_MESSAGE);
                        CarregaTabela();
                    } else {
                        JOptionPane.showMessageDialog(null, "Falha ao cadastrar cliente!", "Falha", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "CPF informado é inválido");
                    txtCpfCli.setBackground(Color.red);
                }
            }
        } else {
            String cpf = Validador.getCpfSomenteNumeros(txtCpfCli);
            String nome = (txtNomeCliente.getText());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dataNascimento = sdf.format(jDateChooser1.getDate());
            String telefone = (txtTelefoneCliente.getText());
            String endereco = (txtEnderecoCliente.getText());

            //Passo as informações da View para Controller
            try {
                boolean retorno = ClienteController.Atualizar(cpf, nome, dataNascimento, telefone, endereco);
                System.out.println(retorno);
                JOptionPane.showMessageDialog(this, "Cliente alterado com sucesso!", "Cliente Alterado", JOptionPane.INFORMATION_MESSAGE);
                modoTela = "Criação";
                CarregaTabela();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Falha ao gravar no banco de dados\n" + e.getMessage(),
                        "Aviso de Falha", JOptionPane.ERROR_MESSAGE);
            }

        }
        txtCpfCli.setText(null);
        txtNomeCliente.setText(null);
        jDateChooser1.setDate(null);
        txtTelefoneCliente.setText(null);
        txtEnderecoCliente.setText(null);
        modoTela = "Criação";
    }//GEN-LAST:event_btnCadastrarClienteActionPerformed

    private void CarregaTabela() {

        ArrayList<String[]> listaCliente;
        listaCliente = ClienteController.ConsultarCliente(txtPsqNomeCli.getText());
        if (listaCliente.size() > 0) {
            DefaultTableModel modelo = (DefaultTableModel) tblPesquisar.getModel();
            modelo.setRowCount(0);

            for (String[] cliente : listaCliente) {
                modelo.addRow(new String[]{
                    cliente[0],
                    cliente[1],
                    cliente[2],
                    cliente[3],
                    cliente[4],});
            }
        }
    }
    private void bntPsqCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntPsqCliActionPerformed
        Validador.ValidaNomes(txtPsqNomeCli);
        ArrayList<String[]> listaCliente;
        listaCliente = ClienteController.ConsultarCliente(txtPsqNomeCli.getText());

        DefaultTableModel modelo = (DefaultTableModel) tblPesquisar.getModel();
        modelo.setRowCount(0);

        for (String[] cliente : listaCliente) {
            modelo.addRow(new String[]{
                cliente[0],
                cliente[1],
                cliente[2],
                cliente[3],
                cliente[4],});
        }

    }//GEN-LAST:event_bntPsqCliActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

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
            java.util.logging.Logger.getLogger(CadastrarClienteView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarClienteView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarClienteView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarClienteView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarClienteView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntPsqCli;
    private javax.swing.JButton btnAtualizarCliente;
    private javax.swing.JButton btnCadastrarCliente;
    private javax.swing.JButton btnExcluirCliente;
    private javax.swing.JButton btnSair;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane tabCli;
    private javax.swing.JTable tblPesquisar;
    private javax.swing.JFormattedTextField txtCpfCli;
    private javax.swing.JTextField txtEnderecoCliente;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtPsqNomeCli;
    private javax.swing.JFormattedTextField txtTelefoneCliente;
    // End of variables declaration//GEN-END:variables
}
