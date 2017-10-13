package serviceTests;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import models.Cidade;
import services.CidadesManagerService;

class CidadesManagerServiceTests {

	@Test
	void LerCidadesDeveRetornarAsCidadesEsperadas() throws InvalidParameterException, FileNotFoundException, IOException {
		String caminho = "Teste\\Teste.teste";
		List<Cidade> cidadesEsperadas = new ArrayList<Cidade>();
		cidadesEsperadas.add(new Cidade("1100015", "RO", "Alta Floresta D'Oeste", "", "-61.9998238963", "-11.9355403048", "Alta Floresta D'Oeste", "", "Cacoal", "Leste Rondoniense"));
		cidadesEsperadas.add(new Cidade("5300108", "DF", "Brasília", "true", "-47.887905478", "-15.7940873619", "Brasilia", "", "Brasília", "Distrito Federal"));
		CidadesManagerService cidadesManager = new CidadesManagerService();
		
		List<Cidade> cidadesLidas = cidadesManager.LeiaCidades(caminho);
		
		assertEquals(cidadesEsperadas.size(), cidadesLidas.size(), "A lista possui mais valores do que o esperado.");
		assertAll("cidadesLidas",
                () -> assertTrue(cidadesEsperadas.get(0).equals(cidadesLidas.get(0)), String.format("Esperado: %s1. Retornado: %s2.", cidadesEsperadas.get(0).toString(), cidadesLidas.get(0).toString())),
                () -> assertTrue(cidadesEsperadas.get(1).equals(cidadesLidas.get(1)), String.format("Esperado: %s1. Retornado: %s2.", cidadesEsperadas.get(1).toString(), cidadesLidas.get(1).toString()))
            );
	}

	@Test
	void FiltreAListaDeCidadesPeloCampoEValorDeveFiltrarPorIbgeIdTest() throws InvalidParameterException{
		List<Cidade> cidadesParaFiltrar = new ArrayList<Cidade>();
		cidadesParaFiltrar.add(new Cidade("1100015", "RO", "Alta Floresta D'Oeste", "", "-61.9998238963", "-11.9355403048", "Alta Floresta D'Oeste", "", "Cacoal", "Leste Rondoniense"));
		cidadesParaFiltrar.add(new Cidade("1100023", "RO", "Ariquemes", "", "-63.033269278", "-9.9084628666", "Ariquemes", "", "Ariquemes", "Leste Rondoniense"));
		cidadesParaFiltrar.add(new Cidade("5300108", "DF", "Brasília", "true", "-47.887905478", "-15.7940873619", "Brasilia", "", "Brasília", "Distrito Federal"));
		List<Cidade> cidadesEsperadas = new ArrayList<Cidade>();
		cidadesEsperadas.add(new Cidade("1100015", "RO", "Alta Floresta D'Oeste", "", "-61.9998238963", "-11.9355403048", "Alta Floresta D'Oeste", "", "Cacoal", "Leste Rondoniense"));
		CidadesManagerService cidadesManager = new CidadesManagerService();
		
		List<Cidade> cidadesFiltradas = cidadesManager.FiltreAListaDeCidadesPeloCampoEValor(cidadesParaFiltrar, "ibge_id", "1100015");
		
		assertEquals(cidadesEsperadas.size(), cidadesFiltradas.size(), "A lista possui mais valores do que o esperado.");
		assertAll("cidadesLidas",
				() -> assertTrue(cidadesEsperadas.get(0).equals(cidadesFiltradas.get(0)), String.format("Esperado: %s1. Retornado: %s2.", cidadesEsperadas.get(0).toString(), cidadesFiltradas.get(0).toString()))
            );
	}
	
