package com.tony.WebPage.controller;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tony.WebPage.banco.BancoUsuario;
import com.tony.WebPage.entidade.Cadastro;

@RestController
public class UsuarioController {

    @Autowired
private BancoUsuario acessoBanco;

@GetMapping("/usuarios")
public ArrayList<Cadastro> listarUsuarios(){
    ArrayList <Cadastro> listadeUsuario = (ArrayList<Cadastro>)acessoBanco.findAll();
    return listadeUsuario;
}

@GetMapping("/usuario/{id}") 
public Optional<Cadastro> getById(@PathVariable int id){
   Optional<Cadastro> usuario = (Optional<Cadastro>) acessoBanco.findById(id);
   return usuario;
}

@DeleteMapping("/delete/{id}") 
public void deleteById(@PathVariable int id){
   acessoBanco.deleteById(id);
   
}
@PostMapping("/cadastrar")
public void cadastrarUsuario(@RequestBody Cadastro novoUsuario){
   acessoBanco.save(novoUsuario);
}

@PutMapping("/alterar/{id}")
public void alterarUsuario(@RequestBody Cadastro usuario, @PathVariable int id) {
    acessoBanco.findById(id).map((Function<? super Cadastro, ? extends Cadastro>) u ->{
         u.setUsuario (usuario.getUsuario());
         u.setEmail (usuario.getEmail());
         u.setSenha (usuario.getSenha());
        return u;
         
    });
    
}






}
