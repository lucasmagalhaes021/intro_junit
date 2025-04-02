package produto;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ProdutoNaoEncontradoExceptionTest {
    @Test
    void deveLancarProdutoNaoEncontradoException() {
        assertThrows(ProdutoNaoEncontradoException.class, () -> {
            // Simulando situação onde a exceção seria lançada
            throw new ProdutoNaoEncontradoException();
        });
    }
}
