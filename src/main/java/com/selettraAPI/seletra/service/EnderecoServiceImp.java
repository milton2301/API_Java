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

import com.selettraAPI.seletra.model.Endereco;
import com.selettraAPI.seletra.repository.EnderecoRepository;


@Service
public class EnderecoServiceImp implements EnderecoService {

  @Autowired
  EnderecoRepository enderecoRepository;

  @Override
  public Endereco novo(Endereco endereco, HttpServletRequest request) {
    var hoje = new Date();
    Date datehoje = hoje;
    endereco.setUsercad(endereco.getUsercad());
    endereco.setDtcad(datehoje);
    endereco.setAtivo(false);
    endereco = (Endereco)enderecoRepository.save(endereco);
    if (endereco != null) {
      return endereco;
    } else {
      return null;
    }
  }

  @Override
  public List<Endereco> listarEnderecos() {
    return enderecoRepository.findAll();
  }

  @Override
  public Optional<Endereco> procurarEnderecos(Long id) {
    return enderecoRepository.findById(id);
  }

  @Override
  public Optional<Endereco> listarEnderecosId(Long id) { 
    return enderecoRepository.findById(id);
  }

  @Override
  public List<Endereco> procurarEnderecosContent(Endereco endereco) {
    return enderecoRepository.findByContents(endereco.getIdcandidato());
  }  
  
  @Override
  public Boolean excluirEnderecos(Endereco endereco) {
    Endereco enderecoTemp = enderecoRepository.findById(endereco.getId()).get();
    if (enderecoTemp == null) {
      return false;
    }
    
    enderecoTemp.setAtivo(false);
    endereco = (Endereco)enderecoRepository.save(enderecoTemp);
    if (endereco != null) {
      return true;
    } else {
      return false;
    }
  }
  
  @Override
  public Boolean salvar(Endereco endereco) {
    if (endereco == null) {
      return false;
    }
    
    Endereco oldendereco = (Endereco)enderecoRepository.findByCreat(endereco.getId()).get();
    oldendereco.setIdcandidato(endereco.getIdcandidato());
    oldendereco.setCep(endereco.getCep());
    oldendereco.setRua(endereco.getRua());
    oldendereco.setNumero(endereco.getNumero());
    oldendereco.setBairro(endereco.getBairro());
    oldendereco.setCidade(endereco.getCidade());
    oldendereco.setEstado(endereco.getEstado());
    oldendereco.setPais(endereco.getPais());
    oldendereco.setComplemento(endereco.getComplemento());
    oldendereco.setAtivo(true);
    endereco = (Endereco)enderecoRepository.save(oldendereco);
    if (endereco != null) {
      return true;
    } else {
      return false;
    }
  }
}
