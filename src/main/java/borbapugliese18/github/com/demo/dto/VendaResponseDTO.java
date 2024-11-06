package borbapugliese18.github.com.demo.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VendaResponseDTO {

    @NotNull
    private Double total;

    @NotNull
    private LocalDate data;

    @Valid
    @NotNull
    private VendedorDTO vendedor;
}
