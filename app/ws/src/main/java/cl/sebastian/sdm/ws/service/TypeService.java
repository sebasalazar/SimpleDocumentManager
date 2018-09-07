package cl.sebastian.sdm.ws.service;

import cl.sebastian.sdm.ws.vo.ResponseVO;

public interface TypeService {

    /**
     *
     * @param name
     * @param description
     * @return
     */
    public ResponseVO create(final String name, final String description);

    /**
     *
     * @param name
     * @return
     */
    public boolean delete(final String name);
}
