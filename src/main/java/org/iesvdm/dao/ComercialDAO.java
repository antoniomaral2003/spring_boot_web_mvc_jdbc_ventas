package org.iesvdm.dao;

import java.util.List;
import java.util.Optional;

import org.iesvdm.dto.ComercialDTO;
import org.iesvdm.modelo.Comercial;

public interface ComercialDAO {
	
	public void create(Comercial cliente);
	
	public List<Comercial> getAll();
	public Optional<Comercial>  find(int id);
	
	public void update(Comercial cliente);
	
	public void delete(long id);
	
	public Double getTotalPedidos(int id);
	
	public Double getMediaPedidos(int id);
	
	public Double getPedidoMax(int id);
	
	public Double getPedidoMin(int id);


}
