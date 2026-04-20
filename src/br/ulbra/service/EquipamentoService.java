/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.service;

/**
 *
 * @author aluno.saolucas
 */


import br.ulbra.dao.EquipamentoDAO;
import br.ulbra.model.Equipamento;
import java.text.SimpleDateFormat;
import java.util.List;

public class EquipamentoService {
    
     private EquipamentoDAO dao;

    public EquipamentoService (EquipamentoDAO dao) {
        this.dao = dao;
    }

    public void cadastrar(Equipamento equipamento) {
        if(equipamento.getTag_patrimonio() == equipamento.getTag_patrimonio()){
            throw new RuntimeException("Não pode ter equipamento tag repetio"); 
        }
         if (equipamento.getSala()== null || equipamento.getSala().isEmpty()) {
            throw new RuntimeException("Sala é obrigatorio");
        }

        if (equipamento.getTag_patrimonio()== null || equipamento.getTag_patrimonio().isEmpty()) {
            throw new RuntimeException("Equipamento tag é obrigatorio");
        }
        dao.salvar(equipamento);
    }
    
    public List<Equipamento> listar() {
        return dao.listar();
    }

    public void atualizar(Equipamento equipamento) {

        if (equipamento.getId_equipamento()<= 0 ) {
            throw new RuntimeException("ID obrigatório para atualizar");
        }

        if (equipamento.getTag_patrimonio()== null || equipamento.getTag_patrimonio().isEmpty()) {
            throw new RuntimeException("Tag dde patrimonio é obrigatório");
        }
          if (equipamento.getSala()== null || !equipamento.getSala().isEmpty()) {
            throw new RuntimeException("Email é obrigatorio !!!");
        }

        dao.atualizar(equipamento);
    }
 public void deletar(int id_equipamento) {
        dao.deletar(id_equipamento);
    }

    public Equipamento buscar(int id_equipamento) {
        return dao.buscarPorId(id_equipamento);
    }
    
    
}
