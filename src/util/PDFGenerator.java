package util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.text.SimpleDateFormat;
import java.io.FileOutputStream;
import java.time.Instant;
import java.util.Date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PDFGenerator {
   static String nombreArchivo;
    public static void generarPDF(String nombre, String fechaNacimiento, String signo,String fecha,String hora,String lugar,String detalles) {
        try {
            
            Document document = new Document();
            
             nombreArchivo = "Cita_" + nombre + "_" + fecha + ".pdf";
             
             
            PdfWriter.getInstance(document, new FileOutputStream(nombreArchivo));
            document.open();
            
            //fuentes
            
            Font fuenteTitulo= new Font(Font.FontFamily.HELVETICA, 18 , Font.BOLD, BaseColor.RED);
            Font fuenteSubTitulo= new Font(Font.FontFamily.HELVETICA, 14 , Font.BOLD, BaseColor.BLACK);
            Font fuenteDatos= new Font(Font.FontFamily.HELVETICA,12, Font.NORMAL, BaseColor.BLACK);
           
            
            Paragraph titulo= new Paragraph("Cita", fuenteTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(20f);
            document.add(titulo);
            document.add(new Paragraph("Nombre: " + nombre,fuenteDatos));
           //document.add(new Paragraph("Fecha de nacimiento: " + fechaNacimiento,fuenteDatos));
           // document.add(new Paragraph("Signo zodiacal: " + signo,fuenteDatos));
            document.add(new Paragraph("Fecha: " + fecha,fuenteDatos));
            document.add(new Paragraph("Hora: " + hora,fuenteDatos));
            document.add(new Paragraph("Lugar: " + lugar,fuenteDatos));
            
            Paragraph subtitulo = new Paragraph("Detalles :",fuenteSubTitulo);
            subtitulo.setAlignment(Element.ALIGN_CENTER);
            subtitulo.setSpacingBefore(20f);
            subtitulo.setSpacingAfter(20f);
            document.add(subtitulo);
           
            Date ahora = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String fechaHoraActual = formato.format(ahora);
        
        document.add( new Paragraph(detalles, fuenteDatos));
        Paragraph fechaParaPdf = new Paragraph(fechaHoraActual);
        
            fechaParaPdf.setAlignment(Element.ALIGN_RIGHT);
            fechaParaPdf.setSpacingAfter(10f);
            document.add(fechaParaPdf);
            
           // document.add(new Paragraph(fechaHoraActual));
            document.close();
            System.out.println("PDF generado exitosamente.");
            File file = new File(nombreArchivo);
            Desktop.getDesktop().open(file);
        } catch (Exception e) {
            System.err.println("Error al generar PDF: " + e.getMessage());
        }
    }
}