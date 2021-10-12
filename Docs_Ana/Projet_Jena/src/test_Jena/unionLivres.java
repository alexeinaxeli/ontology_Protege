package test_Jena;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;

public class unionLivres {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String rdfLivres = "rdf/onto.owl";
		String rdfTestLivres = "rdf/testLivres.rdf";
		
		Model modeloLivres = ModelFactory.createDefaultModel();
		InputStream inputLivres = FileManager.get().open(rdfLivres);
		if (inputLivres == null) {
			throw new IllegalArgumentException("Erreur");
		}
		
		
		Model modeloTestLivres = ModelFactory.createDefaultModel();
		InputStream inputTestLivres = FileManager.get().open(rdfTestLivres);
		if (inputTestLivres == null) {
			throw new IllegalArgumentException("Erreur");
		}
		
		modeloLivres.read(inputLivres, "");
		modeloTestLivres.read(inputTestLivres, "");
		
		Model modeloUnion = modeloLivres.union(modeloTestLivres);
		modeloUnion.write(System.out, "RDF/XML");
		
		try {
			FileOutputStream fos = new FileOutputStream("rdf/unionFichier.rdf");
			modeloUnion.write(fos);
			System.out.println("On a reussi à creer le fichier");
		}catch(IOException ex) {
			System.out.println("Erreur");
		}
		}
}

