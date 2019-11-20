/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lira.apicep.dto;

import br.com.lira.apicep.modelo.Cep;
import org.springframework.data.domain.Page;

/**
 *
 * @author paulo
 */
public class CepDto {
    
    private Integer id;
    
    private String codigoIBGE;
    
    private String cep;
    
    private String logradouro;
    
    private String bairro;
    
    private String complemento;

    public CepDto(Cep cep) {
        this.id = cep.getId();
        this.codigoIBGE = cep.getCodigoIBGE();
        this.cep = cep.getCep();
        this.logradouro = cep.getLogradouro();
        this.bairro = cep.getBairro();
        this.complemento = cep.getComplemento();
    }
    
    

    public Integer getId() {
        return id;
    }

    public String getCodigoIBGE() {
        return codigoIBGE;
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getComplemento() {
        return complemento;
    }
    
    public static Page<CepDto> converter(Page<Cep> ceps) {
        return ceps.map(CepDto::new);
    }
    
}
