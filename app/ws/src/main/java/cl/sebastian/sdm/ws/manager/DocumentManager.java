package cl.sebastian.sdm.ws.manager;

import cl.sebastian.sdm.ws.model.Document;
import java.util.List;
import net.sf.jmimemagic.MagicException;
import net.sf.jmimemagic.MagicMatchNotFoundException;
import net.sf.jmimemagic.MagicParseException;

public interface DocumentManager {

    /**
     *
     * @param id identificador del documento
     * @return El objeto del documento
     */
    public Document getDocument(final Long id);

    /**
     *
     * @return El listado del documento
     */
    public List<Document> getDocuments();

    /**
     *
     * @param document Documento a Persistir
     * @return El objeto persistido
     */
    public Document save(final Document document);

    /**
     *
     * @param document Documento a eliminar
     * @return true si el documento se eliminó
     */
    public boolean delete(final Document document);

    /**
     *
     * @param type Tipo
     * @param name Nombre del archivo
     * @param data datos encodeados
     * @return El documento persistido.
     * @throws net.sf.jmimemagic.MagicException
     * @throws net.sf.jmimemagic.MagicParseException
     * @throws net.sf.jmimemagic.MagicMatchNotFoundException
     */
    public Document create(final String type, final String name, final String data) throws MagicException, MagicParseException, MagicMatchNotFoundException;
}
