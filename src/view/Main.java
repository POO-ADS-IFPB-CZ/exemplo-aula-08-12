package view;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        //TODO: Criar uma aplicação para fazer o CRUD de usuários
        ImageIcon icon = new ImageIcon("imgs/usuario.png");
        String menu[] = {"Criar usuário", "Listar usuários",
        "Editar Usuário", "Excluir usuário"};
        int retorno = JOptionPane.showOptionDialog(null,
                "Escolha o que deseja fazer",
                "Minha aplicação",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                icon, menu, menu[0]);
        System.out.println(retorno);

    }

}
