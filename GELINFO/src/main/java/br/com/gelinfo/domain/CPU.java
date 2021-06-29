package br.com.gelinfo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cpu")
@NamedQueries({@NamedQuery(name = "CPU.listar", query = "SELECT cpu FROM CPU cpu")})
public class CPU {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "cpu_codigo")
	private int codigo;
	@Column(name = "cpu_ip")
	private int ip;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tb_equipamentos_eq_codigo", referencedColumnName = "eq_codigo", nullable = false)
	private Equipamento equipamento;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getIp() {
		return ip;
	}

	public void setIp(int ip) {
		this.ip = ip;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
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
		CPU other = (CPU) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	
}
