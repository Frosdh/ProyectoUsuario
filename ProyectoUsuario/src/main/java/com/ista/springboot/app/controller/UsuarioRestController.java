package com.ista.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ista.springboot.app.entity.Usuario;
import com.ista.springboot.app.service.IUsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioRestController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/usuario")
    public List<Usuario> index() {
        return usuarioService.findAll();
    }

    @PostMapping("/usuario")
    public Usuario save(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario != null) {
            usuarioService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<Usuario> update(@RequestBody Usuario usuarioActualizado, @PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario != null) {
            usuario.setNombre(usuarioActualizado.getNombre());
            usuario.setClave(usuarioActualizado.getClave());
            usuario.setEmail(usuarioActualizado.getEmail());
            usuario.setEstado(usuarioActualizado.getEstado());
            return ResponseEntity.ok(usuarioService.save(usuario));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
