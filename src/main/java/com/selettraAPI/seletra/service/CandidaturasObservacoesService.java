package com.selettraAPI.seletra.service;

/**
 *
 * @author amilt
 */

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;

import com.selettraAPI.seletra.model.CandidaturasObservacoes;

public interface CandidaturasObservacoesService {

  CandidaturasObservacoes novo(CandidaturasObservacoes candidaturas, HttpServletRequest request); 
  
  Boolean salvar(CandidaturasObservacoes candidaturas); 

  List<CandidaturasObservacoes> listarCandidaturasObservacoess();

  Optional<CandidaturasObservacoes> listarCandidaturasObservacoessId(Long id);

  Boolean excluirCandidaturasObservacoess(CandidaturasObservacoes candidaturas); 

  Optional<CandidaturasObservacoes> procurarCandidaturasObservacoess(Long id);
 
  List<CandidaturasObservacoes> procurarCandidaturasObservacoessContent(CandidaturasObservacoes candidaturas);
}
