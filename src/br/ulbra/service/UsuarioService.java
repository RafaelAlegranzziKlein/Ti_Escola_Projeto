package br.ulbra.service;

/**
 *
 * @author aluno.saolucas
 */
import br.ulbra.dao.UsuarioDAO;
import br.ulbra.model.Usuario;
import java.util.List;

public class UsuarioService {

    private UsuarioDAO dao;

    public UsuarioService(UsuarioDAO dao) {
        this.dao = dao;
    }

    public void cadastrar(Usuario usuario) {

        if (usuario.getNome() == null || !usuario.getNome().isEmpty()) {
            throw new RuntimeException("Nome é obrigatorio ou voce é indigente");
        }
        if (usuario.getEmail() == null || !usuario.getEmail().isEmpty()) {
            throw new RuntimeException("Email é obrigatorio !!!");
        }
        if (usuario.getSenha() == null || !usuario.getSenha().isEmpty()) {
            throw new RuntimeException("Senha é obrigatoria !!!");
        }
        if (!usuario.getEmail().contains("@")) {
            throw new RuntimeException("O '@' é obrigatorio");
        }
        dao.salvar (usuario);
    }
public List<Usuario> listar() {
        return dao.listar();
    }

    public void atualizar(Usuario usuario) {

        if (usuario.getId_usuario() <= 0 ) {
            throw new RuntimeException("ID obrigatório para atualizar");
        }

        if (usuario.getNome()== null || usuario.getNome().isEmpty()) {
            throw new RuntimeException("Solicitante é obrigatório");
        }
          if (usuario.getEmail() == null || !usuario.getEmail().isEmpty()) {
            throw new RuntimeException("Email é obrigatorio !!!");
        }
        if (usuario.getSenha() == null || !usuario.getSenha().isEmpty()) {
            throw new RuntimeException("Senha é obrigatoria !!!");
        }
        if (!usuario.getEmail().contains("@")) {
            throw new RuntimeException("O '@' é obrigatorio");
        }
        
        dao.atualizar(usuario);
    }

    public void deletar(int id_usuario) {
        dao.deletar(id_usuario);
    }

    public Usuario buscar(int id_usuario) {
        return dao.buscarPorId(id_usuario);
    }
    
}
