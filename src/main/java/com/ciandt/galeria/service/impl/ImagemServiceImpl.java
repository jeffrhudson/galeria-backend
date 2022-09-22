package com.ciandt.galeria.service.impl;

import com.ciandt.galeria.dto.ImagemDto;
import com.ciandt.galeria.enums.TipoImagem;
import com.ciandt.galeria.model.Imagem;
import com.ciandt.galeria.repository.ImagemRepository;
import com.ciandt.galeria.service.ImagemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImagemServiceImpl implements ImagemService {

    private final ImagemRepository imagemRepository;

    @Override
    public Page<ImagemDto> findAllComFiltro(String nome, TipoImagem tipoImagem, int page, int size) {
        final var pageable = PageRequest.of(page, size, Sort.by("dataCadastro").descending());
        final var imagePage = imagemRepository.findAllByFiltro(nome, tipoImagem, pageable);
        return imagePage.map(this::toDto);
    }

    @Override
    public ImagemDto findById(Long id) {
        final var imagem = imagemRepository.findById(id).get();
        return toDto(imagem);
    }

    @Override
    public ImagemDto salvar(ImagemDto imagemDto) {
        var imagem = toEntity(imagemDto);
        imagem = imagemRepository.save(imagem);
        return toDto(imagem);
    }

    @Override
    public void excluir(Long id) {
        imagemRepository.deleteById(id);
    }

    private ImagemDto toDto(Imagem imagem){
        return ImagemDto.builder()
                .id(imagem.getId())
                .nome(imagem.getNome())
                .tipoImagem(imagem.getTipoImagem())
                .dataCadastro(imagem.getDataCadastro())
                .usuarioCadastro(imagem.getUsuarioCadastro())
                .base64(imagem.getBase64())
                .build();
    }

    private Imagem toEntity(ImagemDto imagemDto){
        return Imagem.builder()
                .id(imagemDto.getId())
                .nome(imagemDto.getNome())
                .tipoImagem(imagemDto.getTipoImagem())
                .dataCadastro(imagemDto.getDataCadastro())
                .usuarioCadastro(imagemDto.getUsuarioCadastro())
                .base64(imagemDto.getBase64())
                .build();
    }
}
