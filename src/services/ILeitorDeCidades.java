package services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import models.Cidade;

public interface ILeitorDeCidades {
	List<Cidade> LeiaCidades(String caminho) throws IOException, FileNotFoundException;
}
