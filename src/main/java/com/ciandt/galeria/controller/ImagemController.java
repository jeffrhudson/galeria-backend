package com.ciandt.galeria.controller;

import com.ciandt.galeria.dto.ImagemDto;
import com.ciandt.galeria.enums.TipoImagem;
import com.ciandt.galeria.service.ImagemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("imagens")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ImagemController {
    private final ImagemService imagemService;

    @GetMapping("/{id}")
    ResponseEntity<ImagemDto> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(imagemService.findById(id));
    }

    @GetMapping("/buscar")
    ResponseEntity<Page<ImagemDto>> buscarComFiltro(@RequestParam(required = false, defaultValue = "") String nome,
                                                 @RequestParam(required = false, defaultValue = "") TipoImagem tipoImagem,
                                                 @RequestParam(required = false, defaultValue = "0") int page,
                                                 @RequestParam(required = false, defaultValue = "10") int size){
        final var imageDtoList = imagemService.findAllComFiltro(nome, tipoImagem, page, size);
        return ResponseEntity.ok(imageDtoList);

    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> excluir(@PathVariable("id") Long id){
        imagemService.excluir(id);
        return ResponseEntity.ok("Deletado");
    }

    @PostMapping
    ResponseEntity<?> salvar(@RequestBody ImagemDto imagemDto){
        return ResponseEntity.ok(imagemService.salvar(imagemDto));
    }
}
