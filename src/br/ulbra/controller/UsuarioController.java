package br.ulbra.controller;

import br.ulbra.dao.UsuarioDAOImpl;
import br.ulbra.model.Usuario;
import br.ulbra.service.UsuarioService;
import java.util.List;
/**
 * @author Rafael Alegranzzi Klein
 */


public class UsuarioController {

    private UsuarioService service;

    public UsuarioController() {
        this.service = new UsuarioService(new UsuarioDAOImpl());
    }

    public String cadastrar(String nome, String email,String senha) {
        try {
            Usuario usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setSenha(senha);
          

            service.cadastrar(usuario);
            return "Usuario cadastrado com sucesso";

        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    public List<Usuario> listar() {
        return service.listar();
    }

    public String atualizar(int id_usuario ,String nome , String email, String senha ) {
        try {

            Usuario usuario = new Usuario();
            usuario.setId_usuario(id_usuario);
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setSenha(senha);
 

            service.atualizar(usuario);

            return "Atualizado com sucesso";

        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    public String deletar(int id_usuario ) {
        try {
            service.deletar(id_usuario );
            return "Deletado com sucesso";
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

}
