package borbapugliese18.github.com.demo.dto;

import borbapugliese18.github.com.demo.model.Vendedor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VendedorDTO {

    private Long id;

    @NotBlank(message = "Campo requerido")
    @Size(min = 3, message = "O nome deve ter no mínimo 3 carateres")
    private String nome;

    @NotBlank(message = "Campo requerido")
    private String email;


    public VendedorDTO(Vendedor entity) {
        id = entity.getId();
        nome = entity.getNome();
        email = entity.getEmail();
    }




}
