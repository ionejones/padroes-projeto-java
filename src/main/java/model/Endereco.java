package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Endereco {
	@Id
	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;
	private String ibge;
	private String gia;
	private String ddd;
	private String siafi;
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public String getComplemento() {
		return complemento;
	}
	
	public String getIbge() {
		return ibge;
	}
	
	public String getGia() {
		return gia;
	}
	
	public String getDdd() {
		return ddd;
	}
	
	public String getSiafi() {
		return siafi;
	}
	
	public String getCep() {
		return cep;
	}
	public String getBairro() {
		return bairro;
	}
	public String getLocalidade() {
		return localidade;
	}
	public String getUf() {
		return uf;
	}

}
