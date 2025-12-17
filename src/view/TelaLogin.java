package view;

import model.Usuario;
import service.UsuarioService;

import javax.swing.*;
import java.io.IOException;

public class TelaLogin extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField campoEmail;
    private JPasswordField campoSenha;
    private UsuarioService usuarioService;

    public TelaLogin() {

        try {
            usuarioService = new UsuarioService();
        } catch (IOException e) {
            exibirMensagemErro("Falha ao conectar com arquivo");
        }

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
        buttonCancel.addActionListener(e -> {
            TelaCadastroUsuario telaCadastroUsuario =
                    new TelaCadastroUsuario();
            telaCadastroUsuario.setVisible(true);
        });
        buttonOK.addActionListener(e -> {

            String email = campoEmail.getText();
            String senha = campoSenha.getText();

            try {
                Usuario usuario = usuarioService.read().stream().filter(
                        u -> u.getEmail().equals(email))
                        .findFirst()
                        .orElse(null);
                if(usuario == null){
                    exibirMensagemErro("Usuário não encontrado");
                }
                if(!usuario.getSenha().equals(senha)){
                    exibirMensagemErro("Senha incorreta");
                }
            } catch (Exception ex) {
                exibirMensagemErro(ex.getMessage());
            }


            TelaPrincipal telaPrincipal = new TelaPrincipal();
            telaPrincipal.pack();
            telaPrincipal.setLocationRelativeTo(null);
            telaPrincipal.setVisible(true);
        });
    }

    private void exibirMensagemErro(String erro) {
        JOptionPane.showMessageDialog(null,
                erro,
                "Mensagem de erro",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        TelaLogin dialog = new TelaLogin();
//        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
