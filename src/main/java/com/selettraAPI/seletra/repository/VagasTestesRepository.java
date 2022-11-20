
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

import com.selettraAPI.seletra.model.VagasTestes;
import javax.persistence.Id;

@Repository
public interface VagasTestesRepository extends JpaRepository<VagasTestes, Id> {

  @Override
  @Query(value = "SELECT * FROM vagas_testes VagasTestes WHERE VagasTestes.ativo = true order by VagasTestes.id", nativeQuery = true)
  List<VagasTestes> findAll();

  @Query(value = "SELECT * FROM vagas_testes VagasTestes WHERE VagasTestes.ativo = true and VagasTestes.id = ?1 order by VagasTestes.id", nativeQuery = true)
  Optional<VagasTestes> findById(Long id);
  
  @Query(value = "SELECT * FROM vagas_testes VagasTestes WHERE VagasTestes.id = ?1 order by VagasTestes.id", nativeQuery = true)
  Optional<VagasTestes> findByCreat(Long id);
  
  @Query(value = "SELECT * FROM vagas_testes VagasTestes WHERE VagasTestes.ativo = true and VagasTestes.idcandidatura = ?1 and VagasTestes.idcandidato = ?2 order by VagasTestes.id", nativeQuery = true)
  List<VagasTestes> findByContents(Long idcandidatura, Long idcandidato);
  
}
