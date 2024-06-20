package jpaprueba.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jpaprueba.modelo.dao.ClienteDao;
import jpaprueba.modelo.entitybean.Cliente;


@RestController
@RequestMapping("/apirest/clientes")
public class ClienteRestController {
	
	@Autowired
	private ClienteDao cdao;
	
	
	
	@PostMapping("/alta")
	public Cliente alta(@RequestBody Cliente cliente) {
		
		return cdao.insertOne(cliente);
	}
	
	@GetMapping("/todos")
	public List<Cliente> todos(){
		return cdao.buscarTodos();
	}
	
	@GetMapping("/uno/{idCliente}")
	public  Cliente buscarUno(@PathVariable int idCliente){
		return cdao.buscarUno(idCliente);
	}
	
	@DeleteMapping("/eliminar/{idCliente}")
	public  String eliminarUno(@PathVariable int idCliente){
		if (cdao.deleteOne(idCliente)== 1)
			return "Cliente eliminado correctamente";
		else
			return "Cliente NOOOO se ha podido eliminar";
	}
	@PutMapping("/modificar")
	public  String eliminarUnomodificar(@RequestBody Cliente cliente){
		if (cdao.updateOne(cliente)== 1)
			return "Cliente modificado correctamente";
		else
			return "Cliente NOOOO se ha podido modificar";
	}
	
	@GetMapping("/pofactur/{facturacionAnual}")
	public  List<Cliente> buscarfactur(@PathVariable double facturacionAnual){
		return cdao.buscarPorfacturacionMayorQue(facturacionAnual);
	}

}
