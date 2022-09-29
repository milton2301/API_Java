
package com.selettraAPI.seletra.controller;

/**
 *
 * @author amilt
 */

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.selettraAPI.seletra.model.Candidaturas;
import com.selettraAPI.seletra.service.CandidaturasService;


@RestController
public class CandidaturasController {
@Autowired
CandidaturasService candidaturasService;
@Autowired
public static final String PERMISSION = "hasAnyAuthority('sell::','sell:create:*')";
  
  @CrossOrigin
  @PostMapping({"/candidaturas"})
  public Candidaturas novoCandidaturas(@RequestBody Candidaturas candidaturas, HttpServletRequest request) {
    return candidaturasService.novo(candidaturas, request);
  }

  
  @CrossOrigin
  @GetMapping({"/candidaturas"})
  public List<Candidaturas> listarCandidaturass() {  
    return candidaturasService.listarCandidaturass();
  } 

  @CrossOrigin
  @GetMapping({"/candidaturas/{id}"})
  public Candidaturas procurarCandidaturass(@PathVariable("id") Long id) {
    return candidaturasService.procurarCandidaturass(id).get();
  }

  
  @CrossOrigin
  @PostMapping({"/candidaturas/{id}/atualizar"})
  public Boolean atualizarCandidaturass(@RequestBody Candidaturas candidaturas) {
    return candidaturasService.salvar(candidaturas);
  }

  @CrossOrigin
  @PostMapping({"/candidaturas/{id}/excluir"})
  public Boolean excluirCandidaturass(@RequestBody Candidaturas candidaturas) {
    return candidaturasService.excluirCandidaturass(candidaturas);
  }

  @CrossOrigin
  @PostMapping({"/candidaturas/procurar"})
  public List<Candidaturas> procurarCandidaturassContent(@RequestBody Candidaturas candidaturas) {
    return candidaturasService.procurarCandidaturassContent(candidaturas);
  }  
}
