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

import com.selettraAPI.seletra.model.Candidaturas;
import com.selettraAPI.seletra.repository.CandidaturasRepository;


@Service
public class CandidaturasServiceImp implements CandidaturasService {

  @Autowired
  CandidaturasRepository candidaturasRepository;

  @Override
  public Candidaturas novo(Candidaturas candidaturas, HttpServletRequest request) {
    var hoje = new Date();
    Date datehoje = hoje;
    candidaturas.setUsercad(candidaturas.getUsercad());
    candidaturas.setDtcad(datehoje);
    candidaturas.setAtivo(false);
    candidaturas = (Candidaturas)candidaturasRepository.save(candidaturas);
    if (candidaturas != null) {
      return candidaturas;
    } else {
      return null;
    }
  }

  @Override
  public List<Candidaturas> listarCandidaturass() {
    return candidaturasRepository.findAll();
  }

  @Override
  public Optional<Candidaturas> procurarCandidaturass(Long id) {
    return candidaturasRepository.findById(id);
  }

  @Override
  public Optional<Candidaturas> listarCandidaturassId(Long id) { 
    return candidaturasRepository.findById(id);
  }

  @Override
  public List<Candidaturas> procurarCandidaturassContent(Candidaturas candidaturas) {
    return candidaturasRepository.findByContents(candidaturas.getIdcandidato());
  }  
  
  @Override
  public Boolean excluirCandidaturass(Candidaturas candidaturas) {
    Candidaturas candidaturasTemp = candidaturasRepository.findById(candidaturas.getId()).get();
    if (candidaturasTemp == null) {
      return false;
    }
    
    candidaturasTemp.setAtivo(false);
    candidaturas = (Candidaturas)candidaturasRepository.save(candidaturasTemp);
    if (candidaturas != null) {
      return true;
    } else {
      return false;
    }
  }
  
  @Override
  public Boolean salvar(Candidaturas candidaturas) {
    if (candidaturas == null) {
      return false;
    }
    
    Candidaturas oldcandidaturas = (Candidaturas)candidaturasRepository.findByCreat(candidaturas.getId()).get();
    oldcandidaturas.setIdcandidato(candidaturas.getIdcandidato());
    oldcandidaturas.setIdcandidato(candidaturas.getIdcandidato());
    oldcandidaturas.setIdvaga(candidaturas.getIdvaga());
    oldcandidaturas.setAprovado(candidaturas.getAprovado());
    oldcandidaturas.setObservacoes(candidaturas.getObservacoes());
    oldcandidaturas.setStatus(candidaturas.getStatus());
    oldcandidaturas.setNomecandidato(candidaturas.getNomecandidato());
    oldcandidaturas.setNomevaga(candidaturas.getNomevaga());
    oldcandidaturas.setAtivo(true);
    candidaturas = (Candidaturas)candidaturasRepository.save(oldcandidaturas);
    if (candidaturas != null) {
      return true;
    } else {
      return false;
    }
  }
}
