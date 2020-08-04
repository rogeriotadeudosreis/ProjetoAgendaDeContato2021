/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import classesdedados.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistencias.ContatoPersistencia;

public class TelaAgenda extends javax.swing.JFrame {

    ContatoPersistencia agenda;
    Contato contato1 = null;
    Contato contato3 = null;
    Contato contatoNovo = null;
    Contato contatoAntigo = null;
    ArrayList<Contato> lista;

    public TelaAgenda() throws Exception {
        initComponents();
        agenda = new ContatoPersistencia("contato.txt");
        lista = new ArrayList();
        imprimirDadosGrid(agenda.recuperar());
    }

    @SuppressWarnings("unchecked")

    public void limparTela() {
        jTextFieldNomeCompleto.setText("");
        jTextFieldTelefone.setText("");
        jTextFieldEmail.setText("");
        jTextFieldLogradouro.setText("");
        jTextFieldNumero.setText("");
    }

    private void imprimirDadosGrid(ArrayList<Contato> lista) {
        DefaultTableModel model = (DefaultTableModel) jTableTelaAgenda.getModel();
        model.setNumRows(0);
        for (int pos = 0; pos < lista.size(); pos++) {
            String[] linha = new String[5];
            Contato aux = lista.get(pos);
            linha[0] = aux.getNomeCompleto().toUpperCase();
            linha[1] = aux.getTelefone();
            linha[2] = aux.getEmail();
            linha[3] = aux.getEnderecoResidencial().getLogradouro().toUpperCase();
            linha[4] = "" + aux.getEnderecoResidencial().getNumero();

            model.addRow(linha);
        }
    }

