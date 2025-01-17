/**
 * 
 */
package org.iesvdm.dao;

import java.util.List;
import java.util.Optional;

import org.iesvdm.dto.ClienteDTO;
import org.iesvdm.modelo.Pedido;

/**
 * @author Antonio Martin
 *
 */
public interface PedidoDAO {
	
	public void create(Pedido pedido);
	
	public List<Pedido> getAll();
	
	public List<Pedido> getAllBy(int idComercial);
	
	public Optional<Pedido> find(int id);
	
	public void update(Pedido pedido);
	
	public void delete(long id);
	
	public List<ClienteDTO> getPedidosClientes(int idCliente);
	

}
