package services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.regex.Pattern;

import models.Cidade;

public class CidadesManagerService implements ICidadesManagerService {

	@Override
	public List<Cidade> LerCidades(String caminho) throws IOException, FileNotFoundException, InvalidParameterException {
		String[] partesDoCaminho = caminho.split(Pattern.quote("\\"));
		String parteFinal = partesDoCaminho[partesDoCaminho.length - 1];
		String[] dadosParteFinal = parteFinal.split(Pattern.quote("."));
		String extensao = dadosParteFinal[dadosParteFinal.length - 1];
		ILeitorDeCidades leitor = LeitorDeCidadesFactory.CrieInstanciaDeLeitor(extensao);
		List<Cidade> cidades = leitor.LerCidades(caminho);
		return cidades;
	}
}
