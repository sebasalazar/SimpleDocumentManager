package cl.sebastian.sdm.ws.api;

import cl.sebastian.sdm.ws.exception.SdmException;
import cl.sebastian.sdm.ws.vo.DocumentVO;
import cl.sebastian.sdm.ws.vo.ResponseVO;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

@WebService
public interface WSDoc {

    /**
     *
     * @param type Tipo al que asociar el archivo
     * @param name Nombre del archivo
     * @param base64data Binario encodeado en base64
     * @return Objeto con la respuesta
     */
    public ResponseVO upload(@WebParam(name = "type") @XmlElement(required = true, nillable = false) String type,
            @WebParam(name = "name") @XmlElement(required = true, nillable = false) String name,
            @WebParam(name = "base64data") @XmlElement(required = true, nillable = false) String base64data);

    /**
     *
     * @param code Código
     * @return El documento con los datos encodeados
     */
    public DocumentVO download(@WebParam(name = "code") @XmlElement(required = true, nillable = false) String code) throws SdmException;

}
