
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

import com.selettraAPI.seletra.model.Candidato;
import com.selettraAPI.seletra.service.CandidatoService;


@RestController
public class CandidatoController {
@Autowired
CandidatoService candidatoService;
@Autowired
public static final String PERMISSION = "hasAnyAuthority('sell::','sell:create:*')";

  @CrossOrigin
  @PostMapping({"/candidatos"})
  public Candidato novoCandidatos(@RequestBody Candidato candidato, HttpServletRequest request) {
    return candidatoService.novo(candidato, request);
  }

  
  @CrossOrigin
  @GetMapping({"/candidatos"})
  public List<Candidato> listarCandidatos() {  
    return candidatoService.listarCandidatos();
  } 

  @CrossOrigin
  @GetMapping({"/candidatos/{id}"})
  public Candidato procurarQuestoes(@PathVariable("id") Long id) {
    return candidatoService.procurarCandidatos(id).get();
  }

  
  @CrossOrigin
  @PostMapping({"/candidatos/{id}/atualizar"})
  public Boolean atualizarCandidatos(@RequestBody Candidato candidato) {
    return candidatoService.salvar(candidato);
  }

  @CrossOrigin
  @PostMapping({"/candidatos/{id}/excluir"})
  public Boolean excluirCandidatos(@RequestBody Candidato candidato) {
    return candidatoService.excluirCandidatos(candidato);
  }

  @CrossOrigin
  @PostMapping({"/candidatos/procurar"})
  public List<Candidato> procurarRespostasContent(@RequestBody Candidato candidato) {
    return candidatoService.procurarCandidatosContent(candidato);
  }  
}
