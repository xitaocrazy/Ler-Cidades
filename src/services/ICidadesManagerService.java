package services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ICidadesManagerService  {
	List<Cidade> LerCidades(String caminho) throws IOException, FileNotFoundException;
}
