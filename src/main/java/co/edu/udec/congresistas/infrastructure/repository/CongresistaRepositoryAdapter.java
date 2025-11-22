package co.edu.udec.congresistas.infrastructure.repository;

import co.edu.udec.congresistas.domain.model.Congresista;
import co.edu.udec.congresistas.domain.ports.outbound.CongresistaRepositoryPort;
import co.edu.udec.congresistas.domain.valueobjects.Correo;
import co.edu.udec.congresistas.domain.valueobjects.Nombre;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CongresistaRepositoryAdapter implements CongresistaRepositoryPort {

    private final SpringDataCongresistaRepository repository;

    public CongresistaRepositoryAdapter(SpringDataCongresistaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Congresista save(Congresista congresista) {

        CongresistaEntity entity = new CongresistaEntity();
        entity.setNombre(congresista.getNombre().getValor());
        entity.setCorreo(congresista.getCorreo().getDireccion());

        CongresistaEntity saved = repository.save(entity);

        return new Congresista(
                saved.getId(),
                new Nombre(saved.getNombre()),
                new Correo(saved.getCorreo())
        );
    }

    @Override
    public List<Congresista> findAll() {
        return repository.findAll().stream()
                .map(e -> new Congresista(
                        e.getId(),
                        new Nombre(e.getNombre()),
                        new Correo(e.getCorreo())
                )).toList();
    }

    @Override
    public Optional<Congresista> findById(Long id) {
        return repository.findById(id)
                .map(e -> new Congresista(
                        e.getId(),
                        new Nombre(e.getNombre()),
                        new Correo(e.getCorreo())
                ));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
