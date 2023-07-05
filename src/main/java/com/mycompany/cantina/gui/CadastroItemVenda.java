/* 
 * Material didático destinado ao curso
 * de Programação Orientada a Objetos do 
 * Bacharelado em Ciência da Computação 
 * do IFNMG - Câmpus Montes Claros
 */
package com.mycompany.cantina.gui;

import com.mycompany.cantina.Util;
import com.mycompany.cantina.entidade.ItemVenda;
import com.mycompany.cantina.entidade.Produto;
import com.mycompany.cantina.entidade.Produto;
import com.mycompany.cantina.entidade.Venda;
import com.mycompany.cantina.repositorio.ItemVendaDao;
import com.mycompany.cantina.repositorio.ProdutoDao;
import com.mycompany.cantina.repositorio.VendaDao;
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
public class CadastroItemVenda extends javax.swing.JInternalFrame {

    private static CadastroItemVenda self;
    private Venda venda;
    private ItemVenda itemVenda;
    private Produto produto;

    /**
     * Creates new form InternaC
     */
    private CadastroItemVenda() {
        venda = new Venda();
        itemVenda = new ItemVenda();
        produto = new Produto();
        initComponents();

        List<Venda> vendas = new VendaDao().findAll();
        DefaultComboBoxModel<Venda> comboBoxModelVenda = new DefaultComboBoxModel<>();
        if (vendas != null) {
            comboBoxModelVenda.addAll(vendas);
        }
        cmbSelecionaVenda.setModel(comboBoxModelVenda);

        List<Produto> produtos = new ProdutoDao().findAll();
        DefaultComboBoxModel<Produto> comboBoxModelProduto = new DefaultComboBoxModel<>();
        if (produtos != null) {
            comboBoxModelProduto.addAll(produtos);
        }
        cmbSelecionaProduto.setModel(comboBoxModelProduto);

    }

