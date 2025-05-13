package com.ista.springboot.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ista.springboot.app.entity.Usuario;

@Service
public interface IUsuarioService {

    List<Usuario> findAll();

    Usuario findById(Long id);

    Usuario save(Usuario usuario);

    void delete(Long id);
}
