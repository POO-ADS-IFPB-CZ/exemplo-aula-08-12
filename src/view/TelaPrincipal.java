package view;

import javax.swing.*;

public class TelaPrincipal extends JFrame {
    private JPanel contentPane;
    private JButton minhaContaButton;
    private JButton produtosButton;
    private JButton clientesButton;
    private JButton buttonOK;

    public TelaPrincipal() {
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Minha aplicação");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
