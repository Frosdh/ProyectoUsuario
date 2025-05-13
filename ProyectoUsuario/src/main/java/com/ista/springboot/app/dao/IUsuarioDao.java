package com.ista.springboot.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.ista.springboot.app.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

}
