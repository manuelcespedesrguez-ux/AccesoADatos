package FicherosSAX.Ejercicio1;

import org.xml.sax.XMLReader;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MainAlumnos {
    public static void main(String[] args) {
        try {
            SAXParserFactory factoria = SAXParserFactory.newInstance();
            SAXParser parserito = factoria.newSAXParser();
            XMLReader lector = parserito.getXMLReader();

            GestionAlumnos gestion = new GestionAlumnos();
            lector.setContentHandler(gestion);

            lector.parse("alumnos.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}