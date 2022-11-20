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

import com.selettraAPI.seletra.model.VagasTestes;
import com.selettraAPI.seletra.repository.VagasTestesRepository;


@Service
public class VagasTestesServiceImp implements VagasTestesService {

  @Autowired
  VagasTestesRepository vagasTestesRepository;

  @Override
  public VagasTestes novo(VagasTestes vagasTestes, HttpServletRequest request) {
    var hoje = new Date();
    Date datehoje = hoje;
    vagasTestes.setUsercad(vagasTestes.getUsercad());
    vagasTestes.setDtcad(datehoje);
    vagasTestes.setAtivo(false);
    vagasTestes = (VagasTestes)vagasTestesRepository.save(vagasTestes);
    if (vagasTestes != null) {
      return vagasTestes;
    } else {
      return null;
    }
  }

  @Override
  public List<VagasTestes> listarVagasTestess() {
    return vagasTestesRepository.findAll();
  }

  @Override
  public Optional<VagasTestes> procurarVagasTestess(Long id) {
    return vagasTestesRepository.findById(id);
  }

  @Override
  public Optional<VagasTestes> listarVagasTestessId(Long id) { 
    return vagasTestesRepository.findById(id);
  }

  @Override
  public List<VagasTestes> procurarVagasTestessContent(VagasTestes vagasTestes) {
    return vagasTestesRepository.findByContents(vagasTestes.getIdcandidatura(), vagasTestes.getIdcandidato());
  }  
  
  @Override
  public Boolean excluirVagasTestess(VagasTestes vagasTestes) {
    VagasTestes vagasTestesTemp = vagasTestesRepository.findById(vagasTestes.getId()).get();
    if (vagasTestesTemp == null) {
      return false;
    }
    
    vagasTestesTemp.setAtivo(false);
    vagasTestes = (VagasTestes)vagasTestesRepository.save(vagasTestesTemp);
    if (vagasTestes != null) {
      return true;
    } else {
      return false;
    }
  }
  
  @Override
  public Boolean salvar(VagasTestes vagasTestes) {
    if (vagasTestes == null) {
      return false;
    }
    
    VagasTestes oldvagasTestes = (VagasTestes)vagasTestesRepository.findByCreat(vagasTestes.getId()).get();
    oldvagasTestes.setIdcandidatura(vagasTestes.getIdcandidatura());
    oldvagasTestes.setIdteste(vagasTestes.getIdteste());
    oldvagasTestes.setIdcandidato(vagasTestes.getIdcandidato());
    oldvagasTestes.setDescricao(vagasTestes.getDescricao());
    oldvagasTestes.setValor(vagasTestes.getValor());
    oldvagasTestes.setValorcandidato(vagasTestes.getValorcandidato());
    oldvagasTestes.setAtivo(true);
    vagasTestes = (VagasTestes)vagasTestesRepository.save(oldvagasTestes);
    if (vagasTestes != null) {
      return true;
    } else {
      return false;
    }
  }
}
