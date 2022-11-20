
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

import com.selettraAPI.seletra.model.Testes;
import javax.persistence.Id;

@Repository
public interface TestesRepository extends JpaRepository<Testes, Id> {

  @Override
  @Query(value = "SELECT * FROM testes Testes WHERE Testes.ativo = true order by Testes.id", nativeQuery = true)
  List<Testes> findAll();

  @Query(value = "SELECT * FROM testes Testes WHERE Testes.ativo = true and Testes.id = ?1 order by Testes.id", nativeQuery = true)
  Optional<Testes> findById(Long id);
  
  @Query(value = "SELECT * FROM testes Testes WHERE Testes.id = ?1 order by Testes.id", nativeQuery = true)
  Optional<Testes> findByCreat(Long id);
  
  @Query(value = "SELECT * FROM testes Testes WHERE Testes.ativo = true and Testes.idcandidato = ?1 and Testes.idvaga = ?2 order by Testes.id", nativeQuery = true)
  List<Testes> findByContents(String descricao);
  
}
