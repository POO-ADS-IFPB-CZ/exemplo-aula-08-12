package view;

import javax.swing.*;

public class TelaCadastroUsuario extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField eMailTextField;
    private JTextField nomeTextField;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;

    public TelaCadastroUsuario() {
        setContentPane(contentPane);
        setModal(true);
        setSize(400,400);
        setTitle("Tela Cadastro Usuário");
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(buttonOK);
    }
}