    public void preencherFormularioTelaAgenda() {
        String posicaoLinhaEcolunaDoNomeCompleto = jTableTelaAgenda.getValueAt(jTableTelaAgenda.getSelectedRow(), 0).toString();
        String policaoLinhaEcolunaDoTelefone = jTableTelaAgenda.getValueAt(jTableTelaAgenda.getSelectedRow(), 1).toString();
        String policaoLinhaEcolunaDoEmail = jTableTelaAgenda.getValueAt(jTableTelaAgenda.getSelectedRow(), 2).toString();
        String policaoLinhaEcolunaDoLogradouro = jTableTelaAgenda.getValueAt(jTableTelaAgenda.getSelectedRow(), 3).toString();
        String policaoLinhaEcolunaDoNumero = jTableTelaAgenda.getValueAt(jTableTelaAgenda.getSelectedRow(), 4).toString();

        jTextFieldNomeCompleto.setText(posicaoLinhaEcolunaDoNomeCompleto);
        jTextFieldTelefone.setText(policaoLinhaEcolunaDoTelefone);
        jTextFieldEmail.setText(policaoLinhaEcolunaDoEmail);
        jTextFieldLogradouro.setText(policaoLinhaEcolunaDoLogradouro);
        jTextFieldNumero.setText(policaoLinhaEcolunaDoNumero);

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldNomeCompleto = new javax.swing.JTextField();
        jTextFieldTelefone = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldLogradouro = new javax.swing.JTextField();
        jTextFieldNumero = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTelaAgenda = new javax.swing.JTable();
        jButtonIncluir = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonListagem = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonConsultar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jTextFieldQtdeContatos = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agenda 2021 - Cadastro");
        setResizable(false);

        jLabel1.setText("Nome");

        jLabel2.setText("Telefone");

        jLabel3.setText("E-mail");

        jLabel4.setText("Endereço Residencial");

        jLabel5.setText("Logradouro");

        jLabel6.setText("Número");

        jTableTelaAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Telefone", "E-mail", "Logrqadouro", "Número"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTelaAgenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTelaAgendaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableTelaAgenda);
        if (jTableTelaAgenda.getColumnModel().getColumnCount() > 0) {
            jTableTelaAgenda.getColumnModel().getColumn(0).setPreferredWidth(500);
            jTableTelaAgenda.getColumnModel().getColumn(1).setResizable(false);
            jTableTelaAgenda.getColumnModel().getColumn(1).setPreferredWidth(170);
            jTableTelaAgenda.getColumnModel().getColumn(2).setResizable(false);
            jTableTelaAgenda.getColumnModel().getColumn(2).setPreferredWidth(350);
            jTableTelaAgenda.getColumnModel().getColumn(3).setResizable(false);
            jTableTelaAgenda.getColumnModel().getColumn(3).setPreferredWidth(450);
            jTableTelaAgenda.getColumnModel().getColumn(4).setResizable(false);
            jTableTelaAgenda.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        jButtonIncluir.setText("INCLUIR");
        jButtonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("EXCLUIR");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonListagem.setText("LISTAGEM");
        jButtonListagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListagemActionPerformed(evt);
            }
        });

        jButtonAlterar.setText("ALTERAR");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonConsultar.setText("CONSULTAR");
        jButtonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("CANCELAR");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(229, 229, 229)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(18, 18, 18)
                                            .addComponent(jTextFieldLogradouro))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addGap(39, 39, 39)
                                            .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel3))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextFieldNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldQtdeContatos)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonIncluir)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonExcluir)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonAlterar)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonConsultar)
                                .addGap(12, 12, 12)
                                .addComponent(jButtonListagem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonCancelar)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonIncluir)
                    .addComponent(jButtonExcluir)
                    .addComponent(jButtonAlterar)
                    .addComponent(jButtonConsultar)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonListagem))
                .addGap(18, 18, 18)
                .addComponent(jTextFieldQtdeContatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed

        try {

            contato3 = new Contato(jTextFieldNomeCompleto.getText(), jTextFieldTelefone.getText(),
                    jTextFieldEmail.getText(), jTextFieldLogradouro.getText(),
                    Integer.parseInt(jTextFieldNumero.getText()));

            contato1 = new Contato();
            contato1.setNomeCompleto(jTextFieldNomeCompleto.getText());
            contato1.setTelefone(jTextFieldTelefone.getText());
            contato1.setEmail(jTextFieldEmail.getText());
            contato1.setEnderecoResidencial(new Endereco(jTextFieldLogradouro.getText(), Integer.parseInt(jTextFieldNumero.getText())));

            contatoNovo = new Contato(jTextFieldNomeCompleto.getText(), jTextFieldTelefone.getText(), jTextFieldEmail.getText(),
                    new Endereco(jTextFieldLogradouro.getText(), Integer.parseInt(jTextFieldNumero.getText())));

            agenda.incluir(contato3);
            imprimirDadosGrid(agenda.recuperar());
            lista = agenda.recuperar();
            jTextFieldQtdeContatos.setText("Contatos Cadastrados: " + lista.size());
            JOptionPane.showMessageDialog(null, "Contato Incluído com Sucesso!!!");
            limparTela();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed

        try {

            int opcao = JOptionPane.showConfirmDialog(null, " Deseja excluir " + jTextFieldNomeCompleto.getText());

            if (opcao == 0) {
                agenda.excluir(jTextFieldNomeCompleto.getText());
                imprimirDadosGrid(agenda.recuperar());
                 lista = agenda.recuperar();
                jTextFieldQtdeContatos.setText("Contatos Cadastrados: " + lista.size());
                JOptionPane.showMessageDialog(null, "Contato Excluído com Sucesso!");

            } else {

                JOptionPane.showMessageDialog(null, "Ação cancelada!");
                limparTela();
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }

    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonListagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListagemActionPerformed
        TelaListagem abrirTelaDeListagem = null;
        try {
            abrirTelaDeListagem = new TelaListagem();
        } catch (Exception ex) {
            Logger.getLogger(TelaAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        abrirTelaDeListagem.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonListagemActionPerformed

    private void jTableTelaAgendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTelaAgendaMouseClicked

        preencherFormularioTelaAgenda();
        contatoAntigo = new Contato(jTextFieldNomeCompleto.getText(), jTextFieldTelefone.getText(),
                jTextFieldEmail.getText(), jTextFieldLogradouro.getText(),
                Integer.parseInt(jTextFieldNumero.getText()));
       
    }//GEN-LAST:event_jTableTelaAgendaMouseClicked

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        try {
            contatoNovo = new Contato(jTextFieldNomeCompleto.getText(), jTextFieldTelefone.getText(), jTextFieldEmail.getText(),
                    new Endereco(jTextFieldLogradouro.getText(), Integer.parseInt(jTextFieldNumero.getText())));
            int opcao = JOptionPane.showConfirmDialog(null, " Deseja Alterar " + jTextFieldNomeCompleto.getText());
            if (opcao == 0) {
                agenda.alterar(contatoAntigo, contatoNovo);
                imprimirDadosGrid(agenda.recuperar());
                 lista = agenda.recuperar();
                jTextFieldQtdeContatos.setText("Contatos Cadastrados: " + lista.size());
                JOptionPane.showMessageDialog(null, "Contato Alterado com Sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Acão Cancelada!!!");
                limparTela();
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }

    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarActionPerformed
        try {
            imprimirDadosGrid(agenda.recuperar()); 
             lista = agenda.recuperar();
            jTextFieldQtdeContatos.setText("Contatos Cadastrados: " + lista.size());
            
// TODO add your handling code here:

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }//GEN-LAST:event_jButtonConsultarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        limparTela();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

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
                if ("windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaAgenda().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(TelaAgenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConsultar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JButton jButtonListagem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTelaAgenda;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldLogradouro;
    private javax.swing.JTextField jTextFieldNomeCompleto;
    private javax.swing.JTextField jTextFieldNumero;
    private javax.swing.JTextField jTextFieldQtdeContatos;
    private javax.swing.JTextField jTextFieldTelefone;
    // End of variables declaration//GEN-END:variables

}
