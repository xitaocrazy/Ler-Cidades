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
		
		List<Cidade> cidadesLidas = cidadesManager.LerCidades(caminho);
		
		assertEquals(cidadesEsperadas.size(), cidadesLidas.size(), "A lista possui mais valores do que o esperado.");
		assertAll("cidadesLidas",
                () -> assertTrue(cidadesEsperadas.get(0).equals(cidadesLidas.get(0)), "Esperado: " + cidadesEsperadas.get(0).toString() + " Retornado: " + cidadesLidas.get(0).toString()),
                () -> assertTrue(cidadesEsperadas.get(0).equals(cidadesLidas.get(0)), "Esperado: " + cidadesEsperadas.get(0).toString() + " Retornado: " + cidadesLidas.get(0).toString())
            );
	}

}
