package org.iesvdm.modelo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//La anotación @Data de lombok proporcionará el código de: 
//getters/setters, toString, equals y hashCode
//propio de los objetos POJOS o tipo Beans
@Data
//Para generar un constructor con lombok con todos los args
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
	
	private long id;
	
	@NotBlank(message = "Introduzca un nombre")
	@Size(min = 4, message = "Nombre al menos de 4 caracteres")
	@Size(max = 30, message = "Nombre de 30 caracteres como máximo")
	private String nombre;
	
	@NotBlank(message = "Introduzca el primer apellido")
	@Size(min = 4, message = "Primer apellido de al menos 4 caracteres")
	@Size(max = 30, message = "Primer apellido de 30 caracteres como máximo")
	private String apellido1;
	
	
	private String apellido2;
	
	@NotBlank(message = "Introduzca una ciudad")
	@Size(max = 50, message = "Ciudad de 50 caracteres como máximo")
	private String ciudad;
	
	@NotBlank(message = "Introduzca una categoria")
	@Size(min = 100, message = "Categoria minima: 100")
	@Size(max = 1000, message = "Categoria maxima: 1000")
	private int categoria;
	
}
