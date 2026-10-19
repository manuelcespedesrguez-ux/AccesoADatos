package FicherosSAX.Ejercicio2;

import org.xml.sax.XMLReader;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MainLibreria {
    public static void main(String[] args) {
        String fichero = "libreria.xml"; 

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            XMLReader lector = saxParser.getXMLReader();

            GestionLibreria gestion = new GestionLibreria();
            lector.setContentHandler(gestion);
            lector.setErrorHandler(gestion); 
            System.out.println("Leyendo archivo: "  + fichero + "\n");
            lector.parse(fichero);

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
