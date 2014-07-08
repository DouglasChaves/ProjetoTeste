package br.com.start.selenium;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestTimes {
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.get("https://start.oiinternet.com.br/login.php?l=auth");
		//Login Site
		driver.findElement(By.id("oi_id")).sendKeys("oi307525");
		driver.findElement(By.id("passwd")).sendKeys("Oi#2013");
		driver.findElement(By.id("btn-do-login")).click();		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testTelaTimes01() {
		//Seleciona menu superior Times / Todos os Profissionais
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("Times"))).click().perform();
		driver.findElement(By.linkText("Todos os Profissionais")).click();

		//Navegando nas Abas superiores da Tela Times / Todos os Profissionais 
		driver.findElement(By.linkText("Governança")).click();
		driver.findElement(By.linkText("Gerência de Projeto")).click();
		driver.findElement(By.linkText("Desenvolvimento")).click();
		driver.findElement(By.linkText("Infra")).click();
		driver.findElement(By.linkText("QA")).click();
		driver.findElement(By.linkText("Fornecedor")).click();
		driver.findElement(By.linkText("Todos")).click();
		
		//Selecionando um Profissional
		driver.findElement(By.linkText("Tabajara Dos Reis Moura")).click();
		
		//Navegando na tela do Profissional
		/*
		driver.findElement(By.cssSelector("[class='fa fa-calendar blue']")).click();
		driver.findElement(By.cssSelector("[class='fc-button-content']")).click();
		driver.findElement(By.cssSelector("[class='fc-button-inner']")).click();
		driver.findElement(By.cssSelector("[class='fc-button-inner']")).click();
		*/
	}
	
	@Test
	public void testTelaTimes02() {
		//Seleciona menu superior Times / Calendario Anual
		Actions actionCal = new Actions(driver);
		actionCal.moveToElement(driver.findElement(By.linkText("Times"))).click().perform();
		driver.findElement(By.linkText("Calendário Anual")).click();
		
		//Navegando no Calend�rio Anual
		driver.findElement(By.linkText("JAN")).click();
		driver.findElement(By.linkText("FEV")).click();
		driver.findElement(By.linkText("MAR")).click();
		driver.findElement(By.linkText("ABR")).click();
		driver.findElement(By.linkText("MAI")).click();
		driver.findElement(By.linkText("JUN")).click();
		driver.findElement(By.linkText("JUL")).click();
		driver.findElement(By.linkText("AGO")).click();
		driver.findElement(By.linkText("SET")).click();
		driver.findElement(By.linkText("OUT")).click();
		driver.findElement(By.linkText("NOV")).click();
		driver.findElement(By.linkText("DEZ")).click();
		
		//Selecionando ano 2015 para exibir Calendário
		Select ano = new Select(driver.findElement(By.id("slc-year")));
		ano.selectByVisibleText("Calendário 2015");
		
		//Seleciona menu superior Times / Liberação de Acesso
		Actions actionAcesso = new Actions(driver);
		actionAcesso.moveToElement(driver.findElement(By.linkText("Times"))).click().perform();
		driver.findElement(By.linkText("Liberação de Acesso")).click();
			
		//Somente Seleciona os campos nao Grava.
		
		//Seleciona Area
		Select area = new Select(driver.findElement(By.id("area-list")));
		area.selectByVisibleText("Infra");
		
		//Seleciona Especialidade
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Select especialidade = new Select(driver.findElement(By.id("speciality-list-92")));
		especialidade.selectByVisibleText("Rede");
		
		//Seleciona Perfil de Acesso
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Select acesso = new Select(driver.findElement(By.name("level")));
		acesso.selectByVisibleText("Administrador");
		
		//Volta Pagina Inicial
		driver.findElement(By.cssSelector("[class='brand logo-oi-internet']")).click();

	}

}
