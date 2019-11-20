package br.com.lira.apicep.controller;

import br.com.lira.apicep.dto.CepDto;
import br.com.lira.apicep.dto.DetalhesDoCepDto;
import br.com.lira.apicep.modelo.Cep;
import br.com.lira.apicep.modelo.Cidade;
import br.com.lira.apicep.repository.CepRepository;
import br.com.lira.apicep.repository.CidadeRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author paulo
 */
@RestController
@RequestMapping("/ceps")
public class CepController {

    @Autowired
    private CepRepository cepRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping
    @Cacheable(value = "listaDeCeps")
    public Page<CepDto> lista(@RequestParam(required = false) String logradouro,
            @PageableDefault(sort = "cep", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable paginacao) {
        //Pageable paginacao = PageRequest.of(pagina, quantidade, Direction.DESC, ordenacao);

        if (logradouro == null) {
            Page<Cep> topicos = cepRepository.findAll(paginacao);
            return CepDto.converter(topicos);
        } else {
            Page<Cep> ceps = cepRepository.findByLogradouroContaining(logradouro, paginacao);
            return CepDto.converter(ceps);
        }
    }

    @GetMapping("/{cep}")
    public ResponseEntity<DetalhesDoCepDto> detalhar(@PathVariable String cep) {
        Optional<Cep> cep2 = cepRepository.findByCep(cep);
        if (cep2.isPresent()) {
            //System.out.println(cep2.get().getCodigoIBGE());
            Optional<Cidade> cidade = cidadeRepository.findByCodigoIBGE(cep2.get().getCodigoIBGE());
            if (cidade.isPresent()) {                
                return ResponseEntity.ok(new DetalhesDoCepDto(cep2.get(), cidade.get()));
            }
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.notFound().build();
    }
}
