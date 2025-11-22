package co.edu.udec.congresistas.domain.ports.inbound;

import co.edu.udec.congresistas.domain.model.Congresista;

import java.util.List;

public interface CongresistaServicePort {

    Congresista crearCongresista(String nombre, String correo);

    List<Congresista> listarCongresistas();

    Congresista actualizarCongresista(Long id, String nombre, String correo);

    void eliminarCongresista(Long id);
}
