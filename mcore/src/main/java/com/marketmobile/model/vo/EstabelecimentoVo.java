<<<<<<< Updated upstream
package com.marketmobile.model.vo;

import com.marketmobile.model.Empresa;
import com.marketmobile.model.Estabelecimento;
import com.marketmobile.model.Localizacao;

public class EstabelecimentoVo {
	
	private Long id;

	private String nome;

	private String descricao;

	private String imagem;

	private String telefone;

	private Integer avaliacao;

	private Integer idLocalizacao;

	private Long idEmpresa;

	private Localizacao localizacao;

	private Empresa empresa;

	public EstabelecimentoVo(Long id, String nome, String descricao,
			String imagem, Integer avaliacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.imagem = imagem;
		this.avaliacao = avaliacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Integer avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Integer getIdLocalizacao() {
		return idLocalizacao;
	}

	public void setIdLocalizacao(Integer idLocalizacao) {
		this.idLocalizacao = idLocalizacao;
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public String toString() {
		return "EstabelecimentoVo [id=" + id + ", nome=" + nome
				+ ", descricao=" + descricao + ", imagem=" + imagem
				+ ", telefone=" + telefone + ", avaliacao=" + avaliacao
				+ ", idLocalizacao=" + idLocalizacao + ", idEmpresa="
				+ idEmpresa + ", localizacao=" + localizacao + ", empresa="
				+ empresa + "]";
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.id = estabelecimento.getId();
		this.avaliacao = estabelecimento.getAvaliacao();
		this.descricao = estabelecimento.getDescricao();
		this.empresa = estabelecimento.getEmpresa();
		
		this.localizacao = estabelecimento.getLocalizacao();
		this.idLocalizacao = estabelecimento.getIdLocalizacao();
		this.imagem = estabelecimento.getImagem();
		this.nome = estabelecimento.getNome();
		this.telefone = estabelecimento.getTelefone();
	}
	
	
	
}
=======
package com.marketmobile.model.vo;

import com.marketmobile.model.Empresa;
import com.marketmobile.model.Localizacao;

public class EstabelecimentoVo {
	
	private Long id;

	private String nome;

	private String descricao;

	private String imagem;

	private String telefone;

	private Integer avaliacao;

	private Integer idLocalizacao;

	private Long idEmpresa;

	private Localizacao localizacao;

	private Empresa empresa;

	public EstabelecimentoVo(Long id, String nome, String descricao,
			String imagem, Integer avaliacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.imagem = imagem;
		this.avaliacao = avaliacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Integer avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Integer getIdLocalizacao() {
		return idLocalizacao;
	}

	public void setIdLocalizacao(Integer idLocalizacao) {
		this.idLocalizacao = idLocalizacao;
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public String toString() {
		return "EstabelecimentoVo [id=" + id + ", nome=" + nome
				+ ", descricao=" + descricao + ", imagem=" + imagem
				+ ", telefone=" + telefone + ", avaliacao=" + avaliacao
				+ ", idLocalizacao=" + idLocalizacao + ", idEmpresa="
				+ idEmpresa + ", localizacao=" + localizacao + ", empresa="
				+ empresa + "]";
	}
	
}
>>>>>>> Stashed changes
