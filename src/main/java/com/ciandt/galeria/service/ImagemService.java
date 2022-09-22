package com.ciandt.galeria.service;

import com.ciandt.galeria.dto.ImagemDto;
import com.ciandt.galeria.enums.TipoImagem;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface ImagemService {
    Page<ImagemDto> findAllComFiltro(String nome, TipoImagem tipoImagem, int page, int size);
    ImagemDto findById(Long id);
    ImagemDto salvar(ImagemDto imagemDto);
    void excluir(Long id);
}
