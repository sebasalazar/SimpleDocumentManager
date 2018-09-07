package cl.sebastian.sdm.ws.manager.impl;

import cl.sebastian.sdm.ws.manager.DocumentManager;
import cl.sebastian.sdm.ws.model.Document;
import cl.sebastian.sdm.ws.model.Type;
import cl.sebastian.sdm.ws.repository.DocumentRepository;
import cl.sebastian.sdm.ws.repository.TypeRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.Resource;
import net.sf.jmimemagic.Magic;
import net.sf.jmimemagic.MagicException;
import net.sf.jmimemagic.MagicMatch;
import net.sf.jmimemagic.MagicMatchNotFoundException;
import net.sf.jmimemagic.MagicParseException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("documentManager")
public class DocumentManagerImpl implements DocumentManager, Serializable {

    private static final long serialVersionUID = 7528929585510665216L;

    @Resource(name = "typeRepository")
    private transient TypeRepository typeRepository;
    @Resource(name = "documentRepository")
    private transient DocumentRepository documentRepository;

    @Override
    public Document getDocument(final Long id) {
        Document doc = null;
        if (id != null && id > 0) {
            doc = documentRepository.findOne(id);
        }
        return doc;
    }

    @Override
    public Document getDocument(final String code) {
        Document doc = null;
        if (StringUtils.isNotBlank(code)) {
            doc = documentRepository.findByCode(code);
        }
        return doc;
    }

    @Override
    public List<Document> getDocuments() {
        List<Document> docs = documentRepository.findAll();
        if (docs == null) {
            docs = new ArrayList<>();
        }
        return docs;
    }

    @Override
    @Transactional
    public Document save(final Document document) {
        Document saved = null;
        if (document != null) {
            saved = documentRepository.save(document);
        }
        return saved;
    }

    @Override
    @Transactional
    public boolean delete(final Document document) {
        boolean ok = false;
        if (document != null) {
            documentRepository.delete(document);
            ok = true;
        }
        return ok;
    }

    @Override
    @Transactional
    public Document create(final String type, final String name, final String data) throws MagicException, MagicParseException, MagicMatchNotFoundException {
        Document doc = null;
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(name) && StringUtils.isNotBlank(data)) {
            Type typeObj = typeRepository.findByNameIgnoreCase(type);
            if (typeObj == null) {
                Type newObj = new Type();
                newObj.setName(type);
                typeObj = typeRepository.save(newObj);
            }

            byte[] bin = Base64.decodeBase64(data);
            MagicMatch match = Magic.getMagicMatch(bin);
            String mime = StringUtils.trimToNull(match.getMimeType());
            String uuid = UUID.randomUUID().toString();

            Document document = new Document();
            document.setCode(uuid);
            document.setFile(bin);
            document.setMime(mime);
            document.setName(name);
            document.setSize((long) bin.length);
            document.setType(typeObj);
            doc = documentRepository.save(document);
        }
        return doc;
    }
}
