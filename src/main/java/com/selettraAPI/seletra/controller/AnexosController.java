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
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
  @PostMapping({"/anexos"})
  public Anexos novoAnexos(@RequestBody Anexos anexo) {
    return anexosservice.novo(anexo);
  }  
  
  @CrossOrigin
  @PostMapping("/anexos/uploads") 
  public String salvarArquivos(MultipartFile file) {
    Anexos anexos = new Anexos();
    anexos.setUsercad("Usuário");
    Anexos anexo = novoAnexos(anexos);
    Long id = anexo.getId();
    int index = 0;
    String fileNameApi = "";
    try {
      String[] filesFolder = {"Files"};
      String serverFolder = System.getProperty("user.dir") + File.separator + "FilesPath";  
      File rootFolder = new File(serverFolder);
      String[] listFiles = rootFolder.list();
      if (listFiles == null || listFiles.length == 0) {
        for (var x = 0; x <= filesFolder.length - 1; x++) {
          File newFolders = new File(rootFolder + File.separator + filesFolder[x]);
          newFolders.mkdirs();
        }
        
        serverFolder = System.getProperty("user.dir") + File.separator + "FilesPath";  
        rootFolder = new File(serverFolder);
        listFiles = rootFolder.list();
        
        for (int i = 0; i <= listFiles.length - 1; i++) {
          if (Objects.equals(filesFolder[index], listFiles[i])) {                       
            if (!file.isEmpty()) {
              String nome = new String(file.getOriginalFilename());
              String[] nomeTemp = nome.split("\\.");
              String namefile = nomeTemp[0] + "(" + id + ")." + nomeTemp[nomeTemp.length - 1];                
              byte[] bytes = file.getBytes();
              Path path = Paths.get(rootFolder + File.separator + filesFolder[index] + File.separator + namefile);
              Files.write(path, bytes);
              anexos.setNomeoriginal(file.getOriginalFilename());
              anexos.setNomeapi(namefile);
              fileNameApi = namefile;
            } else {
              return null;
            }            
          }
        }
                  
      } else {
        for (int i = 0; i <= listFiles.length - 1; i++) {
          if (Objects.equals(filesFolder[index], listFiles[i])) {
            if (!file.isEmpty()) {
              String nome = new String(file.getOriginalFilename());
              String[] nomeTemp = nome.split("\\.");
              String namefile = nomeTemp[0] + "(" + id + ")." + nomeTemp[nomeTemp.length - 1];                
              byte[] bytes = file.getBytes();
              Path path = Paths.get(rootFolder + File.separator + filesFolder[index] + File.separator + namefile);
              Files.write(path, bytes);
              anexos.setNomeoriginal(file.getOriginalFilename());
              anexos.setNomeapi(namefile);
              fileNameApi = namefile;
            } else {
              return null;
            }            
          }
        }
      }
      this.atualizarAnexoss(anexos);
      return id.toString();
    } catch (Exception ex) {
      return null;
    }
  }  
    
  @CrossOrigin
  @GetMapping({"/anexos/{id}/anexodownload"})  
  public ResponseEntity<Resource> downloadAnexos(@PathVariable("id") Long id) {
    var hoje = new Date();
    try {
      Resource file = (Resource) anexosservice.procurarAnexosDowload(id);
      HttpHeaders headers = new HttpHeaders();
      headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
      headers.add("Pragma", "no-cache");
      headers.add("Expires", hoje.toString());      
      headers.add("Content-Disposition", "attachment; filename=" + file.getFilename());
      InputStreamResource resource = new InputStreamResource(file.getInputStream());     
      return ResponseEntity.ok()
             .headers(headers)
             .contentLength(file.contentLength())
             .contentType(MediaType.APPLICATION_OCTET_STREAM)              
             .body(resource);     
    } catch (Exception ex) {  
      return null;  
    }   
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
