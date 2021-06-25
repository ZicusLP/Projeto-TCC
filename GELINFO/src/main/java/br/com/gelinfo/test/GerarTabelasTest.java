package br.com.gelinfo.test;

import org.junit.Test;

import br.com.gelinfo.util.HibernateUtil;

public class GerarTabelasTest {
	
	@Test
	public void Gerar() {
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();

	}
}
