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
		
		//neste metodo setDataHandler que é recebido o arquivo
		//onde é passado o simuladorPDF, você passa o seu arquivogravado no BD ou em outro local
		anexoEmail.setDataHandler(new DataHandler(new ByteArrayDataSource(simuladorPDF(), "application/pdf")));
		anexoEmail.setFileName("Currículo Nelson.pdf");
		
		// Junta as duas partes
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(corpoEmail);
		multipart.addBodyPart(anexoEmail);
		
		//após juntar é passado por envio
		message.setContent(multipart);
		
		Transport.send(message);
		
		}
	

	private FileInputStream simuladorPDF() throws Exception {
		Document document = new Document();
		File file = new File("Currículo Nelson.pdf");
		file.createNewFile();
		PdfWriter.getInstance(document, new FileOutputStream(file));
		document.open();
		document.add(new Paragraph("                                  NELSON SOUTO COSTA\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "Celular: 97547-8395\r\n"
				+ "nelsonscosta@yahoo.com.br\r\n"
				+ "https://www.linkedin.com/in/nelson-souto-itil-083b7b23/\r\n"
				+ "https://github.com/nelsonscosta/Projeto-Spring-Boot/tree/master\r\n"
				+ "https://projetojavawebnelsonsc.com.br/\r\n"
				+ "\r\n"
				+ "Pretensão Salarial: R$ 4000,00\r\n"
				+ "OBJETIVO: ANALISTA DE SISTEMA\r\n"
				+ "\r\n"
				+ "Profissional com 2 anos de experiência em desenvolvimento e manutenção em\r\n"
				+ "Java com HTML, CSS, Java Script e MySQL. Utilizando o servidor Apache.\r\n"
				+ "Atualmente estou me aperfeiçoando, através de cursos em Java\r\n"
				+ "Avançado, HTML e CSS, MYSQL, JAVA SCRIPT, Full Stack Angular e\r\n"
				+ "Spring Boot. e também LINUX. Como também, estudando e me aprimorando\r\n"
				+ "cada vez mais em meu nível de inglês, para me tornar mais fluente no idioma.\r\n"
				+ "Minhas principais entregas foram: desenvolvimento de aplicativo para controle\r\n"
				+ "de estoque, aplicativo para envio de mensagens automáticas por e-mail e a\r\n"
				+ "manutenção em aplicativos Java Web. Com bons conhecimentos em ITIL V3.\r\n"
				+ "\r\n"
				+ "RESULTADOS\r\n"
				+ "- Elaboração e desenvolvimento de aplicativo para envios de e-mails automáticos\r\n"
				+ "em Java, onde gerou um ganho de 100% em produtividade para funcionários\r\n"
				+ "nos atendimentos de chamados e para gerentes e diretoria confiabilidade e\r\n"
				+ "eficácia diante de seus clientes, tornando uma empresa mais sólida e mais\r\n"
				+ "confiável.\r\n"
				+ "\r\n"
				+ "FORMAÇÃO ACADÊMICA\r\n"
				+ "Bacharel em Ciência Da Computação\r\n"
				+ "Universidade Nove De Julho Dezembro/2006\r\n"
				+ "Certificação ITIL Foundation\r\n"
				+ "Prométric Junho/2013\r\n"
				+ "Certificação Lógica de Programção\r\n"
				+ "JDev Treinamento on-line Junho/2021\r\n"
				+ "Certificação Servlets com JSP e JDBC, JPA com Hibernate em JSF\r\n"
				+ "JDev Treinamento on-line Agosto/2013\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "HSTÓRICO PROFISSIONAL\r\n"
				+ " DETRAN - AGOSTO/2019 – FEVEREIRO/2021\r\n"
				+ "Cargo: Analista de Sistema\r\n"
				+ "Manutenção em sistemas internos em WEB do Detran e também no auxílio\r\n"
				+ "de usuários destes sistemas. As entregas destes serviços, possibilitaram, um\r\n"
				+ "grande conforto e produtividade para a acessibilidade dos usuários para este\r\n"
				+ "sistema interno.\r\n"
				+ "\r\n"
				+ " ATLAS SHINDLER – OUTUBRO/2018 –FEVEREIRO/2019\r\n"
				+ "(Projeto Temporário)\r\n"
				+ "Cargo: Programador Java\r\n"
				+ "Manutenção em sistemas JSP com HTML e Java Script\r\n"
				+ "usando banco de dados MySQL e utilizando sistema de versionamento SVN, para\r\n"
				+ "departamentos de Engenharia, gerando produtividade para acabamentos dos\r\n"
				+ "projetos desenvolvidos nos mesmos setores;\r\n"
				+ "\r\n"
				+ " KAINOS - JANEIRO/2018 – AGOSTO/2018\r\n"
				+ "Cargo: Analista de Sistema\r\n"
				+ "Desenvolvimento de um sistemaem  JAVA para acessos a sistemas internos\r\n"
				+ "Auxílio aos usuários presencialmente. Manutenção nos aplicativos da empresa.\r\n"
				+ "E manutênção e configuração das contas dos usuários em Active Directory do\r\n"
				+ "Windows Server 2012\r\n"
				+ "\r\n"
				+ " MOINHO SANTO ANDRÉ – DEZEMBRO/2013 – MAIO/2016\r\n"
				+ "Cargo: Analista de Suporte\r\n"
				+ "Desenvolvi e apliquei conhecimentos na instalação, configuração e\r\n"
				+ "administração em redes com Windows Server (criando políticas de seguranças\r\n"
				+ "na rede e políticas de acessos aos usuários) e também em Backup de Dados. O\r\n"
				+ "impacto deste serviço, gerou para a empresa e para os seus funcionários, um\r\n"
				+ "grande avanço na segurança interna da sua estrutura de rede e através desta\r\n"
				+ "tecnologia houve um melhor controle para os serviços prestados aos seus\r\n"
				+ "clientes\r\n"
				+ ".\r\n"
				+ " ATOS DO BRASIL – FEVEREIRO/2012 – MAIO/2013\r\n"
				+ "Cargo: Analista de Suporte\r\n"
				+ "Desenvolvimento e manutenção de sistemas internos em JAVA, que foi uma\r\n"
				+ "poderosa e eficaz ferramenta para o atendimento dos clientes.\r\n"
				+ "E também auxiliando usuários remotamente nas configurações dentro do\r\n"
				+ "Windows, mantendo assim a boa qualidade e desempenho do seu serviço de\r\n"
				+ "atendimento. Este aplicativo gerou para a área de atendimento ao\r\n"
				+ "cliente, melhor qualidade e maior produtividade, melhor disputa no mercado.\r\n"
				+ "\r\n"
				+ "CURSOS\r\n"
				+ "TI. Exames\r\n"
				+ "Agile Scrum Master\r\n"
				+ "JDEV Treinamentos On line - Java Avançado\r\n"
				+ "JDBC, Servlets, JSP, JSF, JPA e Hibernate, Primefaces, Spring Boot, API REST\r\n"
				+ "AlgaWorks\r\n"
				+ "Web Design Responsivo com HTML5, CSS3 e BEM;\r\n"
				+ "Começando com JavaScript\r\n"
				+ "Programando em TypeScript\r\n"
				+ "FullStack Angular e Spring\r\n"
				+ ""));
		document.close();

		return new FileInputStream(file);

	}

}
