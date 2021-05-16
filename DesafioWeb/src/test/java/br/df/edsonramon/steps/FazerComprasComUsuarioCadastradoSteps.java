package br.df.edsonramon.steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import br.df.edsonramon.utils.Screenshot;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class FazerComprasComUsuarioCadastradoSteps {
		
	public static WebDriver driver;
	
	private String url = "http://automationpractice.com/";
	
	private String email = "user"+System.nanoTime()+"@edson.com";
	private String senha = "teste12345";
	
	private String usuarioSalvo;
		
	@Dado("que realizo o acesso ao site do desafio")
	public void que_realizo_o_acesso_ao_site_do_desafio() {
		System.setProperty("webdriver.chrome.driver", "D:\\Downloads\\navegador\\chromedriver.exe");
		driver = new ChromeDriver();		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Quando("clico em Sign in")
	public void clico_em_sign_in() throws Exception {
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
	}

	@E("informo o e-mail para criar nova conta")
	public void informo_o_e_mail_para_criar_nova_conta() throws Exception {
		driver.findElement(By.id("email_create")).sendKeys(email);
		usuarioSalvo = System.setProperty("keyEmail", email);
		Screenshot.takeSnapShot(driver, "target\\screenshots\\01_emailUsuario.png");
	}

	@E("clico no botão Create an account")
	public void clico_no_botão_create_an_account() {
		driver.findElement(By.id("SubmitCreate")).click();
	}

	@E("preencho as informações pessoais")
	public void preencho_as_informações_pessoais() {
		driver.findElement(By.xpath("//label[@for='id_gender1']/div")).click();
		driver.findElement(By.id("customer_firstname")).sendKeys("Edson");
		driver.findElement(By.id("customer_lastname")).sendKeys("Souza");
		driver.findElement(By.id("passwd")).sendKeys(senha);
		driver.findElement(By.id("days")).sendKeys("20");
		driver.findElement(By.id("months")).sendKeys("May");
		driver.findElement(By.id("years")).sendKeys("2000");
	}

	@E("preencho o endereço")
	public void preencho_o_endereço() {
		driver.findElement(By.id("company")).sendKeys("Lojas Renner S/A");
		driver.findElement(By.id("address1")).sendKeys("Rua 20, Brasília, Distrito Federal");
		driver.findElement(By.id("city")).sendKeys("Brasília");
		driver.findElement(By.id("id_state")).sendKeys("Pennsylvania");
		driver.findElement(By.id("postcode")).sendKeys("00000");
		driver.findElement(By.id("id_country")).sendKeys("United States");
		driver.findElement(By.id("phone")).sendKeys("99877-2020");		
	}

	@E("clico no botão Register")
	public void clico_no_botão_register() {
		driver.findElement(By.id("submitAccount")).click();
	}

	@Então("visualizo a mensagem {string}")
	public void visualizo_a_mensagem(String mensagemFeature) throws Exception {
	   String validaMensagem = driver.findElement(By.xpath("//p[@class='info-account']")).getText();
	   Assert.assertEquals(mensagemFeature, validaMensagem);
	   Screenshot.takeSnapShot(driver, "target\\screenshots\\02_cadastroUsuario.png");
	}

	@E("^informo minhas credenciais de acesso$")
	public void informoMinhasCredenciaisDeAcesso() throws Exception {
		usuarioSalvo = System.getProperty("keyEmail");
		driver.findElement(By.id("email")).sendKeys(usuarioSalvo);
		driver.findElement(By.id("passwd")).sendKeys(senha);
		Screenshot.takeSnapShot(driver, "target\\screenshots\\03_emailUsuarioCriado.png");
		driver.findElement(By.id("SubmitLogin")).click();
	}
	
	@Quando("^pesquiso o produto \"([^\"]*)\"$")
	public void pesquisoOProduto(String produto){
		driver.findElement(By.id("search_query_top")).clear();
		driver.findElement(By.id("search_query_top")).sendKeys(produto);
		driver.findElement(By.name("submit_search")).click();
		WebElement produtoPesquisado = driver.findElement(By.xpath("//div[@class='product-container']//a[contains(text(), '"+produto+"')]"));
		produtoPesquisado.click();		
	}

	@E("^tamanho \"([^\"]*)\"$")
	public void tamanho(String tamanho) {
		switch (tamanho) {
		case "M":
			driver.findElement(By.xpath("//select/option[@title='M']")).click();
			break;
		}
	}
	
	@E("^seleciono a cor \"([^\"]*)\"$")
	public void selecionoACor(String cor) throws Exception {
		switch (cor) {
		case "verde":
			driver.findElement(By.xpath("//ul[@id='color_to_pick_list']/li/a[@name='Green']")).click();
			Thread.sleep(2000);
			Screenshot.takeSnapShot(driver, "target\\screenshots\\04_printedChiffonDress.png");
			break;
		
		case "azul":
			driver.findElement(By.xpath("//ul[@id='color_to_pick_list']/li/a[@name='Blue']")).click();
			Thread.sleep(2000);
			Screenshot.takeSnapShot(driver, "target\\screenshots\\05_fadedShortSleeveT-shirts.png");
			break;
		}
	}
	
	@E("^adiciono a quantidade \"([^\"]*)\"$")
	public void adicionoAQuantidade(String quantidade) throws Exception {
		switch (quantidade) {
		case "2":
			driver.findElement(By.xpath("//i[@class='icon-plus']")).click();
			Screenshot.takeSnapShot(driver, "target\\screenshots\\06_blouse.png");
			break;
		
		case "1":
			Screenshot.takeSnapShot(driver, "target\\screenshots\\07_printedDress.png");
			break;
		}
	}

	@E("^clico no botão Add to cart$")
	public void clicoNoBotãoAddToCart() {
		driver.findElement(By.name("Submit")).click();
	}

	@E("^clico no botão Continue shopping$")
	public void clicoNoBotãoContinueShopping() {		
		driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();
	}

	@E("^clico no link Proceed to checkout$")
	public void clicoNoLinkProceedToCheckout() throws Exception {
		driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
	}

	@E("^clico no botão Proceed to checkout$")
	public void clicoNoBotãoProceedToCheckout() {
		driver.findElement(By.xpath("//*[text()='Proceed to checkout']")).click();
	}

	@E("^marco que aceito todos os termos$")
	public void marcoQueAceitoTodosOsTermos() {
		driver.findElement(By.xpath("//label[contains(text(),'I agree to the terms')]")).click();
		driver.findElement(By.name("processCarrier")).click();
	}

	@E("^seleciono o método de pagamento \"([^\"]*)\"$")
	public void selecionoOMétodoDePagamento(String pagamento) {
		WebElement pagamentoSelecionado = driver.findElement(By.xpath("//a[contains(text(), '"+pagamento+"')]"));
		pagamentoSelecionado.click();
	}

	@E("^clico no botão I confirm my order$")
	public void clicoNoBotãoIConfirmMyOrder() {
		driver.findElement(By.xpath("//button[@class='button btn btn-default button-medium']")).click();
	}

	@Então("^visualizo a mensagem de sucesso \"([^\"]*)\"$")
	public void visualizoAMensagemDeSucesso(String mensagemFeature) throws Exception  {
		String validaMensagem = driver.findElement(By.xpath("//p/strong")).getText();
		Assert.assertEquals(mensagemFeature, validaMensagem);
		Screenshot.takeSnapShot(driver, "target\\screenshots\\08_pedidoConcluido.png");
	}
		
	@After()
	public void encerra() {		
		driver.quit();
	}
}
