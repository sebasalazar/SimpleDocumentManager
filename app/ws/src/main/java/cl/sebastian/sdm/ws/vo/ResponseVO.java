package cl.sebastian.sdm.ws.vo;

import cl.sebastian.sdm.ws.model.BaseBean;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseVO extends BaseBean {

    private boolean ok = false;
    private String code = null;
    private String description = null;

    public ResponseVO() {
        this.ok = false;
        this.code = null;
        this.description = null;
    }

    public ResponseVO(boolean ok, String code, String description) {
        this.ok = ok;
        this.code = code;
        this.description = description;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
