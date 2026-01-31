package mistareas.servicios;

import mistareas.entidades.Task;
import mistareas.repositorios.MisTareasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MisTareasServiceImpl implements MisTareasService {

    private final MisTareasRepository misTareasRepository;

    public MisTareasServiceImpl(MisTareasRepository misTareasRepository) {
        this.misTareasRepository = misTareasRepository;
    }
    @Override
    public void eliminarTarea(Long id) {
        misTareasRepository.eliminarTarea(id);
    }

    @Override
    public List<Task> getMisTareas() {
        return misTareasRepository.getMisTareas();
    }
    @Override
    public void crearTarea(Task task) {
        misTareasRepository.crearTarea(task);
    }

    @Override
    public void actualizarTarea(Task task) {
        misTareasRepository.actualizarTarea(task);
    }
    @Override
    public Task getMiTarea(Long id) {
        return misTareasRepository.getMiTarea(id);
    }

}
