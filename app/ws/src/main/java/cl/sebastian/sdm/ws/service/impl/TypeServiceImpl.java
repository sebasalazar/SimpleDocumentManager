package cl.sebastian.sdm.ws.service.impl;

import cl.sebastian.sdm.ws.manager.TypeManager;
import cl.sebastian.sdm.ws.model.Type;
import cl.sebastian.sdm.ws.service.TypeService;
import java.io.Serializable;
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
    public Type create(final String name, final String description) {
        Type type = null;
        try {
            if (StringUtils.isNotBlank(name) && StringUtils.isNotBlank(description)) {
                type = typeManager.create(name, description);
            }
        } catch (Exception e) {
            type = null;
            LOGGER.error("Error al crear tipo: {}", e.toString());
            LOGGER.debug("Error al crear tipo: {}", e.toString(), e);
        }
        return type;
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
