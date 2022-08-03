package com.selettraAPI.seletra.service;

/**
 *
 * @author amilt
 */

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;

import com.selettraAPI.seletra.model.Candidato;

public interface CandidatoService {

  Candidato novo(Candidato candidato, HttpServletRequest request); 
  
  Boolean salvar(Candidato candidato); 

  List<Candidato> listarCandidatos();

  Optional<Candidato> listarCandidatosId(Long id);

  Boolean excluirCandidatos(Candidato candidato); 

  Optional<Candidato> procurarCandidatos(Long id);
 
  List<Candidato> procurarCandidatosContent(Candidato candidato);
}
