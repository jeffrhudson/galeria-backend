package com.ciandt.galeria.dto;

import com.ciandt.galeria.enums.TipoImagem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImagemDto {
    private Long id;
    private String nome;
    private String base64;
    private TipoImagem tipoImagem;
    private LocalDateTime dataCadastro;
    private String usuarioCadastro;
}
