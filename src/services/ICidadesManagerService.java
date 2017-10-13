package services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import models.Cidade;

public interface ICidadesManagerService  {
	List<Cidade> LeiaCidades(String caminho) throws IOException, FileNotFoundException;
	int BusqueQuantidadeDeItensDistintosPeloCampo(List<Cidade> cidades, String campo);
	List<Cidade> FiltreAListaDeCidadesPeloCampoEValor(List<Cidade> cidades, String campo, String valor);
}