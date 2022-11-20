
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

import com.selettraAPI.seletra.model.Testes;
import com.selettraAPI.seletra.service.TestesService;


@RestController
public class TestesController {
@Autowired
TestesService testesService;
@Autowired
public static final String PERMISSION = "hasAnyAuthority('sell::','sell:create:*')";
  
  @CrossOrigin
  @PostMapping({"/testes"})
  public Testes novoTestes(@RequestBody Testes testes, HttpServletRequest request) {
    return testesService.novo(testes, request);
  }

  
  @CrossOrigin
  @GetMapping({"/testes"})
  public List<Testes> listarTestess() {  
    return testesService.listarTestess();
  } 

  @CrossOrigin
  @GetMapping({"/testes/{id}"})
  public Testes procurarTestess(@PathVariable("id") Long id) {
    return testesService.procurarTestess(id).get();
  }

  
  @CrossOrigin
  @PostMapping({"/testes/{id}/atualizar"})
  public Boolean atualizarTestess(@RequestBody Testes testes) {
    return testesService.salvar(testes);
  }

  @CrossOrigin
  @PostMapping({"/testes/{id}/excluir"})
  public Boolean excluirTestess(@RequestBody Testes testes) {
    return testesService.excluirTestess(testes);
  }

  @CrossOrigin
  @PostMapping({"/testes/procurar"})
  public List<Testes> procurarTestessContent(@RequestBody Testes testes) {
    return testesService.procurarTestessContent(testes);
  }  
}
