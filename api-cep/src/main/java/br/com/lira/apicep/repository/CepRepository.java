package br.com.lira.apicep.repository;

import br.com.lira.apicep.modelo.Cep;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author paulo
 */

public interface CepRepository extends JpaRepository<Cep, Long> {

    public Page<Cep> findByLogradouro(String logradouro, Pageable paginacao);

//    @Query("SELECT t FROM Cep t WHERE t.logradouro LIKE  :logradouro ")
//    public Page<Cep> carregarCepPorLogradouro(@Param("logradouro") String logradouro, Pageable paginacao);
    
    public Page<Cep> findByLogradouroContaining(String logradouro, Pageable paginacao);

    public Optional<Cep> findByCep(String cep);
}
