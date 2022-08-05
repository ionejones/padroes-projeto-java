package service;

import org.springframework.beans.factory.annotation.Autowired;

import model.Cliente;
import model.ClienteRepository;
import model.Endereco;
import model.EnderecoRepository;

public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ViaCepService viaCepService;

	@Override
	public Iterable <Cliente> buscarTodos() {
	   return clienteRepository.findAll();	
	}
	
	@Override
	public Cliente buscarPorId(Long id) {
		java.util.Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}
	
	@Override
	public void inserir (Cliente cliente) {
		String cep = cliente.getEndereco().getCep();
		Endereco endereco =  enderecoRepository.findById(cep).orElseGet(() -> {
			Endereco novoEndereco =  viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		cliente.setEndereco(endereco);
		clienteRepository.save(cliente);

	};
	
	@Override
	public void atualizar (Long id, Cliente cliente) {
		java.util.Optional<Cliente> clienteBd = clienteRepository.findById(id);
		if (clienteBd.isPresent() ) {
			String cep = cliente.getEndereco().getCep();
			Endereco endereco =  enderecoRepository.findById(cep).orElseGet(() -> {
				Endereco novoEndereco =  viaCepService.consultarCep(cep);
				enderecoRepository.save(novoEndereco);
				return novoEndereco;
			});
			cliente.setEndereco(endereco);
			clienteRepository.save(cliente);

		}

	};
	
	@Override
	public void deletar (Long id) {
		clienteRepository.deleteById(id);
		
	};
}
