package TestesBackendCalculadora;

import static org.junit.Assert.*;

import org.junit.Test;

import calculadora_digital.FontesBackendCalculadora.CalculadoraAritmetica;

public class CalculadoraAritmeticaTeste {

	// Atributos para controle do resultado do teste
	double resultadoEsperado;
	double resultadoReal;
	
	@Test
	public void testeSomar2com6() {
		resultadoEsperado = 8;
		CalculadoraAritmetica calc = new CalculadoraAritmetica();
		resultadoReal = calc.somar(2, 6);
		assertEquals(resultadoReal, resultadoEsperado, 0);
	}
	
	@Test
	public void testeSomar3com5() {
		resultadoEsperado = 8;
		CalculadoraAritmetica calc = new CalculadoraAritmetica();
		resultadoReal = calc.somar(3, 5);
		assertEquals(resultadoReal, resultadoEsperado, 0);
	}
	
	@Test
	public void testeMultiplicar3com5() {
		resultadoEsperado = 15;
		CalculadoraAritmetica calc = new CalculadoraAritmetica();
		resultadoReal = calc.multiplicar(3, 5);
		assertEquals(resultadoReal, resultadoEsperado, 0);
	}
	
	@Test
	public void testeSubtrair3de5() {
		resultadoEsperado = 2;
		CalculadoraAritmetica calc = new CalculadoraAritmetica();
		resultadoReal = calc.subtrair(3, 5);
		assertEquals(resultadoReal, resultadoEsperado, 0);
	}
	
	@Test
	public void testeDividir6por2() {
		resultadoEsperado = 3;
		CalculadoraAritmetica calc = new CalculadoraAritmetica();
		resultadoReal = calc.dividir(2, 6);
		assertEquals(resultadoReal, resultadoEsperado, 10);
	}
	
	@Test
	public void testeDividir17por3() {
		resultadoEsperado = 5.666;
		CalculadoraAritmetica calc = new CalculadoraAritmetica();
		resultadoReal = calc.dividir(3, 17);
		assertEquals(resultadoReal, resultadoEsperado, 0.001);
	}
	
	

}
