package services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import models.Cidade;

public class CidadesManagerService implements ICidadesManagerService {

	public List<Cidade> LeiaCidades(String caminho) throws IOException, FileNotFoundException, InvalidParameterException {
		String[] partesDoCaminho = caminho.split(Pattern.quote("\\"));
		String parteFinal = partesDoCaminho[partesDoCaminho.length - 1];
		String[] dadosParteFinal = parteFinal.split(Pattern.quote("."));
		String extensao = dadosParteFinal[dadosParteFinal.length - 1];
		ILeitorDeCidades leitor = LeitorDeCidadesFactory.CrieInstanciaDeLeitor(extensao);
		List<Cidade> cidades = leitor.LeiaCidades(caminho);
		return cidades;
	}
	
	public int BusqueQuantidadeDeItensDistintosPeloCampo(List<Cidade> cidades, String campo){
		List<String> campos;
			switch (campo) {
			case "ibge_id":
				campos = cidades.stream().map(cidade -> cidade.getIbgeId()).collect(Collectors.toList());
				break;
			case "uf":
				campos = cidades.stream().map(cidade -> cidade.getUf()).collect(Collectors.toList());
				break;
			case "name":
				campos = cidades.stream().map(cidade -> cidade.getName()).collect(Collectors.toList());
				break;
			case "capital":
				campos = cidades.stream().map(cidade -> cidade.getCapital()).collect(Collectors.toList());
				break;
			case "lon":
				campos = cidades.stream().map(cidade -> cidade.getLongitude()).collect(Collectors.toList());
				break;
			case "lat":
				campos = cidades.stream().map(cidade -> cidade.getLatitude()).collect(Collectors.toList());
				break;
			case "no_accents":
				campos = cidades.stream().map(cidade -> cidade.getNoAccents()).collect(Collectors.toList());
				break;
			case "alternative_names":
				campos = cidades.stream().map(cidade -> cidade.getAlternativeNames()).collect(Collectors.toList());
				break;
			case "microregion":
				campos = cidades.stream().map(cidade -> cidade.getMicroRegion()).collect(Collectors.toList());
				break;
			case "mesoregion":
				campos = cidades.stream().map(cidade -> cidade.getMesoRegion()).collect(Collectors.toList());
				break;
			default:
				String mensagem = String.format("O campo .%s não é válido.", campo);
				throw new InvalidParameterException(mensagem);
		}
		
		List<String> camposUnicos = campos.stream().distinct().collect(Collectors.toList()); 
		return camposUnicos.size();
	}
	
	public List<Cidade> FiltreAListaDeCidadesPeloCampoEValor(List<Cidade> cidades, String campo, String valor){
		List<Cidade> cidadesFiltradas;
		switch (campo) {
			case "ibge_id":
				cidadesFiltradas = cidades.stream().filter(cidade -> cidade.getIbgeId().contains(valor)).collect(Collectors.toList());
				break;
			case "uf":
				cidadesFiltradas = cidades.stream().filter(cidade -> cidade.getUf().contains(valor)).collect(Collectors.toList());
				break;
			case "name":
				cidadesFiltradas = cidades.stream().filter(cidade -> cidade.getName().contains(valor)).collect(Collectors.toList());
				break;
			case "capital":
				cidadesFiltradas = cidades.stream().filter(cidade -> cidade.getCapital().contains(valor)).collect(Collectors.toList());
				break;
			case "lon":
				cidadesFiltradas = cidades.stream().filter(cidade -> cidade.getLongitude().contains(valor)).collect(Collectors.toList());
				break;
			case "lat":
				cidadesFiltradas = cidades.stream().filter(cidade -> cidade.getLatitude().contains(valor)).collect(Collectors.toList());
				break;
			case "no_accents":
				cidadesFiltradas = cidades.stream().filter(cidade -> cidade.getNoAccents().contains(valor)).collect(Collectors.toList());
				break;
			case "alternative_names":
				cidadesFiltradas = cidades.stream().filter(cidade -> cidade.getAlternativeNames().contains(valor)).collect(Collectors.toList());
				break;
			case "microregion":
				cidadesFiltradas = cidades.stream().filter(cidade -> cidade.getMicroRegion().contains(valor)).collect(Collectors.toList());
				break;
			case "mesoregion":
				cidadesFiltradas = cidades.stream().filter(cidade -> cidade.getMesoRegion().contains(valor)).collect(Collectors.toList());
				break;
			default:
				String mensagem = String.format("O campo .%s não é válido.", campo);
				throw new InvalidParameterException(mensagem);
		}
		
		return cidadesFiltradas;
	}
}
