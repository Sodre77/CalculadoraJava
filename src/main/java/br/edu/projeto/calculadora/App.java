package br.edu.projeto.calculadora;

import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        // Executa a interface gráfica de forma segura na thread do Swing
        SwingUtilities.invokeLater(() -> {
            CalculadoraJanela janela = new CalculadoraJanela();
            janela.setVisible(true); // Torna a janela visível
        });
    }
}