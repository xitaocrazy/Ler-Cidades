import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import models.Cidade;
import services.CidadesManagerService;
import services.ICidadesManagerService;

public class SelecaoInvolves {
	  private static final Scanner SCANNER = new Scanner(System.in);
	  private List<Cidade> cidades;
	  
	  public static void main(String[] args) {
		  SelecaoInvolves obj = new SelecaoInvolves();
		  obj.run();
	  }

	  public void run() {
		  this.cidades = this.LeiaCidades();
		  AguardeComando();
	  }
	  
	  @SuppressWarnings("finally")
	  private List<Cidade> LeiaCidades() {
		  String caminho = "C:\\Users\\daniel.martins\\Documents\\GitHub\\Ler-Cidades\\cidades-fontes\\cidades.csv";
		  //String caminho = "C:\\Users\\daniel.martins\\Documents\\GitHub\\selecaoinvolves\\cidadesJson.json";
		  //String caminho = "C:\\Users\\daniel.martins\\Documents\\GitHub\\selecaoinvolves\\cidadesXml.xml";
		  
		  List<Cidade> cidades = new ArrayList<Cidade>();
		  ICidadesManagerService service = new CidadesManagerService();
		  try {	
			  cidades = service.LeiaCidades(caminho);	
		  } catch (FileNotFoundException e) {
			  e.printStackTrace();
		  } catch (IOException e) {
			  e.printStackTrace();
		  } finally {
			  return cidades;
		  }
	  }

	  private void PrintListaDeCidades(List<Cidade> cidades) {
		  for(Cidade cidade: cidades){
			  System.out.println(cidade.toString());
		  }		  
	  }
	  
	  private void AguardeComando() {
		  ICidadesManagerService service = new CidadesManagerService();
		  String propriedade = "";
		  String valor = "";
		  String mensagem = "";
		  while(true) {
			  propriedade = "";
			  valor = "";
	          System.out.println("Por favor informe o comando desejado:");
	          System.out.println("sair - fecha a aplicação.");
	          System.out.println("count * - escreve a contagem total de registros importados.");
	          System.out.println("count distinct [propriedade] - escreve o total de valores distintos da propriedade (coluna) enviada");
	          System.out.println("filter [propriedade] [valor] - escreve a linha de cabeçalho e todas as linhas em que a propriedade enviada possua o valor informado");

	          String input = SCANNER.nextLine();

	          if (!input.isEmpty()) {
	        	  if (input.contains("distinct")) {
	        		  String[] splitComando = input.split(Pattern.quote(" "));
	        		  propriedade = splitComando.length > 2 ? splitComando[2] : "";
	        		  input = "distinct";
	        	  }	      
	        	  
	        	  if (input.contains("filter")) {
	        		  String[] splitComando = input.split(Pattern.quote(" "));
	        		  propriedade = splitComando.length > 1 ? splitComando[1] : "";
	        		  valor = splitComando.length > 2 ? splitComando[2] : "";
	        		  
	        		  input = "filter";
	        	  }
	        	  
	        	  switch(input) {
	        	  	case "sair":
	        	  		System.exit(0);
	        	  	case "count *":
	        	  		mensagem = String.format("A lista possui %d registros.", this.cidades.size());
	        	  		System.out.println(mensagem);
	        	  		break;
	        	  	case "distinct":
	        	  		int quantidade = service.BusqueQuantidadeDeItensDistintosPeloCampo(this.cidades, propriedade);
	        	  		mensagem = String.format("A lista possui %d registros diferentes para o campo %s.", quantidade, propriedade);
	        	  		System.out.println(mensagem);
	        	  		break;
	        	  	case "filter":
	        	  		System.out.println("ibge_id,uf,name,capital,lon,lat,no_accents,alternative_names,microregion,mesoregion");
	        	  		List<Cidade> cidades = service.FiltreAListaDeCidadesPeloCampoEValor(this.cidades, propriedade, valor);
	        	  		this.PrintListaDeCidades(cidades);
	        	  		break;
	        		default:
	        			System.out.println("Comando inválido");
	        			break;
	        	  }	        	  
	          }
	          
	          System.out.println("");
	          System.out.println("------------------------------------------------------------------------------------------------------------------------");
	          System.out.println("");
	      }
	  }
}
