package helpers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.Cidade;
import services.ILeitorDeCidades;

public class LeitorTesteService implements ILeitorDeCidades {

	@Override
	public List<Cidade> LeiaCidades(String caminho) throws IOException, FileNotFoundException {
		List<Cidade> cidades = new ArrayList<Cidade>();
		cidades.add(new Cidade("1100015", "RO", "Alta Floresta D'Oeste", "", "-61.9998238963", "-11.9355403048", "Alta Floresta D'Oeste", "", "Cacoal", "Leste Rondoniense"));
		cidades.add(new Cidade("5300108", "DF", "Brasília", "true", "-47.887905478", "-15.7940873619", "Brasilia", "", "Brasília", "Distrito Federal"));
		return cidades;
	}

}