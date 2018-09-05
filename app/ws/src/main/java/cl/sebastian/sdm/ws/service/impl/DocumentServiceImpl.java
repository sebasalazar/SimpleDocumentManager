package cl.sebastian.sdm.ws.service.impl;

import cl.sebastian.sdm.ws.manager.DocumentManager;
import cl.sebastian.sdm.ws.model.Document;
import cl.sebastian.sdm.ws.service.DocumentService;
import cl.sebastian.sdm.ws.vo.DocumentVO;
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
    public DocumentVO save(final String type, final String name, final String base64data) {
        DocumentVO vo = null;
        try {
            if (StringUtils.isNotBlank(base64data)) {
                Document doc = documentManager.create(type, name, base64data);
                if (doc != null) {
                    TypeVO tvo = new TypeVO();
                    tvo.setName(doc.getType().getName());
                    tvo.setDescription(doc.getType().getDescription());
                    
                    String data = String.format("data:%s;base64,%s", doc.getMime(), Base64.encodeBase64String(doc.getFile()));
                    vo = new DocumentVO();
                    vo.setData(data);
                    vo.setName(name);
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
