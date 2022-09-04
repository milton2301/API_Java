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

import com.selettraAPI.seletra.model.Contato;
import com.selettraAPI.seletra.repository.ContatoRepository;


@Service
public class ContatoServiceImpl implements ContatoService {

  @Autowired
  ContatoRepository contatoRepository;

  @Override
  public Contato novo(Contato contato, HttpServletRequest request) {
    var hoje = new Date();
    Date datehoje = hoje;
    contato.setUsercad(contato.getUsercad());
    contato.setDtcad(datehoje);
    contato.setAtivo(false);
    contato = (Contato)contatoRepository.save(contato);
    if (contato != null) {
      return contato;
    } else {
      return null;
    }
  }

  @Override
  public List<Contato> listarContatos() {
    return contatoRepository.findAll();
  }

  @Override
  public Optional<Contato> procurarContatos(Long id) {
    return contatoRepository.findById(id);
  }

  @Override
  public Optional<Contato> listarContatosId(Long id) { 
    return contatoRepository.findById(id);
  }

  @Override
  public List<Contato> procurarContatosContent(Contato contato) {
    return contatoRepository.findByContents(contato.getIdcandidato());
  }  
  
  @Override
  public Boolean excluirContatos(Contato contato) {
    Contato contatoTemp = contatoRepository.findById(contato.getId()).get();
    if (contatoTemp == null) {
      return false;
    }
    
    contatoTemp.setAtivo(false);
    contato = (Contato)contatoRepository.save(contatoTemp);
    if (contato != null) {
      return true;
    } else {
      return false;
    }
  }
  
  @Override
  public Boolean salvar(Contato contato) {
    if (contato == null) {
      return false;
    }
    
    Contato oldcontato = (Contato)contatoRepository.findByCreat(contato.getId()).get();
    oldcontato.setIdcandidato(contato.getIdcandidato());
    oldcontato.setTipo(contato.getTipo());
    oldcontato.setValor(contato.getValor());
    oldcontato.setAtivo(true);
    contato = (Contato)contatoRepository.save(oldcontato);
    if (contato != null) {
      return true;
    } else {
      return false;
    }
  }
}
