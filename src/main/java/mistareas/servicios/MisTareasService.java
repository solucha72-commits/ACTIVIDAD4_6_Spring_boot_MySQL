package mistareas.servicios;

import java.util.List;
import mistareas.entidades.Task;

public interface MisTareasService {

    List<Task> getMisTareas();

    Task getMiTarea(Long id);

    void crearTarea(Task task);

    void actualizarTarea(Task task);

    void eliminarTarea(Long id);
}
