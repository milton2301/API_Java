package com.selettraAPI.seletra.service;

/**
 *
 * @author amilt
 */

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;

import com.selettraAPI.seletra.model.Endereco;

public interface EnderecoService {

  Endereco novo(Endereco endereco, HttpServletRequest request); 
  
  Boolean salvar(Endereco endereco); 

  List<Endereco> listarEnderecos();

  Optional<Endereco> listarEnderecosId(Long id);

  Boolean excluirEnderecos(Endereco endereco); 

  Optional<Endereco> procurarEnderecos(Long id);
 
  List<Endereco> procurarEnderecosContent(Endereco endereco);
}
