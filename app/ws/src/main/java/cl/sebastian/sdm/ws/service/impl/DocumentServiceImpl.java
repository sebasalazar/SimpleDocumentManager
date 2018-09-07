package cl.sebastian.sdm.ws.service.impl;

import cl.sebastian.sdm.ws.manager.DocumentManager;
import cl.sebastian.sdm.ws.model.Document;
import cl.sebastian.sdm.ws.service.DocumentService;
import cl.sebastian.sdm.ws.vo.DocumentVO;
import cl.sebastian.sdm.ws.vo.ResponseVO;
import cl.sebastian.sdm.ws.vo.TypeVO;
import java.io.Serializable;
import javax.annotation.Resource;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("documentService")
public class DocumentServiceImpl implements DocumentService, Serializable {

    private static final long serialVersionUID = 6794137678804810752L;

    @Resource(name = "documentManager")
    private transient DocumentManager documentManager;

    private static final Logger LOGGER = LoggerFactory.getLogger(DocumentServiceImpl.class);

    @Override
    public ResponseVO save(final String type, final String name, final String base64data) {
        ResponseVO vo = null;
        try {
            if (StringUtils.isNotBlank(base64data)) {
                Document doc = documentManager.create(type, name, base64data);
                vo = new ResponseVO();
                if (doc != null) {
                    vo.setCode(doc.getCode());
                    vo.setOk(true);
                    vo.setDescription("Success");
                } else {
                    vo.setCode("ERROR");
                    vo.setOk(false);
                    vo.setDescription("Failed");
                }
            }
        } catch (Exception e) {
            vo = new ResponseVO(false, "ERROR", String.format("An error has happend: %s", e.toString()));
            LOGGER.error("Error al guardar: {}", e.toString());
            LOGGER.debug("Error al guardar: {}", e.toString(), e);
        }
        return vo;
    }

    @Override
    public DocumentVO getDocument(final String code) {
        DocumentVO vo = null;
        try {
            if (StringUtils.isNotBlank(code)) {
                Document doc = documentManager.getDocument(code);
                if (doc != null) {
                    TypeVO tvo = new TypeVO();
                    tvo.setName(doc.getType().getName());
                    tvo.setDescription(doc.getType().getDescription());

                    String data = String.format("data:%s;base64,%s", doc.getMime(), Base64.encodeBase64String(doc.getFile()));
                    vo = new DocumentVO();
                    vo.setCode(doc.getCode());
                    vo.setData(data);
                    vo.setName(doc.getName());
                    vo.setType(tvo);
                }
            }
        } catch (Exception e) {
            vo = null;
            LOGGER.error("Error al guardar: {}", e.toString());
            LOGGER.debug("Error al guardar: {}", e.toString(), e);
        }
        return vo;
    }

}
