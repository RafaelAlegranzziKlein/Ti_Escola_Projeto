package br.ulbra.service;

/**
 * @author rafae
 */
import br.ulbra.dao.ChamadoDAO;
import br.ulbra.model.Chamado;
import java.text.SimpleDateFormat;
import java.util.List;

public class ChamadoService {

    private ChamadoDAO dao;

    public ChamadoService(ChamadoDAO dao) {
        this.dao = dao;
    }

    public void cadastrar(Chamado chamado_tecnico) {

        if (chamado_tecnico.getSolicitante() == null || chamado_tecnico.getSolicitante().isEmpty()) {
            throw new RuntimeException("Solicitante é obrigatorio");
        }

        if (chamado_tecnico.getProblema_relatado() == null || chamado_tecnico.getProblema_relatado().isEmpty()) {
            throw new RuntimeException("Tenque exixtir um problema relatado");
        }

        if (chamado_tecnico.getData_abertura() == null || chamado_tecnico.getData_abertura().isEmpty()) {
            throw new RuntimeException("Data é obrigatória");
        }
        String data = chamado_tecnico.getData_abertura();

//Valida formato exato dd/MM/yyyy (bloqueia ///, letras, etc)
        String regexData = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";

        if (!data.matches(regexData)) {
            throw new RuntimeException("Data inválida! Use o formato dd/MM/yyyy corretamente.");
        }
// Valida se a data realmente existe (ex: 31/02 não pode)
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false); // bloqueia datas impossíveis
            sdf.parse(data);
        } catch (Exception e) {
            throw new RuntimeException("Data inválida no calendário!");
        }

        dao.salvar(chamado_tecnico);
    }

    public List<Chamado> listar() {
        return dao.listar();
    }

    public void atualizar(Chamado chamado_tecnico) {

        if (chamado_tecnico.getId() == null) {
            throw new RuntimeException("ID obrigatório para atualizar");
        }

        if (chamado_tecnico.getSolicitante() == null || chamado_tecnico.getSolicitante().isEmpty()) {
            throw new RuntimeException("Solicitante é obrigatório");
        }

        if (chamado_tecnico.getProblema_relatado() == null || chamado_tecnico.getProblema_relatado().isEmpty()) {
            throw new RuntimeException("Problema relatado é obrigatório");
        }

        if (chamado_tecnico.getData_abertura() == null || chamado_tecnico.getData_abertura().isEmpty()) {
            throw new RuntimeException("Data é obrigatória");
        }

        dao.atualizar(chamado_tecnico);
    }

    public void deletar(Long id) {
        dao.deletar(id);
    }

    public Chamado buscar(Long id) {
        return dao.buscarPorId(id);
    }
}
