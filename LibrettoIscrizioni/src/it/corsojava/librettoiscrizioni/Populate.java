package it.corsojava.librettoiscrizioni;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Populate {

		public static void main(String[] args) throws IOException{
			
			LibrettoIscrizioni LI = new LibrettoIscrizioni();
			
			File f;
				f = new File("default_population");
				try {
					FileReader	fr = new FileReader(f);
					BufferedReader br = new BufferedReader(fr);
					String read;
					while(!(read = br.readLine()).startsWith("#")){
						LI.inserisciCdl(read);
					}
					
					while(!(read = br.readLine()).startsWith("#")){
						String [] token = read.split("\\s");
						LI.inserisciStudente(token[0], token[1], Integer.parseInt(token[2]));
						
					}
					
					while(!(read = br.readLine()).startsWith("#")){
						LI.inserisciMateria(read);
						
					}
					
					while(!(read = br.readLine()).startsWith("#")){
						String [] token = read.split("\\s");
						LI.inserisciAppello(token[0], Integer.parseInt(token[1]), Integer.parseInt(token[2]), Integer.parseInt(token[3]));
						
					}
					
					while((read = br.readLine())!=null){
						String [] token = read.split("\\s");
						LI.inserisciIscrizione(Integer.parseInt(token[0]), Integer.parseInt(token[1]));
						
					}
					
					br.close();
					

				} catch (FileNotFoundException e) {
					System.out.println("Verificare la presenza del file \"default_population\" sul disco");
				}
			
				
		}

	}

