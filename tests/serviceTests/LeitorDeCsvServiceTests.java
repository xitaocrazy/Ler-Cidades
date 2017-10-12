package serviceTests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import models.Cidade;
import services.LeitorDeCsvService;

class LeitorDeCsvServiceTests {

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

	@Test
    void LerCidadesDeveRetornarFileNotFoundExceptionQuandoNaoEncontrarOArquivoTest() {
		String caminho = "C:\\cidades.csv";
		LeitorDeCsvService leitor = new LeitorDeCsvService();

        Throwable exception = assertThrows(FileNotFoundException.class, () -> leitor.LerCidades(caminho));
        assertEquals(FileNotFoundException.class, exception.getClass());
        assertEquals("C:\\cidades.csv (O sistema não pode encontrar o arquivo especificado)", exception.getMessage());
    }
	
	//Não consegui provocar um IOException sem ter um framework para mock
	//@Test
    //void LerCidadesDeveRetornarIOExceptionQuandoOcorrerErroDuranteALeituraTest() {
	//	String caminho = "C:\\cidades.csv";
	//	LeitorDeCsvService leitor = new LeitorDeCsvService();
    //
    //    Throwable exception = assertThrows(IOException.class, () -> leitor.LerCidades(caminho));
    //    assertEquals(IOException.class, exception.getClass());
    //}
}
