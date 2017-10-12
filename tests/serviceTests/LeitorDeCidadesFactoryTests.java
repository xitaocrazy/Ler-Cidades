package serviceTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.Test;

import helpers.LeitorTesteService;
import services.ILeitorDeCidades;
import services.LeitorDeCidadesFactory;
import services.LeitorDeCsvService;

class LeitorDeCidadesFactoryTests {

	@Test
	void CrieInstanciaDeLeitorDeveRetornarUmObjetoDoTipoLeitorDeCsvService() {
		ILeitorDeCidades leitor = LeitorDeCidadesFactory.CrieInstanciaDeLeitor("csv");
		
		assertEquals(leitor.getClass(), LeitorDeCsvService.class);
	}

	@Test
	void CrieInstanciaDeLeitorDeveRetornarUmObjetoDoTipoLeitorTesteService() {
		ILeitorDeCidades leitor = LeitorDeCidadesFactory.CrieInstanciaDeLeitor("teste");
		
		assertEquals(leitor.getClass(), LeitorTesteService.class);
	}
	
	@Test
	 void CrieInstanciaDeLeitorDeveRetornarInvalidParameterExceptionQuandoNaoConhecerAExtensaoTest() {
		Throwable exception = assertThrows(InvalidParameterException.class, () -> LeitorDeCidadesFactory.CrieInstanciaDeLeitor("ttt"));
        assertEquals(InvalidParameterException.class, exception.getClass());
        assertEquals("Infelizmente o tipo de arquivo .ttt não é suportado.", exception.getMessage());
    }
}
