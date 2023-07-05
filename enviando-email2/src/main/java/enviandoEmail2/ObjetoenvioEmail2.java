package enviandoEmail2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.ElementListener;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.WritableDirectElement;
import com.itextpdf.text.pdf.PdfWriter;

public class ObjetoenvioEmail2 {
	
	private String userName = "nelsonsouto16@gmail.com";
	private String senha = "n g n l pic m n x h k b o t b";
	
	private String listaDestinatarios = "";
	private String nomeRemetente = "";
	private String assuntoEmail = "";
	private String textoEmail = "";
	//private String filePath = "/caminho/para/arquivo/anexo.txt";
	
	public ObjetoenvioEmail2(String listaDestinatário, String nomeRemetente, String assuntoEmail, String textoEmail) {
		this.listaDestinatarios = listaDestinatário;
		this.nomeRemetente = nomeRemetente;
		this.assuntoEmail = assuntoEmail;
		this.textoEmail = textoEmail;
	}
	
	
	public void enviarEmail(boolean envioHtml)  throws Exception{
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
		//Address[] toUser = InternetAddress
			//	.parse("nelsonsouto16@gmail.com, nelsonscosta@yahoo.com.br, nelsonscosta@aol.com");
		Address[] toUser = InternetAddress
				.parse(listaDestinatarios);
		
		Message message = new MimeMessage(session);// A sessão recebe o properties,  e a mensagem recebe a sessão
		//message.setFrom(new InternetAddress(userName, nomeRemetente));//quem está enviando
		message.setFrom(new InternetAddress(userName, nomeRemetente));//quem está enviando, seu nome no e-mail
		message.setRecipients(Message.RecipientType.TO, toUser);// quem estou enviando
		message.setSubject(assuntoEmail);//Assunto do e-mail
		
		// Se estiver enviando com html, senão enviar texto normal
		if (envioHtml) {
			message.setContent(textoEmail, "text/html; charset=utf-8");
		} else {
			message.setText(textoEmail);
		}
		
		Transport.send(message);
		
		}
	
	public void enviarEmailanexo(boolean envioHtml)  throws Exception{
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
		//Address[] toUser = InternetAddress
			//	.parse("nelsonsouto16@gmail.com, nelsonscosta@yahoo.com.br, nelsonscosta@aol.com");
		Address[] toUser = InternetAddress
				.parse(listaDestinatarios);
		
		Message message = new MimeMessage(session);// A sessão recebe o properties,  e a mensagem recebe a sessão
		//message.setFrom(new InternetAddress(userName, nomeRemetente));//quem está enviando
		message.setFrom(new InternetAddress(userName, nomeRemetente));//quem está enviando, seu nome no e-mail
		message.setRecipients(Message.RecipientType.TO, toUser);// quem estou enviando
		message.setSubject(assuntoEmail);//Assunto do e-mail
		
		
		//PARTE 1 do email que é o texto e adescrição do email;
		MimeBodyPart corpoEmail = new MimeBodyPart();
		
		// Se estiver enviando com html, senão enviar texto normal
		//trocado o message
		if (envioHtml) {
			corpoEmail.setContent(textoEmail, "text/html; charset=utf-8");
		} else {
			corpoEmail.setText(textoEmail);
		}
		
		//PARTE 2 do email que é o anexo do email em pdf;
		MimeBodyPart anexoEmail = new MimeBodyPart();
		String curriculo = "C:\\CURRICULO\\2023\\Currículo.pdf";
		//neste metodo setDataHandler que é recebido o arquivo
		//onde é passado o simuladorPDF, você passa o seu arquivogravado no BD ou em outro local
		anexoEmail.setDataHandler(new DataHandler(new ByteArrayDataSource(curriculo, "application/pdf")));
		anexoEmail.setFileName(curriculo);
		
		// Junta as duas partes
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(corpoEmail);
		multipart.addBodyPart(anexoEmail);
		
		//após juntar é passado por envio
		message.setContent(multipart);
		
		Transport.send(message);
		
		}
	
	/*
	private FileInputStream simuladorPDF() throws Exception {
		Document document = new Document();
		String filePath = "C:\\CURRICULO\\2023Currículo Nelson.pdf";
		File file = new File(filePath);
		PdfWriter.getInstance(document, new FileOutputStream(file));
		document.open();
		//document.add(true);
		document.close();

		return new FileInputStream(file);

	}
*/
}
