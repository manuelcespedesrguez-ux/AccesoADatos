package FicherosSAX.Ejercicio2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestionLibreria extends DefaultHandler {

    private StringBuilder buffer = new StringBuilder();

    private String isbn;
    private String idioma;
    private String titulo;
    private List<String> autores = new ArrayList<>();
    private String editorial;
    private int anio;
    private double precio;
    private String moneda;

    private Map<String, Integer> contadorIdiomas = new HashMap<>();
    private double precioTotalEuros = 0.0;
    private int countLibrosEuros = 0;

    private int maxAutores = -1;
    private String libroConMasAutores = "";

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Inicio del analisis");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Fin del analisis");
        for (Map.Entry<String, Integer> entry : contadorIdiomas.entrySet()) {
            System.out.println("Idioma [" + entry.getKey() + "]: " + entry.getValue() + " libros");
        }

        System.out.printf("Precio total (EUR): %.2f €\n", precioTotalEuros);
        if (countLibrosEuros > 0) {
            System.out.printf("Precio medio (EUR): %.2f €\n", (precioTotalEuros / countLibrosEuros));
        }
        
        System.out.println(libroConMasAutores + " (" + maxAutores + " autores)");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        buffer.setLength(0);

        if (qName.equals("libro")) {
            isbn = attributes.getValue("isbn");
            idioma = attributes.getValue("idioma");
            autores.clear(); 
        } else if (qName.equals("precio")) {
            moneda = attributes.getValue("moneda");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String contenido = buffer.toString().trim();

        switch (qName) {
            case "titulo":
                titulo = contenido;
                break;
            case "autor":
                autores.add(contenido);
                break;
            case "editorial":
                editorial = contenido;
                break;
            case "anio":
                anio = Integer.parseInt(contenido);
                break;
            case "precio":
                precio = Double.parseDouble(contenido);
                break;
            case "libro":
                String cadenaAutores = String.join(", ", autores);
                String infoLibro = String.format("%s (%d)\n%s\n%s %.2f %s [%s] %s",
                        titulo, anio, cadenaAutores, editorial, precio, moneda, isbn, idioma);

                if (anio >= 2010) {
                    System.out.println("[Libros >= 2010]");
                    System.out.println(infoLibro);
                }

                contadorIdiomas.put(idioma, contadorIdiomas.getOrDefault(idioma, 0) + 1);

                if ("EUR".equalsIgnoreCase(moneda)) {
                    precioTotalEuros += precio;
                    countLibrosEuros++;
                }

                if (autores.size() > maxAutores) {
                    maxAutores = autores.size();
                    libroConMasAutores = titulo;
                }
                break;
        }
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.out.println(
                "[WARNING] Línea " + e.getLineNumber() + ", Columna " + e.getColumnNumber() + ": " + e.getMessage());
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        System.out.println(
                "[ERROR] Línea " + e.getLineNumber() + ", Columna " + e.getColumnNumber() + ": " + e.getMessage());
        throw e;
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println("[FATAL ERROR] Línea " + e.getLineNumber() + ", Columna " + e.getColumnNumber() + ": "
                + e.getMessage());
        throw e;
    }
}
