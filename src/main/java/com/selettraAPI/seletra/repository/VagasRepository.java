
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

import com.selettraAPI.seletra.model.Vagas;
import javax.persistence.Id;

@Repository
public interface VagasRepository extends JpaRepository<Vagas, Id> {

  @Override
  @Query(value = "SELECT * FROM vagas Vagas WHERE Vagas.ativo = true order by Vagas.id", nativeQuery = true)
  List<Vagas> findAll();

  @Query(value = "SELECT * FROM vagas Vagas WHERE Vagas.ativo = true and Vagas.id = ?1 order by Vagas.id", nativeQuery = true)
  Optional<Vagas> findById(Long id);
  
  @Query(value = "SELECT * FROM vagas Vagas WHERE Vagas.id = ?1 order by Vagas.id", nativeQuery = true)
  Optional<Vagas> findByCreat(Long id);
  
  @Query(value = "SELECT * FROM vagas Vagas WHERE Vagas.ativo = true and Vagas.nome = ?1 order by Vagas.id", nativeQuery = true)
  List<Vagas> findByContents(String nome);
  
}
