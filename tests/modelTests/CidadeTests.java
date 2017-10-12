package modelTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.Cidade;

class CidadeTests {

	Cidade cidade1;
	Cidade cidade2;
	Cidade cidade3;
	
	@BeforeEach
	void setUp() throws Exception {
		cidade1 = new Cidade("1100015", "RO", "Alta Floresta D'Oeste", "", "-61.9998238963", "-11.9355403048", "Alta Floresta D'Oeste", "", "Cacoal", "Leste Rondoniense");
		cidade2 = new Cidade("5300108", "DF", "Brasília", "true", "-47.887905478", "-15.7940873619", "Brasilia", "", "Brasília", "Distrito Federal");
		cidade3 = new Cidade("1100015", "RO", "Alta Floresta D'Oeste", "", "-61.9998238963", "-11.9355403048", "Alta Floresta D'Oeste", "", "Cacoal", "Leste Rondoniense");
	}

	@Test
	void HashCodeDeveRetornarOValorEsperadoTest() {
		int hashEsperado = this.GetHashCode(cidade1);
		
		int hasRetornado = cidade1.hashCode();
		
		assertEquals(hashEsperado, hasRetornado);
	}

	@Test
	void CidadeDeveCriarUmaInstanciaComOsValoresEsperadosTest() {
		Cidade cidade = new Cidade("5300108", "DF", "Brasília", "true", "-47.887905478", "-15.7940873619", "Brasilia", "", "Brasília", "Distrito Federal");
		
		assertEquals(cidade2, cidade);
	}

	@Test
	void GetIbgeIdDeveRetornarOValorEsperadoTest() {
		String valor = cidade1.getIbgeId();
		
		assertEquals("1100015", valor);
	}

	@Test
	void SetIbgeIdDeveAlterarOValorDaPropriedadeTest() {
		String novoValor = "valorTeste";
		cidade1.setIbgeId(novoValor);
		
		String valor = cidade1.getIbgeId();
		
		assertEquals(novoValor, valor);
	}

	@Test
	void GetUfDeveRetornarOValorEsperadoTest() {
		String valor = cidade1.getUf();
		
		assertEquals("RO", valor);
	}

	@Test
	void SetUfDeveAlterarOValorDaPropriedadeTest() {
		String novoValor = "valorTeste";
		cidade1.setUf(novoValor);
		
		String valor = cidade1.getUf();
		
		assertEquals(novoValor, valor);
	}

	@Test
	void GetNameDeveRetornarOValorEsperadoTest() {
		String valor = cidade1.getName();
		
		assertEquals("Alta Floresta D'Oeste", valor);
	}

	@Test
	void SetNameDeveAlterarOValorDaPropriedadeTest() {
		String novoValor = "valorTeste";
		cidade1.setName(novoValor);
		
		String valor = cidade1.getName();
		
		assertEquals(novoValor, valor);
	}

	@Test
	void GetCapitalDeveRetornarOValorEsperadoTest() {
		String valor = cidade1.getCapital();
		
		assertEquals("", valor);
	}

	@Test
	void SetCapitalDeveAlterarOValorDaPropriedadeTest() {
		String novoValor = "valorTeste";
		cidade1.setCapital(novoValor);
		
		String valor = cidade1.getCapital();
		
		assertEquals(novoValor, valor);
	}

	@Test
	void GetLongitudeDeveRetornarOValorEsperadoTest() {
		String valor = cidade1.getLongitude();
		
		assertEquals("-61.9998238963", valor);
	}

	@Test
	void SetLongitudeDeveAlterarOValorDaPropriedadeTest() {
		String novoValor = "valorTeste";
		cidade1.setLongitude(novoValor);
		
		String valor = cidade1.getLongitude();
		
		assertEquals(novoValor, valor);
	}

	@Test
	void GetLatitudeDeveRetornarOValorEsperadoTest() {
		String valor = cidade1.getLatitude();
		
		assertEquals("-11.9355403048", valor);
	}

	@Test
	void SetLatitudeDeveAlterarOValorDaPropriedadeTest() {
		String novoValor = "valorTeste";
		cidade1.setLatitude(novoValor);
		
		String valor = cidade1.getLatitude();
		
		assertEquals(novoValor, valor);
	}

