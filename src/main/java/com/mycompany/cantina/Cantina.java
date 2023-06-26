/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.cantina;

import com.mycompany.cantina.entidade.Cardapio;
import com.mycompany.cantina.entidade.ItemCardapio;
import com.mycompany.cantina.entidade.ItemVenda;
import com.mycompany.cantina.entidade.Pagamento;
import com.mycompany.cantina.entidade.Pessoa;
import com.mycompany.cantina.entidade.Produto;
import com.mycompany.cantina.entidade.Usuario;
import com.mycompany.cantina.entidade.Venda;

import com.mycompany.cantina.repositorio.CardapioDao;
import com.mycompany.cantina.repositorio.ItemCardapioDao;
import com.mycompany.cantina.repositorio.ItemVendaDao;
import com.mycompany.cantina.repositorio.PagamentoDao;
import com.mycompany.cantina.repositorio.PessoaDao;
import com.mycompany.cantina.repositorio.ProdutoDao;
import com.mycompany.cantina.repositorio.UsuarioDao;
import com.mycompany.cantina.repositorio.VendaDao;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Caixa
 */
public class Cantina {

    public static void main(String[] args) {
        //<editor-fold defaultstate="collapsed" desc="Instancia de Objetos Entidades">
        Cardapio cardapio1 = new Cardapio("DESCRICAO CARDAPIO 1", (double) 251);
        Produto produto1 = new Produto("PIPOCA", (double) 1);
        ItemCardapio itemCardapio1 = new ItemCardapio(cardapio1, produto1, 100, (double) 300);
        Pessoa pessoa1 = new Pessoa(70205341464l, "Ana Zaira", "Rua amendoim, 210, cs, JK - Moc");
        Venda venda1 = new Venda(pessoa1, LocalDate.now());
//        TODO: Implementar ENUM de Pagamento
        Pagamento pagamento1 = new Pagamento(
                LocalDate.parse("2030-05-01"), LocalDate.now(), (double) 220, (double) 100, (double) 0.5, venda1, (int) 1);
        ItemVenda itemVenda1 = new ItemVenda(produto1, venda1, (int) 1200, (double) 650);

//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Incluindo Bidirecionalidade">
        cardapio1.adicionarItemCardapio(itemCardapio1);
        produto1.adicionarItemCardapio(itemCardapio1);
        venda1.adicionarPagamentos(pagamento1);
        venda1.adicionarItemVenda(itemVenda1);

//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="CRUD Cardapio (OK)">
        System.out.println("== Cardapio ==");

        // Salvando um Cardapio
        Long idCardapio1 = new CardapioDao().saveOrUpdate(cardapio1);
        cardapio1.setId(idCardapio1);

        // Recuperando um Cardapio através do id
        cardapio1 = new CardapioDao().findById(idCardapio1);
        System.out.println("> cardapio1Id=" + idCardapio1);

        // Recuperando todos os cadapios
        List<Cardapio> cardapios = new CardapioDao().findAll();
        System.out.println(cardapios);

        // Atualizando a descricao de um cardapio
        cardapio1.setDescricao(cardapio1.getDescricao() + " ATUALIZADO!!!");
        new CardapioDao().saveOrUpdate(cardapio1);

        // Deletando através do ID
//        new CardapioDao().deleteById((long) 1);
//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="CRUD Produto (OK)">
        System.out.println("\n== Produto ==");

        Long idProduto1 = new ProdutoDao().saveOrUpdate(produto1);
        produto1.setId(idProduto1);

        produto1 = new ProdutoDao().findById(idProduto1);
        System.out.println("> produto1Id=" + idProduto1);

        List<Produto> produtos = new ProdutoDao().findAll();
        System.out.println(produtos);

        produto1.setDescricao("PIPOCA DOCE");
        new ProdutoDao().saveOrUpdate(produto1);

//        new ProdutoDao().deleteById((long) 1);
//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="CRUD ItemCardapio (OK)">
        System.out.println("\n== ItemCardapio ==");

        Long idItemCardapio1 = new ItemCardapioDao().saveOrUpdate(itemCardapio1);
        itemCardapio1.setId(idItemCardapio1);

        itemCardapio1 = new ItemCardapioDao().findById(idItemCardapio1);
        System.out.println("> itemCardapio1Id=" + idItemCardapio1);

        List<ItemCardapio> itemCardapios = new ItemCardapioDao().findAll();
        System.out.println(itemCardapios);

        itemCardapio1.setPreco((double) 325.0);
        new ItemCardapioDao().saveOrUpdate(itemCardapio1);

//        new ItemCardapioDao().deleteById(itemCardapio1Id);
//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="CRUD Pessoa (OK)">
        System.out.println("\n== Pessoa ==");

        Long idPessoa1 = new PessoaDao().saveOrUpdate(pessoa1);
        pessoa1.setId(idPessoa1);

        pessoa1 = new PessoaDao().findById(idPessoa1);
        System.out.println("> pessoa1Id=" + idPessoa1);

        List<Pessoa> pessoas = new PessoaDao().findAll();
        System.out.println(pessoas);

        pessoa1.setEndereco("RUA REPÚBLICA DAS BANANAS");
        new PessoaDao().saveOrUpdate(pessoa1);

//        new PessoaDao().deleteById(pessoa1Id);
////</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="CRUD Venda (Ok)">
        System.out.println("\n== Venda ==");

        Long idVenda1 = new VendaDao().saveOrUpdate(venda1);
        venda1.setId(idVenda1);

        venda1 = new VendaDao().findById(idVenda1);
        System.out.println("> venda1Id=" + idVenda1);

        List<Venda> vendas = new VendaDao().findAll();
        System.out.println(vendas);

        venda1.setDataVenda(LocalDate.parse("2023-06-19"));
        new VendaDao().saveOrUpdate(venda1);

//        new VendaDao().deleteById(venda1Id);
//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="CRUD Pessoa (OK)">
        System.out.println("\n== Funcionario ==");


//        new FuncionarioDao().deleteById(idVenda);
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="CRUD Pagamento (OK)">
        System.out.println("\n== Pagamento ==");

        Long idPagamento1 = new PagamentoDao().saveOrUpdate(pagamento1);
        pagamento1.setId(idPagamento1);

        pagamento1 = new PagamentoDao().findById(idPagamento1);
        System.out.println("> idPagamento=" + idPagamento1);

        List<Pagamento> pagamentos = new PagamentoDao().findAll();
        System.out.println(pagamentos);

        pagamento1.setDesconto((double) 1);
        new PagamentoDao().saveOrUpdate(pagamento1);

//        new PagamentoDao().deleteById(idPagamento);
//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="CRUD ItemVenda">
        System.out.println("\n== ItemVenda ==");

        Long idItemVenda1 = new ItemVendaDao().saveOrUpdate(itemVenda1);
        itemVenda1.setId(idVenda1);

        itemVenda1 = new ItemVendaDao().findById(idItemVenda1);
        System.out.println("> idItemVenda=" + idItemVenda1);

        List<ItemVenda> itemVendas = new ItemVendaDao().findAll();
        System.out.println(itemVendas);

        itemVenda1.setPreco((double) 0);
        new ItemVendaDao().saveOrUpdate(itemVenda1);

//        new ItemVendaDao().deleteById(idItemVenda1);
//</editor-fold>
        //
        Usuario usuarioA = new Usuario(null, "Guisso", "guisso@mail.com", "123456", true);
        new UsuarioDao().salvar(usuarioA);
        System.out.println(">> Novo usuário ADMIN inserido no banco de dados");
        
        Usuario usuarioB = new Usuario(null, "Comum", "comum@mail.com", "123456", false);
        new UsuarioDao().salvar(usuarioB);
        System.out.println(">> Novo usuário COMUM inserido no banco de dados");
        
        //
        // Autenticação de usuário
        //
        Usuario usuarioC = new Usuario();
        usuarioC.setEmail("guisso@mail.com");
        usuarioC.setSenha("123456");
        
        Usuario usuarioAutenticado = new UsuarioDao().autenticar(usuarioC);
        if(usuarioAutenticado != null) {
            System.out.println(">> Autenticado: " + usuarioAutenticado);
        } else {
            System.out.println(">> Não autenticado.");
        }
        
    }
}
