package study.springboot.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.springboot.model.Cliente;
import study.springboot.repository.ClienteRepository;
import study.springboot.service.ClienteService;

/**
 * Implementação da Strategy Link ClienteService, a qual pode ser
 * injetada pelo Spring via link Autowired. Com isso, como essa classe é um
 * link Service, ela será tratada como um Singleton.
 * 
 * @author Jhonata
 */

@Service
public class ClienteServiceImpl implements ClienteService{

    //TODO Singleton: Injetar os componentes dos Spring com Autowired
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    @Override
    public void inserir(Cliente cliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inserir'");
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public void deletar(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletar'");
    }

}