	@Test
	void GetNoAccentsDeveRetornarOValorEsperadoTest() {
		String valor = cidade1.getNoAccents();
		
		assertEquals("Alta Floresta D'Oeste", valor);
	}

	@Test
	void SetNoAccentsDeveAlterarOValorDaPropriedadeTest() {
		String novoValor = "valorTeste";
		cidade1.setNoAccents(novoValor);
		
		String valor = cidade1.getNoAccents();
		
		assertEquals(novoValor, valor);
	}

	@Test
	void GetAlternativeNamesDeveRetornarOValorEsperadoTest() {
		String valor = cidade1.getAlternativeNames();
		
		assertEquals("", valor);
	}

	@Test
	void SetAlternativeNamesDeveAlterarOValorDaPropriedadeTest() {
		String novoValor = "valorTeste";
		cidade1.setAlternativeNames(novoValor);
		
		String valor = cidade1.getAlternativeNames();
		
		assertEquals(novoValor, valor);
	}

	@Test
	void GetMicroRegionDeveRetornarOValorEsperadoTest() {
		String valor = cidade1.getMicroRegion();
		
		assertEquals("Cacoal", valor);
	}

	@Test
	void SetMicroRegionDeveAlterarOValorDaPropriedadeTest() {
		String novoValor = "valorTeste";
		cidade1.setMicroRegion(novoValor);
		
		String valor = cidade1.getMicroRegion();
		
		assertEquals(novoValor, valor);
	}

	@Test
	void GetMesoRegionDeveRetornarOValorEsperadoTest() {
		String valor = cidade1.getMesoRegion();
		
		assertEquals("Leste Rondoniense", valor);
	}

	@Test
	void SetMesoRegionDeveAlterarOValorDaPropriedadeTest() {
		String novoValor = "valorTeste";
		cidade1.setMesoRegion(novoValor);
		
		String valor = cidade1.getMesoRegion();
		
		assertEquals(novoValor, valor);
	}

	@Test
	void ToStringDeveRetornarOValorEsperadoTest() {
		String valorEsperado = "Cidade [ibge_id= 1100015, uf= RO, name= Alta Floresta D'Oeste, capital= , lon= -61.9998238963, lat= -11.9355403048, no_accents= Alta Floresta D'Oeste, alternative_names= , microregion= Cacoal, mesoregion= Leste Rondoniense]";
		
		String valorRetornado = cidade1.toString();
		
		assertEquals(valorEsperado, valorRetornado);
	}

	@Test
	void EqualsObjectDeveIndicarQueOsObjetosSaoIguaisTest() {
		boolean valor = cidade1.equals(cidade3);
		
		assertTrue(valor);
	}
	
	@Test
	void EqualsObjectDeveIndicarQueOsObjetosSaoDiferentesTest() {
		boolean valor = cidade1.equals(cidade2);
		
		assertFalse(valor);
	}

	private int GetHashCode(Cidade cidade) {
	    int hashCode = 1;
	    hashCode = (hashCode * 31) ^ (cidade.getIbgeId() != null ? cidade.getIbgeId().hashCode() : 0);
	    hashCode = (hashCode * 31) ^ (cidade.getUf() != null ? cidade.getUf().hashCode() : 0);
	    hashCode = (hashCode * 31) ^ (cidade.getName() != null ? cidade.getName().hashCode() : 0);
	    hashCode = (hashCode * 31) ^ (cidade.getCapital() != null ? cidade.getCapital().hashCode() : 0);
	    hashCode = (hashCode * 31) ^ (cidade.getLongitude() != null ? cidade.getLongitude().hashCode() : 0);
	    hashCode = (hashCode * 31) ^ (cidade.getLatitude() != null ? cidade.getLatitude().hashCode() : 0);
	    hashCode = (hashCode * 31) ^ (cidade.getNoAccents() != null ? cidade.getNoAccents().hashCode() : 0);
	    hashCode = (hashCode * 31) ^ (cidade.getAlternativeNames() != null ? cidade.getAlternativeNames().hashCode() : 0);
	    hashCode = (hashCode * 31) ^ (cidade.getMicroRegion() != null ? cidade.getMicroRegion().hashCode() : 0);
	    hashCode = (hashCode * 31) ^ (cidade.getMesoRegion() != null ? cidade.getMesoRegion().hashCode() : 0);
	    return hashCode;
	}
}
