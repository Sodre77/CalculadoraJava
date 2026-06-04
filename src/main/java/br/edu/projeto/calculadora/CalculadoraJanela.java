package br.edu.projeto.calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraJanela extends JFrame {

    private JTextField display;
    private Calculadora calculadoraBackend;

    // Variáveis de controle de estado
    private String primeiroNumeroStr = "";
    private String segundoNumeroStr = "";
    private String operadorSelecionado = "";
    private boolean temResultadoNoDisplay = false; // Identifica se o que está na tela é o resultado da última conta

    public CalculadoraJanela() {
        this.calculadoraBackend = new Calculadora();

        setTitle("Calculadora Java");
        setSize(350, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

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

        CliqueNumeroOuvinte cliqueNumero = new CliqueNumeroOuvinte();
        CliqueOperacaoOuvinte cliqueOperacao = new CliqueOperacaoOuvinte();

        for (String texto : textosBotoes) {
            JButton botao = new JButton(texto);
            botao.setFont(new Font("Arial", Font.BOLD, 20));
            botao.setFocusable(false);

            if (texto.matches("[0-9]")) {
                botao.addActionListener(cliqueNumero);
            } else if (texto.equals("C")) {
                botao.addActionListener(e -> limparCalculadora());
            } else {
                botao.addActionListener(cliqueOperacao);
            }

            painelBotoes.add(botao);
        }

        add(painelBotoes, BorderLayout.CENTER);
    }

    private void limparCalculadora() {
        display.setText("0");
        primeiroNumeroStr = "";
        segundoNumeroStr = "";
        operadorSelecionado = "";
        temResultadoNoDisplay = false;
    }

    private class CliqueNumeroOuvinte implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton botaoClicado = (JButton) e.getSource();
            String numero = botaoClicado.getText();

            // Se o usuário começar a digitar logo após um resultado, limpamos tudo para começar nova conta
            if (temResultadoNoDisplay) {
                limparCalculadora();
            }

            // Se não escolheu o operador ainda, está digitando o primeiro número
            if (operadorSelecionado.isEmpty()) {
                primeiroNumeroStr += numero;
                display.setText(primeiroNumeroStr);
            } else {
                // Se já tem operador, está digitando o segundo número
                segundoNumeroStr += numero;
                // Exibe no formato: "Número1 Operador Número2"
                display.setText(primeiroNumeroStr + " " + operadorSelecionado + " " + segundoNumeroStr);
            }
        }
    }

    private class CliqueOperacaoOuvinte implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton botaoClicado = (JButton) e.getSource();
            String comando = botaoClicado.getText();

            if (comando.equals("=")) {
                // Só calcula se tivermos o primeiro número, o operador e o segundo número preenchidos
                if (primeiroNumeroStr.isEmpty() || operadorSelecionado.isEmpty() || segundoNumeroStr.isEmpty()) {
                    return;
                }

                double num1 = Double.parseDouble(primeiroNumeroStr);
                double num2 = Double.parseDouble(segundoNumeroStr);
                double resultado = 0;
                boolean erroDivisao = false;

                switch (operadorSelecionado) {
                    case "+":
                        resultado = calculadoraBackend.somar((int) num1, (int) num2);
                        break;
                    case "-":
                        resultado = calculadoraBackend.subtrair((int) num1, (int) num2);
                        break;
                    case "*":
                        resultado = calculadoraBackend.multiplicar((int) num1, (int) num2);
                        break;
                    case "/":
                        try {
                            resultado = calculadoraBackend.dividir(num1, num2);
                        } catch (ArithmeticException ex) {
                            display.setText("Erro: Divisão por 0");
                            erroDivisao = true;
                        }
                        break;
                }

                if (!erroDivisao) {
                    String resultadoFormatado;
                    if (resultado % 1 == 0) {
                        resultadoFormatado = String.valueOf((int) resultado);
                    } else {
                        resultadoFormatado = String.valueOf(resultado);
                    }

                    display.setText(resultadoFormatado);

                    // Prepara o estado caso o usuário queira usar o resultado para uma próxima operação contínua
                    primeiroNumeroStr = resultadoFormatado;
                } else {
                    primeiroNumeroStr = "";
                }

                // Reseta os estados secundários
                segundoNumeroStr = "";
                operadorSelecionado = "";
                temResultadoNoDisplay = true;

            } else {
                // Se o usuário clicou em um operador (+, -, *, /)

                // Se ele acabou de obter um resultado e clica em um operador, usamos esse resultado como primeiro número
                if (temResultadoNoDisplay && !primeiroNumeroStr.isEmpty()) {
                    temResultadoNoDisplay = false;
                }

                // Só permite colocar o operador se o primeiro número já tiver sido iniciado
                if (!primeiroNumeroStr.isEmpty() && segundoNumeroStr.isEmpty()) {
                    operadorSelecionado = comando;
                    display.setText(primeiroNumeroStr + " " + operadorSelecionado);
                }
            }
        }
    }
}