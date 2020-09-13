package br.com.alura.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.alura.microservice.loja.controller.dto.CompraDTO;
import br.com.alura.microservice.loja.controller.dto.InfoFornecedorDTO;

@Service
public class CompraService {
	
	@Autowired
	private RestTemplate restTemplate; // -> @Bean -> LojaApplication.getRestTemplate()

	
	@Autowired
	private DiscoveryClient eurekaClient;
	
	
	public void realizaCompra(CompraDTO compra) {				
		ResponseEntity<InfoFornecedorDTO> exchange = 
			restTemplate.exchange(
				"http://fornecedor/info/" + compra.getEndereco().getEstado(),
				HttpMethod.GET, 
				null, 
				InfoFornecedorDTO.class);
		
		System.out.println(exchange.getBody().getEndereco());
		
		
		// --> Para visualizar as instâncias, é preciso rodar uma segunda em outra porta:
		// --> Run configurations > arguments > program arguments: "--server.port=8082"
		
		eurekaClient.getInstances("fornecedor").stream()
			.forEach(fornecedor -> 
			System.out.println("http://localhost:"+fornecedor.getPort()));
	}

}
