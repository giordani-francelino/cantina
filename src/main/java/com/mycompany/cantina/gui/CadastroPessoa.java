/* 
 * Material didático destinado ao curso
 * de Programação Orientada a Objetos do 
 * Bacharelado em Ciência da Computação 
 * do IFNMG - Câmpus Montes Claros
 */
package com.mycompany.cantina.gui;

import com.mycompany.cantina.Util;
import com.mycompany.cantina.entidade.Pessoa;
import com.mycompany.cantina.repositorio.PessoaDao;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Guisso <luis dot guisso at ifnmg dot edu dot br>
 * @version 0.0.1, 16/08/2021
 */
public class CadastroPessoa extends javax.swing.JInternalFrame {

    private static CadastroPessoa self;
    private Pessoa pessoa;

    /**
     * Creates new form InternaC
     */
    private CadastroPessoa() {
        pessoa = new Pessoa();
        initComponents();
        atualizarCmbTela();

    }

    public static CadastroPessoa getInstance() {
        // Caso a janela ainda não tenha sido instanciada
        if (self == null) {
            self = new CadastroPessoa();
        }

        return self;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPrincipal = new javax.swing.JPanel();
        btnInserir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnjbtListar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbSelecionaPessoa = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtCpf = new com.mycompany.cantina.gui.TxtField();
        txtNome = new com.mycompany.cantina.gui.TxtField();
        txtEndereco = new com.mycompany.cantina.gui.TxtField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Cliente");

        btnInserir.setText("Salvar");
        btnInserir.setToolTipText("");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnjbtListar.setText("Listar");
        btnjbtListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnjbtListarActionPerformed(evt);
            }
        });

        jLabel1.setText("SELECIONA PESSOA");

        jLabel2.setText("NOME");

        jLabel3.setText("ENDEREÇO");

        cmbSelecionaPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSelecionaPessoaActionPerformed(evt);
            }
        });

        jLabel4.setText("CPF");

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                        .addComponent(btnInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(btnjbtListar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(275, 275, 275))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbSelecionaPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(70, 70, 70))
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jpPrincipalLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnExcluir, btnjbtListar});

        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSelecionaPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLimpar)
                        .addComponent(btnExcluir)
                        .addComponent(btnjbtListar))
                    .addComponent(btnInserir))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        try {
            // TODO add your handling code here:
            getDadosTela();
            new PessoaDao().saveOrUpdate(pessoa);
            limparDadosTela();
            atualizarCmbTela();

        } catch (Exception ex) {
            Logger.getLogger(CadastroPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparDadosTela();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            // TODO add your handling code here:
            if (pessoa != null) {
                if (pessoa.getId() != null && pessoa.getId() != 0) {
                    new PessoaDao().deleteById(pessoa.getId());
                }
            }
            limparDadosTela();
            atualizarCmbTela();

        } catch (Exception ex) {
            Logger.getLogger(CadastroPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnjbtListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnjbtListarActionPerformed
        // TODO add your handling code here:
        new Util().relatorios("/Pessoa.jasper", "Listagem de Pessoas");

    }//GEN-LAST:event_btnjbtListarActionPerformed

    private void cmbSelecionaPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSelecionaPessoaActionPerformed
        // TODO add your handling code here:
        pessoa = (Pessoa) cmbSelecionaPessoa.getModel().getSelectedItem();
        setDadosTela();


    }//GEN-LAST:event_cmbSelecionaPessoaActionPerformed

    private void getDadosTela() {
        if (pessoa == null) {
            pessoa = new Pessoa();
        }
        if (pessoa.getCpf() == null) {
            pessoa.setCpf(Long.parseLong(txtCpf.getText()));
        }

        pessoa.setNome(txtNome.getText());
        pessoa.setEndereco(txtEndereco.getText());
    }

    private void setDadosTela() {
        if (pessoa == null) {
            pessoa = new Pessoa();
        }
        txtCpf.setText(String.valueOf(pessoa.getCpf()));
        txtNome.setText(pessoa.getNome());
        txtEndereco.setText(pessoa.getEndereco());
    }

    private void atualizarCmbTela() {
        try {

            List<Pessoa> pessoas = new PessoaDao().findAll();
            DefaultComboBoxModel<Pessoa> comboBoxModelPessoa = new DefaultComboBoxModel<>();
            if (pessoas != null) {
                comboBoxModelPessoa.addAll(pessoas);
            }
            cmbSelecionaPessoa.setModel(comboBoxModelPessoa);

        } catch (Exception ex) {
            Logger.getLogger(CadastroPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void limparDadosTela() {
        try {
            txtCpf.setText("");
            txtNome.setText("");
            txtEndereco.setText("");
            atualizarCmbTela();
            txtCpf.setText("");
            pessoa = null;
        } catch (Exception ex) {
            Logger.getLogger(CadastroPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnjbtListar;
    private javax.swing.JComboBox<Pessoa> cmbSelecionaPessoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jpPrincipal;
    private com.mycompany.cantina.gui.TxtField txtCpf;
    private com.mycompany.cantina.gui.TxtField txtEndereco;
    private com.mycompany.cantina.gui.TxtField txtNome;
    // End of variables declaration//GEN-END:variables
}
