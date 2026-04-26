package br.ulbra.controller;

/**
 *
 * @author rafae
 */
import br.ulbra.dao.ChamadoDAOImpl;
import br.ulbra.model.Chamado;
import br.ulbra.service.ChamadoService;

import java.util.List;

public class ChamadoController {

    private ChamadoService service;

    public ChamadoController() {
        this.service = new ChamadoService(new ChamadoDAOImpl());
    }

    public String cadastrar(int idUsuario, int idEquipamento,
            String problema, String diagnostico,
            String prioridade, String status, String data_abertura) {

        try {
            Chamado c = new Chamado();

            c.setId_usuario(idUsuario);
            c.setId_equipamento(idEquipamento);
            c.setProblema_relatado(problema);
            c.setDiagnostico_tecnico(diagnostico);
            c.setPrioridade(prioridade);
            c.setStatus(status);
            c.setData_abertura(data_abertura);

            service.cadastrar(c);

            return "Chamado criado com sucesso";

        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    public List<Chamado> listar() {
        return service.listar();
    }

    public String atualizar(Long id, int idUsuario, int idEquipamento,
            String problema_relatado,
            String diagnostico_tecnico,
            String prioridade,
            String status,
            String data_abertura) {

        try {
            Chamado c = new Chamado();
            c.setId(id);
            c.setId_usuario(idUsuario);
            c.setId_equipamento(idEquipamento);
            c.setProblema_relatado(problema_relatado);
            c.setDiagnostico_tecnico(diagnostico_tecnico);
            c.setPrioridade(prioridade);
            c.setStatus(status);
            c.setData_abertura(data_abertura);

            service.atualizar(c);

            return "Atualizado com sucesso";

        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    public String deletar(Long id) {
        try {
            service.deletar(id);
            return "Deletado com sucesso";
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }
}
