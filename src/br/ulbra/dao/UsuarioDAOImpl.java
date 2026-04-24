package br.ulbra.dao;

/**
 *
 * @author Rafael Alegranzzi klein
 */
import br.ulbra.model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;


public class UsuarioDAOImpl implements UsuarioDAO {

    
    public List<Usuario> listarTodos() {
        String sql = "Select id_usuario  ,nome From usuarios ORDER BY nome";
        List<Usuario> lista = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setNome(rs.getString("nome"));
                lista.add(u);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
    
    @Override
    public void salvar(Usuario usuario) {
              String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());

            // CRIPTOGRAFIA AQUI: 
            // O gensalt() gera o tempero aleatório e o hashpw gera a senha segura
            String senhaCriptografada = BCrypt.hashpw(usuario.getSenha(), BCrypt.gensalt());
            stmt.setString(3, senhaCriptografada);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com segurança!");

        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar: " + e.getMessage());
        }
    }
    
      /**
     * Método para validação de Login
     */
    public Usuario logar(String email, String senhaDigitada) {
        // Buscamos apenas pelo e-mail, pois não podemos comparar o hash no SQL
        String sql = "SELECT * FROM usuarios WHERE email = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String senhaBanco = rs.getString("senha");

                    // COMPARAÇÃO SEGURA:
                    // O BCrypt verifica se a senha digitada bate com o hash salvo
                    if (BCrypt.checkpw(senhaDigitada, senhaBanco)) {
                        Usuario u = new Usuario();
                        u.setId_usuario(rs.getInt("id_usuario"));
                        u.setNome(rs.getString("nome"));
                        u.setEmail(rs.getString("email"));
                        return u;
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro no login: " + e.getMessage());
        }
        return null; // Login falhou
    }


    @Override
    public List<Usuario> listar() {
        String sql = "SELECT * FROM usuarios";
        List<Usuario> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Usuario u = new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha")
                );
                lista.add(u);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return lista;

    }

    @Override
    public Usuario buscarPorId(int id_usuario) {
        String sql = "SELECT * FROM usuarios WHERE id_usuario = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id_usuario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha")
                );
            }

        } catch (Exception c) {
            throw new RuntimeException(c);
        }

        return null;
    }

    @Override
    public void atualizar(Usuario usuario) {
        String sql = "UPDATE usuarios SET nome = ?, email = ?, senha = ? WHERE id_usuario = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setInt(4, usuario.getId_usuario());

            stmt.executeUpdate();

        } catch (Exception c) {
            throw new RuntimeException(c);
        }
    }

    @Override
    public void deletar(int id_usuario) {
        String sql = "DELETE FROM usuarios WHERE id_usuario = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_usuario);
            stmt.executeUpdate();

        } catch (Exception c) {
            throw new RuntimeException(c);
        }
    }



}