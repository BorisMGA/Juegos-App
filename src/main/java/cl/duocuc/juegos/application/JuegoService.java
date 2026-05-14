package cl.duocuc.juegos.application;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.duocuc.juegos.domain.Juego;
import cl.duocuc.juegos.infrastructure.mapper.JuegoMapper;
import cl.duocuc.juegos.infrastructure.repository.JuegoRepository;

@Service
public class JuegoService {

    private final JuegoRepository repo;

    public JuegoService(JuegoRepository repo) {
        this.repo = repo;
    }

    public List<Juego> listar() {
        return repo.findAll().stream().map(JuegoMapper::toDomain).toList();
    }

    public Juego crear(Juego j) {
        return JuegoMapper.toDomain(repo.save(JuegoMapper.toEntity(j)));
    }

    public Juego actualizar(Long id, Juego j) {
        j.setId(id);
        return crear(j);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
