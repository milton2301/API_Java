package com.selettraAPI.seletra.service;

/**
 *
 * @author amilt
 */

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;

import com.selettraAPI.seletra.model.VagasTestes;

public interface VagasTestesService {

  VagasTestes novo(VagasTestes vagasTestes, HttpServletRequest request); 
  
  Boolean salvar(VagasTestes vagasTestes); 

  List<VagasTestes> listarVagasTestess();

  Optional<VagasTestes> listarVagasTestessId(Long id);

  Boolean excluirVagasTestess(VagasTestes vagasTestes); 

  Optional<VagasTestes> procurarVagasTestess(Long id);
 
  List<VagasTestes> procurarVagasTestessContent(VagasTestes vagasTestes);
}
