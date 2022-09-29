package com.selettraAPI.seletra.service;

/**
 *
 * @author amilt
 */

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;

import com.selettraAPI.seletra.model.Candidaturas;

public interface CandidaturasService {

  Candidaturas novo(Candidaturas candidaturas, HttpServletRequest request); 
  
  Boolean salvar(Candidaturas candidaturas); 

  List<Candidaturas> listarCandidaturass();

  Optional<Candidaturas> listarCandidaturassId(Long id);

  Boolean excluirCandidaturass(Candidaturas candidaturas); 

  Optional<Candidaturas> procurarCandidaturass(Long id);
 
  List<Candidaturas> procurarCandidaturassContent(Candidaturas candidaturas);
}
