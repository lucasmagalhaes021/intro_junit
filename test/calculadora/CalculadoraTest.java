package calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
    
    private Calculadora calc;
    
    @BeforeEach
    public void inicializa() {
        calc = new Calculadora();
    }

    @Nested
    @DisplayName("Testes do método soma")
    class TesteSoma {
        @Test
        @DisplayName("Teste soma com números positivos")
        void testSomaPositivos() {
            assertEquals(5, calc.soma(2, 3), "2 + 3 deve ser 5");
        }

        @Test
        @DisplayName("Teste soma com números negativos")
        void testSomaNegativos() {
            assertEquals(-5, calc.soma(-2, -3), "-2 + -3 deve ser -5");
        }

        @Test
        @DisplayName("Teste soma com zero")
        void testSomaComZero() {
            assertEquals(3, calc.soma(3, 0), "3 + 0 deve ser 3");
        }
    }

    @Nested
    @DisplayName("Testes do método subtração")
    class TesteSubtracao {
        @Test
        @DisplayName("Teste subtração com números positivos")
        void testSubtracaoPositivos() {
            assertEquals(2, calc.subtracao(5, 3), "5 - 3 deve ser 2");
        }

        @Test
        @DisplayName("Teste subtração com números negativos")
        void testSubtracaoNegativos() {
            assertEquals(-2, calc.subtracao(-5, -3), "-5 - -3 deve ser -2");
        }

        @Test
        @DisplayName("Teste subtração com zero")
        void testSubtracaoComZero() {
            assertEquals(5, calc.subtracao(5, 0), "5 - 0 deve ser 5");
        }
    }

    @Nested
    @DisplayName("Testes do método multiplicação")
    class TesteMultiplicacao {
        @Test
        @DisplayName("Teste multiplicação com números positivos")
        void testMultiplicacaoPositivos() {
            assertEquals(15, calc.multiplicacao(3, 5), "3 * 5 deve ser 15");
        }

        @Test
        @DisplayName("Teste multiplicação com zero")
        void testMultiplicacaoComZero() {
            assertEquals(0, calc.multiplicacao(5, 0), "5 * 0 deve ser 0");
        }

        @Test
        @DisplayName("Teste multiplicação com números negativos")
        void testMultiplicacaoNegativos() {
            assertEquals(15, calc.multiplicacao(-3, -5), "-3 * -5 deve ser 15");
        }
    }

    @Nested
    @DisplayName("Testes do método divisão")
    class TesteDivisao {
        @Test
        @DisplayName("Teste divisão normal")
        void testDivisaoNormal() {
            assertEquals(2, calc.divisao(6, 3), "6 / 3 deve ser 2");
        }

        @Test
        @DisplayName("Teste divisão por zero")
        void testDivisaoPorZero() {
            assertThrows(ArithmeticException.class, () -> calc.divisao(5, 0),
                    "Divisão por zero deve lançar ArithmeticException");
        }

        @Test
        @DisplayName("Teste divisão com números negativos")
        void testDivisaoNegativos() {
            assertEquals(2, calc.divisao(-6, -3), "-6 / -3 deve ser 2");
        }
    }

    @Nested
    @DisplayName("Testes do método somatória")
    class TesteSomatoria {
        @Test
        @DisplayName("Teste somatória de número positivo")
        void testSomatoriaPositivo() {
            assertEquals(15, calc.somatoria(5), "Somatória de 5 deve ser 15 (5+4+3+2+1+0)");
        }

        @Test
        @DisplayName("Teste somatória de zero")
        void testSomatoriaZero() {
            assertEquals(0, calc.somatoria(0), "Somatória de 0 deve ser 0");
        }

        @Test
        @DisplayName("Teste somatória de número negativo")
        void testSomatoriaNegativo() {
            assertEquals(0, calc.somatoria(-1), "Somatória de número negativo deve ser 0");
        }
    }

    @Nested
    @DisplayName("Testes do método ehPositivo")
    class TesteEhPositivo {
        @Test
        @DisplayName("Teste número positivo")
        void testNumeroPositivo() {
            assertTrue(calc.ehPositivo(5), "5 deve ser considerado positivo");
        }

        @Test
        @DisplayName("Teste número negativo")
        void testNumeroNegativo() {
            assertFalse(calc.ehPositivo(-5), "-5 não deve ser considerado positivo");
        }

        @Test
        @DisplayName("Teste zero")
        void testZero() {
            assertTrue(calc.ehPositivo(0), "0 deve ser considerado positivo");
        }
    }

    @Nested
    @DisplayName("Testes do método compara")
    class TesteCompara {
        @Test
        @DisplayName("Teste números iguais")
        void testNumerosIguais() {
            assertEquals(0, calc.compara(5, 5), "Comparação de números iguais deve retornar 0");
        }

        @Test
        @DisplayName("Teste primeiro número maior")
        void testPrimeiroMaior() {
            assertEquals(1, calc.compara(7, 5), "Comparação com primeiro número maior deve retornar 1");
        }

        @Test
        @DisplayName("Teste segundo número maior")
        void testSegundoMaior() {
            assertEquals(-1, calc.compara(5, 7), "Comparação com segundo número maior deve retornar -1");
        }

        @Test
        @DisplayName("Teste com números negativos")
        void testComparacaoNegativos() {
            assertEquals(1, calc.compara(-2, -5), "Comparação com números negativos (-2 > -5) deve retornar 1");
        }
    }
}