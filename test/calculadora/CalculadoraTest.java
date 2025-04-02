package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois números")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exce��o n�o lan�ada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}
	
	@Test
	public void testSubtracao() {
		int result = calc.subtracao(10, 2);
		Assertions.assertEquals(8, result);	
	}
	
	@Test
	public void testMultiplicacao() {
		int result = calc.multiplicacao(10, 2);
		Assertions.assertEquals(20, result);	
	}
	
	@Test
	public void testehpositivo() {
		boolean isPositive = calc.ehPositivo(10);
		assertTrue(isPositive == true);	
	}
	
	@Test
	public void testehpositivoNumberNegative() {
		boolean isPositive = calc.ehPositivo(-10);
		assertTrue(isPositive == false);	
	}
	
	@Test
	public void testSomatario() {
		int resultSum =  calc.somatoria(10);
		Assertions.assertEquals(55, resultSum);
	}
	
	@Test
	public void testcomparaNegative() {
		int resultComparison =  calc.compara(10, 15);
		Assertions.assertEquals(-1, resultComparison);
	}
	
	@Test
	public void testcomparaPositive() {
		int resultComparison =  calc.compara(15, 2);
		Assertions.assertEquals(1, resultComparison);
	}

	@Test
	public void testcomparaIgual() {
		int resultComparison =  calc.compara(2, 2);
		Assertions.assertEquals(0, resultComparison);
	}

}
