package LectorFicherosXML;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class LeerXML {
    
    public static void main(String[] args) {
        try {
            
            File estibanez = new File("Empleados.xml");
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(estibanez);
            
            doc.getDocumentElement().normalize();
            System.out.println("Elemento raíz: " + doc.getDocumentElement().getNodeName());
            
            NodeList listaEmpleados = doc.getElementsByTagName("Empleado");
            System.out.println("----------------------------------------");

            for (int i = 0; i < listaEmpleados.getLength(); i++) {
                Node nodo = listaEmpleados.item(i);
                
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;
                    
                    String id = elemento.getElementsByTagName("id").item(0).getTextContent();
                    String apellido = elemento.getElementsByTagName("apellido").item(0).getTextContent();
                    String departamento = elemento.getElementsByTagName("departamento").item(0).getTextContent();
                    String salario = elemento.getElementsByTagName("salario").item(0).getTextContent();
                    
                    System.out.println("Empleado ID: " + id);
                    System.out.println(" - Apellido: " + apellido);
                    System.out.println(" - Departamento: " + departamento);
                    System.out.println(" - Salario: " + salario);
                    System.out.println("----------------------------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
