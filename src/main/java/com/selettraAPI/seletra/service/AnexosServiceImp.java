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


@Service
public class AnexosServiceImp implements AnexosService {

  @Autowired
  AnexosRepository anexosRepository;

  @Override
  public Anexos novo(Anexos anexos, HttpServletRequest request) {
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
    oldanexos.setNomeapi(anexos.getNomeapi());
    oldanexos.setAtivo(true);
    anexos = (Anexos)anexosRepository.save(oldanexos);
    if (anexos != null) {
      return true;
    } else {
      return false;
    }
  }
}
