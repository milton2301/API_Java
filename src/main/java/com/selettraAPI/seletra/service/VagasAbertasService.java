package com.selettraAPI.seletra.service;

/**
 *
 * @author amilt
 */

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;

import com.selettraAPI.seletra.model.VagasAbertas;

public interface VagasAbertasService {

  VagasAbertas novo(VagasAbertas contato, HttpServletRequest request); 
  
  Boolean salvar(VagasAbertas contato); 

  List<VagasAbertas> listarVagasAbertass();

  Optional<VagasAbertas> listarVagasAbertassId(Long id);

  Boolean excluirVagasAbertass(VagasAbertas contato); 

  Optional<VagasAbertas> procurarVagasAbertass(Long id);
 
  List<VagasAbertas> procurarVagasAbertassContent(VagasAbertas contato);
}
