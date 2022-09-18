
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

import com.selettraAPI.seletra.model.Endereco;
import javax.persistence.Id;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Id> {

  @Override
  @Query(value = "SELECT * FROM enderecos Endereco WHERE Endereco.ativo = true order by Endereco.id", nativeQuery = true)
  List<Endereco> findAll();

  @Query(value = "SELECT * FROM enderecos Endereco WHERE Endereco.ativo = true and Endereco.id = ?1 order by Endereco.id", nativeQuery = true)
  Optional<Endereco> findById(Long id);
  
  @Query(value = "SELECT * FROM enderecos Endereco WHERE Endereco.id = ?1 order by Endereco.id", nativeQuery = true)
  Optional<Endereco> findByCreat(Long id);
  
  @Query(value = "SELECT * FROM enderecos Endereco WHERE Endereco.ativo = true and Endereco.idcandidato = ?1 order by Endereco.id", nativeQuery = true)
  List<Endereco> findByContents(Long idcandidato);
  
}
