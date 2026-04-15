package br.ulbra.model;




/**
 *
 * @author rafael
 */

public class Chamado {
    private Long id; 
    private String solicitante;
    private String sala;
    private String equipamento_tag;
    private String problema_relatado;
    private String diagnostico_tecnico;
    private String prioridade;
    private String status;
    private String data_abertura;

    public Chamado() {
    }

    public Chamado(Long id, String solicitante, String sala, String equipamento_tag, String problema_relatado, String diagnostico_tecnico, String prioridade, String status, String data_abertura) {
        this.id = id;
        this.solicitante = solicitante;
        this.sala = sala;
        this.equipamento_tag = equipamento_tag;
        this.problema_relatado = problema_relatado;
        this.diagnostico_tecnico = diagnostico_tecnico;
        this.prioridade = prioridade;
        this.status = status;
        this.data_abertura = data_abertura;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public void setEquipamento_tag(String equipamento_tag) {
        this.equipamento_tag = equipamento_tag;
    }

    public void setProblema_relatado(String problema_relatado) {
        this.problema_relatado = problema_relatado;
    }

    public void setDiagnostico_tecnico(String diagnostico_tecnico) {
        this.diagnostico_tecnico = diagnostico_tecnico;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setData_abertura(String data_abertura) {
        this.data_abertura = data_abertura;
    }

    public Long getId() {
        return id;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public String getSala() {
        return sala;
    }

    public String getEquipamento_tag() {
        return equipamento_tag;
    }

    public String getProblema_relatado() {
        return problema_relatado;
    }

    public String getDiagnostico_tecnico() {
        return diagnostico_tecnico;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public String getStatus() {
        return status;
    }

    public String getData_abertura() {
        return data_abertura;
    }
    
    
}