	@Test
	void FiltreAListaDeCidadesPeloCampoEValorDeveFiltrarPorUfTest() throws InvalidParameterException{
		List<Cidade> cidadesParaFiltrar = new ArrayList<Cidade>();
		cidadesParaFiltrar.add(new Cidade("1100015", "RO", "Alta Floresta D'Oeste", "", "-61.9998238963", "-11.9355403048", "Alta Floresta D'Oeste", "", "Cacoal", "Leste Rondoniense"));
		cidadesParaFiltrar.add(new Cidade("1100023", "RO", "Ariquemes", "", "-63.033269278", "-9.9084628666", "Ariquemes", "", "Ariquemes", "Leste Rondoniense"));
		cidadesParaFiltrar.add(new Cidade("5300108", "DF", "Brasília", "true", "-47.887905478", "-15.7940873619", "Brasilia", "", "Brasília", "Distrito Federal"));
		List<Cidade> cidadesEsperadas = new ArrayList<Cidade>();
		cidadesEsperadas.add(new Cidade("1100015", "RO", "Alta Floresta D'Oeste", "", "-61.9998238963", "-11.9355403048", "Alta Floresta D'Oeste", "", "Cacoal", "Leste Rondoniense"));
		cidadesEsperadas.add(new Cidade("1100023", "RO", "Ariquemes", "", "-63.033269278", "-9.9084628666", "Ariquemes", "", "Ariquemes", "Leste Rondoniense"));
		CidadesManagerService cidadesManager = new CidadesManagerService();
		
		List<Cidade> cidadesFiltradas = cidadesManager.FiltreAListaDeCidadesPeloCampoEValor(cidadesParaFiltrar, "uf", "RO");
		
		assertEquals(cidadesEsperadas.size(), cidadesFiltradas.size(), "A lista possui mais valores do que o esperado.");
		assertAll("cidadesLidas",
				() -> assertTrue(cidadesEsperadas.get(0).equals(cidadesFiltradas.get(0)), String.format("Esperado: %s1. Retornado: %s2.", cidadesEsperadas.get(0).toString(), cidadesFiltradas.get(0).toString())),
                () -> assertTrue(cidadesEsperadas.get(1).equals(cidadesFiltradas.get(1)), String.format("Esperado: %s1. Retornado: %s2.", cidadesEsperadas.get(1).toString(), cidadesFiltradas.get(1).toString()))
            );
	}
	
	@Test
	void FiltreAListaDeCidadesPeloCampoEValorDeveFiltrarPorNameTest() throws InvalidParameterException{
		List<Cidade> cidadesParaFiltrar = new ArrayList<Cidade>();
		cidadesParaFiltrar.add(new Cidade("1100015", "RO", "Alta Floresta D'Oeste", "", "-61.9998238963", "-11.9355403048", "Alta Floresta D'Oeste", "", "Cacoal", "Leste Rondoniense"));
		cidadesParaFiltrar.add(new Cidade("1100023", "RO", "Ariquemes", "", "-63.033269278", "-9.9084628666", "Ariquemes", "", "Ariquemes", "Leste Rondoniense"));
		cidadesParaFiltrar.add(new Cidade("5300108", "DF", "Brasília", "true", "-47.887905478", "-15.7940873619", "Brasilia", "", "Brasília", "Distrito Federal"));
		cidadesParaFiltrar.add(new Cidade("1100023", "RO", "Ariquemes", "", "-63.033269278", "-9.9084628666", "Ariquemes", "", "Ariquemes", "Leste Rondoniense"));
		List<Cidade> cidadesEsperadas = new ArrayList<Cidade>();
		cidadesEsperadas.add(new Cidade("1100023", "RO", "Ariquemes", "", "-63.033269278", "-9.9084628666", "Ariquemes", "", "Ariquemes", "Leste Rondoniense"));
		cidadesEsperadas.add(new Cidade("1100023", "RO", "Ariquemes", "", "-63.033269278", "-9.9084628666", "Ariquemes", "", "Ariquemes", "Leste Rondoniense"));
		CidadesManagerService cidadesManager = new CidadesManagerService();
		
		List<Cidade> cidadesFiltradas = cidadesManager.FiltreAListaDeCidadesPeloCampoEValor(cidadesParaFiltrar, "name", "Ariquemes");
		
		assertEquals(cidadesEsperadas.size(), cidadesFiltradas.size(), "A lista possui mais valores do que o esperado.");
		assertAll("cidadesLidas",
				() -> assertTrue(cidadesEsperadas.get(0).equals(cidadesFiltradas.get(0)), String.format("Esperado: %s1. Retornado: %s2.", cidadesEsperadas.get(0).toString(), cidadesFiltradas.get(0).toString())),
                () -> assertTrue(cidadesEsperadas.get(1).equals(cidadesFiltradas.get(1)), String.format("Esperado: %s1. Retornado: %s2.", cidadesEsperadas.get(1).toString(), cidadesFiltradas.get(1).toString()))
            );
	}
	
