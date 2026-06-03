package br.edu.projeto.calculadora;

public class App {

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        System.out.println("Soma: " + calculadora.somar(10, 5));
        System.out.println("Subtracao: " + calculadora.subtrair(10, 5));
        System.out.println("Multiplicacao: " + calculadora.multiplicar(10, 5));
        System.out.println("Divisao: " + calculadora.dividir(10, 5));
    }
}
