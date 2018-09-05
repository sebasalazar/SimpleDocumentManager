package cl.sebastian.sdm.ws.service;

import cl.sebastian.sdm.ws.model.Type;

public interface TypeService {

    /**
     *
     * @param name
     * @param description
     * @return
     */
    public Type create(final String name, final String description);

    /**
     *
     * @param name
     * @return
     */
    public boolean delete(final String name);
}
