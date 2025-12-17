package view;

import service.UsuarioService;

import javax.swing.*;
import java.io.IOException;

public class TelaCadastroUsuario extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField campoEmail;
    private JTextField campoNome;
    private JPasswordField campoSenha1;
    private JPasswordField campoSenha2;
    private UsuarioService usuarioService;

    public TelaCadastroUsuario() {

        try {
            usuarioService = new UsuarioService();
        } catch (IOException e) {
            //TODO: Estudar sobre Log
            exibirMensagemErro("Falha ao abrir arquivo");
        }

        setContentPane(contentPane);
        setModal(true);
        setSize(400,400);
        setTitle("Tela Cadastro Usuário");
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(buttonOK);
        buttonCancel.addActionListener(e -> dispose());
        buttonOK.addActionListener(e->{
            if(validarFormulario()){

            }
        });
    }

    private boolean validarFormulario() {
        String email = campoEmail.getText();
        String nome = campoNome.getText();
        //TODO: Ajustar depois para usar char[] (getPassword())
        String senha = campoSenha1.getText();
        String confirmar = campoSenha2.getText();

        if(!email.contains("@") || email.isEmpty()){
            exibirMensagemErro("E-mail inválido");
            return false;
        }
        if(senha.isEmpty()){
            exibirMensagemErro("Informe sua senha");
            return false;
        }
        if(!senha.equals(confirmar)){
            exibirMensagemErro("As senhas precisam ser iguais");
            return false;
        }
        return true;
    }

    private void exibirMensagemErro(String erro) {
        JOptionPane.showMessageDialog(null,
                erro,
                "Mensagem de erro",
                JOptionPane.ERROR_MESSAGE);
    }
}
