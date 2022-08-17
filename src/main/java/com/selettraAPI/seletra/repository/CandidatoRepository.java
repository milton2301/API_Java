
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

import com.selettraAPI.seletra.model.Candidato;
import javax.persistence.Id;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Id> {

  @Override
  @Query(value = "SELECT * FROM candidatos Candidatos WHERE Candidatos.ativo = true order by Candidatos.id", nativeQuery = true)
  List<Candidato> findAll();

  @Query(value = "SELECT * FROM candidatos Candidatos WHERE Candidatos.ativo = true and Candidatos.id = ?1 order by Candidatos.id", nativeQuery = true)
  Optional<Candidato> findById(Long id);
  
  @Query(value = "SELECT * FROM candidatos Candidatos WHERE Candidatos.id = ?1 order by Candidatos.id", nativeQuery = true)
  Optional<Candidato> findByCreat(Long id);
  
  @Query(value = "SELECT * FROM candidatos Candidatos WHERE Candidatos.ativo = true and (Candidatos.nome like %?1% or Candidatos.nacionalidade like %?2%) order by Candidatos.id", nativeQuery = true)
  List<Candidato> findByContents(String nome, String nacionalidade);
  
}
