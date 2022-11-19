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

import com.selettraAPI.seletra.model.VagasAbertas;
import com.selettraAPI.seletra.repository.VagasAbertasRepository;


@Service
public class VagasAbertasServiceImp implements VagasAbertasService {

  @Autowired
  VagasAbertasRepository contatoRepository;

  @Override
  public VagasAbertas novo(VagasAbertas contato, HttpServletRequest request) {
    var hoje = new Date();
    Date datehoje = hoje;
    contato.setUsercad(contato.getUsercad());
    contato.setDtcad(datehoje);
    contato.setAtivo(false);
    contato = (VagasAbertas)contatoRepository.save(contato);
    if (contato != null) {
      return contato;
    } else {
      return null;
    }
  }

  @Override
  public List<VagasAbertas> listarVagasAbertass() {
    return contatoRepository.findAll();
  }

  @Override
  public Optional<VagasAbertas> procurarVagasAbertass(Long id) {
    return contatoRepository.findById(id);
  }

  @Override
  public Optional<VagasAbertas> listarVagasAbertassId(Long id) { 
    return contatoRepository.findById(id);
  }

  @Override
  public List<VagasAbertas> procurarVagasAbertassContent(VagasAbertas contato) {
    return contatoRepository.findByContents(contato.getDescricao());
  }  
  
  @Override
  public Boolean excluirVagasAbertass(VagasAbertas contato) {
    VagasAbertas contatoTemp = contatoRepository.findById(contato.getId()).get();
    if (contatoTemp == null) {
      return false;
    }
    
    contatoTemp.setAtivo(false);
    contato = (VagasAbertas)contatoRepository.save(contatoTemp);
    if (contato != null) {
      return true;
    } else {
      return false;
    }
  }
  
  @Override
  public Boolean salvar(VagasAbertas contato) {
    if (contato == null) {
      return false;
    }
    
    VagasAbertas oldcontato = (VagasAbertas)contatoRepository.findByCreat(contato.getId()).get();
    oldcontato.setDescricao(contato.getDescricao());
    oldcontato.setAtivo(true);
    contato = (VagasAbertas)contatoRepository.save(oldcontato);
    if (contato != null) {
      return true;
    } else {
      return false;
    }
  }
}
