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
	
	@Size(min = 4, message = "{error.nombre.size.min}")
	@Size(max = 30, message = "{error.nombre.size.max}")
	private String nombre;
	
	@Size(min = 4, message = "{error.apellido1.size.min}")
	@Size(max = 30, message = "{error.apellido1.size.max}")
	private String apellido1;
	
	private String apellido2;
	
	@DecimalMin(value = "0.276", inclusive = true)
	@DecimalMax(value = "0.946", inclusive = true)
	private BigDecimal comision;
	
}
