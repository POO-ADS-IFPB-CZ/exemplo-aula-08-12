package view;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        ImageIcon icon = new ImageIcon("imgs/error.png");
        JOptionPane.showMessageDialog(null,
                "Hello World", "Mudando o título",
                JOptionPane.ERROR_MESSAGE,
                icon);

    }

}
