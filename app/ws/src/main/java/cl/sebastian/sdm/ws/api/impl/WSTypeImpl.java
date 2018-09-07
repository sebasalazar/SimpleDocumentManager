package cl.sebastian.sdm.ws.api.impl;

import cl.sebastian.sdm.ws.api.WSType;
import cl.sebastian.sdm.ws.service.TypeService;
import cl.sebastian.sdm.ws.vo.ResponseVO;
import java.io.Serializable;
import javax.annotation.Resource;
import javax.jws.WebService;

@WebService(endpointInterface = "cl.sebastian.sdm.ws.api.WSType")
public class WSTypeImpl implements WSType, Serializable {

    private static final long serialVersionUID = 7880717480782925824L;

    @Resource(name = "typeService")
    private transient TypeService typeService;

    @Override
    public ResponseVO create(String name, String description) {
        return typeService.create(name, description);
    }
}