	@Test
	void FiltreAListaDeCidadesPeloCampoEValorDeveFiltrarPorCapitalTest() throws InvalidParameterException{
		List<Cidade> cidadesParaFiltrar = new ArrayList<Cidade>();
		cidadesParaFiltrar.add(new Cidade("1100015", "RO", "Alta Floresta D'Oeste", "true", "-61.9998238963", "-11.9355403048", "Alta Floresta D'Oeste", "", "Cacoal", "Leste Rondoniense"));
		cidadesParaFiltrar.add(new Cidade("1100023", "RO", "Ariquemes", "", "-63.033269278", "-9.9084628666", "Ariquemes", "", "Ariquemes", "Leste Rondoniense"));
		cidadesParaFiltrar.add(new Cidade("5300108", "DF", "Brasília", "true", "-47.887905478", "-15.7940873619", "Brasilia", "", "Brasília", "Distrito Federal"));
		cidadesParaFiltrar.add(new Cidade("1100023", "RO", "Ariquemes", "", "-63.033269278", "-9.9084628666", "Ariquemes", "", "Ariquemes", "Leste Rondoniense"));
		List<Cidade> cidadesEsperadas = new ArrayList<Cidade>();
		cidadesEsperadas.add(new Cidade("1100015", "RO", "Alta Floresta D'Oeste", "true", "-61.9998238963", "-11.9355403048", "Alta Floresta D'Oeste", "", "Cacoal", "Leste Rondoniense"));
		cidadesEsperadas.add(new Cidade("5300108", "DF", "Brasília", "true", "-47.887905478", "-15.7940873619", "Brasilia", "", "Brasília", "Distrito Federal"));
		CidadesManagerService cidadesManager = new CidadesManagerService();
		
		List<Cidade> cidadesFiltradas = cidadesManager.FiltreAListaDeCidadesPeloCampoEValor(cidadesParaFiltrar, "capital", "true");
		
		assertEquals(cidadesEsperadas.size(), cidadesFiltradas.size(), "A lista possui mais valores do que o esperado.");
		assertAll("cidadesLidas",
				() -> assertTrue(cidadesEsperadas.get(0).equals(cidadesFiltradas.get(0)), String.format("Esperado: %s1. Retornado: %s2.", cidadesEsperadas.get(0).toString(), cidadesFiltradas.get(0).toString())),
                () -> assertTrue(cidadesEsperadas.get(1).equals(cidadesFiltradas.get(1)), String.format("Esperado: %s1. Retornado: %s2.", cidadesEsperadas.get(1).toString(), cidadesFiltradas.get(1).toString()))
            );
	}
	
