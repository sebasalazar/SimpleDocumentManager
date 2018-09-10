package cl.sebastian.sdm.ws.manager.impl;

import cl.sebastian.sdm.ws.manager.TypeManager;
import cl.sebastian.sdm.ws.model.Type;
import cl.sebastian.sdm.ws.repository.TypeRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("typeManager")
public class TypeManagerImpl implements TypeManager, Serializable {

    private static final long serialVersionUID = 3994539769071704064L;
    @Resource(name = "typeRepository")
    private transient TypeRepository typeRepository;

    @Override
    public Type getType(final Long id) {
        Type type = null;
        if (id != null && id > 0) {
            type = typeRepository.findOne(id);
        }
        return type;
    }

    @Override
    public Type getType(final String name) {
        Type type = null;
        if (StringUtils.isNotBlank(name)) {
            type = typeRepository.findByNameIgnoreCase(name);
        }
        return type;
    }

    @Override
    public List<Type> getTypes() {
        List<Type> types = typeRepository.findAll();
        if (types == null) {
            types = new ArrayList<>();
        }
        return types;
    }

    @Override
    @Transactional
    public Type save(final Type type) {
        Type saved = null;
        if (type != null) {
            saved = typeRepository.save(type);
        }
        return saved;
    }

    @Override
    @Transactional
    public boolean delete(final Type type) {
        boolean ok = false;
        if (type != null) {
            typeRepository.delete(type);
            ok = true;
        }
        return ok;
    }

    @Override
    @Transactional
    public Type create(final String name, final String description) {
        Type type = null;
        if (StringUtils.isNotBlank(name)) {
            Type result = typeRepository.findByNameIgnoreCase(name);
            if (result == null) {
                result = new Type();
                result.setName(name);
                result.setDescription(description);
            } else {
                result.setName(name);
                result.setDescription(description);
            }
            type = typeRepository.save(result);
        }
        return type;
    }

}
