
package com.selettraAPI.seletra.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author amilt
 */

import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.selettraAPI.seletra.model.Usuarios;
import com.selettraAPI.seletra.service.UsuariosService;


@RestController
public class UsuariosController {
@Autowired
UsuariosService usuariosService;
@Autowired
public static final String PERMISSION = "hasAnyAuthority('sell::','sell:create:*')";
  
  @CrossOrigin
  @PostMapping({"/signin"})
  public Usuarios Logar(@RequestBody Usuarios usuarios) {
    try{
        return usuariosService.login(usuarios);
    }catch(Exception e){
        return null;
    }
  }

  @CrossOrigin
  @PostMapping({"/usuarios"})
  public Usuarios novoUsuarios(@RequestBody Usuarios usuarios, HttpServletRequest request) {
    return usuariosService.novo(usuarios, request);
  }

  
  @CrossOrigin
  @GetMapping({"/usuarios"})
  public List<Usuarios> listarUsuarioss() {  
    return usuariosService.listarUsuarioss();
  } 

  @CrossOrigin
  @GetMapping({"/usuarios/{id}"})
  public Usuarios procurarUsuarioss(@PathVariable("id") Long id) {
    return usuariosService.procurarUsuarioss(id).get();
  }

  
  @CrossOrigin
  @PostMapping({"/usuarios/{id}/atualizar"})
  public Boolean atualizarUsuarioss(@RequestBody Usuarios usuarios) {
    return usuariosService.salvar(usuarios);
  }

  @CrossOrigin
  @PostMapping({"/usuarios/{id}/excluir"})
  public Boolean excluirUsuarioss(@RequestBody Usuarios usuarios) {
    return usuariosService.excluirUsuarioss(usuarios);
  }

  @CrossOrigin
  @PostMapping({"/usuarios/procurar"})
  public List<Usuarios> procurarUsuariossContent(@RequestBody Usuarios usuarios) {
    return usuariosService.procurarUsuariossContent(usuarios);
  }  
}
