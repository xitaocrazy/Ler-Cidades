package services;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import models.Cidade;

public class LeitorDeCsvService implements ILeitorDeCidades {

	@Override
	public List<Cidade> LeiaCidades(String caminho) throws IOException, FileNotFoundException {
		List<Cidade> cidades = new ArrayList<Cidade>();
		BufferedReader buffer = null;
	    String linha = "";
	    String csvDivisor = ",";
	    try {
	        buffer = new BufferedReader(new InputStreamReader(new FileInputStream(caminho), "UTF-8"));
	        linha = buffer.readLine();
	        while ((linha = buffer.readLine()) != null) {	        	
	            String[] cidade = linha.split(csvDivisor);
	            Cidade city = new Cidade(cidade[0], cidade[1], cidade[2], cidade[3], cidade[4], cidade[5], cidade[6], cidade[7], cidade[8], cidade[9]);
	            cidades.add(city);
	        }

	    } finally {
	        if (buffer != null) {
	        	buffer.close();
	        }
	    }			
		return cidades;
	}

}
