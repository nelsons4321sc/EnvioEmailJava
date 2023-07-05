package enviandoEmail2;

import org.junit.Test;


public class AppTest {
	
	@Test
    public void TesteEmail() throws Exception{
		
		ObjetoenvioEmail2 onbjetEnviaEmail2 = new ObjetoenvioEmail2(null, null, null, null);
    	
		//caso o e-mail não está sendo enviado colocar um tempo
		Thread.sleep(2000);	
    }
}
