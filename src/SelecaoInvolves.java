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

	  private void PrintListaDeCidades() {
		  for(int i = 0; i < this.cidades.size(); i++) {
			  Cidade cidade = this.cidades.get(i);
			  System.out.println(cidade.toString());
		  }
	  }
	  
	  private void AguardeComando() {
		  while(true) {
			  String propriedade = "";
	          System.out.println("Por favor informe o comando desejado:");
	          System.out.println("sair - fecha a aplicação.");
	          System.out.println("count * - escreve a contagem total de registros importados.");
	          System.out.println("count distinct [propriedade] - escreve o total de valores distintos da propriedade (coluna) enviada");
	          System.out.println("filter [propriedade] [valor] - escreve a linha de cabeçalho e todas as linhas em que a propriedade enviada possua o valor informado");

	          String input = SCANNER.nextLine();

	          if (!input.isEmpty()) {
	        	  if (input.contains("distinct")) {
	        		  String[] splitComando = input.split(Pattern.quote(" "));
	        		  propriedade = splitComando[2];
	        		  input = "distinct";
	        	  }	        	  
	        	  
	        	  switch(input) {
	        	  	case "sair":
	        	  		System.exit(0);
	        	  	case "count *":
	        	  		System.out.println("A lista possui " + this.cidades.size() + " registros");
	        	  		break;
	        	  	case "distinct":
	        	  		System.out.println(propriedade);
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
