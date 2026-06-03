package br.edu.projeto.calculadora;

import javax.swing.*;

public class CalculadoraJanela extends JFrame {
    // Componente do ecrã da calculadora
    private JTextField display;
    // Instância do teu back-end
    private Calculadora calculadoraBackend;

    public CalculadoraJanela() {
        // Inicializa o teu back-end para usarmos mais à frente
        this.calculadoraBackend = new Calculadora();

    }
}
