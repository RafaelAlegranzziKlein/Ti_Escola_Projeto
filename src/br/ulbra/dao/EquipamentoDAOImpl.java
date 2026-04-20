package br.ulbra.dao;

/**
 *
 * @author rafae
 */
import br.ulbra.model.Equipamento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipamentoDAOImpl implements EquipamentoDAO {

    @Override
    public void salvar(Equipamento equipamento) {
        String sql = "INSERT INTO equipamentos (tag_patrimonio, sala) VALUES (?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, equipamento.getTag_patrimonio());
            stmt.setString(2, equipamento.getSala());

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Equipamento> listar() {
        String sql = "SELECT * FROM equipamentos";
        List<Equipamento> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Equipamento e = new Equipamento(
                        rs.getInt("id_equipamento"),
                        rs.getString("tag_patrimonio"),
                        rs.getString("sala")
                );
                lista.add(e);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return lista;

    }

    @Override
    public Equipamento buscarPorId(int id_equipamento) {
        String sql = "SELECT * FROM equipamentos WHERE id_equipamento = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id_equipamento);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Equipamento(
                        rs.getInt("id_equipamento"),
                        rs.getString("tag_patrimonio"),
                        rs.getString("sala")
                );
            }

        } catch (Exception c) {
            throw new RuntimeException(c);
        }

        return null;
    }

    @Override
    public void atualizar(Equipamento equipamentos) {
        String sql = "UPDATE equipamentos SET tag_patrimonio = ?, sala = ? WHERE id_equipamento = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, equipamentos.getTag_patrimonio());
            stmt.setString(2, equipamentos.getSala());
            stmt.setInt(3, equipamentos.getId_equipamento());

            stmt.executeUpdate();

        } catch (Exception c) {
            throw new RuntimeException(c);
        }
    }

    @Override
    public void deletar(int id_equipamento) {
        String sql = "DELETE FROM equipamentos WHERE id_equipamento = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_equipamento);
            stmt.executeUpdate();

        } catch (Exception c) {
            throw new RuntimeException(c);
        }
    }

    @Override
    public boolean existeTag(String tag) {
        String sql = "SELECT COUNT(*) FROM equipamentos WHERE tag_patrimonio = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tag);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return false;
    }
}
