package services;

import java.security.InvalidParameterException;

public class LeitorDeCidadesFactory {
	public static ILeitorDeCidades CrieInstanciaDeLeitor(String extensao) {
		switch(extensao) {
		case "csv":
			return new LeitorDeCsvService();
		default:
			throw new InvalidParameterException("Infelizmente o tipo de arquivo ." + extensao + " não é suportado.");
		}
		
	}
}
