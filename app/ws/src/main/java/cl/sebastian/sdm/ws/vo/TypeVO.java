package cl.sebastian.sdm.ws.vo;

import cl.sebastian.sdm.ws.model.BaseBean;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TypeVO extends BaseBean {

    private String name = null;
    private String description = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
