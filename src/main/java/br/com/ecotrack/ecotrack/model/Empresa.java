package br.com.ecotrack.ecotrack.model;

import br.com.ecotrack.ecotrack.model.enums.TipoEmpresa;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "empresa")
@Data // Isso aqui cria automaticamente getters, setters e toString
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 14)
    private String cnpj;

    @Column(nullable = false, length = 150)
    private String razaoSocial;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoEmpresa tipo;

    private boolean ativo = true;
}