/**
 * 
 */
package org.iesvdm.dto;

import org.iesvdm.modelo.Pedido;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Antonio Martin
 *
 */

@Data
@NoArgsConstructor
public class PedidoDTO extends Pedido {
	
	private int id;
	private double total;
	private String fecha;
	private int id_cliente;
	private int id_comercial;
	
	public PedidoDTO(int id, double total, String fecha, int id_cliente, int id_comercial) {
		
		super(id, total, fecha, id_cliente, id_comercial);
		
	}
	
	

}
