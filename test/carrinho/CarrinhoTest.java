package carrinho;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Testes da classe Carrinho")
public class CarrinhoTest {

    private Carrinho carrinho;
    private Produto livro;
    private Produto mouse;
    private Produto teclado;

    @BeforeEach
    public void setUp() {
        carrinho = new Carrinho();
        livro = new Produto("Livro de Java", 120.0);
        mouse = new Produto("Mouse sem fio", 80.0);
        teclado = new Produto("Teclado mecânico", 250.0);
    }

    @Nested
    @DisplayName("Testes do método addItem e getValorTotal")
    class TestAddItemEGetValorTotal {

        @Test
        @DisplayName("Adicionar itens e verificar se o valor total é calculado corretamente")
        void testValorTotalAposAddItens() {
            carrinho.addItem(livro);
            carrinho.addItem(mouse);
            assertEquals(200.0, carrinho.getValorTotal(),
                    "Deve somar o valor do livro (120.0) e do mouse (80.0)");
        }

        @Test
        @DisplayName("Adicionar item único e verificar valor total")
        void testValorTotalComItemUnico() {
            carrinho.addItem(teclado);
            assertEquals(250.0, carrinho.getValorTotal(),
                    "O valor deve ser igual ao preço do teclado (250.0)");
        }

        @Test
        @DisplayName("Carrinho vazio deve ter valor total igual a zero")
        void testCarrinhoVazioValorZero() {
            assertEquals(0.0, carrinho.getValorTotal(),
                    "Carrinho recém-criado ou esvaziado deve ter valor total 0.0");
        }
    }

    @Nested
    @DisplayName("Testes do método removeItem")
    class TestRemoveItem {

        @BeforeEach
        void adicionaItensParaRemover() {
            carrinho.addItem(livro);
            carrinho.addItem(mouse);
            carrinho.addItem(teclado);
        }

        @Test
        @DisplayName("Remover produto existente")
        void testRemoveItemExistente() {
            try {
                carrinho.removeItem(mouse);
                assertEquals(2, carrinho.getQtdeItems(),
                        "Após remover mouse, deve haver 2 itens no carrinho");
                assertFalse(carrinho.getValorTotal() == 450.0,
                        "Valor total não deve mais incluir o mouse");
            } catch (ProdutoNaoEncontradoException e) {
                fail("Não deveria lançar ProdutoNaoEncontradoException pois o item está no carrinho");
            }
        }

        @Test
        @DisplayName("Tentar remover produto que não existe no carrinho deve lançar exceção")
        void testRemoveItemInexistente() {
            Produto fone = new Produto("Fone de ouvido", 50.0);
            assertThrows(ProdutoNaoEncontradoException.class,
                    () -> carrinho.removeItem(fone),
                    "Deve lançar ProdutoNaoEncontradoException ao remover produto inexistente");
        }
    }

    @Nested
    @DisplayName("Testes do método getQtdeItems")
    class TestGetQtdeItems {

        @Test
        @DisplayName("Quantidade de itens deve ser zero em carrinho novo")
        void testQtdeItemsCarrinhoNovo() {
            assertEquals(0, carrinho.getQtdeItems(),
                    "Carrinho recém-criado deve ter 0 itens");
        }

        @Test
        @DisplayName("Quantidade deve refletir o número de itens adicionados")
        void testQtdeItemsAposAdicoes() {
            carrinho.addItem(livro);
            carrinho.addItem(mouse);
            carrinho.addItem(teclado);
            assertEquals(3, carrinho.getQtdeItems(),
                    "Deve retornar 3 itens");
        }
    }

    @Nested
    @DisplayName("Testes do método esvazia")
    class TestEsvazia {

        @Test
        @DisplayName("Esvaziar carrinho deve remover todos os itens")
        void testEsvaziaCarrinho() {
            carrinho.addItem(livro);
            carrinho.addItem(mouse);
            carrinho.esvazia();
            assertEquals(0, carrinho.getQtdeItems(),
                    "Ao esvaziar, todos os itens devem ser removidos");
            assertEquals(0.0, carrinho.getValorTotal(),
                    "Valor total deve ser 0 após esvaziar");
        }
    }
}