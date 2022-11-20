package com.selettraAPI.seletra.service;

/**
 *
 * @author amilt
 */

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;

import com.selettraAPI.seletra.model.Testes;

public interface TestesService {

  Testes novo(Testes testes, HttpServletRequest request); 
  
  Boolean salvar(Testes testes); 

  List<Testes> listarTestess();

  Optional<Testes> listarTestessId(Long id);

  Boolean excluirTestess(Testes testes); 

  Optional<Testes> procurarTestess(Long id);
 
  List<Testes> procurarTestessContent(Testes testes);
}
