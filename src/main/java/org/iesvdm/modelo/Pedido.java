/**
 * 
 */
package org.iesvdm.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Antonio Martin
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
	
	private int id;
	private double total;
	private String fecha;
	private int id_cliente;
	private int id_comercial;
	

}
