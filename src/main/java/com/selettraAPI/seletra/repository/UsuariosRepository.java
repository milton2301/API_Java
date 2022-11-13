
package com.selettraAPI.seletra.repository;

/**
 *
 * @author amilt
 */

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.selettraAPI.seletra.model.Usuarios;
import javax.persistence.Id;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Id> {

  @Override
  @Query(value = "SELECT * FROM usuarios Usuarios WHERE Usuarios.ativo = true order by Usuarios.id", nativeQuery = true)
  List<Usuarios> findAll();

  @Query(value = "SELECT * FROM usuarios Usuarios WHERE Usuarios.ativo = true and Usuarios.id = ?1 order by Usuarios.id", nativeQuery = true)
  Optional<Usuarios> findById(Long id);
  
  @Query(value = "SELECT * FROM usuarios Usuarios WHERE Usuarios.id = ?1 order by Usuarios.id", nativeQuery = true)
  Optional<Usuarios> findByCreat(Long id);
  
  @Query(value = "SELECT * FROM usuarios Usuarios WHERE Usuarios.ativo = true and Usuarios.id = ?1 order by Usuarios.id", nativeQuery = true)
  List<Usuarios> findByContents(Long id);
  
  @Query(value = "SELECT * FROM usuarios Usuarios WHERE Usuarios.ativo = true and Usuarios.usuario = ?1 and Usuarios.senha = ?2", nativeQuery = true)
  Optional<Usuarios> findByLogin(String usuario, String senha);
  
  
}
