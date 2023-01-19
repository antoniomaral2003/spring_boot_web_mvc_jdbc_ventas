/**
 * 
 */
package org.iesvdm.service;

import org.iesvdm.dao.ComercialDAO;
import org.iesvdm.dao.PedidoDAO;
import org.iesvdm.dto.ComercialDTO;
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
	
	public Double listTotalPedidos(Integer id) {
		
		return comercialDAO.getTotalPedidos(id);
		
	}
	
	public Double listMediaPedidos(Integer id) {
		
		return comercialDAO.getMediaPedidos(id);
		
	}
	
	public Double pedidoMax(Integer id) {
		
		return comercialDAO.getPedidoMax(id);
		
	}
	
	public Double pedidoMin(Integer id) {
		
		return comercialDAO.getPedidoMin(id);
		
	}
	
	// PEDIDO
	public List<Pedido> listAllPedidoBy(Integer id) {
		
		return pedidoDAO.getAllBy(id);
		
	}
	
	public Pedido onePedido(Integer id) {
		
		Optional<Pedido> optPed = pedidoDAO.find(id);
		
		if (optPed.isPresent()) {
			
			return optPed.get();
			
		} else {
			
			return null;
			
		}
		
	}
	
	public void newPedido(Pedido pedido) {
		
		pedidoDAO.create(pedido);
		
	}
	
	public void replacePedido(Pedido pedido) {
		
		pedidoDAO.update(pedido);
		
	}
	
	public void deletePedido(int id) {
		
		pedidoDAO.delete(id);
		
	}
	

}
