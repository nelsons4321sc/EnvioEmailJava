package enviandoEmail2;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;


public class AppTest {
	
	private String userName = "nelsonsouto16@gmail.com";
	private String senha = "n g n l pic m n x h k b o t b";

   
    @Test
    public void TesteEmail(){
    	try {
    		Properties properties = new Properties();

    		properties.put("mail.smtp.ssl.trust", "*"); //Autenticação com ssl
    		properties.put("mail.smtp.auth", "true"); // Autorização
    		properties.put("mail.smtp.starttls", "true"); //Autenticação
    		properties.put("mail.smtp.host", "smtp.gmail.com"); //servidor gmail Google
    		properties.put("mail.smtp.port", "465"); //Porta do Servidor - caminho de entrada que está liberado para envio de email 
    		properties.put("mail.smtp.socketFactory.port", "465");// Especifica a porta a ser conectada pelo socket
    		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); // Classe de conexão
    		
    		Session session = Session.getInstance(properties, new Authenticator() {//pegando as intâncias da propridade passadas acima, 
    			//e também a autenticação com usuário e senha do email utilizado
    			@Override
    			protected PasswordAuthentication getPasswordAuthentication() {

    				return new PasswordAuthentication(userName, senha);
    			}
    		});
    		//testando o objeto de conexão, caso não conectasse iria dar erro de conexão
    		//System.out.println(senha);
    		Address[] toUser = InternetAddress
    				.parse("nelsonsouto16@gmail.com, nelsonscosta@yahoo.com.br, nelsonscosta@aol.com");
    		
    		Message message = new MimeMessage(session);// A sessão recebe o properties,  e a mensagem recebe a sessão
    		//message.setFrom(new InternetAddress(userName, nomeRemetente));//quem está enviando
    		message.setFrom(new InternetAddress(userName, "Nelson - Programador em Java"));//quem está enviando, seu nome no e-mail
    		message.setRecipients(Message.RecipientType.TO, toUser);// quem estou enviando
    		message.setSubject("Chegou email enviado com java");//Assunto do e-mail
    		message.setText("Teste de email");
    		
    		Transport.send(message);

		} catch (Exception e) {
			e.printStackTrace();
		} 
    	    }
}
