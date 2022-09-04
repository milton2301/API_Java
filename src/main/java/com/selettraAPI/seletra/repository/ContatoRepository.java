
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

import com.selettraAPI.seletra.model.Contato;
import javax.persistence.Id;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Id> {

  @Override
  @Query(value = "SELECT * FROM contatos Contato WHERE Contato.ativo = true order by Contato.id", nativeQuery = true)
  List<Contato> findAll();

  @Query(value = "SELECT * FROM contatos Contato WHERE Contato.ativo = true and Contato.id = ?1 order by Contato.id", nativeQuery = true)
  Optional<Contato> findById(Long id);
  
  @Query(value = "SELECT * FROM contatos Contato WHERE Contato.id = ?1 order by Contato.id", nativeQuery = true)
  Optional<Contato> findByCreat(Long id);
  
  @Query(value = "SELECT * FROM contatos Contato WHERE Contato.ativo = true and Contato.idcandidato = ?1 order by Contato.id", nativeQuery = true)
  List<Contato> findByContents(Long idcandidato);
  
}
