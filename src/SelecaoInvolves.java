import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import models.Cidade;
import services.CidadesManagerService;
import services.ICidadesManagerService;

public class SelecaoInvolves {

	  public static void main(String[] args) {
		  SelecaoInvolves obj = new SelecaoInvolves();
		  obj.run();
	  }

	  public void run() {
		  ICidadesManagerService service = new CidadesManagerService();
		  String caminho = "C:\\Users\\daniel.martins\\Documents\\GitHub\\Ler-Cidades\\cidades-fontes\\cidades.csv";
		  //String caminho = "C:\\Users\\daniel.martins\\Documents\\GitHub\\selecaoinvolves\\cidadesJson.json";
		  //String caminho = "C:\\Users\\daniel.martins\\Documents\\GitHub\\selecaoinvolves\\cidadesXml.xml";
		  List<Cidade> cidades;
		  Cidade cidade;
		    try {	
		    	cidades = service.LerCidades(caminho);
		        for(int i = 0; i < cidades.size(); i++) {
		        	cidade = cidades.get(i);
		        	System.out.println("Cidade [ibge_id= " + cidade.getIbgeId() 
                            			+ " , uf=" + cidade.getUf()
							        	+ " , name=" + cidade.getName()
							        	+ " , capital=" + cidade.getCapital()
							        	+ " , lon=" + cidade.getLongitude()
							        	+ " , lat=" + cidade.getLatitude()
							        	+ " , no_accents=" + cidade.getNoAccents()
							        	+ " , alternative_names=" + cidade.getAlternativeNames()
							        	+ " , microregion=" + cidade.getMicroRegion()
							        	+ " , mesoregion=" + cidade.getMesoRegion() + "]");
		        }
	
		    } catch (FileNotFoundException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
	  }

}
