package br.com.zup.flyway.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.flyway.example.domains.Livro;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long> {

}
