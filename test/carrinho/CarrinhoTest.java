package carrinho;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class CarrinhoTest {

    Carrinho carrinho;
    Produto livro;
    Produto mouse;

    @BeforeEach
    public void setUp() {
        carrinho = new Carrinho();
        livro = new Produto("Livro de Java", 120.0);
        mouse = new Produto("Mouse sem fio", 80.0);
    }

    @Test
    public void testCarrinhoVazio() {
        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal());
    }

    @Test
    public void testAdicionarItem() {
        carrinho.addItem(livro);
        assertEquals(1, carrinho.getQtdeItems());
        assertEquals(120.0, carrinho.getValorTotal());
    }

    @Test
    public void testAdicionarMultiplosItens() {
        carrinho.addItem(livro);
        carrinho.addItem(mouse);
        assertEquals(2, carrinho.getQtdeItems());
        assertEquals(200.0, carrinho.getValorTotal());
    }

    @Test
    public void testRemoverItemExistente() throws ProdutoNaoEncontradoException {
        carrinho.addItem(livro);
        carrinho.removeItem(livro);
        assertEquals(0, carrinho.getQtdeItems());
    }

    @Test
    public void testRemoverItemInexistente() {
        assertThrows(ProdutoNaoEncontradoException.class, () -> {
            carrinho.removeItem(mouse);
        });
    }

    @Test
    public void testEsvaziarCarrinho() {
        carrinho.addItem(livro);
        carrinho.addItem(mouse);
        carrinho.esvazia();
        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal());
    }
}