	@Test
	void FiltreAListaDeCidadesPeloCampoEValorDeveFiltrarPorLongitude() throws InvalidParameterException{
		List<Cidade> cidadesParaFiltrar = new ArrayList<Cidade>();
		cidadesParaFiltrar.add(new Cidade("1100015", "RO", "Alta Floresta D'Oeste", "", "-61.9998238963", "-11.9355403048", "Alta Floresta D'Oeste", "", "Cacoal", "Leste Rondoniense"));
		cidadesParaFiltrar.add(new Cidade("1100023", "RO", "Ariquemes", "", "-63.033269278", "-9.9084628666", "Ariquemes", "", "Ariquemes", "Leste Rondoniense"));
		cidadesParaFiltrar.add(new Cidade("5300108", "DF", "Brasília", "true", "-47.887905478", "-15.7940873619", "Brasilia", "", "Brasília", "Distrito Federal"));
		cidadesParaFiltrar.add(new Cidade("1100023", "RO", "Ariquemes", "", "-63.033269278", "-9.9084628666", "Ariquemes", "", "Ariquemes", "Leste Rondoniense"));
		List<Cidade> cidadesEsperadas = new ArrayList<Cidade>();
		cidadesEsperadas.add(new Cidade("1100023", "RO", "Ariquemes", "", "-63.033269278", "-9.9084628666", "Ariquemes", "", "Ariquemes", "Leste Rondoniense"));
		cidadesEsperadas.add(new Cidade("1100023", "RO", "Ariquemes", "", "-63.033269278", "-9.9084628666", "Ariquemes", "", "Ariquemes", "Leste Rondoniense"));
		CidadesManagerService cidadesManager = new CidadesManagerService();
		
		List<Cidade> cidadesFiltradas = cidadesManager.FiltreAListaDeCidadesPeloCampoEValor(cidadesParaFiltrar, "lon", "-63.033269278");
		
		assertEquals(cidadesEsperadas.size(), cidadesFiltradas.size(), "A lista possui mais valores do que o esperado.");
		assertAll("cidadesLidas",
				() -> assertTrue(cidadesEsperadas.get(0).equals(cidadesFiltradas.get(0)), String.format("Esperado: %s1. Retornado: %s2.", cidadesEsperadas.get(0).toString(), cidadesFiltradas.get(0).toString())),
                () -> assertTrue(cidadesEsperadas.get(1).equals(cidadesFiltradas.get(1)), String.format("Esperado: %s1. Retornado: %s2.", cidadesEsperadas.get(1).toString(), cidadesFiltradas.get(1).toString()))
            );
	}
	
	@Test
	void FiltreAListaDeCidadesPeloCampoEValorDeveFiltrarPorLatitude() throws InvalidParameterException{
		List<Cidade> cidadesParaFiltrar = new ArrayList<Cidade>();
		cidadesParaFiltrar.add(new Cidade("1100015", "RO", "Alta Floresta D'Oeste", "", "-61.9998238963", "-11.9355403048", "Alta Floresta D'Oeste", "", "Cacoal", "Leste Rondoniense"));
		cidadesParaFiltrar.add(new Cidade("1100023", "RO", "Ariquemes", "", "-63.033269278", "-9.9084628666", "Ariquemes", "", "Ariquemes", "Leste Rondoniense"));
		cidadesParaFiltrar.add(new Cidade("5300108", "DF", "Brasília", "true", "-47.887905478", "-15.7940873619", "Brasilia", "", "Brasília", "Distrito Federal"));
		cidadesParaFiltrar.add(new Cidade("1100023", "RO", "Ariquemes", "", "-63.033269278", "-9.9084628666", "Ariquemes", "", "Ariquemes", "Leste Rondoniense"));
		List<Cidade> cidadesEsperadas = new ArrayList<Cidade>();
		cidadesEsperadas.add(new Cidade("1100023", "RO", "Ariquemes", "", "-63.033269278", "-9.9084628666", "Ariquemes", "", "Ariquemes", "Leste Rondoniense"));
		cidadesEsperadas.add(new Cidade("1100023", "RO", "Ariquemes", "", "-63.033269278", "-9.9084628666", "Ariquemes", "", "Ariquemes", "Leste Rondoniense"));
		CidadesManagerService cidadesManager = new CidadesManagerService();
		
		List<Cidade> cidadesFiltradas = cidadesManager.FiltreAListaDeCidadesPeloCampoEValor(cidadesParaFiltrar, "lat", "-9.9084628666");
		
		assertEquals(cidadesEsperadas.size(), cidadesFiltradas.size(), "A lista possui mais valores do que o esperado.");
		assertAll("cidadesLidas",
				() -> assertTrue(cidadesEsperadas.get(0).equals(cidadesFiltradas.get(0)), String.format("Esperado: %s1. Retornado: %s2.", cidadesEsperadas.get(0).toString(), cidadesFiltradas.get(0).toString())),
                () -> assertTrue(cidadesEsperadas.get(1).equals(cidadesFiltradas.get(1)), String.format("Esperado: %s1. Retornado: %s2.", cidadesEsperadas.get(1).toString(), cidadesFiltradas.get(1).toString()))
            );
	}
	
