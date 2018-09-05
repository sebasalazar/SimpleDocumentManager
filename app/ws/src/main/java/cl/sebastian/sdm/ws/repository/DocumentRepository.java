package cl.sebastian.sdm.ws.repository;

import cl.sebastian.sdm.ws.model.Document;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

@Resource(name = "documentRepository")
public interface DocumentRepository extends JpaRepository<Document, Long> {

    /**
     *
     * @param code Código para buscar
     * @return La fila que corresponde al código usado.
     */
    public Document findByCode(String code);
}
