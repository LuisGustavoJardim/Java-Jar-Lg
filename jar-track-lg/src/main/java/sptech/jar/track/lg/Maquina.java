package sptech.jar.track.lg;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class Maquina {
    private Integer idMaquina;
    private String hostnameMaquina;
    private Integer status;
    private String nomeModeloCpu;
    private Double clockCpu;
    private String nomeModeloRam;
    private Double capacidadeTotalRam;
    private String nomeModeloDisco;
    private Double capacidadeTotalDisco;
    private Double leituraDisco;
    private Double escritaDisco;
    private Integer fkEmpresa;
    


    public Maquina(Integer idMaquina, String hostnameMaquina, Integer status, String nomeModeloCpu, Double clockCpu, String nomeModeloRam, Double capacidadeTotalRam, String nomeModeloDisco, Double capacidadeTotalDisco, Double leituraDisco, Double escritaDisco, Integer fkEmpresa) {
        this.idMaquina = idMaquina;
        this.hostnameMaquina = hostnameMaquina;
        this.status = status;
        this.nomeModeloCpu = nomeModeloCpu;
        this.clockCpu = clockCpu;
        this.nomeModeloRam = nomeModeloRam;
        this.capacidadeTotalRam = capacidadeTotalRam;
        this.nomeModeloDisco = nomeModeloDisco;
        this.capacidadeTotalDisco = capacidadeTotalDisco;
        this.leituraDisco = leituraDisco;
        this.escritaDisco = escritaDisco;
        this.fkEmpresa = fkEmpresa;
        
    }

    public Maquina() {
    }

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getHostnameMaquina() {
        return hostnameMaquina;
    }

    public void setHostnameMaquina(String hostnameMaquina) {
        this.hostnameMaquina = hostnameMaquina;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNomeModeloCpu() {
        return nomeModeloCpu;
    }

    public void setNomeModeloCpu(String nomeModeloCpu) {
        this.nomeModeloCpu = nomeModeloCpu;
    }

    public Double getClockCpu() {
        return clockCpu;
    }

    public void setClockCpu(Double clockCpu) {
        this.clockCpu = clockCpu;
    }

    public String getNomeModeloRam() {
        return nomeModeloRam;
    }

    public void setNomeModeloRam(String nomeModeloRam) {
        this.nomeModeloRam = nomeModeloRam;
    }

    public Double getCapacidadeTotalRam() {
        return capacidadeTotalRam;
    }

    public void setCapacidadeTotalRam(Double capacidadeTotalRam) {
        this.capacidadeTotalRam = capacidadeTotalRam;
    }

    public String getNomeModeloDisco() {
        return nomeModeloDisco;
    }

    public void setNomeModeloDisco(String nomeModeloDisco) {
        this.nomeModeloDisco = nomeModeloDisco;
    }

    public Double getCapacidadeTotalDisco() {
        return capacidadeTotalDisco;
    }

    public void setCapacidadeTotalDisco(Double capacidadeTotalDisco) {
        this.capacidadeTotalDisco = capacidadeTotalDisco;
    }

    public Double getLeituraDisco() {
        return leituraDisco;
    }

    public void setLeituraDisco(Double leituraDisco) {
        this.leituraDisco = leituraDisco;
    }

    public Double getEscritaDisco() {
        return escritaDisco;
    }

    public void setEscritaDisco(Double escritaDisco) {
        this.escritaDisco = escritaDisco;
    }


    public Integer getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Integer fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

    

    @Override
    public String toString() {
        return "Maquina{" +
                "idMaquina=" + idMaquina +
                ", hostnameMaquina='" + hostnameMaquina + '\'' +
                ", status=" + status +
                ", nomeModeloCpu='" + nomeModeloCpu + '\'' +
                ", clockCpu=" + clockCpu +
                ", nomeModeloRam='" + nomeModeloRam + '\'' +
                ", capacidadeTotalRam=" + capacidadeTotalRam +
                ", nomeModeloDisco='" + nomeModeloDisco + '\'' +
                ", capacidadeTotalDisco=" + capacidadeTotalDisco +
                ", leituraDisco=" + leituraDisco +
                ", escritaDisco=" + escritaDisco +
                ", fkEmpresa=" + fkEmpresa +
                '}';
    }
}