	@Test
	void FiltreAListaDeCidadesPeloCampoEValorDeveFiltrarPorNoAccentsTest() throws InvalidParameterException{
		List<Cidade> cidadesParaFiltrar = new ArrayList<Cidade>();
		cidadesParaFiltrar.add(new Cidade("1100015", "RO", "Alta Floresta D'Oeste", "", "-61.9998238963", "-11.9355403048", "Alta Floresta D'Oeste", "", "Cacoal", "Leste Rondoniense"));
		cidadesParaFiltrar.add(new Cidade("1100023", "RO", "Ariquemes", "", "-63.033269278", "-9.9084628666", "Ariquemes", "", "Ariquemes", "Leste Rondoniense"));
		cidadesParaFiltrar.add(new Cidade("5300108", "DF", "Brasília", "true", "-47.887905478", "-15.7940873619", "Brasilia", "", "Brasília", "Distrito Federal"));
		cidadesParaFiltrar.add(new Cidade("1100023", "RO", "Ariquemes", "", "-63.033269278", "-9.9084628666", "Ariquemes", "", "Ariquemes", "Leste Rondoniense"));
		List<Cidade> cidadesEsperadas = new ArrayList<Cidade>();
		cidadesEsperadas.add(new Cidade("1100023", "RO", "Ariquemes", "", "-63.033269278", "-9.9084628666", "Ariquemes", "", "Ariquemes", "Leste Rondoniense"));
		cidadesEsperadas.add(new Cidade("1100023", "RO", "Ariquemes", "", "-63.033269278", "-9.9084628666", "Ariquemes", "", "Ariquemes", "Leste Rondoniense"));
		CidadesManagerService cidadesManager = new CidadesManagerService();
		
		List<Cidade> cidadesFiltradas = cidadesManager.FiltreAListaDeCidadesPeloCampoEValor(cidadesParaFiltrar, "no_accents", "Ariquemes");
		
		assertEquals(cidadesEsperadas.size(), cidadesFiltradas.size(), "A lista possui mais valores do que o esperado.");
		assertAll("cidadesLidas",
				() -> assertTrue(cidadesEsperadas.get(0).equals(cidadesFiltradas.get(0)), String.format("Esperado: %s1. Retornado: %s2.", cidadesEsperadas.get(0).toString(), cidadesFiltradas.get(0).toString())),
                () -> assertTrue(cidadesEsperadas.get(1).equals(cidadesFiltradas.get(1)), String.format("Esperado: %s1. Retornado: %s2.", cidadesEsperadas.get(1).toString(), cidadesFiltradas.get(1).toString()))
            );
	}
	
