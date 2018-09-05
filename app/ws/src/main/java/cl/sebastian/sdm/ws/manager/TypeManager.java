package cl.sebastian.sdm.ws.manager;

import cl.sebastian.sdm.ws.model.Type;
import java.util.List;

public interface TypeManager {

    /**
     *
     * @param id Identificador numérico del tipo
     * @return El objeto del tipo
     */
    public Type getType(final Long id);

    /**
     *
     * @param name Nombre del tipo
     * @return El objeto del tipo
     */
    public Type getType(final String name);

    /**
     *
     * @return El listado de tipos en la base de datos.
     */
    public List<Type> getTypes();

    /**
     *
     * @param type objeto a guardar
     * @return El objeto almacenado
     */
    public Type save(final Type type);

    /**
     *
     * @param type objeto a eliminar
     * @return true si se eliminó false en cualquier otro caso
     */
    public boolean delete(final Type type);
    
    /**
     * 
     * @param name Nombre del tipo
     * @param description Descripción del tipo
     * @return El objeto del tipo
     */
    public Type create(final String name, final String description);
}
