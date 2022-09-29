package com.selettraAPI.seletra.service;

/**
 *
 * @author amilt
 */

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;

import com.selettraAPI.seletra.model.Vagas;

public interface VagasService {

  Vagas novo(Vagas vagas, HttpServletRequest request); 
  
  Boolean salvar(Vagas vagas); 

  List<Vagas> listarVagas();

  Optional<Vagas> listarVagasId(Long id);

  Boolean excluirVagas(Vagas vagas); 

  Optional<Vagas> procurarVagas(Long id);
 
  List<Vagas> procurarVagasContent(Vagas vagas);
}
