package services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.List;

public class CidadesManagerService implements ICidadesManagerService {

	@Override
	public List<Cidade> LerCidades(String caminho) throws IOException, FileNotFoundException, InvalidParameterException {
		ILeitorDeCidades leitor = LeitorDeCidadesFactory.CrieInstanciaDeLeitor("csv");
		List<Cidade> cidades = leitor.LerCidades(caminho);
		return cidades;
	}
}
