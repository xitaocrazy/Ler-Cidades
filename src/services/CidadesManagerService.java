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
	
	public List<Cidade> BusqueItensDistinguindoPeloCampo(List<Cidade> cidades, String campo){
		List<Cidade> cidadesFiltradas = cidades.stream().filter(cidade -> cidade.getName() != null && !cidade.getName().equals("")).collect(Collectors.toList());
		return cidadesFiltradas;
		
		
		// Create the list with duplicates. 
		//List<String> listAll = Arrays.asList("CO2", "CH4", "SO2", "CO2", "CH4", "SO2", "CO2", "CH4", "SO2"); 
		// Create a list with the distinct elements using stream. 
		//List<String> listDistinct = listAll.stream().distinct().collect(Collectors.toList()); 
		// Display them to terminal using stream::collect with a build in Collector. 
		//String collectAll = listAll.stream().collect(Collectors.joining(", ")); 
		//System.out.println(collectAll); //=> CO2, CH4, SO2, CO2, CH4 etc.. 
		//String collectDistinct = listDistinct.stream().collect(Collectors.joining(", ")); 
		//System.out.println(collectDistinct); //=> CO2, CH4, SO2
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
