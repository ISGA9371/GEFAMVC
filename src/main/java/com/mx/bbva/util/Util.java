package com.mx.bbva.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;
import javax.xml.bind.DatatypeConverter;

import com.mx.bbva.util.Document;

import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class Util {

    public Util(){}

    public boolean validaFloat(String cadena){
        Pattern p = Pattern.compile("[^0-9.]");
        Matcher m = p.matcher(cadena);
        StringBuffer sb = new StringBuffer();
        boolean resultado = m.find();
        boolean caracteresIlegales = true;
        while(resultado) {
            caracteresIlegales = false;
            m.appendReplacement(sb, "");
            resultado = m.find();
        }
        // Añade el ultimo segmento de la entrada a la cadena
        m.appendTail(sb);
        cadena = sb.toString();
        if (caracteresIlegales==false) {
            System.out.println("La cadena contiene caracteres ilegales");
            return false;
        }
        return true;
    }

    public boolean validaInt(String cadena){
        Pattern p = Pattern.compile("[^0-9]");
        Matcher m = p.matcher(cadena);
        StringBuffer sb = new StringBuffer();
        boolean resultado = m.find();
        boolean caracteresIlegales = true;
        while(resultado) {
            caracteresIlegales = false;
            m.appendReplacement(sb, "");
            resultado = m.find();
        }
        // Añade el ultimo segmento de la entrada a la cadena
        m.appendTail(sb);
        cadena = sb.toString();
        if (caracteresIlegales==false) {
            System.out.println("La cadena contiene caracteres ilegales");
            return false;
        }
        return true;
    }

    public boolean grabarFicheroALocal(CommonsMultipartFile uploaded,String path) throws Exception {

        File localFile = new File(path+uploaded.getOriginalFilename());
        FileOutputStream os = null;

        try {

            os = new FileOutputStream(localFile);
            os.write(uploaded.getBytes());
            return true;
        } finally {
            if (os != null) {
                try {
                    os.close();


                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
    }


    public String codificaArchivo(UploadItem uploadItem) throws Exception{
		System.out.println("-------------------------------------------");
		System.out.println("OriginalFilename: " + uploadItem.getFileData().getOriginalFilename());
		System.out.println("-------------------------------------------");
		System.out.println("ContentType: " + uploadItem.getFileData().getContentType());
		System.out.println("Test Size: " + uploadItem.getFileData().getSize());
		System.out.println("Test Name: " + uploadItem.getFileData().getName());

        return  DatatypeConverter.printBase64Binary(uploadItem.getFileData().getBytes());

    }

    public void descargaArchivoCodificado(String fileName,String cadenaEncriptada,HttpServletResponse response)throws Exception{
        Document doc = new Document();
        doc.setFilename(fileName);
        byte[] decodeds1= DatatypeConverter.parseBase64Binary(cadenaEncriptada);
        Blob blob = new SerialBlob(decodeds1);
        doc.setContent(blob);
        response.resetBuffer();
        response.setHeader("Content-Disposition", "inline;filename=\"" +doc.getFilename()+ "\"");
        OutputStream out = response.getOutputStream();
        response.setContentType(doc.getContentType());
        IOUtils.copy(doc.getContent().getBinaryStream(), out);
        out.flush();
        out.close();
    }
    /**
     * Aplica ala encriptación SHA-1 a una cadena.
     * @param text Cadena de texto a convertir.
     * @return Cadena convertida.
     * @throws NoSuchAlgorithmException This exception is thrown when a
     * particular cryptographic algorithm is requested but is not available in
     * the environment.
     * @throws UnsupportedEncodingException The Character Encoding is not
     * supported.
     */
    public String SHA1(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException  {

        MessageDigest md;
        md = MessageDigest.getInstance("SHA-1");
        byte[] sha1hash = new byte[40];
        md.update(text.getBytes("iso-8859-1"), 0, text.length());
        sha1hash = md.digest();

        return convertToHex(sha1hash);

    }

    /**
     * Convierte una cadena a código hexadecimal.
     * @param data Cadena a convertir.
     * @return Cadena convertida.
     */
    private static String convertToHex(byte[] data) {

        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                if ((0 <= halfbyte) && (halfbyte <= 9))
                    buf.append((char) ('0' + halfbyte));
                else
                    buf.append((char) ('a' + (halfbyte - 10)));
                halfbyte = data[i] & 0x0F;
            } while(two_halfs++ < 1);
        }

        return buf.toString();

    }

    /**
     * Valida que la cadena compla las condiciones de la expresión regular.
     * @param cadena Cadena o texto a evaluar.
     * @param regularExpression Expresión regular.
     * @return Verdadero (true) si la cadena comple las condiciones de la
     * expresión regular, falso (false) en caso contrario.
     */
    public boolean validaExpresionRegular (String cadena, String regularExpression) {

        Pattern pattern;
        Matcher matcher;

        pattern = Pattern.compile(regularExpression);
        matcher = pattern.matcher(cadena);

        return matcher.matches();

    }

    /**
     * Busca el contenido indicado por la expresión regular en la cadena
     * indicada.
     * @param cadena Cadena o texto en la que se buscará el contenido.
     * @param regularExpression Expresión regular.
     * @return Verdadero (true) si la cadena contiene los valores de la
     * expresión regular, falso (false) en caso contrario.
     */
    public boolean encuentraExpresionRegular (String cadena, String regularExpression) {

        Pattern pattern;
        Matcher matcher;

        pattern = Pattern.compile(regularExpression);
        matcher = pattern.matcher(cadena);

        if (matcher.find()) {
            return true;
        } else {
            return false;
        }

    }

    public boolean borrarArchivo(String urlArchivo){

        boolean borrado=false;
        try{
            File uploadedFile = new File(urlArchivo);
//		                System.out.println("Se borrara el temporal:" + urlArchivo);
            if (uploadedFile.exists()) {
                borrado = uploadedFile.delete();
//					       System.out.println(" - archivo borrado" + urlArchivo);
            }
            return borrado;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean bajarArchivo( HttpServletResponse response, String filePath,String docName) {
        boolean guardado=false;

        System.out.println("Descargando: " + filePath + docName);
        File file = new File(filePath + docName);
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            MimetypesFileTypeMap mimeTypes = new MimetypesFileTypeMap();
            mimeTypes.addMimeTypes("application/vnd.ms-excel xls");
            mimeTypes.addMimeTypes("application/pdf pdf");
            mimeTypes.addMimeTypes("application/vnd.ms-powerpoint ppt");
            mimeTypes.addMimeTypes("application/msword doc");
            mimeTypes.addMimeTypes("application/x-rar-compressed rar");
            mimeTypes.addMimeTypes("text/html htm html");
            mimeTypes.addMimeTypes("application/zip zip");
            mimeTypes.addMimeTypes("text/plain txt");

            String disHeader = "Attachment;Filename=" + docName;
            System.out.println("disHeader: " + disHeader);
            response.setHeader("Content-Disposition", disHeader);
            response.setContentType(mimeTypes.getContentType(file));

            int i;
            while ((i=fileInputStream.read())!=-1){
                response.getOutputStream().write(i);
            }
            guardado = true;
            response.getOutputStream().flush();
            response.getOutputStream().close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return guardado;
    }

    public void llamaGarbageCollector(){
        Runtime garbage = Runtime.getRuntime();
        //System.out.println("Liberando Memoria...");
        //System.out.println("Inicial:"+ (garbage.freeMemory()/(1024*1024)));
        garbage.gc();
        //System.out.println(" Final:"+(garbage.freeMemory()/(1024*1024)));
        garbage = null;
    }


}
