package util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;

import java.io.FileOutputStream;

public class PDFGenerator {
   static String nombreArchivo;
    public static void generarPDF(String nombre, String fechaNacimiento, String signo,String fecha,String hora,String lugar,String detalles) {
        try {
            Document document = new Document();
            
             nombreArchivo = "Respuesta_" + nombre + "_" + signo + ".pdf";
            PdfWriter.getInstance(document, new FileOutputStream(nombreArchivo));
            document.open();
            document.add(new Paragraph("Nombre: " + nombre));
            document.add(new Paragraph("Fecha de nacimiento: " + fechaNacimiento));
            document.add(new Paragraph("Signo zodiacal: " + signo));
            document.add(new Paragraph("Fecha:" + fecha));
            document.add(new Paragraph("Hora:" + hora));
            document.add(new Paragraph("Lugar:" + lugar));
            document.add(new Paragraph("Detalles:" + detalles));
            document.close();
            System.out.println("PDF generado exitosamente.");
            File file = new File(nombreArchivo);
            Desktop.getDesktop().open(file);
        } catch (Exception e) {
            System.err.println("Error al generar PDF: " + e.getMessage());
        }
    }
}