/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.controller;

/**
 *
 * @author rafae
 */

import br.ulbra.dao.EquipamentoDAO;
import br.ulbra.dao.EquipamentoDAOImpl;
import br.ulbra.model.Equipamento;
import br.ulbra.service.EquipamentoService;
import java.util.List;

public class EquipamentoController {
      private EquipamentoService service;

    public EquipamentoController() {
        this.service = new EquipamentoService(new EquipamentoDAOImpl());
    }

    public String cadastrar(String tag_patrimonio, String sala) {
        try {
            Equipamento equipamento = new Equipamento();
            equipamento.setTag_patrimonio(tag_patrimonio);
            equipamento.setSala(sala);
            
          

            service.cadastrar(equipamento);
            return "Equipamento cadastrado com sucesso";

        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    public List<Equipamento> listar() {
        return service.listar();
    }

    public String atualizar(int id_equipamento ,String tag_patrimonio, String sala ) {
        try {

            Equipamento equipamento = new Equipamento();
            equipamento.setId_equipamento(id_equipamento);
            equipamento.setTag_patrimonio(tag_patrimonio);
            equipamento.setSala(sala);
 

            service.atualizar(equipamento);

            return "Atualizado com sucesso";

        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    public String deletar(int id_equipamento ) {
        try {
            service.deletar(id_equipamento );
            return "Deletado com sucesso";
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

}


