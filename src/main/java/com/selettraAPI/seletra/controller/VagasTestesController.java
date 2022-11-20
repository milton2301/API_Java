
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

import com.selettraAPI.seletra.model.VagasTestes;
import com.selettraAPI.seletra.service.VagasTestesService;


@RestController
public class VagasTestesController {
@Autowired
VagasTestesService vagasTestesService;
@Autowired
public static final String PERMISSION = "hasAnyAuthority('sell::','sell:create:*')";
  
  @CrossOrigin
  @PostMapping({"/vagas_testes"})
  public VagasTestes novoVagasTestes(@RequestBody VagasTestes vagasTestes, HttpServletRequest request) {
    return vagasTestesService.novo(vagasTestes, request);
  }

  
  @CrossOrigin
  @GetMapping({"/vagas_testes"})
  public List<VagasTestes> listarVagasTestess() {  
    return vagasTestesService.listarVagasTestess();
  } 

  @CrossOrigin
  @GetMapping({"/vagas_testes/{id}"})
  public VagasTestes procurarVagasTestess(@PathVariable("id") Long id) {
    return vagasTestesService.procurarVagasTestess(id).get();
  }

  
  @CrossOrigin
  @PostMapping({"/vagas_testes/{id}/atualizar"})
  public Boolean atualizarVagasTestess(@RequestBody VagasTestes vagasTestes) {
    return vagasTestesService.salvar(vagasTestes);
  }

  @CrossOrigin
  @PostMapping({"/vagas_testes/{id}/excluir"})
  public Boolean excluirVagasTestess(@RequestBody VagasTestes vagasTestes) {
    return vagasTestesService.excluirVagasTestess(vagasTestes);
  }

  @CrossOrigin
  @PostMapping({"/vagas_testes/procurar"})
  public List<VagasTestes> procurarVagasTestessContent(@RequestBody VagasTestes vagasTestes) {
    return vagasTestesService.procurarVagasTestessContent(vagasTestes);
  }  
}