	@Test
	void FiltreAListaDeCidadesPeloCampoEValorDeveFiltrarPorAlternativeNamesTest() throws InvalidParameterException{
		List<Cidade> cidadesParaFiltrar = new ArrayList<Cidade>();
		cidadesParaFiltrar.add(new Cidade("1100015", "RO", "Alta Floresta D'Oeste", "", "-61.9998238963", "-11.9355403048", "Alta Floresta D'Oeste", "", "Cacoal", "Leste Rondoniense"));
		cidadesParaFiltrar.add(new Cidade("1100023", "RO", "Ariquemes", "", "-63.033269278", "-9.9084628666", "Ariquemes", "alternativo", "Ariquemes", "Leste Rondoniense"));
		cidadesParaFiltrar.add(new Cidade("5300108", "DF", "Brasília", "true", "-47.887905478", "-15.7940873619", "Brasilia", "", "Brasília", "Distrito Federal"));
		cidadesParaFiltrar.add(new Cidade("1100023", "RO", "Ariquemes", "", "-63.033269278", "-9.9084628666", "Ariquemes", "alternativo", "Ariquemes", "Leste Rondoniense"));
		List<Cidade> cidadesEsperadas = new ArrayList<Cidade>();
		cidadesEsperadas.add(new Cidade("1100023", "RO", "Ariquemes", "", "-63.033269278", "-9.9084628666", "Ariquemes", "alternativo", "Ariquemes", "Leste Rondoniense"));
		cidadesEsperadas.add(new Cidade("1100023", "RO", "Ariquemes", "", "-63.033269278", "-9.9084628666", "Ariquemes", "alternativo", "Ariquemes", "Leste Rondoniense"));
		CidadesManagerService cidadesManager = new CidadesManagerService();
		
		List<Cidade> cidadesFiltradas = cidadesManager.FiltreAListaDeCidadesPeloCampoEValor(cidadesParaFiltrar, "alternative_names", "alternativo");
		
		assertEquals(cidadesEsperadas.size(), cidadesFiltradas.size(), "A lista possui mais valores do que o esperado.");
		assertAll("cidadesLidas",
				() -> assertTrue(cidadesEsperadas.get(0).equals(cidadesFiltradas.get(0)), String.format("Esperado: %s1. Retornado: %s2.", cidadesEsperadas.get(0).toString(), cidadesFiltradas.get(0).toString())),
                () -> assertTrue(cidadesEsperadas.get(1).equals(cidadesFiltradas.get(1)), String.format("Esperado: %s1. Retornado: %s2.", cidadesEsperadas.get(1).toString(), cidadesFiltradas.get(1).toString()))
            );
	}
	
	@Test
	void FiltreAListaDeCidadesPeloCampoEValorDeveFiltrarPorMicroRegionTest() throws InvalidParameterException{
		List<Cidade> cidadesParaFiltrar = new ArrayList<Cidade>();
		cidadesParaFiltrar.add(new Cidade("1100015", "RO", "Alta Floresta D'Oeste", "", "-61.9998238963", "-11.9355403048", "Alta Floresta D'Oeste", "", "Cacoal", "Leste Rondoniense"));
		cidadesParaFiltrar.add(new Cidade("1100023", "RO", "Ariquemes", "", "-63.033269278", "-9.9084628666", "Ariquemes", "", "Ariquemes", "Leste Rondoniense"));
		cidadesParaFiltrar.add(new Cidade("5300108", "DF", "Brasília", "true", "-47.887905478", "-15.7940873619", "Brasilia", "", "Brasília", "Distrito Federal"));
		cidadesParaFiltrar.add(new Cidade("1100023", "RO", "Ariquemes", "", "-63.033269278", "-9.9084628666", "Ariquemes", "", "Ariquemes", "Leste Rondoniense"));
		List<Cidade> cidadesEsperadas = new ArrayList<Cidade>();
		cidadesEsperadas.add(new Cidade("1100023", "RO", "Ariquemes", "", "-63.033269278", "-9.9084628666", "Ariquemes", "", "Ariquemes", "Leste Rondoniense"));
		cidadesEsperadas.add(new Cidade("1100023", "RO", "Ariquemes", "", "-63.033269278", "-9.9084628666", "Ariquemes", "", "Ariquemes", "Leste Rondoniense"));
		CidadesManagerService cidadesManager = new CidadesManagerService();
		
		List<Cidade> cidadesFiltradas = cidadesManager.FiltreAListaDeCidadesPeloCampoEValor(cidadesParaFiltrar, "microregion", "Ariquemes");
		
		assertEquals(cidadesEsperadas.size(), cidadesFiltradas.size(), "A lista possui mais valores do que o esperado.");
		assertAll("cidadesLidas",
				() -> assertTrue(cidadesEsperadas.get(0).equals(cidadesFiltradas.get(0)), String.format("Esperado: %s1. Retornado: %s2.", cidadesEsperadas.get(0).toString(), cidadesFiltradas.get(0).toString())),
                () -> assertTrue(cidadesEsperadas.get(1).equals(cidadesFiltradas.get(1)), String.format("Esperado: %s1. Retornado: %s2.", cidadesEsperadas.get(1).toString(), cidadesFiltradas.get(1).toString()))
            );
	}
	
