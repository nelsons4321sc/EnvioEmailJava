package enviandoEmail2;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.junit.Test;


public class AppTest {
	
	private String userName = "nelsonsouto16@gmail.com";
	private String senha = "n g n l pic m n x h k b o t b";

   
    @Test
    public void TesteEmail(){
    	try {
    		Properties properties = new Properties();

    		properties.put("mail.smtp.ssl.trust", "*"); 
    		properties.put("mail.smtp.auth", "true"); // Autorização
    		properties.put("mail.smtp.starttls", "true"); //Autenticação
    		properties.put("mail.smtp.host", "smtp.gmail.com"); //servidor gmail Google
    		properties.put("mail.smtp.port", "465"); //Porta do Servidor - caminho de entrada que está liberado para envio de email 
    		properties.put("mail.smtp.socketFactory.port", "465");// Especifica a porta a ser conectada pelo socket
    		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); // Classe de conexão
    		
    		Session session = Session.getInstance(properties, new Authenticator() {
    			@Override
    			protected PasswordAuthentication getPasswordAuthentication() {

    				return new PasswordAuthentication(userName, senha);
    			}
    		});
    		
    		System.out.println(senha);

		} catch (Exception e) {
			e.printStackTrace();
		} 
    	    }
}
