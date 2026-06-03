package br.edu.projeto.calculadora;

/**
 * Calculadora simples com as quatro operações básicas.
 */
public class Calculadora {

    public int somar(int a, int b) {
        return a + b;
    }

    public int subtrair(int a, int b) {
        return a - b;
    }

    public int multiplicar(int a, int b) {
        return a * b;
    }

    public double dividir(double a, double b) {
        if (b == 0.0) {
            throw new ArithmeticException("Nao e possivel dividir por zero.");
        }
        return a / b;
    }
}
