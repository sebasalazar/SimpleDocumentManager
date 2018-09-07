package cl.sebastian.sdm.ws.api;

import cl.sebastian.sdm.ws.vo.ResponseVO;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

@WebService
public interface WSType {

    /**
     *
     * @param name Nombre del tipo
     * @param description Descripción
     * @return Un tipo o una excepción
     */
    public ResponseVO create(@WebParam(name = "name") @XmlElement(required = true, nillable = false) String name,
            @WebParam(name = "description") @XmlElement(required = false, nillable = true) String description);

}
