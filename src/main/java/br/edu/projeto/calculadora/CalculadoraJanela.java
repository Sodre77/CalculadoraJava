package br.edu.projeto.calculadora;

import javax.swing.*;
import java.awt.*;

public class CalculadoraJanela extends JFrame {

    // Componente do ecrã da calculadora
    private JTextField display;
    // Instância do teu back-end
    private Calculadora calculadoraBackend;

    public CalculadoraJanela() {
        // Inicializa o teu back-end para usarmos mais à frente
        this.calculadoraBackend = new Calculadora();

        // Configurações básicas da Janela (JFrame)
        setTitle("Calculadora Java");
        setSize(300, 400); // Tamanho ideal para uma calculadora desktop
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela no ecrã
        setLayout(new BorderLayout()); // Organização por regiões (Norte, Sul, Centro...)

        // Criar e configurar o Display (Ecrã)
        display = new JTextField("0");
        display.setFont(new Font("Arial", Font.BOLD, 24)); // Fonte grande e legível
        display.setHorizontalAlignment(JTextField.RIGHT); // Alinha os números à direita
        display.setEditable(false); // Impede o utilizador de digitar com o teclado físico
        display.setBackground(Color.WHITE);

        // Adiciona o display na região Norte (topo) da janela
        add(display, BorderLayout.NORTH);
    }
}