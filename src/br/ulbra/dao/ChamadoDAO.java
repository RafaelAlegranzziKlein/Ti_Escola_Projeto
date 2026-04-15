package br.ulbra.dao;

/**
 *
 * @author rafael
 */
import br.ulbra.model.Chamado;
import java.util.List;

public interface ChamadoDAO {

    void salvar(Chamado chamado_tecnico);

    List<Chamado> listar();

    Chamado buscarPorId(Long id);

    void atualizar(Chamado chamado_tecnico);

    void deletar(Long id);
}


