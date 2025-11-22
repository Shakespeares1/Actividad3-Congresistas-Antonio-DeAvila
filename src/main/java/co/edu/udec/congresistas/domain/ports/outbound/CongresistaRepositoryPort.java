package co.edu.udec.congresistas.domain.ports.outbound;

import co.edu.udec.congresistas.domain.model.Congresista;

import java.util.List;
import java.util.Optional;

public interface CongresistaRepositoryPort {

    Congresista save(Congresista congresista);

    List<Congresista> findAll();

    Optional<Congresista> findById(Long id);

    void deleteById(Long id);
}
