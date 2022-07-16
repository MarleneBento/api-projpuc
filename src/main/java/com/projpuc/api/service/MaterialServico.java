package com.projpuc.api.service;

import com.projpuc.api.model.Material;
import com.projpuc.api.repository.MaterialRepositorio;
import com.projpuc.api.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class MaterialServico {

    @Autowired
    private MaterialRepositorio repositorio;

    public List<Material> listaTodosMateriais() { return repositorio.findAll();
    }

    public Material buscarPorId(Long id) {
        Optional<Material> obj = repositorio.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));

    }

    public Material atualizar(Long id, Material obj) {
        try {
            Material entity = repositorio.getOne(id);
            updateData(entity, obj);
            return repositorio.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public Material inserir(Material obj) {
        return repositorio.save(obj);
    }

    private void updateData(Material entity, Material obj) {
        entity.setDescricao(obj.getDescricao());
        entity.setMarca(obj.getMarca());
        entity.setQuantidade(obj.getQuantidade());
        entity.setCusto(obj.getCusto());
        entity.setEstoque(obj.getEstoque());
       }
}
