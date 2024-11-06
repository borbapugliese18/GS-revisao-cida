package borbapugliese18.github.com.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Campo requerido")
    private Double total;

    @Column(nullable = false)
    @NotNull(message = "Campo requerido")
    private LocalDate data;

    @Column(nullable = false)
    @NotNull(message = "Campo requerido")
    private Double comissao;

    @Column(nullable = false)
    @NotNull(message = "Campo requerido")
    private String status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vendedor_id", nullable = false)
    private Vendedor vendedor;





}
