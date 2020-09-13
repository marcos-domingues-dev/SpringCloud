package br.com.alura.microservice.loja.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.microservice.loja.controller.dto.InfoFornecedorDTO;

// -- Feign integrado com
// --> Ribbon (Client Side Load Balance)
// --> Eureka

@FeignClient("fornecedor") //-> ID do microsserviço
public interface FornecedorClient {

	@RequestMapping("/info/{estado}")
	InfoFornecedorDTO getInfoPorEstado(@PathVariable String estado);
}
