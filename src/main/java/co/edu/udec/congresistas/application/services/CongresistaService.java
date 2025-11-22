package co.edu.udec.congresistas.application.services;

import co.edu.udec.congresistas.domain.model.Congresista;
import co.edu.udec.congresistas.domain.ports.inbound.CongresistaServicePort;
import co.edu.udec.congresistas.domain.ports.outbound.CongresistaRepositoryPort;
import co.edu.udec.congresistas.domain.valueobjects.Correo;
import co.edu.udec.congresistas.domain.valueobjects.Nombre;

import java.util.List;

public class CongresistaService implements CongresistaServicePort {

    private final CongresistaRepositoryPort repositoryPort;

    public CongresistaService(CongresistaRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Congresista crearCongresista(String nombre, String correo) {
        Nombre nombreVO = new Nombre(nombre);
        Correo correoVO = new Correo(correo);

        Congresista congresista = new Congresista(null, nombreVO, correoVO);

        return repositoryPort.save(congresista);
    }

    @Override
    public List<Congresista> listarCongresistas() {
        return repositoryPort.findAll();
    }

    @Override
    public Congresista actualizarCongresista(Long id, String nombre, String correo) {
        Nombre nombreVO = new Nombre(nombre);
        Correo correoVO = new Correo(correo);

        Congresista congresista = new Congresista(id, nombreVO, correoVO);

        return repositoryPort.save(congresista);
    }

    @Override
    public void eliminarCongresista(Long id) {
        repositoryPort.deleteById(id);
    }
}
