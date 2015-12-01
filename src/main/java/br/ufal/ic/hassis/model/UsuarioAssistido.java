package br.ufal.ic.hassis.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UsuarioAssistido implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	@NotEmpty
	private String nomeAssistido;
	private String rg;
	private String cpf;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")//"dd-MM-yyyy")
	private Date dtNascimento;
	private String endereco;
	private String endComplemento;
	@NotNull
	@NotEmpty
	private String estado;
	@NotNull
	@NotEmpty
	private String cidade;
	private String bairro;
	private String cep;
	private String ddd1;
	private String telefone1;
	private String ddd2;
	private String telefone2;
	private String email;
	private String genero;
	private boolean isGestante;
	private String orientacaoSexual;
	private String estadoCivil;
	private String etnia;
	private String escolaridade;
	private String renda;
	private String numeroFilhos;
	private String quandoComecou;
//	private Drogas tiposDrogas[];
	private boolean usaMaconha;
	private boolean usaCocaina;
	private boolean usaCrack;
	private boolean usaCola;
	private boolean usaLolo;
	private boolean usaEcstasy;
	private boolean usaLancaPerfume;
	private boolean usaOutrasDrogas;
	
	private String frequenciaConsumo;
	private String relatosNasDrogas;
	private String ondeCompra;
	private String comoCompra;
	private String compraOutrasFormas;
	private boolean possuiAmigosQueUsam;
	private boolean usaComAmigos;
	private boolean possuiFamiliaresQueUsam;
	private boolean usaComFamiliares;
	private boolean recebeuTratamento;
	private String tratamentoRecebido;
	private String outroTratamentoRecebido;
	private String doencas;
	private String ondeFoiResgatado;
	private String porqueInternacao;
	private String comoFicouSabendo;
	private String imagemDPE;

	public String getNomeAssistido() {
		return nomeAssistido;
	}

	public void setNomeAssistido(String nomeAssistido) {
		this.nomeAssistido = nomeAssistido;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEndComplemento() {
		return endComplemento;
	}

	public void setEndComplemento(String endComplemento) {
		this.endComplemento = endComplemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getDdd1() {
		return ddd1;
	}

	public void setDdd1(String ddd1) {
		this.ddd1 = ddd1;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getDdd2() {
		return ddd2;
	}

	public void setDdd2(String ddd2) {
		this.ddd2 = ddd2;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public boolean isGestante() {
		return isGestante;
	}

	public void setGestante(boolean isGestante) {
		this.isGestante = isGestante;
	}

	public String getOrientacaoSexual() {
		return orientacaoSexual;
	}

	public void setOrientacaoSexual(String orientacaoSexual) {
		this.orientacaoSexual = orientacaoSexual;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEtnia() {
		return etnia;
	}

	public void setEtnia(String etnia) {
		this.etnia = etnia;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getRenda() {
		return renda;
	}

	public void setRenda(String renda) {
		this.renda = renda;
	}

	public String getNumeroFilhos() {
		return numeroFilhos;
	}

	public void setNumeroFilhos(String numeroFilhos) {
		this.numeroFilhos = numeroFilhos;
	}

	public String getQuandoComecou() {
		return quandoComecou;
	}

	public void setQuandoComecou(String quandoComecou) {
		this.quandoComecou = quandoComecou;
	}
	public boolean isUsaMaconha() {
		return usaMaconha;
	}

	public void setUsaMaconha(boolean usaMaconha) {
		this.usaMaconha = usaMaconha;
	}

	public boolean isUsaCocaina() {
		return usaCocaina;
	}

	public void setUsaCocaina(boolean usaCocaina) {
		this.usaCocaina = usaCocaina;
	}

	public boolean isUsaCrack() {
		return usaCrack;
	}

	public void setUsaCrack(boolean usaCrack) {
		this.usaCrack = usaCrack;
	}

	public boolean isUsaCola() {
		return usaCola;
	}

	public void setUsaCola(boolean usaCola) {
		this.usaCola = usaCola;
	}

	public boolean isUsaLolo() {
		return usaLolo;
	}

	public void setUsaLolo(boolean usaLolo) {
		this.usaLolo = usaLolo;
	}

	public boolean isUsaEcstasy() {
		return usaEcstasy;
	}

	public void setUsaEcstasy(boolean usaEcstasy) {
		this.usaEcstasy = usaEcstasy;
	}

	public boolean isUsaLancaPerfume() {
		return usaLancaPerfume;
	}

	public void setUsaLancaPerfume(boolean usaLancaPerfume) {
		this.usaLancaPerfume = usaLancaPerfume;
	}

	public boolean isUsaOutrasDrogas() {
		return usaOutrasDrogas;
	}

	public void setUsaOutrasDrogas(boolean usaOutrasDrogas) {
		this.usaOutrasDrogas = usaOutrasDrogas;
	}

	public String getFrequenciaConsumo() {
		return frequenciaConsumo;
	}

	public void setFrequenciaConsumo(String frequenciaConsumo) {
		this.frequenciaConsumo = frequenciaConsumo;
	}

	public String getRelatosNasDrogas() {
		return relatosNasDrogas;
	}

	public void setRelatosNasDrogas(String relatosNasDrogas) {
		this.relatosNasDrogas = relatosNasDrogas;
	}

	public String getOndeCompra() {
		return ondeCompra;
	}

	public void setOndeCompra(String ondeCompra) {
		this.ondeCompra = ondeCompra;
	}

	public String getComoCompra() {
		return comoCompra;
	}

	public void setComoCompra(String comoCompra) {
		this.comoCompra = comoCompra;
	}

	public boolean isPossuiAmigosQueUsam() {
		return possuiAmigosQueUsam;
	}

	public void setPossuiAmigosQueUsam(boolean possuiAmigosQueUsam) {
		this.possuiAmigosQueUsam = possuiAmigosQueUsam;
	}

	

	public String getCompraOutrasFormas() {
		return compraOutrasFormas;
	}

	public void setCompraOutrasFormas(String compraOutrasFormas) {
		this.compraOutrasFormas = compraOutrasFormas;
	}

	public boolean isUsaComAmigos() {
		return usaComAmigos;
	}

	public void setUsaComAmigos(boolean usaComAmigos) {
		this.usaComAmigos = usaComAmigos;
	}
	

	public boolean isPossuiFamiliaresQueUsam() {
		return possuiFamiliaresQueUsam;
	}

	public void setPossuiFamiliaresQueUsam(boolean possuiFamiliaresQueUsam) {
		this.possuiFamiliaresQueUsam = possuiFamiliaresQueUsam;
	}

	public boolean isUsaComFamiliares() {
		return usaComFamiliares;
	}

	public void setUsaComFamiliares(boolean usaComFamiliares) {
		this.usaComFamiliares = usaComFamiliares;
	}

	public boolean isRecebeuTratamento() {
		return recebeuTratamento;
	}

	public void setRecebeuTratamento(boolean recebeuTratamento) {
		this.recebeuTratamento = recebeuTratamento;
	}

	public String getTratamentoRecebido() {
		return tratamentoRecebido;
	}

	public void setTratamentoRecebido(String tratamentoRecebido) {
		this.tratamentoRecebido = tratamentoRecebido;
	}

	public String getOutroTratamentoRecebido() {
		return outroTratamentoRecebido;
	}

	public void setOutroTratamentoRecebido(String outroTratamentoRecebido) {
		this.outroTratamentoRecebido = outroTratamentoRecebido;
	}

	public String getDoencas() {
		return doencas;
	}

	public void setDoencas(String doencas) {
		this.doencas = doencas;
	}

	public String getOndeFoiResgatado() {
		return ondeFoiResgatado;
	}

	public void setOndeFoiResgatado(String ondeFoiResgatado) {
		this.ondeFoiResgatado = ondeFoiResgatado;
	}

	public String getPorqueInternacao() {
		return porqueInternacao;
	}

	public void setPorqueInternacao(String porqueInternacao) {
		this.porqueInternacao = porqueInternacao;
	}

	public String getComoFicouSabendo() {
		return comoFicouSabendo;
	}

	public void setComoFicouSabendo(String comoFicouSabendo) {
		this.comoFicouSabendo = comoFicouSabendo;
	}

	public String getImagemDPE() {
		return imagemDPE;
	}

	public void setImagemDPE(String imagemDPE) {
		this.imagemDPE = imagemDPE;
	}

}
