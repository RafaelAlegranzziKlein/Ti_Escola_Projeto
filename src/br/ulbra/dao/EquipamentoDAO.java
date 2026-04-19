/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.dao;

/**
 *
 * @author Rafael Alegranzzi Klein
 */

import br.ulbra.model.Equipamento;
import java.util.List;

public interface EquipamentoDAO {

    void salvar(Equipamento equipamento);

    List<Equipamento> listar();

    Equipamento buscarPorId(int id_equipamento);

    void atualizar(Equipamento equipamento);

    void deletar(int id_equipamento);
}
