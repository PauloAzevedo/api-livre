/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lira.apicep.dto;

import br.com.lira.apicep.modelo.Cidade;
import br.com.lira.apicep.modelo.Estado;


/**
 *
 * @author paulo
 */
public class CidadeDto {
    
    
    private Integer id;
    
    private String cidade;
    
    private String codigoIBGE;
    
    private EstadoDto estado;

    public CidadeDto(Cidade cidade) {
        this.id = cidade.getIdCidade();
        this.cidade = cidade.getCidade();
        this.codigoIBGE = cidade.getCodigoIBGE();
        this.estado = new EstadoDto(cidade.getEstado());
    }
    
    

    public Integer getId() {
        return id;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCodigoIBGE() {
        return codigoIBGE;
    }

    public EstadoDto getEstado() {
        return estado;
    }
    
    
    
    
}
