package br.edu.projeto.calculadora;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculadoraTest {

    private final Calculadora calculadora = new Calculadora();

    @Test
    @DisplayName("Deve somar números positivos, negativos e zero")
    void deveSomarValoresVariados() {
        assertEquals(8, calculadora.somar(5, 3));
        assertEquals(-2, calculadora.somar(-5, 3));
        assertEquals(0, calculadora.somar(0, 0));
    }

    @Test
    @DisplayName("Deve subtrair números positivos, negativos e zero")
    void deveSubtrairValoresVariados() {
        assertEquals(2, calculadora.subtrair(5, 3));
        assertEquals(-8, calculadora.subtrair(-5, 3));
        assertEquals(0, calculadora.subtrair(0, 0));
    }

    @Test
    @DisplayName("Deve multiplicar números positivos, negativos e zero")
    void deveMultiplicarValoresVariados() {
        assertEquals(15, calculadora.multiplicar(5, 3));
        assertEquals(-15, calculadora.multiplicar(-5, 3));
        assertEquals(0, calculadora.multiplicar(0, 99));
    }

    @Test
    @DisplayName("Deve dividir números e lançar exceção ao dividir por zero")
    void deveDividirOuLancarExcecao() {
        assertEquals(2.5, calculadora.dividir(5, 2), 0.0001);
        assertEquals(-2.5, calculadora.dividir(-5, 2), 0.0001);
        assertThrows(ArithmeticException.class, () -> calculadora.dividir(10, 0));
    }
}
