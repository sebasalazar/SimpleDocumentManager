package cl.sebastian.sdm.ws.service.impl;

import cl.sebastian.sdm.ws.manager.TypeManager;
import cl.sebastian.sdm.ws.model.Type;
import cl.sebastian.sdm.ws.service.TypeService;
import cl.sebastian.sdm.ws.vo.ResponseVO;
import java.io.Serializable;
import java.util.UUID;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("typeService")
public class TypeServiceImpl implements TypeService, Serializable {

    private static final long serialVersionUID = 3732840187605861376L;

    @Resource(name = "typeManager")
    private transient TypeManager typeManager;
    private static final Logger LOGGER = LoggerFactory.getLogger(TypeServiceImpl.class);

    @Override
    public ResponseVO create(final String name, final String description) {
        ResponseVO vo = null;
        try {
            if (StringUtils.isNotBlank(name) && StringUtils.isNotBlank(description)) {
                Type type = typeManager.create(name, description);
                vo = new ResponseVO();
                if (type != null) {
                    vo.setCode(UUID.randomUUID().toString());
                    vo.setDescription("Success");
                    vo.setOk(true);
                } else {
                    vo.setCode("Error");
                    vo.setDescription("Failed");
                    vo.setOk(false);
                }
            }
        } catch (Exception e) {
            vo = new ResponseVO(false, "Error", String.format("An error has happend: %s", e.toString()));
            LOGGER.error("Error al crear tipo: {}", e.toString());
            LOGGER.debug("Error al crear tipo: {}", e.toString(), e);
        }
        return vo;
    }

    @Override
    public boolean delete(final String name) {
        boolean ok = false;
        try {
            if (StringUtils.isNotBlank(name)) {
                Type type = typeManager.getType(name);
                if (type != null) {
                    ok = typeManager.delete(type);
                }
            }
        } catch (Exception e) {
            ok = false;
            LOGGER.error("Error al eliminar tipo: {}", e.toString());
            LOGGER.debug("Error al eliminar tipo: {}", e.toString(), e);
        }
        return ok;
    }
}
