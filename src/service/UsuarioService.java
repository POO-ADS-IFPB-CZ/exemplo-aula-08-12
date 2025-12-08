package service;

import dao.GenericDao;
import exception.EmailDuplicadoException;
import exception.SenhaInvalidaException;
import model.Usuario;

import java.io.IOException;

public class UsuarioService {

    private GenericDao<Usuario> usuarioDao;

    public UsuarioService() throws IOException {
        usuarioDao = new GenericDao<>("usuarios.txt");
    }

    public boolean create(Usuario usuario) throws
            SenhaInvalidaException, EmailDuplicadoException,
            IOException, ClassNotFoundException {
        if (usuario.getSenha().length() < 8) {
            throw new SenhaInvalidaException(
                    "A senha precisa ter pelo menos 8 caracteres");
        }
        if (usuarioDao.getObjetos()
                .stream()
                .filter(o -> o.getEmail().equals(usuario.getEmail()))
                .count() > 0) {
            throw new EmailDuplicadoException(
                    "Já existe outro usuário com esse e-mail"
            );
        }
        return usuarioDao.salvar(usuario);
    }

}
