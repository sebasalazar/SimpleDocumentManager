package cl.sebastian.sdm.ws.service;

import cl.sebastian.sdm.ws.vo.DocumentVO;
import cl.sebastian.sdm.ws.vo.ResponseVO;

public interface DocumentService {

    /**
     *
     * @param type Tipo
     * @param name Nombre del archivo
     * @param base64data Binario encodeado en base 64
     * @return El objeto persistido
     */
    public ResponseVO save(final String type, final String name, final String base64data);
    
    /**
     * 
     * @param code Código único del documento
     * @return El documento
     */
    public DocumentVO getDocument(final String code);

}
