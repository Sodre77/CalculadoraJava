package br.edu.projeto.calculadora;

import javax.swing.*;
import java.awt.*;

public class CalculadoraJanela extends JFrame {

    private JTextField display;
    private Calculadora calculadoraBackend;

    public CalculadoraJanela() {
        this.calculadoraBackend = new Calculadora();

        // Configurações básicas da Janela
        setTitle("Calculadora Java");
        setSize(350, 450); // Aumentei um pouco o tamanho para acomodar bem os botões
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 1. Criar e configurar o Display (Topo)
        display = new JTextField("0");
        display.setFont(new Font("Arial", Font.BOLD, 28));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBackground(Color.WHITE);
        display.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margem interna
        add(display, BorderLayout.NORTH);

        // 2. Criar o Painel para os Botões (Centro)
        // Uma calculadora padrão precisa de 4 linhas e 4 colunas para o básico
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(4, 4, 5, 5)); // 4x4 com espaçamento de 5 pixels

        // Array com os textos dos botões na ordem de exibição (da esquerda para a direita, de cima para baixo)
        String[] textosBotoes = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        // Loop para criar, estilizar e adicionar cada botão ao painel
        for (String texto : textosBotoes) {
            JButton botao = new JButton(texto);
            botao.setFont(new Font("Arial", Font.BOLD, 20));
            botao.setFocusable(false); // Remove aquela bordinha tracejada chata de foco

            // Adiciona o botão na grade
            painelBotoes.add(botao);
        }

        // Adiciona o painel de botões no centro da janela
        add(painelBotoes, BorderLayout.CENTER);
    }
}