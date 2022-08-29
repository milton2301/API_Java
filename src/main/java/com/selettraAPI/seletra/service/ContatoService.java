package com.selettraAPI.seletra.service;

/**
 *
 * @author amilt
 */

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;

import com.selettraAPI.seletra.model.Contato;

public interface ContatoService {

  Contato novo(Contato contato, HttpServletRequest request); 
  
  Boolean salvar(Contato contato); 

  List<Contato> listarContatos();

  Optional<Contato> listarContatosId(Long id);

  Boolean excluirContatos(Contato contato); 

  Optional<Contato> procurarContatos(Long id);
 
  List<Contato> procurarContatosContent(Contato contato);
}
