package study.springboot.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.springboot.model.Cliente;
import study.springboot.model.Endereco;
import study.springboot.repository.ClienteRepository;
import study.springboot.repository.EnderecoRepository;
import study.springboot.service.ClienteService;
import study.springboot.service.ViaCepService;

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

    @Autowired
    private EnderecoRepository enderecoRepository;

    
    @Autowired
    private ViaCepService viaCepService;

     //TODO Strategy: Implementar os métodos definidos na interface.
    //TODO Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        //Buscar todos os clientes
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
       salvarClienteComCep(cliente);//ação usada do método abaixo
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        //Buscar cliente por id, caso exista
        Optional<Cliente> clienteById = clienteRepository.findById(id);
        if(clienteById.isPresent()){
            salvarClienteComCep(cliente);
        }
    }

    private void salvarClienteComCep(Cliente cliente){
        //Verificar se o endereço do Cliente já existe (pelo CEP)
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            //Caso não exista, integrar com o ViaCep e persistir o retorno.
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        //Inserir Cliente, vinculando o Endereço (novo ou existente).
        clienteRepository.save(cliente);
    }

    @Override
    public void deletar(Long id) {
       //Deletar cliente por id
       clienteRepository.deleteById(id);
    }

}
