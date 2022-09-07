/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.selettraAPI.seletra.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;

import com.selettraAPI.seletra.service.AnexosService;
import com.selettraAPI.seletra.model.Anexos;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
/**
 *
 * @author amilt
 */

@RestController
public class AnexosController {
    
    @Autowired
    AnexosService anexosservice;
    
    private final String pathArquivos;
    
    public AnexosController(@Value("${spring.arquivos.path}") String pathArquivos){
        this.pathArquivos = pathArquivos;
    }
    
  @CrossOrigin
  @PostMapping("/anexos/upload")
    public String salvarArquivo(@RequestParam MultipartFile file){
        var caminho = pathArquivos + UUID.randomUUID() + "." + extrairExtensao(file.getOriginalFilename()); 
        try{
            Files.copy(file.getInputStream(), Path.of(caminho), StandardCopyOption.REPLACE_EXISTING);
            return caminho;
        }catch(Exception e){
            return "Erro ao salvar";
        }
    }
    
    private String extrairExtensao(String nomeArquivo){
        int i = nomeArquivo.lastIndexOf(".");
        return nomeArquivo.substring(i + 1);
    }
    
    
  @CrossOrigin
  @PostMapping({"/anexos"})
  public Anexos novoAnexos(@RequestBody Anexos anexo, HttpServletRequest request) {
    return anexosservice.novo(anexo, request);
  }

  
  @CrossOrigin
  @GetMapping({"/anexos"})
  public List<Anexos> listarAnexoss() {  
    return anexosservice.listarAnexoss();
  } 

  @CrossOrigin
  @GetMapping({"/anexos/{id}"})
  public Anexos procurarAnexoss(@PathVariable("id") Long id) {
    return anexosservice.procurarAnexoss(id).get();
  }

  
  @CrossOrigin
  @PostMapping({"/anexos/{id}/atualizar"})
  public Boolean atualizarAnexoss(@RequestBody Anexos anexo) {
    return anexosservice.salvar(anexo);
  }

  @CrossOrigin
  @PostMapping({"/anexos/{id}/excluir"})
  public Boolean excluirAnexoss(@RequestBody Anexos anexo) {
    return anexosservice.excluirAnexoss(anexo);
  }

  @CrossOrigin
  @PostMapping({"/anexos/procurar"})
  public List<Anexos> procurarAnexossContent(@RequestBody Anexos anexo) {
    return anexosservice.procurarAnexossContent(anexo);
  }
}
