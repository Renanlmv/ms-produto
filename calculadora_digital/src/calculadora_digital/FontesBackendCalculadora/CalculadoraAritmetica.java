package calculadora_digital.FontesBackendCalculadora;

public class CalculadoraAritmetica {
	
	double resultado;
	
	public double somar(double num1, double num2) {
		
		resultado = num1+num2;
		return resultado;
	}
	
	public double subtrair(double num1, double num2) {
		
		resultado = num2-num1;
		return resultado;
	}
	
	public double multiplicar(double num1, double num2) {
		
		resultado = num1*num2;
		return resultado;
	}
	
	public double dividir(double num1, double num2) {
		
		resultado = num2/num1;
		return resultado;
	}

}
