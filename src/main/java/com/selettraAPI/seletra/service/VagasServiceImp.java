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

import com.selettraAPI.seletra.model.Vagas;
import com.selettraAPI.seletra.repository.VagasRepository;


@Service
public class VagasServiceImp implements VagasService {

  @Autowired
  VagasRepository vagasRepository;

  @Override
  public Vagas novo(Vagas vagas, HttpServletRequest request) {
    var hoje = new Date();
    Date datehoje = hoje;
    vagas.setUsercad(vagas.getUsercad());
    vagas.setDtcad(datehoje);
    vagas.setAtivo(false);
    vagas = (Vagas)vagasRepository.save(vagas);
    if (vagas != null) {
      return vagas;
    } else {
      return null;
    }
  }

  @Override
  public List<Vagas> listarVagas() {
    return vagasRepository.findAll();
  }

  @Override
  public Optional<Vagas> procurarVagas(Long id) {
    return vagasRepository.findById(id);
  }

  @Override
  public Optional<Vagas> listarVagasId(Long id) { 
    return vagasRepository.findById(id);
  }

  @Override
  public List<Vagas> procurarVagasContent(Vagas vagas) {
    return vagasRepository.findByContents(vagas.getNome());
  }  
  
  @Override
  public Boolean excluirVagas(Vagas vagas) {
    Vagas vagasTemp = vagasRepository.findById(vagas.getId()).get();
    if (vagasTemp == null) {
      return false;
    }
    
    vagasTemp.setAtivo(false);
    vagas = (Vagas)vagasRepository.save(vagasTemp);
    if (vagas != null) {
      return true;
    } else {
      return false;
    }
  }
  
  @Override
  public Boolean salvar(Vagas vagas) {
    if (vagas == null) {
      return false;
    }
    
    Vagas oldvagas = (Vagas)vagasRepository.findByCreat(vagas.getId()).get();
    oldvagas.setDescricao(vagas.getDescricao());
    oldvagas.setNome(vagas.getNome());
    oldvagas.setSetor(vagas.getSetor());
    oldvagas.setSalario(vagas.getSalario());
    oldvagas.setDtabertura(vagas.getDtabertura());
    oldvagas.setDtfechamento(vagas.getDtfechamento());
    oldvagas.setAtivo(true);
    vagas = (Vagas)vagasRepository.save(oldvagas);
    if (vagas != null) {
      return true;
    } else {
      return false;
    }
  }
}
