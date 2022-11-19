
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

import com.selettraAPI.seletra.model.VagasAbertas;
import javax.persistence.Id;

@Repository
public interface VagasAbertasRepository extends JpaRepository<VagasAbertas, Id> {

  @Override
  @Query(value = "SELECT * FROM vagas_abertas VagasAbertas WHERE VagasAbertas.ativo = true order by VagasAbertas.id", nativeQuery = true)
  List<VagasAbertas> findAll();

  @Query(value = "SELECT * FROM vagas_abertas VagasAbertas WHERE VagasAbertas.ativo = true and VagasAbertas.id = ?1 order by VagasAbertas.id", nativeQuery = true)
  Optional<VagasAbertas> findById(Long id);
  
  @Query(value = "SELECT * FROM vagas_abertas VagasAbertas WHERE VagasAbertas.id = ?1 order by VagasAbertas.id", nativeQuery = true)
  Optional<VagasAbertas> findByCreat(Long id);
  
  @Query(value = "SELECT * FROM vagas_abertas VagasAbertas WHERE VagasAbertas.ativo = true and VagasAbertas.descricao = ?1 order by VagasAbertas.id", nativeQuery = true)
  List<VagasAbertas> findByContents(String descricao);
  
}
