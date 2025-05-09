package study.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import study.springboot.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, String>{

}
