
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

import com.selettraAPI.seletra.model.CandidaturasObservacoes;
import javax.persistence.Id;

@Repository
public interface CandidaturasObservacoesRepository extends JpaRepository<CandidaturasObservacoes, Id> {

  @Override
  @Query(value = "SELECT * FROM candidaturasobservacoes CandidaturasObservacoes WHERE CandidaturasObservacoes.ativo = true order by CandidaturasObservacoes.id", nativeQuery = true)
  List<CandidaturasObservacoes> findAll();

  @Query(value = "SELECT * FROM candidaturasobservacoes CandidaturasObservacoes WHERE CandidaturasObservacoes.ativo = true and CandidaturasObservacoes.id = ?1 order by CandidaturasObservacoes.id", nativeQuery = true)
  Optional<CandidaturasObservacoes> findById(Long id);
  
  @Query(value = "SELECT * FROM candidaturasobservacoes CandidaturasObservacoes WHERE CandidaturasObservacoes.id = ?1 order by CandidaturasObservacoes.id", nativeQuery = true)
  Optional<CandidaturasObservacoes> findByCreat(Long id);
  
  @Query(value = "SELECT * FROM candidaturasobservacoes CandidaturasObservacoes WHERE CandidaturasObservacoes.ativo = true and CandidaturasObservacoes.idcandidato = ?1 and CandidaturasObservacoes.idvaga = ?2 order by CandidaturasObservacoes.id", nativeQuery = true)
  List<CandidaturasObservacoes> findByContents(Long idcandidato, Long idvaga);
  
}
