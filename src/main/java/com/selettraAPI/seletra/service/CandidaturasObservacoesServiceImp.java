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

import com.selettraAPI.seletra.model.CandidaturasObservacoes;
import com.selettraAPI.seletra.repository.CandidaturasObservacoesRepository;


@Service
public class CandidaturasObservacoesServiceImp implements CandidaturasObservacoesService {

  @Autowired
  CandidaturasObservacoesRepository candidaturasRepository;

  @Override
  public CandidaturasObservacoes novo(CandidaturasObservacoes candidaturas, HttpServletRequest request) {
    var hoje = new Date();
    Date datehoje = hoje;
    candidaturas.setUsercad(candidaturas.getUsercad());
    candidaturas.setDtcad(datehoje);
    candidaturas.setAtivo(false);
    candidaturas = (CandidaturasObservacoes)candidaturasRepository.save(candidaturas);
    if (candidaturas != null) {
      return candidaturas;
    } else {
      return null;
    }
  }

  @Override
  public List<CandidaturasObservacoes> listarCandidaturasObservacoess() {
    return candidaturasRepository.findAll();
  }

  @Override
  public Optional<CandidaturasObservacoes> procurarCandidaturasObservacoess(Long id) {
    return candidaturasRepository.findById(id);
  }

  @Override
  public Optional<CandidaturasObservacoes> listarCandidaturasObservacoessId(Long id) { 
    return candidaturasRepository.findById(id);
  }

  @Override
  public List<CandidaturasObservacoes> procurarCandidaturasObservacoessContent(CandidaturasObservacoes candidaturas) {
    return candidaturasRepository.findByContents(candidaturas.getIdcandidato(), candidaturas.getIdcandidatura());
  }  
  
  @Override
  public Boolean excluirCandidaturasObservacoess(CandidaturasObservacoes candidaturas) {
    CandidaturasObservacoes candidaturasTemp = candidaturasRepository.findById(candidaturas.getId()).get();
    if (candidaturasTemp == null) {
      return false;
    }
    
    candidaturasTemp.setAtivo(false);
    candidaturas = (CandidaturasObservacoes)candidaturasRepository.save(candidaturasTemp);
    if (candidaturas != null) {
      return true;
    } else {
      return false;
    }
  }
  
  @Override
  public Boolean salvar(CandidaturasObservacoes candidaturas) {
    if (candidaturas == null) {
      return false;
    }
    
    CandidaturasObservacoes oldcandidaturas = (CandidaturasObservacoes)candidaturasRepository.findByCreat(candidaturas.getId()).get();
    oldcandidaturas.setIdcandidato(candidaturas.getIdcandidato());
    oldcandidaturas.setIdcandidatura(candidaturas.getIdcandidatura());
    oldcandidaturas.setIdvaga(candidaturas.getIdvaga());
    oldcandidaturas.setDescricao(candidaturas.getDescricao());
    oldcandidaturas.setAtivo(true);
    candidaturas = (CandidaturasObservacoes)candidaturasRepository.save(oldcandidaturas);
    if (candidaturas != null) {
      return true;
    } else {
      return false;
    }
  }
}
