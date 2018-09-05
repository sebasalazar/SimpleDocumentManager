package cl.sebastian.sdm.ws.repository;

import cl.sebastian.sdm.ws.model.Type;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

@Resource(name = "typeRepository")
public interface TypeRepository extends JpaRepository<Type, Long> {

    /**
     * Realiza un select sobre la tabla de tipos
     *
     * @param name Nombre por el cuál buscar.
     * @return La fila encontrada
     */
    public Type findByNameIgnoreCase(String name);
}
