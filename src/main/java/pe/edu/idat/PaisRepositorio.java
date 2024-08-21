package pe.edu.idat;

import java.util.HashMap;
import java.util.Map;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import pe.edu.idat.ws.Moneda;
import pe.edu.idat.ws.Pais;

@Component
public class PaisRepositorio {
	
	private static final Map<String, Pais> paises = new HashMap<>();

	@PostConstruct
	public void initData() {
		Pais peru = new Pais();
		peru.setNombre("Perú");
		peru.setCapital("Lima");
		peru.setPoblacion(33720000);
		peru.setMoneda(Moneda.SOL);
		paises.put(peru.getNombre(), peru);

		Pais ecuador = new Pais();
		ecuador.setNombre("Ecuador");
		ecuador.setCapital("Quito");
		ecuador.setPoblacion(17800000);
		ecuador.setMoneda(Moneda.DOLAR);
		paises.put(ecuador.getNombre(), ecuador);

		Pais colombia = new Pais();
		colombia.setNombre("Colombia");
		colombia.setCapital("Bogota");
		colombia.setPoblacion(51520000);
		colombia.setMoneda(Moneda.PESO);
		paises.put(colombia.getNombre(), colombia);

	}

	public Pais buscarPais(String nombre) {
		Assert.notNull(nombre, "El nombre del país no puede ser nulo");
		return paises.get(nombre);
	}
}