package br.com.gelinfo.domain;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_inventario")
@NamedQueries({
@NamedQuery(name = "Inventario.listar", query = "SELECT inventario FROM Inventario inventario"),
@NamedQuery(name = "Inventario.buscarPorCodigo", query = "SELECT inventario FROM Inventario inventario WHERE inventario.codigo = :codigo")
})
public class Inventario {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "inv_codigo")
	private int codigo;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name = "inv_data")
	private Date data;
	@Column(name = "inv_status")
	private String status;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tb_usuarios_u_codigo", referencedColumnName = "u_codigo", nullable = false)
	private Usuario usuario;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tb_setores_st_codigo", referencedColumnName = "st_codigo", nullable = false)
	private Setor setor;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	@Override
	public String toString() {
		return "Inventario [codigo=" + codigo + ", data=" + data + ", status=" + status + ", usuario=" + usuario
				+ ", setor=" + setor + "]";
	}
	
	
}
