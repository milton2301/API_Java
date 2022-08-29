
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

import com.selettraAPI.seletra.model.Endereco;
import com.selettraAPI.seletra.service.EnderecoService;


@RestController
public class EnderecoController {
@Autowired
EnderecoService enderecoService;
@Autowired
public static final String PERMISSION = "hasAnyAuthority('sell::','sell:create:*')";
  
  @CrossOrigin
  @PostMapping({"/enderecos"})
  public Endereco novoEndereco(@RequestBody Endereco endereco, HttpServletRequest request) {
    return enderecoService.novo(endereco, request);
  }

  
  @CrossOrigin
  @GetMapping({"/enderecos"})
  public List<Endereco> listarEnderecos() {  
    return enderecoService.listarEnderecos();
  } 

  @CrossOrigin
  @GetMapping({"/enderecos/{id}"})
  public Endereco procurarEnderecos(@PathVariable("id") Long id) {
    return enderecoService.procurarEnderecos(id).get();
  }

  
  @CrossOrigin
  @PostMapping({"/enderecos/{id}/atualizar"})
  public Boolean atualizarEnderecos(@RequestBody Endereco endereco) {
    return enderecoService.salvar(endereco);
  }

  @CrossOrigin
  @PostMapping({"/enderecos/{id}/excluir"})
  public Boolean excluirEnderecos(@RequestBody Endereco endereco) {
    return enderecoService.excluirEnderecos(endereco);
  }

  @CrossOrigin
  @PostMapping({"/enderecos/procurar"})
  public List<Endereco> procurarEnderecosContent(@RequestBody Endereco endereco) {
    return enderecoService.procurarEnderecosContent(endereco);
  }  
}
