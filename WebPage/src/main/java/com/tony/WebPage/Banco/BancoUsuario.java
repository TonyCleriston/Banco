package com.tony.WebPage.Banco;

import org.springframework.data.repository.CrudRepository;

import com.tony.WebPage.entidade.Cadastro;

public interface BancoUsuario  extends CrudRepository< Integer , Cadastro >{
    
}
