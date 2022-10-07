
package com.selettraAPI.seletra.controller;

/**
 *
 * @author amilt
 */

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.selettraAPI.seletra.model.CandidaturasObservacoes;
import com.selettraAPI.seletra.service.CandidaturasObservacoesService;


@RestController
public class CandidaturasObservacoesController {
@Autowired
CandidaturasObservacoesService candidaturasObservacoesService;
@Autowired
public static final String PERMISSION = "hasAnyAuthority('sell::','sell:create:*')";
  
  @CrossOrigin
  @PostMapping({"/candidaturasobservacoes"})
  public CandidaturasObservacoes novoCandidaturasObservacoes(@RequestBody CandidaturasObservacoes candidaturasObservacoes, HttpServletRequest request) {
    return candidaturasObservacoesService.novo(candidaturasObservacoes, request);
  }

  
  @CrossOrigin
  @GetMapping({"/candidaturasobservacoes"})
  public List<CandidaturasObservacoes> listarCandidaturasObservacoess() {  
    return candidaturasObservacoesService.listarCandidaturasObservacoess();
  } 

  @CrossOrigin
  @GetMapping({"/candidaturasobservacoes/{id}"})
  public CandidaturasObservacoes procurarCandidaturasObservacoess(@PathVariable("id") Long id) {
    return candidaturasObservacoesService.procurarCandidaturasObservacoess(id).get();
  }
 
  @CrossOrigin
  @PostMapping({"/candidaturasobservacoes/{id}/atualizar"})
  public Boolean atualizarCandidaturasObservacoess(@RequestBody CandidaturasObservacoes candidaturasObservacoes) {
    return candidaturasObservacoesService.salvar(candidaturasObservacoes);
  }

  @CrossOrigin
  @PostMapping({"/candidaturasobservacoes/{id}/excluir"})
  public Boolean excluirCandidaturasObservacoess(@RequestBody CandidaturasObservacoes candidaturasObservacoes) {
    return candidaturasObservacoesService.excluirCandidaturasObservacoess(candidaturasObservacoes);
  }

  @CrossOrigin
  @PostMapping({"/candidaturasobservacoes/procurar"})
  public List<CandidaturasObservacoes> procurarCandidaturasObservacoessContent(@RequestBody CandidaturasObservacoes candidaturasObservacoes) {
    return candidaturasObservacoesService.procurarCandidaturasObservacoessContent(candidaturasObservacoes);
  }  
}
