package br.edu.projeto.calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraJanela extends JFrame {

    private JTextField display;
    private Calculadora calculadoraBackend;

    // VARIÁVEIS DE CONTROLE DE ESTADO
    private double primeiroNumero = 0;
    private String operadorSelecionado = "";
    private boolean iniciarNovoNumero = false; // Indica se o próximo clique numérico limpa a tela para o 2º valor

    public CalculadoraJanela() {
        this.calculadoraBackend = new Calculadora();

        setTitle("Calculadora Java");
        setSize(350, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 1. Criar e configurar o Display
        display = new JTextField("0");
        display.setFont(new Font("Arial", Font.BOLD, 28));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBackground(Color.WHITE);
        display.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(display, BorderLayout.NORTH);

        // 2. Criar o Painel para os Botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(4, 4, 5, 5));

        String[] textosBotoes = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        // Instanciando os ouvintes de eventos
        CliqueNumeroOuvinte cliqueNumero = new CliqueNumeroOuvinte();
        CliqueOperacaoOuvinte cliqueOperacao = new CliqueOperacaoOuvinte();

        for (String texto : textosBotoes) {
            JButton botao = new JButton(texto);
            botao.setFont(new Font("Arial", Font.BOLD, 20));
            botao.setFocusable(false);

            // Separação da lógica de cliques por tipo de botão
            if (texto.matches("[0-9]")) {
                botao.addActionListener(cliqueNumero);
            } else if (texto.equals("C")) {
                // Ação direta para o botão de limpar (Clear)
                botao.addActionListener(e -> limparCalculadora());
            } else {
                // Ouvinte para os operadores (+, -, *, /) e o igual (=)
                botao.addActionListener(cliqueOperacao);
            }

            painelBotoes.add(botao);
        }

        add(painelBotoes, BorderLayout.CENTER);
    }

    // Método auxiliar para resetar a calculadora (Botão C)
    private void limparCalculadora() {
        display.setText("0");
        primeiroNumero = 0;
        operadorSelecionado = "";
        iniciarNovoNumero = false;
    }

    // Classe interna para controlar o clique dos números (Modificada)
    private class CliqueNumeroOuvinte implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton botaoClicado = (JButton) e.getSource();
            String numero = botaoClicado.getText();

            // Se o usuário acabou de clicar em um operador, limpamos a tela para o novo número
            if (display.getText().equals("0") || iniciarNovoNumero) {
                display.setText(numero);
                iniciarNovoNumero = false; // Desmarca o sinalizador
            } else {
                display.setText(display.getText() + numero);
            }
        }
    }

    // Classe interna para tratar os operadores e o sinal de igual
    private class CliqueOperacaoOuvinte implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton botaoClicado = (JButton) e.getSource();
            String comando = botaoClicado.getText();

            if (comando.equals("=")) {
                // todo: Chamar o back-end e exibir o resultado final aqui no próximo passo
            } else {
                // Guarda o primeiro número digitado convertido para double
                primeiroNumero = Double.parseDouble(display.getText());
                operadorSelecionado = comando;
                iniciarNovoNumero = true; // Avisa que o próximo número digitado iniciará do zero
            }
        }
    }
}