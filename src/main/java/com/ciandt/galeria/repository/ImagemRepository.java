package com.ciandt.galeria.repository;

import com.ciandt.galeria.enums.TipoImagem;
import com.ciandt.galeria.model.Imagem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagemRepository extends JpaRepository<Imagem, Long> {
    @Query("Select i FROM Imagem i " +
            "WHERE (:nome IS NULL OR UPPER(i.nome) LIKE UPPER('%'||:nome||'%')) " +
            "AND (:tipo IS NULL OR i.tipoImagem = :tipo) ")
    Page<Imagem> findAllByFiltro(String nome, TipoImagem tipo, Pageable pageable);
}
