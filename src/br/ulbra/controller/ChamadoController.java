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

    public String cadastrar(String solicitante, String sala, String equipamento_tag, String problema_relatado,
            String diagnostico_tecnico, String prioridade, String status, String data_abertura) {
        try {
            Chamado chamado_tecnico = new Chamado();
            chamado_tecnico.setSolicitante(solicitante);
            chamado_tecnico.setSala(sala);
            chamado_tecnico.setEquipamento_tag(equipamento_tag);
            chamado_tecnico.setProblema_relatado(problema_relatado);
            chamado_tecnico.setDiagnostico_tecnico(diagnostico_tecnico);
            chamado_tecnico.setPrioridade(prioridade);
            chamado_tecnico.setStatus(status);
            chamado_tecnico.setData_abertura(data_abertura);

            service.cadastrar(chamado_tecnico);
            return "Chamado tecnico feito com sucesso";

        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    public List<Chamado> listar() {
        return service.listar();
    }

    public String atualizar(Long id, String solicitante, String sala, String equipamento_tag, String problema_relatado,
            String diagnostico_tecnico, String prioridade, String status, String data_abertura) {
        try {

            Chamado chamado_tecnico = new Chamado();
            chamado_tecnico.setId(id);
            chamado_tecnico.setSolicitante(solicitante);
            chamado_tecnico.setSala(sala);
            chamado_tecnico.setEquipamento_tag(equipamento_tag);
            chamado_tecnico.setProblema_relatado(problema_relatado);
            chamado_tecnico.setDiagnostico_tecnico(diagnostico_tecnico);
            chamado_tecnico.setPrioridade(prioridade);
            chamado_tecnico.setStatus(status);
            chamado_tecnico.setData_abertura(data_abertura);

            service.atualizar(chamado_tecnico);

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
