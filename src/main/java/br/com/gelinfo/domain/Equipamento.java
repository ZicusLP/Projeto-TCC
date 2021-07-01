package br.com.gelinfo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tb_equipamentos")
@NamedQueries({
@NamedQuery(name = "Equipamento.listar", query = "SELECT equipamento FROM Equipamento equipamento"),
@NamedQuery(name = "Equipamento.buscarPorCodigo", query = "SELECT equipamento FROM Equipamento equipamento WHERE equipamento.codigo = :codigo")
})
public class Equipamento {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "eq_codigo")
	private int codigo;
	@Column(name = "eq_patrimonio", length = 25, nullable = false)
	private String patrimonio;
	@Column(name = "eq_npatrimonio", length = 25, nullable = false)
	private String npatrimonio;
	@Column(name = "eq_nserie", length = 25, nullable = false)
	private String nserie;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tb_tipo_tp_codigo", referencedColumnName = "tp_codigo", nullable = false)
	private TipoEquipamento tipo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tb_setores_st_codigo", referencedColumnName = "st_codigo", nullable = false)
	private Setor setor;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tb_modelos_md_codigo", referencedColumnName = "md_codigo", nullable = false)
	private Modelo modelo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinTable(name="equipamento_invetario",
            joinColumns={@JoinColumn(name="tb_equipamentos_eq_codigo",
             referencedColumnName="eq_codigo")},
            inverseJoinColumns={@JoinColumn(name="tb_inventario_inv_codigo",
             referencedColumnName="inv_codigo")})
	private Inventario inventario;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(String patrimonio) {
		this.patrimonio = patrimonio;
	}

	public String getNpatrimonio() {
		return npatrimonio;
	}

	public void setNpatrimonio(String npatrimonio) {
		this.npatrimonio = npatrimonio;
	}

	public String getNserie() {
		return nserie;
	}

	public void setNserie(String nserie) {
		this.nserie = nserie;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	public TipoEquipamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoEquipamento tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Equipamento [codigo=" + codigo + ", patrimonio=" + patrimonio + ", npatrimonio=" + npatrimonio
				+ ", nserie=" + nserie + ", tipo=" + tipo + ", setor=" + setor + ", modelo=" + modelo + ", inventario="
				+ inventario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipamento other = (Equipamento) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	
	
}
