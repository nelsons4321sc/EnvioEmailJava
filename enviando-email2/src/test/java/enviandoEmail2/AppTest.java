package enviandoEmail2;

import org.junit.Test;


public class AppTest {
	
	@Test
    public void TesteEmail() throws Exception{
		
		ObjetoenvioEmail2 enviaEmail = new ObjetoenvioEmail2("nelsonscosta@yahoo.com.br",
															  "Nelson - Programador em Java",
															  "Email enviado através do java",
															  "Email de teste");
		enviaEmail.enviarEmail();
    	
		//caso o e-mail não está sendo enviado colocar um tempo
		Thread.sleep(2000);	
    }
}
