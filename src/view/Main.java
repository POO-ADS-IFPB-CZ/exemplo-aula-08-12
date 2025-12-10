package view;

import exception.EmailDuplicadoException;
import exception.NomeInvalidoException;
import exception.SenhaInvalidaException;
import model.Usuario;
import service.UsuarioService;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        UsuarioService usuarioService = null;
        try {
            usuarioService = new UsuarioService();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            usuarioService.create(new Usuario("joao@gmail.com",
                    "João", "123456"));
        } catch (SenhaInvalidaException e) {
            System.out.println(e.getMessage());
        } catch (EmailDuplicadoException e) {

        } catch (IOException e) {

        } catch (ClassNotFoundException e) {

        } catch (NomeInvalidoException e) {

        }

    }

}
