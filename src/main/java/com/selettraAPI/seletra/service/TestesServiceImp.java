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

import com.selettraAPI.seletra.model.Testes;
import com.selettraAPI.seletra.repository.TestesRepository;


@Service
public class TestesServiceImp implements TestesService {

  @Autowired
  TestesRepository testesRepository;

  @Override
  public Testes novo(Testes testes, HttpServletRequest request) {
    var hoje = new Date();
    Date datehoje = hoje;
    testes.setUsercad(testes.getUsercad());
    testes.setDtcad(datehoje);
    testes.setAtivo(false);
    testes = (Testes)testesRepository.save(testes);
    if (testes != null) {
      return testes;
    } else {
      return null;
    }
  }

  @Override
  public List<Testes> listarTestess() {
    return testesRepository.findAll();
  }

  @Override
  public Optional<Testes> procurarTestess(Long id) {
    return testesRepository.findById(id);
  }

  @Override
  public Optional<Testes> listarTestessId(Long id) { 
    return testesRepository.findById(id);
  }

  @Override
  public List<Testes> procurarTestessContent(Testes testes) {
    return testesRepository.findByContents(testes.getDescricao());
  }  
  
  @Override
  public Boolean excluirTestess(Testes testes) {
    Testes testesTemp = testesRepository.findById(testes.getId()).get();
    if (testesTemp == null) {
      return false;
    }
    
    testesTemp.setAtivo(false);
    testes = (Testes)testesRepository.save(testesTemp);
    if (testes != null) {
      return true;
    } else {
      return false;
    }
  }
  
  @Override
  public Boolean salvar(Testes testes) {
    if (testes == null) {
      return false;
    }
    
    Testes oldtestes = (Testes)testesRepository.findByCreat(testes.getId()).get();
    oldtestes.setDescricao(testes.getDescricao());
    oldtestes.setAtivo(true);
    testes = (Testes)testesRepository.save(oldtestes);
    if (testes != null) {
      return true;
    } else {
      return false;
    }
  }
}
