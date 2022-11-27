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

import com.selettraAPI.seletra.model.Usuarios;
import com.selettraAPI.seletra.repository.UsuariosRepository;


@Service
public class UsuariosServiceImp implements UsuariosService {

  @Autowired
  UsuariosRepository usuariosRepository;

 @Override
  public Usuarios login(Usuarios usuarios) {
    return usuariosRepository.findByLogin(usuarios.getUsuario(), criptografar(usuarios.getSenha(), 10)).get();
  }
  
  @Override
  public Usuarios novo(Usuarios usuarios, HttpServletRequest request) {
    var hoje = new Date();
    Date datehoje = hoje;
    usuarios.setUsercad(usuarios.getUsercad());
    usuarios.setDtcad(datehoje);
    usuarios.setAtivo(false);
    usuarios = (Usuarios)usuariosRepository.save(usuarios);
    if (usuarios != null) {
      return usuarios;
    } else {
      return null;
    }
  }

  @Override
  public List<Usuarios> listarUsuarioss() {
    return usuariosRepository.findAll();
  }

  @Override
  public Optional<Usuarios> procurarUsuarioss(Long id) {
    return usuariosRepository.findById(id);
  }

  @Override
  public Optional<Usuarios> listarUsuariossId(Long id) { 
    return usuariosRepository.findById(id);
  }

  @Override
  public List<Usuarios> procurarUsuariossContent(Usuarios usuarios) {
    return usuariosRepository.findByContents(usuarios.getId());
  }  
  
  @Override
  public Boolean excluirUsuarioss(Usuarios usuarios) {
    Usuarios usuariosTemp = usuariosRepository.findById(usuarios.getId()).get();
    if (usuariosTemp == null) {
      return false;
    }
    
    usuariosTemp.setAtivo(false);
    usuarios = (Usuarios)usuariosRepository.save(usuariosTemp);
    if (usuarios != null) {
      return true;
    } else {
      return false;
    }
  }
  
  @Override
  public Boolean salvar(Usuarios usuarios) {
    if (usuarios == null) {
      return false;
    }
    
    Usuarios oldusuarios = (Usuarios)usuariosRepository.findByCreat(usuarios.getId()).get();
    oldusuarios.setEmail(usuarios.getEmail());
    oldusuarios.setNome(usuarios.getNome());
    //oldusuarios.setSenha(usuarios.getSenha());
    oldusuarios.setSuspenso(usuarios.getSuspenso());
    oldusuarios.setUsuario(usuarios.getUsuario());
    oldusuarios.setAtivo(true);
    usuarios = (Usuarios)usuariosRepository.save(oldusuarios);
    if (usuarios != null) {
      return true;
    } else {
      return false;
    }
  }

    @Override
  public Boolean alterarSenha(Usuarios usuarios) {
    if (usuarios == null) {
      return false;
    }
    
    Usuarios oldusuarios = (Usuarios)usuariosRepository.findByCreat(usuarios.getId()).get();
    oldusuarios.setEmail(usuarios.getEmail());
    oldusuarios.setNome(usuarios.getNome());
    oldusuarios.setSenha(criptografar(usuarios.getSenha(), 10));
    oldusuarios.setSuspenso(usuarios.getSuspenso());
    oldusuarios.setUsuario(usuarios.getUsuario());
    oldusuarios.setAtivo(true);
    usuarios = (Usuarios)usuariosRepository.save(oldusuarios);
    if (usuarios != null) {
      return true;
    } else {
      return false;
    }
  }
  
  public static String criptografar(String msg, int chave) {
    String Cript = "";
    for(int i = 0; i < msg.length(); i++) {
        Cript += (char) (msg.charAt(i) + chave);
    }
    return Cript;
}
  
  public static String descriptografar(String msgCript, int chave) {
    String msg = "";
    for(int i = 0; i < msgCript.length(); i++) {
        msg += (char) (msgCript.charAt(i) - chave);
    }
    return msg;
}
  
}
