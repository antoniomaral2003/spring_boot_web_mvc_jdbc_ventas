/**
 * 
 */
package org.iesvdm.dto;

import org.iesvdm.modelo.Comercial;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Antonio Martin
 *
 */

@Data
@NoArgsConstructor
public class ComercialDTO extends Comercial {
	
	private double totalPedidos;
	private double mediaPedidos;
	
	// Constrcutor de la clase
	public ComercialDTO(int id, String nombre, String apellido1, String apellido2, float comision, double totalPedidos, double mediaPedidos) {
		
		super(id, nombre, apellido1, apellido2, comision);
		
		this.totalPedidos = totalPedidos;
		this.mediaPedidos = mediaPedidos;
		
	}
	

}
