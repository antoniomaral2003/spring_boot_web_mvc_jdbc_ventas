/**
 * 
 */
package org.iesvdm.dao;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

import org.iesvdm.modelo.Cliente;
import org.iesvdm.modelo.Comercial;
import org.iesvdm.modelo.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Antonio Martin
 *
 */
@Slf4j
@Repository
public class PedidoDAOImpl implements PedidoDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public synchronized void create(Pedido pedido) {

		// Desde java15+ se tiene la triple quote """ para bloques de texto como
		// cadenas.
		String sqlInsert = """
				INSERT INTO pedido (total, fecha, id_cliente, id_comercial)
				VALUES  (     ?,         ?,         ?,       ?)
				  """;

		KeyHolder keyHolder = new GeneratedKeyHolder();
		//Con recuperación de id generado
		int rows = jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sqlInsert, new String[] { "id" });
			int idx = 1;
			ps.setDouble(idx++, pedido.getTotal());
			ps.setString(idx++, pedido.getFecha());
			ps.setInt(idx++, pedido.getId_cliente());
			ps.setInt(idx++, pedido.getId_comercial());
			return ps;
		}, keyHolder);

		pedido.setId(keyHolder.getKey().intValue());

		//Sin recuperación de id generado
		//int rows = jdbcTemplate.update(sqlInsert,
		//		cliente.getNombre(),
		//		cliente.getApellido1(),
		//		cliente.getApellido2(),
		//		cliente.getCiudad(),
		//		cliente.getCategoria()
		//);

		log.info("Insertados {} registros.", rows);
	}
	
	@Override
	public List<Pedido> getAll() {
		
		List<Pedido> listPedido = jdbcTemplate.query("SELECT * FROM pedido",
				(rs, rowNum) -> new Pedido(rs.getInt("id"), rs.getDouble("total"), rs.getString("fecha"),
						rs.getInt("id_cliente"), rs.getInt("id_comercial"))

		);

		log.info("Devueltos {} registros.", listPedido.size());

		return listPedido;
		
		
	}
	
	@Override
	public List<Pedido> getAllBy(int idComercial) {
		
		List<Pedido> listPedido = jdbcTemplate.query("SELECT * FROM pedido WHERE id_comercial = ?",
				(rs, rowNum) -> new Pedido(rs.getInt("id"), rs.getDouble("total"), rs.getString("fecha"),
						rs.getInt("id_cliente"), rs.getInt("id_comercial")), idComercial

		);

		log.info("Devueltos {} registros.", listPedido.size());

		return listPedido;
		
	}
	
	@Override
	public Optional<Pedido> find(int id) {
		
		Pedido ped =  jdbcTemplate.queryForObject("SELECT * FROM pedido WHERE id = ?"														
								, (rs, rowNum) -> new Pedido(rs.getInt("id"),
            						 						rs.getDouble("total"),
            						 						rs.getString("fecha"),
            						 						rs.getInt("id_cliente"),
            						 						rs.getInt("id_comercial")) 
								, id
								);
		
		if (ped != null) { 
			return Optional.of(ped);}
		else { 
			log.info("Pedido no encontrado.");
			return Optional.empty(); }	
		
		
	}
	
	@Override
	public void update(Pedido pedido) {
		
		int rows = jdbcTemplate.update("""
				UPDATE pedido SET 
								total = ?, 
								fecha = ?, 
								id_cliente = ?,
								id_comercial = ?  
						WHERE id = ?
				""", pedido.getTotal()
				, pedido.getFecha()
				, pedido.getId_cliente()
				, pedido.getId_comercial()
				, pedido.getId());

		log.info("Update de Pedido con {} registros actualizados.", rows);
		
		
	}
	
	@Override
	public void delete(long id) {
		
		int rows = jdbcTemplate.update("DELETE FROM pedido WHERE id = ?", id);
		
		log.info("Delete de Pedido con {} registros eliminados.", rows);
		
		
	}
	
	@Override
	public List<Pedido> getPedidosClientes(int idCliente) {
		
		List<Pedido> listPedido = jdbcTemplate.query("SELECT cliente.id, cliente.nombre, pedido.total FROM pedido INNER JOIN cliente WHERE cliente.id = ? ORDER BY pedido.total DESC",
				(rs, rowNum) -> new Pedido(rs.getInt("id"), rs.getDouble("total"), rs.getString("fecha"),
						rs.getInt("id_cliente"), rs.getInt("id_comercial")), idCliente

		);

		log.info("Devueltos {} registros.", listPedido.size());

		return listPedido;
		
	}

}
