package br.ulbra.model;

/**
 *
 * @author rafael
 */
public class Chamado {

    private long id;
    private int id_usuario;
    private int id_equipamento;
    private String problema_relatado;
    private String diagnostico_tecnico;
    private String prioridade;
    private String status;
    private String data_abertura;

    public Chamado() {
    }

    public Chamado(long id, int id_usuario, int id_equipamento, String problema_relatado, String diagnostico_tecnico, String prioridade, String status, String data_abertura) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.id_equipamento = id_equipamento;
        this.problema_relatado = problema_relatado;
        this.diagnostico_tecnico = diagnostico_tecnico;
        this.prioridade = prioridade;
        this.status = status;
        this.data_abertura = data_abertura;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_equipamento() {
        return id_equipamento;
    }

    public void setId_equipamento(int id_equipamento) {
        this.id_equipamento = id_equipamento;
    }

    public String getProblema_relatado() {
        return problema_relatado;
    }

    public void setProblema_relatado(String problema_relatado) {
        this.problema_relatado = problema_relatado;
    }

    public String getDiagnostico_tecnico() {
        return diagnostico_tecnico;
    }

    public void setDiagnostico_tecnico(String diagnostico_tecnico) {
        this.diagnostico_tecnico = diagnostico_tecnico;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getData_abertura() {
        return data_abertura;
    }

    public void setData_abertura(String data_abertura) {
        this.data_abertura = data_abertura;
    }

}
