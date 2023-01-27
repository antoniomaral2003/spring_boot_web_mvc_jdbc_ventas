package org.iesvdm.modelo;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comercial {

	private int id;
	
	@NotBlank(message = "Introduzca un nombre")
	@Size(min = 4, message = "Nombre al menos de 4 caracteres")
	@Size(max = 30, message = "Nombre de 30 caracteres como máximo")
	private String nombre;
	
	@NotBlank(message = "Introduzca el primer apellido")
	@Size(min = 4, message = "Primer apellido de al menos 4 caracteres")
	@Size(max = 30, message = "Primer apellido de 30 caracteres como máximo")
	private String apellido1;
	
	private String apellido2;
	
	@NotBlank(message = "Introduzca una comision")
	@DecimalMin(value = 0.276, inclusive = true)
	@DecimalMax(value = 0.946, inclusive = true)
	private BigDecimal comision;
	
}
