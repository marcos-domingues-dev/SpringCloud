package br.com.alura.microservice.loja.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private long pedidoId;

	private Integer tempoDePreparo;
	
	private String enderecoDeDestino;
	
	private LocalDate dataParaEntrega;
	
	private Long voucher;
	
	@Enumerated(EnumType.STRING)
	private CompraState state;
	
	public long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public Integer getTempoDePreparo() {
		return tempoDePreparo;
	}

	public void setTempoDePreparo(Integer tempoDePreparo) {
		this.tempoDePreparo = tempoDePreparo;
	}

	public String getEnderecoDeDestino() {
		return enderecoDeDestino;
	}

	public void setEnderecoDeDestino(String enderecoDeDestino) {
		this.enderecoDeDestino = enderecoDeDestino;
	}
	
	public void setDataParaEntrega(LocalDate dataParaEntrega) {
		this.dataParaEntrega = dataParaEntrega;
	}
	
	public LocalDate getDataParaEntrega() {
		return dataParaEntrega;
	}
	
	public void setVoucher(Long voucher) {
		this.voucher = voucher;
	}
	
	public Long getVoucher() {
		return voucher;
	}
	
}
