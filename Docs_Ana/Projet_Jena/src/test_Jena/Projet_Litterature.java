package test_Jena;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.VCARD;

public class Projet_Litterature {
	
	static String generalURI = "http://www.semanticweb.org/alexane_ana/projet_semantiqueweb";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String livres = generalURI + "/livres/";
		String livresEspagnol = livres + "EnEspagnol/";
		String livresFrancais = livres + "EnFrancais/";
		
		Model modelo = ModelFactory.createDefaultModel();
		
		Resource recursoEspagnol = modelo.createResource(livresEspagnol)
				.addProperty(VCARD.FN,"Escritos en Español")
				.addProperty(VCARD.N, modelo.createResource(livresEspagnol+ "Doce_cuentos_peregrinos")
				.addProperty(VCARD.BDAY, "1992")
				.addProperty(VCARD.Country, "Colombia")
				)
				.addProperty(VCARD.N, modelo.createResource(livresEspagnol+ "Luna_de_Plutón")
						.addProperty(VCARD.BDAY, "2015")
						.addProperty(VCARD.Country, "Argentina")
				)
				.addProperty(VCARD.N, modelo.createResource(livresEspagnol+ "El_festival_de_la_blasfemia")
						.addProperty(VCARD.BDAY, "2016")
						.addProperty(VCARD.Country, "Venezuela")
				)
				.addProperty(VCARD.N, modelo.createResource(livresEspagnol+ "Kalpa_Imperial")
						.addProperty(VCARD.BDAY, "1983")
						.addProperty(VCARD.Country, "Argentina")
				);
		
		
		Resource recursoFrancais = modelo.createResource(livresFrancais)
				.addProperty(VCARD.FN,"Escritos en Francais")
				.addProperty(VCARD.N, modelo.createResource(livresFrancais+ "Kel")
				.addProperty(VCARD.BDAY, "2013")
				.addProperty(VCARD.Country, "Mérignac, France")
				)
				.addProperty(VCARD.N, modelo.createResource(livresEspagnol+ "L_Enchanteur")
						.addProperty(VCARD.BDAY, "2018")
						.addProperty(VCARD.Country, "Malesherbes, France")
				)
				.addProperty(VCARD.N, modelo.createResource(livresEspagnol+ "Les_Furtifs")
						.addProperty(VCARD.BDAY, "2019")
						.addProperty(VCARD.Country, "Clamecy, France")
				)
				.addProperty(VCARD.N, modelo.createResource(livresEspagnol+ "Paris_for_dummies")
						.addProperty(VCARD.BDAY, "2010")
						.addProperty(VCARD.Country, "France")
				);
		
		Resource langue = modelo.createResource(livres)
				.addProperty(VCARD.N, "Litterature");
		
		try {
			
			FileOutputStream fos = new FileOutputStream("rdf/testLivres.rdf");
			modelo.write(fos);
			System.out.println("On a reussi à creer le fichier RDF");
		}catch (IOException ex) {
			System.out.println("Erreur");
		}

	}

}
