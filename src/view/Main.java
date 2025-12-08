package view;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //System.out.println("Hello world!");
        //Ao invés disso, utilizar
        JOptionPane.showMessageDialog(null,
                "Hello World");
//        Scanner scanner = new Scanner(System.in);
        //Ao invés disso, utilizar
        String nome = JOptionPane.showInputDialog(null,
                "Informe seu nome");
    }

}
