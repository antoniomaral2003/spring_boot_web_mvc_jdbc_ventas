/**
 * 
 */
package org.iesvdm.dto;

import org.iesvdm.modelo.Cliente;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Antonio Martin
 *
 */

@Data
@NoArgsConstructor
public class ClienteDTO extends Cliente {
	
	private double totalPedidos;
	
	public ClienteDTO(long id, String nombre, String apellido1, String apellido2, String ciudad, int categoria, double totalPedidos) {
		
		super(id, nombre, apellido1, apellido2, ciudad, categoria);
		
		this.totalPedidos = totalPedidos;
		
	}

}
