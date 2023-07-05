/* 
 * Material didático destinado ao curso
 * de Programação Orientada a Objetos do 
 * Bacharelado em Ciência da Computação 
 * do IFNMG - Câmpus Montes Claros
 */
package com.mycompany.cantina.gui;

import com.mycompany.cantina.Util;
import com.mycompany.cantina.entidade.Pagamento;
import com.mycompany.cantina.entidade.Venda;
import com.mycompany.cantina.entidade.Pagamento;
import com.mycompany.cantina.repositorio.VendaDao;
import com.mycompany.cantina.repositorio.PagamentoDao;
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
public class CadastroPagamento extends javax.swing.JInternalFrame {

    private static CadastroPagamento self;
    private Venda venda;
    private Pagamento pagamento;

    /**
     * Creates new form InternaC
     */
    private CadastroPagamento() {
        venda = new Venda();
        pagamento = new Pagamento();
        initComponents();
        List<Venda> vendas = new VendaDao().findAll();
        DefaultComboBoxModel<Venda> comboBoxModelVenda = new DefaultComboBoxModel<>();
        if (vendas != null) {
            comboBoxModelVenda.addAll(vendas);
        }
        cmbSelecionaVenda.setModel(comboBoxModelVenda);
    }

    public static CadastroPagamento getInstance() {
        // Caso a janela ainda não tenha sido instanciada
        if (self == null) {
            self = new CadastroPagamento();
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
        frmDataPagamento = new javax.swing.JFormattedTextField();
        cmbSelecionaPagamento = new javax.swing.JComboBox<>();
        frmDataVencimento = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtValorPagamento = new javax.swing.JTextField();
        txtAcrescimo = new javax.swing.JTextField();
        txtDesconto = new javax.swing.JTextField();
        cmbTipoPagamento = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cmbSelecionaVenda = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Pessoa");
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

        jLabel1.setText("SELECIONA PAGAMENTO");

        jLabel2.setText("DATA DO PAGAMENTO  (dd/mm/aaaa)");

        frmDataPagamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        cmbSelecionaPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSelecionaPagamentoActionPerformed(evt);
            }
        });

        frmDataVencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        jLabel5.setText("DATA DO VENCIMENTO  (dd/mm/aaaa)");

        jLabel6.setText("VALOR DO PAGAMENTO");

        jLabel7.setText("ACRÉSCIMO");

        jLabel8.setText("DESCONTO");

        jLabel9.setText("TIPO DE PAGAMENTO");

        txtValorPagamento.setToolTipText("");

        txtDesconto.setToolTipText("");

        cmbTipoPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CARTAO", "DINHEIRO", "PIX" }));
        cmbTipoPagamento.setSelectedIndex(1);
        cmbTipoPagamento.setToolTipText("");
        cmbTipoPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoPagamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                                .addComponent(btnInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluir)
                                .addGap(18, 18, 18)
                                .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(21, 21, 21)
                                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAcrescimo, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtDesconto)
                                    .addComponent(frmDataVencimento, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(frmDataPagamento)
                                    .addComponent(txtValorPagamento)))
                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbSelecionaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbTipoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jpPrincipalLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnExcluir, btnListar});

        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(frmDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(frmDataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtValorPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtAcrescimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cmbTipoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSelecionaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLimpar)
                        .addComponent(btnExcluir)
                        .addComponent(btnListar))
                    .addComponent(btnInserir))
                .addContainerGap())
        );

        jLabel3.setText("SELECIONA VENDA");

        cmbSelecionaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSelecionaVendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addGap(36, 36, 36)
                .addComponent(cmbSelecionaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbSelecionaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbSelecionaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSelecionaVendaActionPerformed
        // TODO add your handling code here:
        venda = (Venda) cmbSelecionaVenda.getModel().getSelectedItem();
        atualizarCmbTela();
    }//GEN-LAST:event_cmbSelecionaVendaActionPerformed

    private void cmbTipoPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoPagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoPagamentoActionPerformed

    private void cmbSelecionaPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSelecionaPagamentoActionPerformed
        // TODO add your handling code here:
        pagamento = (Pagamento) cmbSelecionaPagamento.getModel().getSelectedItem();
        setDadosTela();
    }//GEN-LAST:event_cmbSelecionaPagamentoActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        // TODO add your handling code here:
        new Util().relatorios("/Pagamento.jasper", "Listagem de pagamentos");
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            // TODO add your handling code here:
//            getDadosTela();
            //            if (new PagamentoDao().findById(venda.getId()) == null) {
            //                JOptionPane.showMessageDialog(this, "não cadastraado");
            //                return;
            //            }
            new PagamentoDao().deleteById(pagamento.getId());
            limparDadosTela();
            getDadosTela();
            atualizarCmbTela();

        } catch (Exception ex) {
            Logger.getLogger(CadastroPagamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparDadosTela();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        try {
            // TODO add your handling code here:
            getDadosTela();
            //            if (new PagamentoDao().findById(venda.getId()) != null) {
            //                JOptionPane.showMessageDialog(this, "já cadastraado");
            //                return;
            //            }
            new PagamentoDao().saveOrUpdate(pagamento);
            limparDadosTela();
            getDadosTela();
            atualizarCmbTela();

        } catch (Exception ex) {
            Logger.getLogger(CadastroPagamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnInserirActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
        List<Venda> vendas = new VendaDao().findAll();
        DefaultComboBoxModel<Venda> comboBoxModelVenda = new DefaultComboBoxModel<>();
        if (vendas != null) {
            comboBoxModelVenda.addAll(vendas);
        }
        cmbSelecionaVenda.setModel(comboBoxModelVenda);
    }//GEN-LAST:event_formInternalFrameActivated

    private void getDadosTela() {
        venda = (Venda) cmbSelecionaVenda.getModel().getSelectedItem();
        pagamento = (Pagamento) cmbSelecionaPagamento.getModel().getSelectedItem();
        if (pagamento == null) {
            pagamento = new Pagamento();
        }

        pagamento.setVenda(venda);
        if (!frmDataPagamento.getText().equals("")) {
            DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
            pagamento.setDataPagamento(LocalDate.parse(frmDataPagamento.getText(), formatters));
        } else {
            pagamento.setDataPagamento(null);
        }

        if (!frmDataVencimento.getText().equals("")) {
            DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
            pagamento.setDataVencimento(LocalDate.parse(frmDataVencimento.getText(), formatters));
        } else {
            pagamento.setDataVencimento(null);
        }

//        if (!txtValorPagamento.getText().equals("")) {
            pagamento.setValorPagamento(Double.parseDouble(txtValorPagamento.getText()));
//        }
//        if (!txtAcrescimo.getText().equals("")) {
            pagamento.setAcrescimo(Double.parseDouble(txtAcrescimo.getText()));
//        }
//        if (!txtDesconto.getText().equals("")) {
            pagamento.setDesconto(Double.parseDouble(txtDesconto.getText()));
//        }
        pagamento.setTipoPagamento(cmbTipoPagamento.getSelectedIndex());
    }

    private void setDadosTela() {
        if (pagamento == null) {
            pagamento = new Pagamento();
        }
        if (pagamento.getDataVencimento() != null) {
            Date date = Date.valueOf(pagamento.getDataVencimento());
            frmDataVencimento.setText(new SimpleDateFormat("dd/MM/yyyy").format(date));
        } else {
            frmDataVencimento.setText("");
        }

        if (pagamento.getDataPagamento() != null) {
            Date date = Date.valueOf(pagamento.getDataPagamento());
            frmDataPagamento.setText(new SimpleDateFormat("dd/MM/yyyy").format(date));
        } else {
            frmDataPagamento.setText("");
        }

        txtValorPagamento.setText(String.valueOf(pagamento.getValorPagamento()));
        txtAcrescimo.setText(String.valueOf(pagamento.getAcrescimo()));
        txtDesconto.setText(String.valueOf(pagamento.getDesconto()));
        cmbTipoPagamento.setSelectedIndex(pagamento.getTipoPagamento());

    }

    private void atualizarCmbTela() {
        try {

            List<Pagamento> pagamentos = new VendaDao().localizarPagamentosPorIdVenda(venda);
            DefaultComboBoxModel<Pagamento> comboBoxModelPagamento = new DefaultComboBoxModel<>();
            if (pagamentos != null) {
                comboBoxModelPagamento.addAll(pagamentos);
            }
            cmbSelecionaPagamento.setModel(comboBoxModelPagamento);

        } catch (Exception ex) {
            Logger.getLogger(CadastroPagamento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void limparDadosTela() {
        try {
            frmDataPagamento.setText("");
            frmDataVencimento.setText("");
            txtValorPagamento.setText("");
            txtAcrescimo.setText("");
            txtDesconto.setText("");
            cmbTipoPagamento.setSelectedIndex(1);
            atualizarCmbTela();
            pagamento = null;
        } catch (Exception ex) {
            Logger.getLogger(CadastroPagamento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnListar;
    private javax.swing.JComboBox<Pagamento> cmbSelecionaPagamento;
    private javax.swing.JComboBox<Venda> cmbSelecionaVenda;
    private javax.swing.JComboBox<String> cmbTipoPagamento;
    private javax.swing.JFormattedTextField frmDataPagamento;
    private javax.swing.JFormattedTextField frmDataVencimento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JTextField txtAcrescimo;
    private javax.swing.JTextField txtDesconto;
    private javax.swing.JTextField txtValorPagamento;
    // End of variables declaration//GEN-END:variables
}
