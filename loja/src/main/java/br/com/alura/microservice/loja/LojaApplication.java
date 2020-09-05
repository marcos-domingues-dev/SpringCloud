package br.com.alura.microservice.loja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class LojaApplication {

	
	/* 
	 * ================================================================================
	 * @Bean e @Autowired
	 * ------------------
	 * 
	 * 		@Bean --> Instância será gerenciada pelo Spring -> Prmitindo assim @Autowired
	 * 
	 * 
	 * ================================================================================
	 * Eureka
	 * ------
	 * 
	 * 		@LoadBalanced -> Adiciona inteligência para o RestTemplate resolver com Eureka
	 *   		de  : "http://fornecedor/"
	 *   		Para: "http://localhost:8081/"
	 *   
	 *   	Nas requisições REST que implementamos, passamos apenas o nome da outra aplicação: fornecedor
	 *   	O Spring substitui automaticamente o nome pelo IP. 
	 * --------------------------------------------------------------------------------
	 * */
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(LojaApplication.class, args);
	}

}
