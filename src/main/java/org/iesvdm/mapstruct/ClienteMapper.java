/**
 * 
 */
package org.iesvdm.mapstruct;

import org.iesvdm.dto.ClienteDTO;
import org.iesvdm.modelo.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Antonio Martin
 *
 */

@Mapper(componentModel = "spring")
public interface ClienteMapper {
	
	@Mapping(target = "totalPedidos", source = "totalPedidosIn")
	public ClienteDTO clienteALClienteDTO(Cliente cliente, double totalPedidosIn);
	
	public Cliente clienteDTOALCliente(ClienteDTO cliente);

}
