package br.com.lira.apicep.dto;

import br.com.lira.apicep.modelo.Cep;
import br.com.lira.apicep.modelo.Cidade;

/**
 *
 * @author paulo
 */
public class DetalhesDoCepDto {
    
    private Integer id;
    
    private String codigoIBGE;
    
    private String cep;
    
    private String logradouro;
    
    private String bairro;
    
    private String complemento;
    
    private CidadeDto cidadeDto;

    public DetalhesDoCepDto(Cep cep, Cidade cidade) {
        this.id = cep.getId();
        this.codigoIBGE = cep.getCodigoIBGE();
        this.cep = cep.getCep();
        this.logradouro = cep.getLogradouro();
        this.bairro = cep.getBairro();
        this.complemento = cep.getComplemento();
        this.cidadeDto = new CidadeDto(cidade);
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

    public CidadeDto getCidadeDto() {
        return cidadeDto;
    }
    
    
            
}
