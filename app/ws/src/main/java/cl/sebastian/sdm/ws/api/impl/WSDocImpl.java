package cl.sebastian.sdm.ws.api.impl;

import cl.sebastian.sdm.ws.api.WSDoc;
import cl.sebastian.sdm.ws.exception.SdmException;
import cl.sebastian.sdm.ws.service.DocumentService;
import cl.sebastian.sdm.ws.vo.DocumentVO;
import cl.sebastian.sdm.ws.vo.ResponseVO;
import java.io.Serializable;
import javax.annotation.Resource;
import javax.jws.WebService;

@WebService(endpointInterface = "cl.sebastian.sdm.ws.api.WSDoc")
public class WSDocImpl implements WSDoc, Serializable {

    private static final long serialVersionUID = 7573711519194335232L;

    @Resource(name = "documentService")
    private transient DocumentService documentService;

    @Override
    public ResponseVO upload(String type, String name, String base64data) {
        return documentService.save(type, name, base64data);
    }

    @Override
    public DocumentVO download(String code) throws SdmException {
        DocumentVO document = documentService.getDocument(code);
        if (document == null) {
            throw new SdmException("The document hasn't loaded");
        }
        return document;
    }

}
