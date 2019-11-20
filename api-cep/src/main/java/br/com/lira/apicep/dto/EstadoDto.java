package br.com.lira.apicep.dto;

import br.com.lira.apicep.modelo.Estado;

/**
 *
 * @author paulo
 */
public class EstadoDto {
    
    private Integer id;
    
    private String estado;
    
    private String sigla;
    private String cUF;

    public EstadoDto(Estado estado) {
        this.id = estado.getId();
        this.estado = estado.getEstado();
        this.sigla = estado.getSigla();      
        this.cUF = estado.getcUF();
    }  
    
    public Integer getId() {
        return id;
    }

    public String getEstado() {
        return estado;
    }

    public String getSigla() {
        return sigla;
    }

    public String getcUF() {
        return cUF;
    }
    
    
       
    
}
