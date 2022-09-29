
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

import com.selettraAPI.seletra.model.Candidaturas;
import javax.persistence.Id;

@Repository
public interface CandidaturasRepository extends JpaRepository<Candidaturas, Id> {

  @Override
  @Query(value = "SELECT * FROM candidaturas Candidaturas WHERE Candidaturas.ativo = true order by Candidaturas.id", nativeQuery = true)
  List<Candidaturas> findAll();

  @Query(value = "SELECT * FROM candidaturas Candidaturas WHERE Candidaturas.ativo = true and Candidaturas.id = ?1 order by Candidaturas.id", nativeQuery = true)
  Optional<Candidaturas> findById(Long id);
  
  @Query(value = "SELECT * FROM candidaturas Candidaturas WHERE Candidaturas.id = ?1 order by Candidaturas.id", nativeQuery = true)
  Optional<Candidaturas> findByCreat(Long id);
  
  @Query(value = "SELECT * FROM candidaturas Candidaturas WHERE Candidaturas.ativo = true and Candidaturas.idcandidato = ?1 order by Candidaturas.id", nativeQuery = true)
  List<Candidaturas> findByContents(Long idcandidato);
  
}
