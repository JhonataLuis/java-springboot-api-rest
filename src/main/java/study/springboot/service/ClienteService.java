package study.springboot.service;

import org.springframework.stereotype.Service;

/**
 * Interface que define o padrão Strategy no domínio de cliente. Com
 * isso, se necessário, podemos ter multiplas implementações dessa mesma
 * interface
 * 
 * @author Jhonata
 */

import study.springboot.model.Cliente;

@Service
public interface ClienteService {

    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    void inserir(Cliente cliente);

    void atualizar(Long id, Cliente cliente);

    void deletar(Long id);
}
