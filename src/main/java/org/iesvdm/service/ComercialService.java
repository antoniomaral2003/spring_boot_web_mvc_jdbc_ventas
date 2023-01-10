/**
 * 
 */
package org.iesvdm.service;

import org.iesvdm.dao.ComercialDAO;
import org.iesvdm.dao.PedidoDAO;
import org.iesvdm.modelo.Comercial;
import org.iesvdm.modelo.Pedido;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Antonio Martin
 *
 */

@Service
public class ComercialService {
	
	private ComercialDAO comercialDAO;
	private PedidoDAO pedidoDAO;
	
	public ComercialService(ComercialDAO comercialDAO, PedidoDAO pedidoDAO) {
		
		this.comercialDAO = comercialDAO;
		this.pedidoDAO = pedidoDAO;
		
	}
	
	// COMERCIAL
	public List<Comercial> listAll(){
		
		return comercialDAO.getAll();
		
	}
	
	public Comercial one(Integer id) {
		
		Optional<Comercial> optCom = comercialDAO.find(id);
		
		if (optCom.isPresent()) {
			
			return optCom.get();
			
		} else {
			
			return null;
			
		}
		
	}
	
	public void newComercial(Comercial comercial) {
		
		comercialDAO.create(comercial);
		
	}
	
	public void replaceComercial(Comercial comercial) {
		
		comercialDAO.update(comercial);
		
	}
	
	public void deleteComercial(int id) {
		
		comercialDAO.delete(id);
		
	}
	
	// PEDIDO
	public List<Pedido> listAllPedido() {
		
		return pedidoDAO.getAll();
		
	}
	
	
	

}
