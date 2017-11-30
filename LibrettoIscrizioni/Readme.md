Il repo contiene:

- uno script SQL (crea_libretto_iscrizioni) per la creazione del database. Si trova sotto la directory SQL.

- una libreria (LibrettoIscrizioni.java) con metodi per la connessione al db ed il popolamento delle tabelle

- un eseguibile (Populate.java) che sfruttando i metodi forniti dalla libreria, popola il db a partire da un file con alcuni dati di default

- un file in testo semplice (default_population) contenente dei dati di default, formattato in modo da poter essere parsato dall'eseguibile di popolamento