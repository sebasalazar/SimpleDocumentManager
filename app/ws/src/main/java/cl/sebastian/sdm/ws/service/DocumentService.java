package cl.sebastian.sdm.ws.service;

import cl.sebastian.sdm.ws.model.Document;
import cl.sebastian.sdm.ws.vo.DocumentVO;

public interface DocumentService {

    /**
     *
     * @param type Tipo
     * @param name Nombre del archivo
     * @param base64data Binario encodeado en base 64
     * @return El objeto persistido
     */
    public DocumentVO save(final String type, final String name, final String base64data);

}
