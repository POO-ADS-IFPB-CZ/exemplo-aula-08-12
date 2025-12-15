package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLogin extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField eMailTextField;
    private JPasswordField passwordField1;

    public TelaLogin() {
        setContentPane(contentPane);
        setModal(true);
        setTitle("Tela de Login");
        //Sempre no topo
//        setAlwaysOnTop(true);
        //Alterando o tamanho da tela
        setSize(400,200);
        //Abrir no centro da tela
        setLocationRelativeTo(null);
        //Alterando o ícone da tela
        ImageIcon icon = new ImageIcon("src/imgs/cadeado.png");
        setIconImage(icon.getImage());
        getRootPane().setDefaultButton(buttonOK);
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastroUsuario telaCadastroUsuario =
                        new TelaCadastroUsuario();
                telaCadastroUsuario.setVisible(true);
            }
        });
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaPrincipal telaPrincipal = new TelaPrincipal();
                telaPrincipal.pack();
                telaPrincipal.setLocationRelativeTo(null);
                telaPrincipal.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        TelaLogin dialog = new TelaLogin();
//        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