    public static CadastroItemVenda getInstance() {
        // Caso a janela ainda não tenha sido instanciada
        if (self == null) {
            self = new CadastroItemVenda();
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
        txtQuantidade = new javax.swing.JTextField();
        cmbSelecionaProduto = new javax.swing.JComboBox<>();
        txtPreco = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbSelecionaItemVenda = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cmbSelecionaVenda = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Item Vendido");
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

        jLabel1.setText("SELECIONA PRODUTO");

        jLabel2.setText("QUANTIDADE");

        txtQuantidade.setToolTipText("");

        cmbSelecionaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSelecionaProdutoActionPerformed(evt);
            }
        });

        txtPreco.setToolTipText("");

        jLabel4.setText("PREÇO");

        jLabel3.setText("SELECIONA ITEM VENDIDO");

        cmbSelecionaItemVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSelecionaItemVendaActionPerformed(evt);
            }
        });

        jLabel5.setText("SELECIONA VENDA");

        cmbSelecionaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSelecionaVendaActionPerformed(evt);
            }
        });

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
                        .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbSelecionaItemVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbSelecionaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbSelecionaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jpPrincipalLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnExcluir, btnListar});

        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbSelecionaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(19, 19, 19)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSelecionaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(0, 14, Short.MAX_VALUE)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cmbSelecionaItemVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            getDadosTela();
            //            if (new ItemVendaDao().findById(venda.getId()) != null) {
            //                JOptionPane.showMessageDialog(this, "já cadastraado");
            //                return;
            //            }
            new ItemVendaDao().saveOrUpdate(itemVenda);
            limparDadosTela();
            getDadosTela();
            atualizarCmbTela();

        } catch (Exception ex) {
            Logger.getLogger(CadastroItemVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed

        limparDadosTela();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
//            getDadosTela();
            //            if (new ItemVendaDao().findById(venda.getId()) == null) {
            //                JOptionPane.showMessageDialog(this, "não cadastraado");
            //                return;
            //            }
            new ItemVendaDao().deleteById(itemVenda.getId());
            limparDadosTela();
            getDadosTela();

        } catch (Exception ex) {
            Logger.getLogger(CadastroItemVenda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        // TODO add your handling code here:
        new Util().relatorios("/ItemVenda.jasper", "Listagem de itens vendidos");

    }//GEN-LAST:event_btnListarActionPerformed

    private void cmbSelecionaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSelecionaProdutoActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_cmbSelecionaProdutoActionPerformed

    private void cmbSelecionaItemVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSelecionaItemVendaActionPerformed
        // TODO add your handling code here:
        itemVenda = (ItemVenda) cmbSelecionaItemVenda.getModel().getSelectedItem();
        produto = itemVenda.getProduto();
        setDadosTela();

    }//GEN-LAST:event_cmbSelecionaItemVendaActionPerformed

    private void cmbSelecionaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSelecionaVendaActionPerformed
        // TODO add your handling code here:
        atualizarCmbTela();
    }//GEN-LAST:event_cmbSelecionaVendaActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
        List<Venda> vendas = new VendaDao().findAll();
        DefaultComboBoxModel<Venda> comboBoxModelVenda = new DefaultComboBoxModel<>();
        if (vendas != null) {
            comboBoxModelVenda.addAll(vendas);
        }
        cmbSelecionaVenda.setModel(comboBoxModelVenda);

        List<Produto> produtos = new ProdutoDao().findAll();
        DefaultComboBoxModel<Produto> comboBoxModelProduto = new DefaultComboBoxModel<>();
        if (produtos != null) {
            comboBoxModelProduto.addAll(produtos);
        }
        cmbSelecionaProduto.setModel(comboBoxModelProduto);

    }//GEN-LAST:event_formInternalFrameActivated
    private void getDadosTela() {
        venda = (Venda) cmbSelecionaVenda.getModel().getSelectedItem();
        itemVenda = (ItemVenda) cmbSelecionaItemVenda.getModel().getSelectedItem();

        if (itemVenda == null) {
            itemVenda = new ItemVenda();
        }

//        if (!txtPreco.getText().equals("")) {
            itemVenda.setPreco(Double.parseDouble(txtPreco.getText()));
//        }
//        if (!txtQuantidade.getText().equals("")) {
            itemVenda.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
//        }
        produto = (Produto) cmbSelecionaProduto.getModel().getSelectedItem();
        itemVenda.setProduto(produto);
        itemVenda.setVenda(venda);

    }

    private void setDadosTela() {
        if (itemVenda == null) {
            itemVenda = new ItemVenda();
        }
        txtPreco.setText(String.valueOf(itemVenda.getPreco()));
        txtQuantidade.setText(String.valueOf(itemVenda.getQuantidade()));
        cmbSelecionaProduto.addItem(itemVenda.getProduto());
        cmbSelecionaProduto.setSelectedIndex(cmbSelecionaProduto.getItemCount() - 1);
    }

    private void atualizarCmbTela() {
        try {
            venda = (Venda) cmbSelecionaVenda.getModel().getSelectedItem();

            List<Produto> produtos = new ProdutoDao().findAll();
            DefaultComboBoxModel<Produto> comboBoxModelProduto = new DefaultComboBoxModel<>();
            if (produtos != null) {
                comboBoxModelProduto.addAll(produtos);
            }
            cmbSelecionaProduto.setModel(comboBoxModelProduto);

            List<ItemVenda> itemVendas = new VendaDao().localizarItemVendasPorIdVenda(venda);
            DefaultComboBoxModel<ItemVenda> comboBoxModelItemVenda = new DefaultComboBoxModel<>();
            if (itemVendas != null) {
                comboBoxModelItemVenda.addAll(itemVendas);
            }
            cmbSelecionaItemVenda.setModel(comboBoxModelItemVenda);

        } catch (Exception ex) {
            Logger.getLogger(CadastroItemVenda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void limparDadosTela() {
        try {
            txtPreco.setText("");
            txtQuantidade.setText("");
            cmbSelecionaProduto.setSelectedIndex(-1);
            itemVenda = null;
            atualizarCmbTela();
        } catch (Exception ex) {
            Logger.getLogger(CadastroItemVenda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnListar;
    private javax.swing.JComboBox<ItemVenda> cmbSelecionaItemVenda;
    private javax.swing.JComboBox<Produto> cmbSelecionaProduto;
    private javax.swing.JComboBox<Venda> cmbSelecionaVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}