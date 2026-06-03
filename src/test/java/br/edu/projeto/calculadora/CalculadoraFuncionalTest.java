package br.edu.projeto.calculadora;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraFuncionalTest {

    @Test
    @DisplayName("Deve validar um fluxo simples de calculo com varias operacoes")
    void deveExecutarFluxoCompletoDeCalculo() {
        Calculadora calculadora = new Calculadora();

        int totalInicial = calculadora.somar(20, 10);
        int totalAjustado = calculadora.subtrair(totalInicial, 5);
        int totalFinal = calculadora.multiplicar(totalAjustado, 2);
        double resultado = calculadora.dividir(totalFinal, 5);

        assertEquals(10.0, resultado, 0.0001);
    }
}
