package com.avaliacao.pigbank.cliente.services;

import com.avaliacao.pigbank.cliente.model.Cliente;
import com.avaliacao.pigbank.cliente.model.ClienteDTO;
import com.avaliacao.pigbank.cliente.repositoies.ClienteRepository;
import com.avaliacao.pigbank.exceptions.ExceptionDataIntegrityViolation;
import com.avaliacao.pigbank.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente buscarCliente(Long id){
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrato! ID: " + id +
                ", Tipo: " + Cliente.class.getName()));

    }



    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    public Cliente gerarCliente(Cliente cliente){
        cliente.setId(null);
        return clienteRepository.save(cliente);

    }

    public Cliente atualizarCliente(Long id, ClienteDTO clienteDto) {
        Cliente upCliente = buscarCliente(id);
        upCliente.setNome(clienteDto.getNome());
        upCliente.setCnpj(clienteDto.getCnpj());
        upCliente.setCpf(clienteDto.getCpf());
        upCliente.setEmail(clienteDto.getEmail());
        upCliente.setEndereco(clienteDto.getEndereco());
        upCliente.setTelefone(clienteDto.getTelefone());
        return clienteRepository.save(upCliente);
    }

    public void deletarCliente(Long id) {

        //Cliente cliente = buscarCliente(id);
        //clienteRepository.delete(cliente);

        buscarCliente(id);
        try{
            clienteRepository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new ExceptionDataIntegrityViolation("Existe uma associação entre contas e clientes." +
                    " Este procedimento não pode ser concluído!");
        }
    }
}
