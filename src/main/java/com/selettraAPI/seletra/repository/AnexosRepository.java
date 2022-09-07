
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

import com.selettraAPI.seletra.model.Anexos;
import javax.persistence.Id;

@Repository
public interface AnexosRepository extends JpaRepository<Anexos, Id> {

  @Override
  @Query(value = "SELECT * FROM anexos Anexo WHERE Anexo.ativo = true order by Anexo.id", nativeQuery = true)
  List<Anexos> findAll();

  @Query(value = "SELECT * FROM anexos Anexo WHERE Anexo.ativo = true and Anexo.id = ?1 order by Anexo.id", nativeQuery = true)
  Optional<Anexos> findById(Long id);
  
  @Query(value = "SELECT * FROM anexos Anexo WHERE Anexo.id = ?1 order by Anexo.id", nativeQuery = true)
  Optional<Anexos> findByCreat(Long id);
  
  @Query(value = "SELECT * FROM anexos Anexo WHERE Anexo.ativo = true and Anexo.idcandidato order by Anexo.id", nativeQuery = true)
  List<Anexos> findByContents(Long idcandidato);
  
}
