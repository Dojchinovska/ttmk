package com.bazi.ttmk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "ligi",
        uniqueConstraints = @UniqueConstraint(columnNames = {"id_sezona", "ime_liga"}),
        schema = "project"
)
public class Liga implements java.io.Serializable {

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "idLiga", column = @Column(name = "id_liga", nullable = false)),
            @AttributeOverride(name = "idSezona", column = @Column(name = "id_sezona", nullable = false))
    })
    private LigaId id;

    @Column(name = "ime_liga", nullable = false, length = 40)
    private String imeLiga;

    @OneToMany(mappedBy = "liga")
    private List<Natprevar> natprevari;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_sezona", updatable = false, insertable = false, nullable = false)
    @JsonIgnore
    private Sezona sezona;
}