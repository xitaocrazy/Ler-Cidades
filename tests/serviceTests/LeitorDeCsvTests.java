package serviceTests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import services.Cidade;
import services.LeitorDeCsvService;

class LeitorDeCsvTests {

	@Test
	void LerCidadesDeveRetornarAsCidadesEsperadasTest() throws FileNotFoundException, IOException {
		String caminho = "C:\\Users\\daniel.martins\\Documents\\GitHub\\Ler-Cidades\\tests\\cidades-fontes\\cidades.csv";
		LeitorDeCsvService leitor = new LeitorDeCsvService();
		List<Cidade> cidadesEsperadas = new ArrayList<Cidade>();
		cidadesEsperadas.add(new Cidade("1100015", "RO", "Alta Floresta D'Oeste", "", "-61.9998238963", "-11.9355403048", "Alta Floresta D'Oeste", "", "Cacoal", "Leste Rondoniense"));
		cidadesEsperadas.add(new Cidade("5300108", "DF", "Brasília", "true", "-47.887905478", "-15.7940873619", "Brasilia", "", "Brasília", "Distrito Federal"));
		
		List<Cidade> cidadesLidas;
		cidadesLidas = leitor.LerCidades(caminho);
		
		assertEquals(cidadesEsperadas.size(), cidadesLidas.size(), "A lista possui mais valores do que o esperado.");
		assertAll("cidadesLidas",
                () -> assertTrue(cidadesEsperadas.get(0).equals(cidadesLidas.get(0)), "Esperado: " + cidadesEsperadas.get(0).toString() + " Retornado: " + cidadesLidas.get(0).toString()),
                () -> assertTrue(cidadesEsperadas.get(0).equals(cidadesLidas.get(0)), "Esperado: " + cidadesEsperadas.get(0).toString() + " Retornado: " + cidadesLidas.get(0).toString())
            );
	}

}
