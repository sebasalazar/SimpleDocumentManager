package cl.sebastian.sdm.ws.vo;

import cl.sebastian.sdm.ws.model.BaseBean;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DocumentVO extends BaseBean {

    private TypeVO type = null;
    private String name = null;
    private String data = null;

    public TypeVO getType() {
        return type;
    }

    public void setType(TypeVO type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
