package com.selettraAPI.seletra.service;

/**
 *
 * @author amilt
 */

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;

import com.selettraAPI.seletra.model.Anexos;
import org.springframework.core.io.Resource;

public interface AnexosService {

  Anexos novo(Anexos anexos);
  
  Boolean salvar(Anexos anexos); 

  List<Anexos> listarAnexoss();

  Optional<Anexos> listarAnexossId(Long id);

  Boolean excluirAnexoss(Anexos anexos); 

  Optional<Anexos> procurarAnexoss(Long id);
 
  List<Anexos> procurarAnexossContent(Anexos anexos);

  Resource procurarAnexosDowload(Long id);

}
