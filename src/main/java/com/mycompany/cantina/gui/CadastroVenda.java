/* 
 * Material didático destinado ao curso
 * de Programação Orientada a Objetos do 
 * Bacharelado em Ciência da Computação 
 * do IFNMG - Câmpus Montes Claros
 */
package com.mycompany.cantina.gui;

import com.mycompany.cantina.Util;
import com.mycompany.cantina.entidade.Pessoa;
import com.mycompany.cantina.entidade.Venda;
import com.mycompany.cantina.repositorio.PessoaDao;
import com.mycompany.cantina.repositorio.VendaDao;
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
public class CadastroVenda extends javax.swing.JInternalFrame {

    private static CadastroVenda self;
    private Pessoa pessoa;
    private Venda venda;

    /**
     * Creates new form InternaC
     */
    private CadastroVenda() {
        pessoa = new Pessoa();
        venda = new Venda();
        initComponents();
            List<Pessoa> pessoas = new PessoaDao().findAll();
            DefaultComboBoxModel<Pessoa> comboBoxModelPessoa = new DefaultComboBoxModel<>();
            if (pessoas != null) {
                comboBoxModelPessoa.addAll(pessoas);
            }
            cmbSelecionaPessoa.setModel(comboBoxModelPessoa);
//        atualizarCmbTela();

    }

    public static CadastroVenda getInstance() {
        // Caso a janela ainda não tenha sido instanciada
        if (self == null) {
            self = new CadastroVenda();
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
        btnListar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbSelecionaPessoa = new javax.swing.JComboBox<>();
        cmbSelecionaVenda = new javax.swing.JComboBox<>();
        frmDataVenda = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Venda");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        btnInserir.setText("Salvar");
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

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        jLabel1.setText("SELECIONA PESSOA");

        jLabel2.setText("DATA DA VENDA (dd/mm/aaaa)");

        jLabel3.setText("SELECIONA VENDA");

        cmbSelecionaPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSelecionaPessoaActionPerformed(evt);
            }
        });

        cmbSelecionaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSelecionaVendaActionPerformed(evt);
            }
        });

        frmDataVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        jLabel4.setText("Para inserir não preencha SELECIONA VENDA, caso preencha indevidamente clik em Limpar ");

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                        .addComponent(btnInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbSelecionaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(12, 12, 12)))
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(frmDataVenda)
                            .addComponent(cmbSelecionaPessoa, 0, 263, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jpPrincipalLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnExcluir, btnListar});

        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSelecionaPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(frmDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbSelecionaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLimpar)
                        .addComponent(btnExcluir)
                        .addComponent(btnListar))
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
            new VendaDao().saveOrUpdate(venda);
            limparDadosTela();
            getDadosTela();
            atualizarCmbTela();

        } catch (Exception ex) {
            Logger.getLogger(CadastroVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparDadosTela();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            // TODO add your handling code here:
            getDadosTela();
//            if (new VendaDao().findById(pessoa.getId()) == null) {
//                JOptionPane.showMessageDialog(this, "não cadastraado");
//                return;
//            }
            new VendaDao().deleteById(venda.getId());
            limparDadosTela();
            getDadosTela();
            atualizarCmbTela();

        } catch (Exception ex) {
            Logger.getLogger(CadastroVenda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        // TODO add your handling code here:
        new Util().relatorios("/Venda.jasper", "Listagem de vendas");

    }//GEN-LAST:event_btnListarActionPerformed

    private void cmbSelecionaPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSelecionaPessoaActionPerformed
        // TODO add your handling code here:
        pessoa = (Pessoa) cmbSelecionaPessoa.getModel().getSelectedItem();
        atualizarCmbTela();
    }//GEN-LAST:event_cmbSelecionaPessoaActionPerformed

    private void cmbSelecionaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSelecionaVendaActionPerformed
        // TODO add your handling code here:
        venda = (Venda) cmbSelecionaVenda.getModel().getSelectedItem();
        setDadosTela();
    }//GEN-LAST:event_cmbSelecionaVendaActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
            List<Pessoa> pessoas = new PessoaDao().findAll();
            DefaultComboBoxModel<Pessoa> comboBoxModelPessoa = new DefaultComboBoxModel<>();
            if (pessoas != null) {
                comboBoxModelPessoa.addAll(pessoas);
            }
            cmbSelecionaPessoa.setModel(comboBoxModelPessoa);
    }//GEN-LAST:event_formInternalFrameActivated

    private void getDadosTela() {
        pessoa = (Pessoa) cmbSelecionaPessoa.getModel().getSelectedItem();
        venda = (Venda) cmbSelecionaVenda.getModel().getSelectedItem();
        if (venda == null) {
            venda = new Venda();
        }
        venda.setPessoa(pessoa);
        if (!frmDataVenda.getText().equals("")) {
            DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
            venda.setDataVenda(LocalDate.parse(frmDataVenda.getText(), formatters));
        } else {
            venda.setDataVenda(null);
        }

    }

    private void setDadosTela() {
        if (venda == null) {
            venda = new Venda();
        }
        if (venda.getDataVenda() != null) {
            Date date = Date.valueOf(venda.getDataVenda());
            frmDataVenda.setText(new SimpleDateFormat("dd/MM/yyyy").format(date));
        } else {
            frmDataVenda.setText("");
        }
    }

    private void atualizarCmbTela() {
        try {


            List<Venda> vendas = new PessoaDao().localizarVendasPorIdPessoa(pessoa);
            DefaultComboBoxModel<Venda> comboBoxModelVenda = new DefaultComboBoxModel<>();
            if (vendas != null) {
                comboBoxModelVenda.addAll(vendas);
            }
            cmbSelecionaVenda.setModel(comboBoxModelVenda);

        } catch (Exception ex) {
            Logger.getLogger(CadastroVenda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void limparDadosTela() {
        try {
            frmDataVenda.setText("");
            atualizarCmbTela();
            venda = null;
        } catch (Exception ex) {
            Logger.getLogger(CadastroVenda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnListar;
    private javax.swing.JComboBox<Pessoa> cmbSelecionaPessoa;
    private javax.swing.JComboBox<Venda> cmbSelecionaVenda;
    private javax.swing.JFormattedTextField frmDataVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jpPrincipal;
    // End of variables declaration//GEN-END:variables
}
