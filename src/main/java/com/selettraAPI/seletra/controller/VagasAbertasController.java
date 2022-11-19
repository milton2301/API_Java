
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

import com.selettraAPI.seletra.model.VagasAbertas;
import com.selettraAPI.seletra.service.VagasAbertasService;


@RestController
public class VagasAbertasController {
@Autowired
VagasAbertasService vagasAbertasService;
@Autowired
public static final String PERMISSION = "hasAnyAuthority('sell::','sell:create:*')";
  
  @CrossOrigin
  @PostMapping({"/vagas_abertas"})
  public VagasAbertas novoVagasAbertas(@RequestBody VagasAbertas vagasAbertas, HttpServletRequest request) {
    return vagasAbertasService.novo(vagasAbertas, request);
  }

  
  @CrossOrigin
  @GetMapping({"/vagas_abertas"})
  public List<VagasAbertas> listarVagasAbertass() {  
    return vagasAbertasService.listarVagasAbertass();
  } 

  @CrossOrigin
  @GetMapping({"/vagas_abertas/{id}"})
  public VagasAbertas procurarVagasAbertass(@PathVariable("id") Long id) {
    return vagasAbertasService.procurarVagasAbertass(id).get();
  }

  
  @CrossOrigin
  @PostMapping({"/vagas_abertas/{id}/atualizar"})
  public Boolean atualizarVagasAbertass(@RequestBody VagasAbertas vagasAbertas) {
    return vagasAbertasService.salvar(vagasAbertas);
  }

  @CrossOrigin
  @PostMapping({"/vagas_abertas/{id}/excluir"})
  public Boolean excluirVagasAbertass(@RequestBody VagasAbertas vagasAbertas) {
    return vagasAbertasService.excluirVagasAbertass(vagasAbertas);
  }

  @CrossOrigin
  @PostMapping({"/vagas_abertas/procurar"})
  public List<VagasAbertas> procurarVagasAbertassContent(@RequestBody VagasAbertas vagasAbertas) {
    return vagasAbertasService.procurarVagasAbertassContent(vagasAbertas);
  }  
}
