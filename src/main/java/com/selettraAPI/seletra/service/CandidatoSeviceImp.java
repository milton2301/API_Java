
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

import com.selettraAPI.seletra.model.Candidato;
import com.selettraAPI.seletra.repository.CandidatoRepository;


@Service
public class CandidatoSeviceImp implements CandidatoService {

  @Autowired
  CandidatoRepository candidatoRepository;

  @Override
  public Candidato novo(Candidato candidato, HttpServletRequest request) {
    var hoje = new Date();
    Date datehoje = hoje;
    candidato.setUsercad(candidato.getUsercad());
    candidato.setDtcad(datehoje);
    candidato.setAtivo(false);
    candidato = (Candidato)candidatoRepository.save(candidato);
    if (candidato != null) {
      return candidato;
    } else {
      return null;
    }
  }

  @Override
  public List<Candidato> listarCandidatos() {
    return candidatoRepository.findAll();
  }

  @Override
  public Optional<Candidato> procurarCandidatos(Long id) {
    return candidatoRepository.findById(id);
  }

  @Override
  public Optional<Candidato> listarCandidatosId(Long id) { 
    return candidatoRepository.findById(id);
  }

  @Override
  public List<Candidato> procurarCandidatosContent(Candidato candidato) {
    return candidatoRepository.findByContents(candidato.getNome());
  }  
  
  @Override
  public Boolean excluirCandidatos(Candidato candidato) {
    Candidato candidatoTemp = candidatoRepository.findById(candidato.getId()).get();
    if (candidatoTemp == null) {
      return false;
    }
    candidatoTemp.setUsercad(candidato.getUsercad());
    var hoje = new Date();
    Date datehoje = hoje;
    candidatoTemp.setDtcad(datehoje);
    candidatoTemp.setAtivo(false);
    candidato = (Candidato)candidatoRepository.save(candidatoTemp);
    if (candidato != null) {
      return true;
    } else {
      return false;
    }
  }
  
  @Override
  public Boolean salvar(Candidato candidato) {
    if (candidato == null) {
      return false;
    }
    
    Candidato oldcandidato = (Candidato)candidatoRepository.findByCreat(candidato.getId()).get();
    oldcandidato.setNome(candidato.getNome());
    oldcandidato.setCpf(candidato.getCpf());
    oldcandidato.setEstadocivil(candidato.getEstadocivil());
    oldcandidato.setIdade(candidato.getIdade());
    oldcandidato.setRg(candidato.getRg());
    oldcandidato.setAtivo(true);
    candidato = (Candidato)candidatoRepository.save(oldcandidato);
    if (candidato != null) {
      return true;
    } else {
      return false;
    }
  }
}
