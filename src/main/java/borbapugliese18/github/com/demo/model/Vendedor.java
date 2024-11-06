package borbapugliese18.github.com.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_vendedor")
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "campo requerido")
    private String nome;

    @Column(nullable = false)
    private String email;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendedor", orphanRemoval = true)
    List<Venda> vendas = new ArrayList<>();
}
