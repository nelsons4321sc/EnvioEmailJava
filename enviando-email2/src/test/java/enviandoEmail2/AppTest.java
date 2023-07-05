package enviandoEmail2;

import org.junit.Test;


public class AppTest {
	
	@Test
    public void TesteEmail() throws Exception{
		
		StringBuilder stringBuilderTextoEmail = new StringBuilder();
		
		stringBuilderTextoEmail.append("<h2>Como Vai, Segue abaixo</h2>");
		stringBuilderTextoEmail.append("<h2>algumas informações minhas</h2><br/>");
		stringBuilderTextoEmail.append("<h3 style=\"color: rgb(105, 105, 208)\">Celular: 97547-8395<br/>");
		stringBuilderTextoEmail.append("Email Príncipal: nelsonscosta@yahoo.com.br<br/>");
		stringBuilderTextoEmail.append("https://www.linkedin.com/in/nelson-souto-itil-083b7b23/<br/>");
		stringBuilderTextoEmail.append("https://github.com/nelsonscosta/Projeto-Spring-Boot/tree/master</h3><br/>");
		
		
		
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
