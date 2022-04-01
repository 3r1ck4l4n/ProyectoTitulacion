package mx.com.ipn.upiicsa.informatica.systemexpbackend;

import org.jasypt.util.text.BasicTextEncryptor;

public class Encript {
    public static void main(String[] args) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        // Salt (sal) necesaria para el cifrado
        textEncryptor.setPassword("G0CvDz7oJn6");
        // Datos a cifrar (nombre de usuario o contraseña de la base de datos)
        String username = textEncryptor.encrypt("root");
        String password = textEncryptor.encrypt("root");
        System.out.println("username:" + username);
        System.out.println("password:" + password);
    }
    }
