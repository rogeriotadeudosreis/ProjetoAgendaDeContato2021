/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import classesdedados.Contato;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import persistencias.ContatoPersistencia;

/**
 *
 * @author roger
 */
public class TelaListagem extends javax.swing.JFrame {

    ContatoPersistencia agenda = null;
    ArrayList<Contato> lista;

    /**
     * Creates new form TelaListagem
     */
    public TelaListagem() throws Exception {
        initComponents();
        agenda = new ContatoPersistencia("contato.txt");
        lista = new ArrayList<>();
        imprimirDadosGrid(agenda.recuperar());
        lista = agenda.recuperar();
            jTextFieldQtdeContatos.setText("Contatos Cadastrados: " + lista.size());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    private void imprimirDadosGrid(ArrayList<Contato> lista) {
        DefaultTableModel model = (DefaultTableModel) jTableListagem.getModel();
        model.setNumRows(0);
        for (int pos = 0; pos < lista.size(); pos++) {
            String[] linha = new String[5];
            Contato aux = lista.get(pos);
            linha[0] = aux.getNomeCompleto().toUpperCase();
            linha[1] = aux.getTelefone();
            linha[2] = aux.getEmail();
            linha[3] = aux.getEnderecoResidencial().getLogradouro().toUpperCase();
            linha[4] = " " + aux.getEnderecoResidencial().getNumero();
            model.addRow(linha);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListagem = new javax.swing.JTable();
        jButtonListar = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jTextFieldQtdeContatos = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agenda 2021 - Listagem");
        setResizable(false);

        jTableListagem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Telefone", "E-mail", "Logradouro", "Número"
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
        jTableListagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListagemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableListagem);
        if (jTableListagem.getColumnModel().getColumnCount() > 0) {
            jTableListagem.getColumnModel().getColumn(0).setPreferredWidth(450);
            jTableListagem.getColumnModel().getColumn(1).setResizable(false);
            jTableListagem.getColumnModel().getColumn(1).setPreferredWidth(175);
            jTableListagem.getColumnModel().getColumn(2).setResizable(false);
            jTableListagem.getColumnModel().getColumn(2).setPreferredWidth(350);
            jTableListagem.getColumnModel().getColumn(3).setResizable(false);
            jTableListagem.getColumnModel().getColumn(3).setPreferredWidth(450);
            jTableListagem.getColumnModel().getColumn(4).setResizable(false);
            jTableListagem.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        jButtonListar.setText("Listar");
        jButtonListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListarActionPerformed(evt);
            }
        });

        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonListar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonVoltar)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldQtdeContatos, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 873, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonListar)
                    .addComponent(jButtonVoltar)
                    .addComponent(jTextFieldQtdeContatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListarActionPerformed

        try {
            imprimirDadosGrid(agenda.recuperar());
            lista = agenda.recuperar();
            jTextFieldQtdeContatos.setText("Contatos Cadastrados: " + lista.size());

        } catch (Exception erro) {

        }
    }//GEN-LAST:event_jButtonListarActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed

        TelaAgenda voltaTelaCadastro = null;
        try {
            voltaTelaCadastro = new TelaAgenda();
        } catch (Exception ex) {
            Logger.getLogger(TelaListagem.class.getName()).log(Level.SEVERE, null, ex);
        }
        voltaTelaCadastro.setVisible(true);
        dispose();

    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jTableListagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListagemMouseClicked


    }//GEN-LAST:event_jTableListagemMouseClicked

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
            java.util.logging.Logger.getLogger(TelaListagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaListagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaListagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaListagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaListagem().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(TelaListagem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonListar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListagem;
    private javax.swing.JTextField jTextFieldQtdeContatos;
    // End of variables declaration//GEN-END:variables
}
