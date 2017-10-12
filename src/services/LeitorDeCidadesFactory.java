package services;

import java.security.InvalidParameterException;

import helpers.LeitorTesteService;

public class LeitorDeCidadesFactory {
	public static ILeitorDeCidades CrieInstanciaDeLeitor(String extensao) {
		switch(extensao) {
		case "csv":
			return new LeitorDeCsvService();
		case "teste": //Como não podia usar nenhum framework para mock, tive que fazer referência ao projeto de testes para usar a classe que faz o mock do comportamento de leitura.
			return new LeitorTesteService();
		default:
			String mensagem = String.format("Infelizmente o tipo de arquivo .%s não é suportado.", extensao);
			throw new InvalidParameterException(mensagem);
		}
		
	}
}
