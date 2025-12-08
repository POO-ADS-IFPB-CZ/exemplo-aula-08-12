package service;

import dao.GenericDao;
import exception.EmailDuplicadoException;
import exception.SenhaInvalidaException;
import model.Usuario;

import java.io.IOException;
import java.util.List;

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

    public List<Usuario> read() throws IOException,
            ClassNotFoundException {
        return usuarioDao.getObjetos().stream().toList();
    }

    public boolean update(Usuario usuario) throws
            SenhaInvalidaException, IOException,
            ClassNotFoundException {
        //TODO: Refatorar para evitar se repetir... DRY
        if (usuario.getSenha().length() < 8) {
            throw new SenhaInvalidaException(
                    "A senha precisa ter pelo menos 8 caracteres");
        }
        return usuarioDao.atualizar(usuario);
    }

    public boolean delete(Usuario usuario) throws IOException,
            ClassNotFoundException {
        return usuarioDao.deletar(usuario);
    }

}
