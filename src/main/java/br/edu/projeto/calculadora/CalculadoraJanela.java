package br.edu.projeto.calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraJanela extends JFrame {

    private JTextField display;
    private Calculadora calculadoraBackend;

    public CalculadoraJanela() {
        this.calculadoraBackend = new Calculadora();

        // Configurações básicas da Janela
        setTitle("Calculadora Java");
        setSize(350, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 1. Criar e configurar o Display (Topo)
        display = new JTextField("0");
        display.setFont(new Font("Arial", Font.BOLD, 28));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBackground(Color.WHITE);
        display.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(display, BorderLayout.NORTH);

        // 2. Criar o Painel para os Botões (Centro)
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(4, 4, 5, 5));

        String[] textosBotoes = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        // Instancia o nosso ouvinte de cliques para os números
        CliqueNumeroOuvinte cliqueNumero = new CliqueNumeroOuvinte();

        for (String texto : textosBotoes) {
            JButton botao = new JButton(texto);
            botao.setFont(new Font("Arial", Font.BOLD, 20));
            botao.setFocusable(false);

            // Se o botão for um número de 0 a 9, associamos a ação de clique nele
            if (texto.matches("[0-9]")) {
                botao.addActionListener(cliqueNumero);
            }

            painelBotoes.add(botao);
        }

        add(painelBotoes, BorderLayout.CENTER);
    }

    // Classe interna (Inner Class) para controlar o clique dos números
    private class CliqueNumeroOuvinte implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Descobre qual botão disparou o evento
            JButton botaoClicado = (JButton) e.getSource();
            String numero = botaoClicado.getText();

            // Se o display só tiver "0", nós substituímos. Se não, concatenamos.
            if (display.getText().equals("0")) {
                display.setText(numero);
            } else {
                display.setText(display.getText() + numero);
            }
        }
    }
}