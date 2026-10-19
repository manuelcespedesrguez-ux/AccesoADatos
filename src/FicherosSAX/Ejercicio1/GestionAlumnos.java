package FicherosSAX.Ejercicio1;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class GestionAlumnos extends DefaultHandler {

    private StringBuilder buffer = new StringBuilder();

    private String idActual;
    private String nombreActual;
    private String apellidosActuales;
    private String cicloActual;
    private double notaActual;

    private List<String> listadoAlumnos = new ArrayList<>();
    private int totalAlumnos = 0;
    private double sumaNotas = 0.0;
    
    private double notaMasAlta = -1.0;
    private String alumnoNotaMasAlta = "";

    private double notaMasBaja = 11.0;
    private String alumnoNotaMasBaja = "";

    private int aprobados = 0;
    private int suspensos = 0;

    @Override 
    public void startDocument() throws SAXException {
        System.out.println("Inicio lectura fichero");
    }

    @Override 
    public void endDocument() throws SAXException {
        System.out.println("Fin de la lectura");
    
        for (String info : listadoAlumnos) {
            System.out.println(info);
        }

        System.out.println("Número total de alumnos: " + totalAlumnos);

        if (totalAlumnos > 0) {
            double media = sumaNotas / totalAlumnos;
            System.out.println("Nota media de la clase: " + media);
        }

        System.out.println("Nota más alta: " + alumnoNotaMasAlta + ", nota: " + notaMasAlta);
        System.out.println("Nota más baja: " + alumnoNotaMasBaja + ", nota: " + notaMasBaja);
        System.out.println("Alumnos aprobados: " + aprobados);
        System.out.println("Alumnos suspensos: " + suspensos);
    } // <-- ¡Aquí se cierra correctamente endDocument()!

    @Override 
    public void startElement(String uri, String localName, String qName, Attributes atributos) throws SAXException {
        buffer.setLength(0);

        if (qName.equals("alumno")) {
            idActual = atributos.getValue("id");
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
            case "nombre":
                nombreActual = contenido;
                break;
            case "apellidos":
                apellidosActuales = contenido;
                break;
            case "ciclo":
                cicloActual = contenido;
                break;
            case "nota": 
                notaActual = Double.parseDouble(contenido);
                break;
            case "alumno":
                totalAlumnos++;
                sumaNotas += notaActual;

                String infoAlumno = String.format("[%s] %s, %s (%s)\nNota: %.2f", 
                    idActual, apellidosActuales, nombreActual, cicloActual, notaActual);
                listadoAlumnos.add(infoAlumno);
            
                if (notaActual > notaMasAlta) {
                    notaMasAlta = notaActual;
                    alumnoNotaMasAlta = apellidosActuales + ", " + nombreActual;
                }
                if (notaActual < notaMasBaja) {
                    notaMasBaja = notaActual;
                    alumnoNotaMasBaja = apellidosActuales + ", " + nombreActual;
                }
                
                if (notaActual >= 5.0) {
                    aprobados++;
                } else {
                    suspensos++;
                }
                break;
        }
    }
}