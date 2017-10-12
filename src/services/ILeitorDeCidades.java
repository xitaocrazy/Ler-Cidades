package services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ILeitorDeCidades {
	List<Cidade> LerCidades(String caminho) throws IOException, FileNotFoundException;
}
