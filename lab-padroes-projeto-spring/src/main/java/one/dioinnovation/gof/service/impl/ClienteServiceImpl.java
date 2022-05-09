package one.dioinnovation.gof.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.dioinnovation.gof.model.Cliente;
import one.dioinnovation.gof.model.ClienteRepository;
import one.dioinnovation.gof.model.Endereco;
import one.dioinnovation.gof.model.EnderecoRepository;
import one.dioinnovation.gof.service.ViaCepService;
import one.dioinnovation.gof.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	// Singleton: Injetar os componentes do Spring com @Autowired.
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ViaCepService viaCepService;
	
	// Strategy: Implementar os métodos definidos na interface.
	// Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

	@Override
	public Iterable<Cliente> buscarTodos() {
		// Buscar todos os Clientes.
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		// Buscar Cliente por ID.
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if(cliente.isPresent()) {
			return cliente.get();
		}
		return null;
	}

	@Override
	public void inserir(Cliente cliente) {
		salvarClienteComCep(cliente);
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		// Buscar Cliente por ID, caso exista:
		Optional<Cliente> clienteBd = clienteRepository.findById(id);
		if(clienteBd.isPresent()) {
			salvarClienteComCep(cliente);
		}
	}

	@Override
	public void deletar(Long id) {
		// Deletar Cliente por ID.
		clienteRepository.deleteById(id);
	}

	private void salvarClienteComCep(Cliente cliente) {
		String cep = cliente.getEndereco().getCep();
	 	Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
	 		Endereco novoEndereco = viaCepService.consultarCep(cep);
	 		enderecoRepository.save(novoEndereco);
	 		return null;
	 	});
	 	cliente.setEndereco(endereco);
	 	clienteRepository.save(cliente);
	}

}
