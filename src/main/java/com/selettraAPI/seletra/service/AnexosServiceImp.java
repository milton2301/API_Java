package com.selettraAPI.seletra.service;

/**
 *
 * @author amilt
 */

import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selettraAPI.seletra.model.Anexos;
import com.selettraAPI.seletra.repository.AnexosRepository;
import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;


@Service
public class AnexosServiceImp implements AnexosService {

  @Autowired
  AnexosRepository anexosRepository;

  @Override
  public Anexos novo(Anexos anexos) {
    var hoje = new Date();
    Date datehoje = hoje;
    anexos.setUsercad(anexos.getUsercad());
    anexos.setDtcad(datehoje);
    anexos.setAtivo(false);
    anexos = (Anexos)anexosRepository.save(anexos);
    if (anexos != null) {
      return anexos;
    } else {
      return null;
    }
  }

  @Override
  public Resource procurarAnexosDowload(Long id) {    
    Anexos anexos = anexosRepository.findById(id).get();
    if (Objects.nonNull(anexos)) {
      String nome = new String(anexos.getNomeapi());
      String[] nomeTemp = nome.split("\\.");
      String filetype = nomeTemp[nomeTemp.length - 1];
      Resource resource = extrairArquivos(anexos.getNomeapi(),0);
      return resource;
    }    
    return null;    
  }
  
  @Override
  public List<Anexos> listarAnexoss() {
    return anexosRepository.findAll();
  }

  @Override
  public Optional<Anexos> procurarAnexoss(Long id) {
    return anexosRepository.findById(id);
  }

  @Override
  public Optional<Anexos> listarAnexossId(Long id) { 
    return anexosRepository.findById(id);
  }

  @Override
  public List<Anexos> procurarAnexossContent(Anexos anexos) {
    return anexosRepository.findByContents(anexos.getIdcandidato());
  }  
  
  @Override
  public Boolean excluirAnexoss(Anexos anexos) {
    Anexos anexosTemp = anexosRepository.findById(anexos.getId()).get();
    if (anexosTemp == null) {
      return false;
    }
    
    anexosTemp.setAtivo(false);
    anexos = (Anexos)anexosRepository.save(anexosTemp);
    if (anexos != null) {
      return true;
    } else {
      return false;
    }
  }
  
  @Override
  public Boolean salvar(Anexos anexos) {
    if (anexos == null) {
      return false;
    }
    
    Anexos oldanexos = (Anexos)anexosRepository.findByCreat(anexos.getId()).get();
    oldanexos.setIdcandidato(anexos.getIdcandidato());
    oldanexos.setAtivo(true);
    anexos = (Anexos)anexosRepository.save(oldanexos);
    if (anexos != null) {
      return true;
    } else {
      return false;
    }
  }
  
  public Resource extrairArquivos(String fileName, int index) {
    try {
      Resource resource = null;
      String[] fileFolder = {"Files"};
      String serverFolder = System.getProperty("user.dir") + File.separator + "FilesPath";  
      File rootFolder = new File(serverFolder);
      String[] fileList = rootFolder.list();
      if (fileList == null || fileList.length == 0) {          
        return null;
      } else {        
        for (int i = 0; i <= fileList.length - 1; i++) {
          if (Objects.equals(fileFolder[index], fileList[i])) {            
            if (fileName != "") {              
              Path file = Paths.get(rootFolder + File.separator + fileFolder[index] + File.separator + fileName);              
              resource = (Resource) new UrlResource(file.toUri());
              if (resource != null ) {
                return resource;
              } else {
                return null;
              }            
            }
          }
        }        
        return resource;      
      } 
    } catch (MalformedURLException ex) {
      throw new RuntimeException("Error: " + ex.getMessage());
    }
  }
  
}
