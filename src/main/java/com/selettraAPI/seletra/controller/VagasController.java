
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

import com.selettraAPI.seletra.model.Vagas;
import com.selettraAPI.seletra.service.VagasService;


@RestController
public class VagasController {
@Autowired
VagasService vagasService;
@Autowired
public static final String PERMISSION = "hasAnyAuthority('sell::','sell:create:*')";
  
  @CrossOrigin
  @PostMapping({"/vagas"})
  public Vagas novoVagas(@RequestBody Vagas vagas, HttpServletRequest request) {
    return vagasService.novo(vagas, request);
  }

  
  @CrossOrigin
  @GetMapping({"/vagas"})
  public List<Vagas> listarVagas() {  
    return vagasService.listarVagas();
  } 

  @CrossOrigin
  @GetMapping({"/vagas/{id}"})
  public Vagas procurarVagas(@PathVariable("id") Long id) {
    return vagasService.procurarVagas(id).get();
  }

  
  @CrossOrigin
  @PostMapping({"/vagas/{id}/atualizar"})
  public Boolean atualizarVagas(@RequestBody Vagas vagas) {
    return vagasService.salvar(vagas);
  }

  @CrossOrigin
  @PostMapping({"/vagas/{id}/excluir"})
  public Boolean excluirVagas(@RequestBody Vagas vagas) {
    return vagasService.excluirVagas(vagas);
  }

  @CrossOrigin
  @PostMapping({"/vagas/procurar"})
  public List<Vagas> procurarVagasContent(@RequestBody Vagas vagas) {
    return vagasService.procurarVagasContent(vagas);
  }  
}
