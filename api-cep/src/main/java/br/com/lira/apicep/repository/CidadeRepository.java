/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lira.apicep.repository;



import br.com.lira.apicep.modelo.Cidade;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author paulo
 */
public interface CidadeRepository extends JpaRepository<Cidade, Long>{
    
    
    public Optional<Cidade> findByCodigoIBGE(String codigoIBGE);
}
