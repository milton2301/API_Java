package com.selettraAPI.seletra.service;

/**
 *
 * @author amilt
 */

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;

import com.selettraAPI.seletra.model.Usuarios;

public interface UsuariosService {

  Usuarios login(Usuarios usuarios); 
    
  Usuarios novo(Usuarios usuarios, HttpServletRequest request); 
  
  Boolean salvar(Usuarios usuarios); 

  List<Usuarios> listarUsuarioss();

  Optional<Usuarios> listarUsuariossId(Long id);

  Boolean excluirUsuarioss(Usuarios usuarios); 

  Optional<Usuarios> procurarUsuarioss(Long id);
 
  List<Usuarios> procurarUsuariossContent(Usuarios usuarios);
}
