package br.ulbra.dao;

/**
 *
 * @author rafael
 */
import br.ulbra.model.Chamado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChamadoDAOImpl implements ChamadoDAO {

    @Override
    public void salvar(Chamado chamado_tecnico) {
        String sql = "INSERT INTO chamado_tecnico (solicitante, sala , equipamento_tag , problema_relatado, "
                + "diagnostico_tecnico , prioridade , status, data_abertura) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

       try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {


            stmt.setString(1, chamado_tecnico.getSolicitante());
            stmt.setString(2, chamado_tecnico.getSala());
            stmt.setString(3, chamado_tecnico.getEquipamento_tag());
            stmt.setString(4, chamado_tecnico.getProblema_relatado());
            stmt.setString(5, chamado_tecnico.getDiagnostico_tecnico());
            stmt.setString(6, chamado_tecnico.getPrioridade());
            stmt.setString(7, chamado_tecnico.getStatus());
            stmt.setString(8, chamado_tecnico.getData_abertura());

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Chamado> listar() {
        String sql = "SELECT * FROM chamado_tecnico";
        List<Chamado> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Chamado c = new Chamado(
                        rs.getLong("id"),
                        rs.getString("solicitante"),
                        rs.getString("sala"),
                        rs.getString("equipamento_tag"),
                        rs.getString("problema_relatado"),
                        rs.getString("diagnostico_tecnico"),
                        rs.getString("prioridade"),
                        rs.getString("status"),
                        rs.getString("data_abertura")
                );
                lista.add(c);
            }

        } catch (Exception c) {
            throw new RuntimeException(c);
        }

        return lista;
    }

    @Override
    public Chamado buscarPorId(Long id) {
        String sql = "SELECT * FROM chamado_tecnico WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Chamado(
                        rs.getLong("id"),
                        rs.getString("solicitante"),
                        rs.getString("sala"),
                        rs.getString("equipamento_tag"),
                        rs.getString("problema_relatado"),
                        rs.getString("diagnostico_tecnico"),
                        rs.getString("prioridade"),
                        rs.getString("status"),
                        rs.getString("data_abertura")
                );
            }

        } catch (Exception c) {
            throw new RuntimeException(c);
        }

        return null;
    }

    @Override
    public void atualizar(Chamado chamado_tecnico) {
        String sql = "UPDATE chamado_tecnico SET solicitante = ?, sala = ?, equipamento_tag = ?, "
                + "problema_relatado = ?, diagnostico_tecnico = ?, prioridade = ?, status = ?, data_abertura = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, chamado_tecnico.getSolicitante());
            stmt.setString(2, chamado_tecnico.getSala());
            stmt.setString(3, chamado_tecnico.getEquipamento_tag());
            stmt.setString(4, chamado_tecnico.getProblema_relatado());
            stmt.setString(5, chamado_tecnico.getDiagnostico_tecnico());
            stmt.setString(6, chamado_tecnico.getPrioridade());
            stmt.setString(7, chamado_tecnico.getStatus());
            stmt.setString(8, chamado_tecnico.getData_abertura());
            stmt.setLong(9, chamado_tecnico.getId()); 

            stmt.executeUpdate();

        } catch (Exception c) {
            throw new RuntimeException(c);
        }
    }

    @Override
    public void deletar(Long id) {
        String sql = "DELETE FROM chamado_tecnico WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (Exception c) {
            throw new RuntimeException(c);
        }
    }
}
