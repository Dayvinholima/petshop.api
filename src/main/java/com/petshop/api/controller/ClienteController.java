package com.petshop.api.controller;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petshop.api.model.Cliente;
import com.petshop.api.repository.ClienteRepository;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
    
    @PostMapping    
    public Cliente cadastrarCliente(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    
    }


    @PutMapping("/{id}")
    public Cliente atualizarCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente){
        Optional<Cliente> clienteExistente = clienteRepository.findById(id);

        if(clienteExistente.isPresent()){
            Cliente clienteObj = clienteExistente.get();

            clienteObj.setNome(cliente.getNome());
            clienteObj.setSobreNome(cliente.getSobreNome());
            clienteObj.setGenero(cliente.getGenero());
            clienteObj.setEmail(cliente.getEmail());
            clienteObj.setSenha(cliente.getSenha());

        }
        return null;
    }

    @GetMapping
    public List<Cliente> ListarClientes(){
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional <Cliente> obterClientePeloId(@PathVariable("id") long id){
        return clienteRepository.findById(id);
    }
    
    @DeleteMapping("/{id}")
    public void deletarClientePeloId(@PathVariable("id") long id){
            clienteRepository.deleteById(id);
    }
    
    @GetMapping("/email/{email}")
    public Optional<Cliente> obterClientePeloEmail(@PathVariable("email") String email){
        return clienteRepository.findByEmail(email);
    }

    @GetMapping("/nome/{nome}")
    public Optional<List<Cliente>> obterClientePeloNome(@PathVariable("nome") String nome){
        return clienteRepository.findByNome(nome);
    }


    @Autowired
    private ClienteRepository clienteRepository;
}
