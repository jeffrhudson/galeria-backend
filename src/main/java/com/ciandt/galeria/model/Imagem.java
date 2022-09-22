package com.ciandt.galeria.model;

import com.ciandt.galeria.enums.TipoImagem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Imagem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @Lob
    private String base64;
    @Enumerated(EnumType.STRING)
    private TipoImagem tipoImagem;
    private LocalDateTime dataCadastro;
    private String usuarioCadastro;
}
