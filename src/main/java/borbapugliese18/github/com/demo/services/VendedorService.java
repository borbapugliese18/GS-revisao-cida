package borbapugliese18.github.com.demo.services;

import borbapugliese18.github.com.demo.dto.VendedorDTO;
import borbapugliese18.github.com.demo.model.Vendedor;
import borbapugliese18.github.com.demo.repository.VendedorRepository;
import borbapugliese18.github.com.demo.services.exception.DatabaseException;
import borbapugliese18.github.com.demo.services.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository repository;

    @Transactional(readOnly = true)
    public List<VendedorDTO> findAll() {
        return repository.findAll().stream()
                .map(VendedorDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public VendedorDTO findById(Long id) {
        Vendedor entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado! Id: " + id)
        );

        return new VendedorDTO(entity);
    }

    @Transactional
    public VendedorDTO insert(VendedorDTO dto) {
        Vendedor entity = new Vendedor();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new VendedorDTO(entity);
    }

    @Transactional
    public VendedorDTO update(Long id, VendedorDTO dto) {
        try {
            Vendedor entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new VendedorDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado! Id: " + id);
        }
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado! Id: " + id);
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private void copyDtoToEntity(VendedorDTO dto, Vendedor entity) {
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());


    }

}
