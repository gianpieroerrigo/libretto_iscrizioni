package it.corsojava.librettoiscrizioni;

import java.sql.*;

	public class LibrettoIscrizioni {
	
		private Connection c;

		public LibrettoIscrizioni() {
			
			try {	// provo col connector mysql
				Class.forName("com.mysql.jdbc.Driver"); 
			
			} catch (ClassNotFoundException c1) { 
				System.out.println("Connector Mysql non trovato. Provo con MariaDB");
				
				try {	// provo col connector MariaDB
						Class.forName("org.mariadb.jdbc.Driver"); 
				} catch (ClassNotFoundException c2) {
						System.out.println("Accertarsi di aver installato il connector adatto al proprio DB");
					
					}
				
			}
			try { 	// provo un DB mysql
				c = DriverManager.getConnection("jdbc:mysql://localhost:3306/libretto_iscrizioni","root","root");
				
			} catch (SQLException s1) {
				System.out.println("Connessione al db mysql fallita. Provo con un DB MariaDB" );
				
				try {	// provo un DB MariaDB
					c = DriverManager.getConnection("jdbc:mariadb://localhost:3306/libretto_iscrizioni","root","");
					
				} catch (SQLException s2) {
						System.out.println("DB non Accessibile");
					}
				
			}
		
		}
	
		public boolean inserisciCdl(String nomeCorso) { // inserisce nel DB il corso specificato
		
			try {
				PreparedStatement psCdl = c.prepareStatement("INSERT INTO cdl(nome) VALUES (?)");
				psCdl.setString(1, nomeCorso);
				psCdl.execute();
			} catch (SQLException e) {
					System.out.println("Corso "+nomeCorso+" non inserito");
					return false;
				}
			return true;
			
		}
		
		public boolean inserisciStudente(String nomeStudente, String cognomeStudente, int cdl ) { // inserisce nel DB lo studente specificato
			
			try {
				PreparedStatement psStudente = c.prepareStatement("INSERT INTO studente(nome,cognome,cdl) VALUES (?,?,?)");
				psStudente.setString(1, nomeStudente);
				psStudente.setString(2, cognomeStudente);
				psStudente.setInt(3, cdl);
				psStudente.execute();
			} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("Studente "+nomeStudente+" "+cognomeStudente+" non inserito correttamente");
					return false;
				}
			return true;
			
		}
		
		public boolean inserisciMateria(String nomeMateria) {
			
			try {
				PreparedStatement psEsame = c.prepareStatement("INSERT INTO materia(nome) VALUES (?)");
				psEsame.setString(1, nomeMateria);
				psEsame.execute();
			} catch (SQLException e) {
					System.out.println("Materia "+nomeMateria+" non inserito correttamente");
					return false;
				}
			return true;
			
		}
		
		public boolean inserisciAppello(String data, int idMateria, int idCdl, int cfu) {
			
			try {
				PreparedStatement psAppello = c.prepareStatement("INSERT INTO appello(data,materia,cdl,cfu) VALUES (?,?,?,?)");
				psAppello.setString(1, data);
				psAppello.setInt(2, idMateria);
				psAppello.setInt(3, idCdl);
				psAppello.setInt(4, cfu);
				psAppello.execute();
			} catch (SQLException e) {
					System.out.println("Appello "+data+" non inserito correttamente");
					return false;
				}
			return true;			
						
		}

		public boolean inserisciIscrizione(int matricola, int idAppello) {
			
			try {
				PreparedStatement psIscrizione = c.prepareStatement("INSERT INTO iscrizione(studente,appello) VALUES (?,?)");
				psIscrizione.setInt(1, matricola);
				psIscrizione.setInt(2, idAppello);
				psIscrizione.execute();
			} catch (SQLException e) {
					System.out.println("Iscrizione per lo studente matricola "+matricola+" all'appello "+idAppello+" non inserito correttamente");
					return false;
				}
			return true;			
						
		}
	}
	
	
