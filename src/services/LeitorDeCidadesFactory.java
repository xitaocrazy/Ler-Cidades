package services;

import java.security.InvalidParameterException;

import helpers.LeitorTesteService;

public class LeitorDeCidadesFactory {
	public static ILeitorDeCidades CrieInstanciaDeLeitor(String extensao) {
		switch(extensao) {
		case "csv":
			return new LeitorDeCsvService();
		case "teste": //Como n�o podia usar nenhum framework para mock, tive que fazer refer�ncia ao projeto de testes para usar a classe que faz o mock do comportamento de leitura.
			return new LeitorTesteService();
		default:
			String mensagem = String.format("Infelizmente o tipo de arquivo .%s n�o � suportado.", extensao);
			throw new InvalidParameterException(mensagem);
		}
		
	}
}
