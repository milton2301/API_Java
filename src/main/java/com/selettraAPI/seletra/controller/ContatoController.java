
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

import com.selettraAPI.seletra.model.Contato;
import com.selettraAPI.seletra.service.ContatoService;


@RestController
public class ContatoController {
@Autowired
ContatoService contatoService;
@Autowired
public static final String PERMISSION = "hasAnyAuthority('sell::','sell:create:*')";
  
  @CrossOrigin
  @PostMapping({"/contatos"})
  public Contato novoContato(@RequestBody Contato contato, HttpServletRequest request) {
    return contatoService.novo(contato, request);
  }

  
  @CrossOrigin
  @GetMapping({"/contatos"})
  public List<Contato> listarContatos() {  
    return contatoService.listarContatos();
  } 

  @CrossOrigin
  @GetMapping({"/contatos/{id}"})
  public Contato procurarContatos(@PathVariable("id") Long id) {
    return contatoService.procurarContatos(id).get();
  }

  
  @CrossOrigin
  @PostMapping({"/contatos/{id}/atualizar"})
  public Boolean atualizarContatos(@RequestBody Contato contato) {
    return contatoService.salvar(contato);
  }

  @CrossOrigin
  @PostMapping({"/contatos/{id}/excluir"})
  public Boolean excluirContatos(@RequestBody Contato contato) {
    return contatoService.excluirContatos(contato);
  }

  @CrossOrigin
  @PostMapping({"/contatos/procurar"})
  public List<Contato> procurarContatosContent(@RequestBody Contato contato) {
    return contatoService.procurarContatosContent(contato);
  }  
}
