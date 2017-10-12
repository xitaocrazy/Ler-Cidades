import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SelecaoInvolves {

	  public static void main(String[] args) {
		  SelecaoInvolves obj = new SelecaoInvolves();
		  obj.run();
	  }

	  public void run() {
	    String arquivoCSV = "C:\\Users\\daniel.martins\\Documents\\GitHub\\selecaoinvolves\\cidades.csv";
	    BufferedReader br = null;
	    String linha = "";
	    String csvDivisor = ",";
	    try {

	        br = new BufferedReader(new FileReader(arquivoCSV));
	        while ((linha = br.readLine()) != null) {
	            String[] cidade = linha.split(csvDivisor);
	            System.out.println("País [ibge_id= " + cidade[0] 
	                                 + " , name=" + cidade[1] + "]");

	        }

	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if (br != null) {
	            try {
	                br.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	  }

}
