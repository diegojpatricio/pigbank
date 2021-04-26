package com.avaliacao.pigbank.conta.services;



import com.avaliacao.pigbank.cliente.model.Cliente;
import com.avaliacao.pigbank.cliente.services.ClienteService;
import com.avaliacao.pigbank.conta.model.Conta;
import com.avaliacao.pigbank.conta.repositories.ContaRepository;
import com.avaliacao.pigbank.exceptions.ExceptionDataIntegrityViolation;
import com.avaliacao.pigbank.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private ClienteService clienteService;




    public Conta buscarConta(Long id){
        Optional<Conta> obj = contaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrato! ID: " + id +
                ", Tipo: " + Conta.class.getName()));

    }


    public List<Conta> listarConta(Long id_cliente) {
        clienteService.buscarCliente(id_cliente);
        return contaRepository.buscarClienteId(id_cliente);
    }

    public Conta atualizarConta(Long id, Conta conta) {
        Conta upConta = buscarConta(id);
        upDate(upConta, conta);
        return contaRepository.save(upConta);
    }

    private void upDate(Conta upConta, Conta conta) {
        upConta.setSaldo(conta.getSaldo());
        upConta.setAgencia(conta.getAgencia());
        upConta.setNumeroConta(conta.getNumeroConta());
        upConta.setTipoConta(conta.getTipoConta());
        upConta.setCliente(conta.getCliente());
    }

    public Conta gerarConta(Long id_cliente, Conta conta) {
        conta.setId(null);
        Cliente cliente = clienteService.buscarCliente(id_cliente);
        conta.setCliente(cliente);
        return contaRepository.save(conta);
    }

    public void deleteConta(Long id) {
        Conta idconta = buscarConta(id);
        Cliente idClienteConta = idconta.getCliente();


        try{
            clienteService.deletarCliente(idClienteConta.getId());
            contaRepository.deleteById(id);
        }

        catch (DataIntegrityViolationException e){
            throw new ExceptionDataIntegrityViolation("Existe uma associação entre contas e clientes." +
                    " Este procedimento não pode ser concluído!");
        }


    }
}
