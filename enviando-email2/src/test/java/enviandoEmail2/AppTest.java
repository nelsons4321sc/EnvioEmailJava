package enviandoEmail2;

import org.junit.Test;


public class AppTest {
	
	@Test
    public void TesteEmail() throws Exception{
		
		StringBuilder stringBuilderTextoEmail = new StringBuilder();
		
		stringBuilderTextoEmail.append("<center><h1 style=\"color: red\">INFORMAÇÕES PROFISSIONAIS</h1></center>");
		
		stringBuilderTextoEmail.append("<h2>Como Vai, Segue abaixo</h2>");
		stringBuilderTextoEmail.append("<h2>algumas informações minhas</h2><br/>");
		stringBuilderTextoEmail.append("<h3 style=\"color: rgb(105, 105, 208)\">Celular: 97547-8395<br/>");
		stringBuilderTextoEmail.append("Email Príncipal: nelsonscosta@yahoo.com.br<br/>");
		stringBuilderTextoEmail.append("https://www.linkedin.com/in/nelson-souto-itil-083b7b23/<br/>");
		stringBuilderTextoEmail.append("https://github.com/nelsonscosta/Projeto-Spring-Boot/tree/master</h3><br/>");
		stringBuilderTextoEmail.append("https://github.com/nelsonscosta/Projeto-Spring-Boot/tree/master</h3><br/>");
		stringBuilderTextoEmail.append("<center><img style=\"width: 30%; height:30%;\" src=\"https://amplificadigital.com.br/wp-content/uploads/2019/12/amplifica_banner_blog_programaccca7acc83o.webp\" alt=\"\"></center>");
		
		stringBuilderTextoEmail.append("<center><h2 style=\"background-color:rgb(210, 220, 241)\"> OBJETIVO: ANALISTA DE SISTEMA</h2></center>");
		stringBuilderTextoEmail.append("<p>");
		stringBuilderTextoEmail.append("<center><h3 style=\"background-color: rgb(234, 245, 196)\"><strong> Profissional com mais de 10 anos de experiência com atendimento em suporte e\r\n"
				+ "    manutenção em sistemas internos, experiências em Java com HTML, CSS,\r\n"
				+ "    Java Script e MySQL. Utilizando o servidor Apache. Conhecimento Postman.\r\n"
				+ "    Me aperfeiçoando também no desenvolvimento com Spring Boot, Angular e criação\r\n"
				+ "    de apps em Android Studio. Como também, estudando e me aprimorando cada vez\r\n"
				+ "    mais em meu nível de inglês, para me tornar mais fluente no idioma.\r\n"
				+ "    Experiência também em instalação e configuração de servidores, roteadores e\r\n"
				+ "    infraestrutura de rede. </strong></h3></center>");
		
		stringBuilderTextoEmail.append("<h3 style=\"background-color:rgb(210, 220, 241)\"><center>RESULTADOS</center></h3>");
		stringBuilderTextoEmail.append("<center><h3 style=\"background-color: rgb(234, 245, 196)\"><strong> Elaboração e desenvolvimento de aplicativo, onde gerou um ganho de 100%\r\n"
				+ "em produtividade para funcionários nos atendimentos de chamados e para gerentes e\r\n"
				+ "diretoria confiabilidade e eficácia diante de seus clientes, tornando uma empresa mais\r\n"
				+ "sólida e mais confiável; Elaboração e desenvolvimento de formulários em Java, que\r\n"
				+ "potencializaram em 70% o atendimento de Service Desk, melhorando sua qualidade,\r\n"
				+ "eficácia e confiabilidade junto aos clientes da empresa, gerando mais competitividade\r\n"
				+ "no mercado.</strong></h3></center>");
		stringBuilderTextoEmail.append("<h3 style=\"background-color:rgb(210, 220, 241)\"><center> FORMAÇÃO ACADÊMICA E CERTIFICAÇÕES</center></h3>");
		stringBuilderTextoEmail.append("<center><h3 style=\"background-color: rgb(234, 245, 196)\"><strong><b> Bacharel em Ciência Da Computação\r\n"
				+ "Universidade Nove De Julho Dezembro/2006</b></strong></center></h3>");
		stringBuilderTextoEmail.append("<h3 style=\"background-color:rgb(234, 245, 196)\"><center><strong> Certificação ITIL Foundation\r\n"
				+ "Prométric Junho/2013 </strong></center></h3>");
		stringBuilderTextoEmail.append("<h3 style=\"background-color:rgb(234, 245, 196)\"><center><strong> Certificação Lógica de Programção\r\n"
				+ "JDev Treinamento on-line Junho/2021</strong></center></h3>");
		stringBuilderTextoEmail.append("<h3 style=\"background-color:rgb(234, 245, 196)\"><center><strong> Certificação Orientação a Objeto com Java\r\n"
				+ "JDev Treinamento on-line Agosto/2013</strong>\r\n"
				+ "</center></h3>");
		stringBuilderTextoEmail.append("<h3 style=\"background-color:rgb(234, 245, 196)\"><center><strong> Certificação JSF 2.2 introdução e funcionamento\r\n"
				+ "JDev Treinamento on-line Maio/2023</strong>\r\n"
				+ "</center></h3>");
		stringBuilderTextoEmail.append("<h3 style=\"background-color:rgb(234, 245, 196)\"><center><strong> Certificação JPA e Hibernate no JSF 2.2 e Persistência de dados\r\n"
				+ "JDev Treinamento on-line Maio/2023</strong>\r\n"
				+ "</center></h3>");
		stringBuilderTextoEmail.append("<h3 style=\"background-color:rgb(234, 245, 196)\"><center><strong> Certificação Servlets com JavaServer Pages e JDBC\r\n"
				+ "JDev Treinamento on-line Novembro/2022</strong>\r\n"
				+ "</center></h3>");
		stringBuilderTextoEmail.append("<h3 style=\"background-color:rgb(210, 220, 241)\"><center>HSTÓRICO PROFISSIONAL</center></h3>");
		stringBuilderTextoEmail.append("<center>\r\n"
				+ "<li><strong style=\"color: rgb(255,0,0)\"> DETRAN - AGOSTO/2019 – FEVEREIRO/2021</strong></li>\r\n"
				+ "<br>\r\n"
				+ "Cargo: Analista de Sistema\r\n"
				+ "<br>\r\n"
				+ "Manutenção em sistema internos em WEB do detran;\r\n"
				+ "atendimento aos chamados de 1º nível<br>\r\n"
				+ "<p></p>\r\n"
				+ "<li><strong style=\"color: rgb(255,0,0)\">ATLAS SHINDLER – OUTUBRO/2018 –FEVEREIRO/2019 </strong></li>\r\n"
				+ "(Projeto Temporário)</strong>\r\n"
				+ "<br>\r\n"
				+ "Cargo: Analista de Sistema\r\n"
				+ "<br>\r\n"
				+ "Manutenção e desenvolvimento em sistemas JSP com HTML e Java Script\r\n"
				+ "usando banco de dados MySQL, para departamentos de Engenharia, gerando\r\n"
				+ "produtividade para os acabamentos dos projetos desenvolvidos nos mesmos\r\n"
				+ "setores;\r\n"
				+ "<p></p>\r\n"
				+ "<li\"><strong style=\"color: rgb(255,0,0)\">KAINOS - JANEIRO/2018 – AGOSTO/2018</strong></li>\r\n"
				+ "<br>\r\n"
				+ "Cargo: Analista de Suporte\r\n"
				+ "<br>\r\n"
				+ "Suporte aos Sistemas interno da empresa, com configuração e administração\r\n"
				+ "em Servidores e suporte técnico aos usuários\r\n"
				+ "Desenvolvimento em aplicativo sftp em java para um projeto\r\n"
				+ "interno da empresa. \r\n"
				+ "Configuração e ajustes em ferramentas de softphones como FIVE9,\r\n"
				+ "FRONTCOMM e demais aplicações. Suporte Técnico a usuários remoto\r\n"
				+ "e localmente (na instalação e configuração de diversas aplicações nas\r\n"
				+ "estações de trabalho Windows).\r\n"
				+ "<p></p>\r\n"
				+ "<li\"><strong style=\"color: rgb(255,0,0)\"> ATOS DO BRASIL – FEVEREIRO/2012 – MAIO/2013</strong></li> \r\n"
				+ "    <br>\r\n"
				+ "Cargo: Analista de Suporte\r\n"
				+ "<br>\r\n"
				+ "No Service Desk (auxiliando usuários remotamente nas configurações dentro\r\n"
				+ "do Windows) mantendo assim a boa qualidade e desempenho do seu serviço e\r\n"
				+ "também na criação e elaboração de formulários Linguagem de programação\r\n"
				+ "JAVA, que foi uma poderosa e eficaz ferramenta para o atendimento.\r\n"
				+ "<p></p>\r\n"
				+ "</center>");
		stringBuilderTextoEmail.append("");
		stringBuilderTextoEmail.append("");
		stringBuilderTextoEmail.append("");
		stringBuilderTextoEmail.append("");
		stringBuilderTextoEmail.append("");
		stringBuilderTextoEmail.append("");
		stringBuilderTextoEmail.append("");
		stringBuilderTextoEmail.append("");
		stringBuilderTextoEmail.append("");
		stringBuilderTextoEmail.append("");
		stringBuilderTextoEmail.append("");
		stringBuilderTextoEmail.append("");
		stringBuilderTextoEmail.append("");
		stringBuilderTextoEmail.append("");
		stringBuilderTextoEmail.append("");
		stringBuilderTextoEmail.append("");
		stringBuilderTextoEmail.append("");
		stringBuilderTextoEmail.append("");
		stringBuilderTextoEmail.append("");
		stringBuilderTextoEmail.append("");
		stringBuilderTextoEmail.append("");
		stringBuilderTextoEmail.append("");
		stringBuilderTextoEmail.append("");
		stringBuilderTextoEmail.append("");
		stringBuilderTextoEmail.append("<h3>E você também está recebendo  o meu Projeto de Demonstração</h3>");
		stringBuilderTextoEmail.append("<h3>Por favor,clique no botão abaixo, para obter acesso</h3>");
		stringBuilderTextoEmail.append("<a target=\"_blank\" href=\"https://projetojavawebnelsonsc.com.br\" style=\"color:#2b086b; padding:14px 25px; text-align: center; text-decoration: none;display: inline-block; border-radius: 30px; font-size:20px; font-family: Courier; border: 3px solid rgb(1, 51, 1); background-color: #64af38;\">Acesso ao Projeto</a>");
		
		stringBuilderTextoEmail.append("<span style=\"font-size: 15px;\"> Ass.: Nelson Souto Costa</span>");
		
		
		
		ObjetoenvioEmail2 enviaEmail = new ObjetoenvioEmail2("nelsonscosta@yahoo.com.br",
															  "Nelson - Programador em Java",
															  "Email enviado através do java",
															   stringBuilderTextoEmail.toString());
		//quando enviar email html será true
		//quando enviar email somente texto será false
		enviaEmail.enviarEmail(true);
    	
		//caso o e-mail não está sendo enviado colocar um tempo
		Thread.sleep(2000);	
    }
}
