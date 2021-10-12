package test_Jena;

import java.io.InputStream;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;

public class testWriteRead2 {
	public static void main(String[] args) {
		// créer un modèle vide
		Model model = ModelFactory.createDefaultModel() ;
		// utiliser le FileManager pour trouver le fichier d'entrée
		InputStream in = FileManager.get().open("rdf/onto.owl") ;
		if(in == null) {
			throw new IllegalArgumentException(
					"Fichier : " + "fichero.owl" + " non trouvee") ;
		}
		// lire le fichier RDF/XML
		model.read(in, null) ;
		// l'écrire sur la sortie standard
		model.write(System.out) ;

	}

}
