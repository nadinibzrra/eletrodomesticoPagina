package tads.eaj.ufrn.eletrodomesticopagina.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Eletrodomestico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Size(min = 3,max = 25, message = "digite um eletrodomestico de nome entre 3 e 25")
    @NotBlank
    private String nome;
    @Size(min = 3,max = 20)
    @NotBlank
    private String marca;
    @Size(min = 3,max = 12)
    @NotBlank
    private String cor;
    @NotBlank
    private double preco;
    @NotBlank
    private int potencia;
    private String imageUri;
    private Date deleted;



}
