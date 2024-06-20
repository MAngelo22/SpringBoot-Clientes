package jpaprueba.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jpaprueba.modelo.entitybean.Cliente;
import jpaprueba.repository.ClienteRepository;

@Repository
public class ClienteDaoImplMy8Jpa implements ClienteDao{
	
	@Autowired
	private ClienteRepository crepo;

	@Override
	public List<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		return crepo.findAll();
	}

	@Override
	public Cliente buscarUno(int idCliente) {
		// TODO Auto-generated method stub
		return crepo.findById(idCliente).orElse(null);
	}

	@Override
	public Cliente insertOne(Cliente cliente) {
		try {
			return crepo.save(cliente);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int updateOne(Cliente cliente) {
		if (buscarUno(cliente.getIdCliente()) != null) {
			crepo.save(cliente);
			return 1;
			
		}else
			return 0;
	}

	@Override
	public int deleteOne(int idCliente) {

		if (buscarUno(idCliente) != null) {
			crepo.deleteById(idCliente);
			return 1;
			
		}else
			return 0;
	}

	@Override
	public List<Cliente> buscarPorfacturacionMayorQue(double facturacionAnual) {
		// TODO Auto-generated method stub
		return crepo.findFacturMayor(facturacionAnual);
	}
	
	

}
