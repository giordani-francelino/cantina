/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.cantina;

import com.mycompany.cantina.entidade.Cardapio;
import com.mycompany.cantina.entidade.ItemCardapio;
import com.mycompany.cantina.entidade.Produto;
import com.mycompany.cantina.repositorio.CardapioDao;
import com.mycompany.cantina.repositorio.ItemCardapioDao;
import com.mycompany.cantina.repositorio.ProdutoDao;
import java.util.List;

/**
 *
 * @author Caixa
 */
public class Cantina {
    
    public static void main(String[] args) {
        Cardapio cardapio1 = new Cardapio("DESCRICAO CARDAPIO 1", (double) 251);
        Produto produto1 = new Produto("PIPOCA", (double) 1);
        ItemCardapio itemCardapio1 = new ItemCardapio(cardapio1, produto1, 100, (double) 300);
        
        cardapio1.adicionarItemCardapio(itemCardapio1);
        produto1.adicionarItemCardapio(itemCardapio1);

        //<editor-fold defaultstate="collapsed" desc="CRUD Cardapio (OK)">
        // Salvando um Cardapio
        Long cardapio1Id = new CardapioDao().saveOrUpdate(cardapio1);
        cardapio1.setId(cardapio1Id);

        // Recuperando um Cardapio através do id
        Cardapio cardapio1Aux = new CardapioDao().findById(cardapio1Id);
        System.out.println(cardapio1Aux);

        // Recuperando todos os cadapios
        List<Cardapio> cardapios = new CardapioDao().findAll();
        System.out.println(cardapios);

        // Atualizando a descricao de um cardapio
        cardapio1Aux.setDescricao(cardapio1Aux.getDescricao() + " ATUALIZADO!!!");
        new CardapioDao().saveOrUpdate(cardapio1Aux);

//        // Deletando através do ID
//        new CardapioDao().deleteById((long) 1);
//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="CRUD Produto (OK)">
        Long produto1Id = new ProdutoDao().saveOrUpdate(produto1);
        produto1.setId(produto1Id);
        
        Produto produto1Aux = new ProdutoDao().findById(produto1Id);
        System.out.println(produto1Aux);
        
        List<Produto> produtos = new ProdutoDao().findAll();
        System.out.println(produtos);
        
        produto1Aux.setDescricao("PIPOCA DOCE");
        new ProdutoDao().saveOrUpdate(produto1Aux);

//        new ProdutoDao().deleteById((long) 1);
//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="CRUD ItemCardapio">
        Long itemCardapio1Id = new ItemCardapioDao().saveOrUpdate(itemCardapio1);
        itemCardapio1.setId(itemCardapio1Id);
        itemCardapio1.setCardapio(cardapio1);
        itemCardapio1.setProduto(produto1);
        
        ItemCardapio itemCardapio1Aux = new ItemCardapioDao().findById(itemCardapio1Id);
        System.out.println(itemCardapio1Aux);
        
        List<ItemCardapio> itemCardapios = new ItemCardapioDao().findAll();
        System.out.println(itemCardapios);
        
        itemCardapio1Aux.setPreco((double) 35000);
        new ItemCardapioDao().saveOrUpdate(itemCardapio1);

//        new ItemCardapioDao().deleteById(itemCardapio1Id);
//</editor-fold>
    }
}
