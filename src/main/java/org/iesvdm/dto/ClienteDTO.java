/**
 * 
 */
package org.iesvdm.dto;

import org.iesvdm.modelo.Cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Antonio Martin
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
	
	private long id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String ciudad;
	private int categoria;
	
	private double totalPedidos;
	

}
