package pe.edu.idat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import pe.edu.idat.ws.GetPaisRequest;
import pe.edu.idat.ws.GetPaisResponse;

@Endpoint
public class PaisEndpoint {
	private static final String NAMESPACE_URI = "http://idat.edu.pe/ws";
	private PaisRepositorio repositorio;

	@Autowired
	public PaisEndpoint(PaisRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPaisRequest")

	@ResponsePayload
	public GetPaisResponse getCountry(@RequestPayload GetPaisRequest request) {
		GetPaisResponse response = new GetPaisResponse();
		response.setPais(repositorio.buscarPais(request.getNombre()));
		return response;
	}
}