	@Test
	void FiltreAListaDeCidadesPeloCampoEValorDeveFiltrarPorMesoRegionTest() throws InvalidParameterException{
		List<Cidade> cidadesParaFiltrar = new ArrayList<Cidade>();
		cidadesParaFiltrar.add(new Cidade("1100015", "RO", "Alta Floresta D'Oeste", "", "-61.9998238963", "-11.9355403048", "Alta Floresta D'Oeste", "", "Cacoal", "Leste Rondoniense"));
		cidadesParaFiltrar.add(new Cidade("1100023", "RO", "Ariquemes", "", "-63.033269278", "-9.9084628666", "Ariquemes", "", "Ariquemes", "Leste Rondoniense"));
		cidadesParaFiltrar.add(new Cidade("5300108", "DF", "Brasília", "true", "-47.887905478", "-15.7940873619", "Brasilia", "", "Brasília", "Distrito Federal"));
		cidadesParaFiltrar.add(new Cidade("1100023", "RO", "Ariquemes", "", "-63.033269278", "-9.9084628666", "Ariquemes", "", "Ariquemes", "Leste Rondoniense"));
		List<Cidade> cidadesEsperadas = new ArrayList<Cidade>();
		cidadesEsperadas.add(new Cidade("1100015", "RO", "Alta Floresta D'Oeste", "", "-61.9998238963", "-11.9355403048", "Alta Floresta D'Oeste", "", "Cacoal", "Leste Rondoniense"));
		cidadesEsperadas.add(new Cidade("1100023", "RO", "Ariquemes", "", "-63.033269278", "-9.9084628666", "Ariquemes", "", "Ariquemes", "Leste Rondoniense"));
		cidadesEsperadas.add(new Cidade("1100023", "RO", "Ariquemes", "", "-63.033269278", "-9.9084628666", "Ariquemes", "", "Ariquemes", "Leste Rondoniense"));
		CidadesManagerService cidadesManager = new CidadesManagerService();
		
		List<Cidade> cidadesFiltradas = cidadesManager.FiltreAListaDeCidadesPeloCampoEValor(cidadesParaFiltrar, "mesoregion", "Leste Rondoniense");
		
		assertEquals(cidadesEsperadas.size(), cidadesFiltradas.size(), "A lista possui mais valores do que o esperado.");
		assertAll("cidadesLidas",
				() -> assertTrue(cidadesEsperadas.get(0).equals(cidadesFiltradas.get(0)), String.format("Esperado: %s1. Retornado: %s2.", cidadesEsperadas.get(0).toString(), cidadesFiltradas.get(0).toString())),
                () -> assertTrue(cidadesEsperadas.get(1).equals(cidadesFiltradas.get(1)), String.format("Esperado: %s1. Retornado: %s2.", cidadesEsperadas.get(1).toString(), cidadesFiltradas.get(1).toString()))
            );
	}
}
