package view;

import javax.swing.*;

public class TelaPrincipal extends JDialog {
    private JPanel contentPane;
    private JButton minhaContaButton;
    private JButton produtosButton;
    private JButton clientesButton;
    private JButton buttonOK;

    public TelaPrincipal() {
        setContentPane(contentPane);
        setModal(true);
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(buttonOK);
    }
}
