package br.com.start.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestTarefas {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		wait = new  WebDriverWait(driver,15);
		//AcessaURL
		driver.get("https://start.oiinternet.com.br/login.php?l=auth");
		
	}

	@After
	public void tearDown() throws Exception {
		//Fecha o navegador
		driver.quit();
	}

	@Test
	public void testeTelaTarefas() {
		
		//Login Site
		driver.findElement(By.id("oi_id")).sendKeys("oi307525");
		driver.findElement(By.id("passwd")).sendKeys("Oi#2013");
		driver.findElement(By.id("btn-do-login")).click();
		
		
		//Selecionar menu superior Tarefas
		Actions actionTT = new Actions(driver);
		actionTT.moveToElement(driver.findElement(By.linkText("Tarefas"))).click().perform();
		driver.findElement(By.linkText("Todas as Tarefas")).click();
		
		//Pesquisa Tarefas
		driver.findElement(By.cssSelector("input[id='search']")).sendKeys("Reports");
		driver.findElement(By.cssSelector("input[class='btn btn-primary']")).click();
		
		//Aguarda bot�o limpar filtro
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("filter-clear")));
		
		//Limpa Pesquisa
		driver.findElement(By.id("filter-clear")).click();		

		//Nova Pesquisa
		driver.findElement(By.cssSelector("input[id='search']")).sendKeys("Projeto");
		driver.findElement(By.cssSelector("input[class='btn btn-primary']")).click();
		
		//Limpa Pesquisa
		driver.findElement(By.id("filter-clear")).click();
		
		//Pesquisa por noma do projeto
		driver.findElement(By.id("token-input-filter-project")).sendKeys("Automatização do fluxo de vendas");
		driver.findElement(By.cssSelector("input[class='btn btn-primary']")).click();
		
		//Limpa Pesquisa
		driver.findElement(By.id("filter-clear")).click();
		
		//Pesquisa por nome Professional
		driver.findElement(By.id("token-input-filter-directed")).sendKeys("Tabajara Dos Reis Moura ");
		driver.findElement(By.cssSelector("input[class='btn btn-primary']")).click();
		
		//Limpa Pesquisa
		driver.findElement(By.id("filter-clear")).click();
		
		//Pesquisa por Tipo
		Select pesqTipo = new Select(driver.findElement(By.id("filter-type")));
		pesqTipo.selectByVisibleText("Melhoria");
		driver.findElement(By.cssSelector("input[class='btn btn-primary']")).click();
		
		//Pesquisa por Status
		Select pesqStatus = new Select(driver.findElement(By.id("filter-status")));
		pesqStatus.selectByVisibleText("Para fazer");
		driver.findElement(By.cssSelector("input[class='btn btn-primary']")).click();
		
		//Pesquisa por Prioridade
		Select pesqPrioridade = new Select(driver.findElement(By.id("filter-priority")));
		pesqPrioridade.selectByVisibleText("Normal");
		driver.findElement(By.cssSelector("input[class='btn btn-primary']")).click();
		
		//Pesquisa por Periodo
		Select pesqPeriodo = new Select (driver.findElement(By.name("period")));
		pesqPeriodo.selectByVisibleText("data de criação");
		driver.findElement(By.id("start_date")).clear();
		driver.findElement(By.id("start_date")).sendKeys("01/01/2014");
		driver.findElement(By.id("finish_date")).clear();
		driver.findElement(By.id("finish_date")).sendKeys("24/06/2014");
		
		//Ordenar 
		Select ordenarData = new Select (driver.findElement(By.name("order")));
		ordenarData.selectByVisibleText("data de criação");
		Select ordenarTipo = new Select (driver.findElement(By.name("orderby")));
		ordenarTipo.selectByVisibleText("ascendente");
		driver.findElement(By.cssSelector("input[class='btn btn-primary']")).click();
		
		//Visuliza pesquisa 
		driver.findElement(By.linkText("Pesquisas Salvas")).click();
		
		//Seleciona Item da pesquisa
		driver.findElement(By.linkText("#903 - Notificação de e-mail")).click();
		//Navegando na Tarefa
		driver.findElement(By.linkText("Investimento de tempo")).click();//Aba superior investimento de tempo
		driver.findElement(By.linkText("Comentários")).click();//Aba superior Comentários
		//Navegando aba Comentários
		driver.findElement(By.id("assignment-comment-type")).click();
		driver.findElement(By.cssSelector("[value='2']")).click();
		driver.findElement(By.name("body")).click();
		driver.findElement(By.name("body")).sendKeys("Teste - Não será adicionado nenhum Comentário. Vamos para outra Aba");
		//Navegando na Tarefa
		driver.findElement(By.linkText("Log de Eventos")).click();//Aba superior Log de Eventos
		driver.findElement(By.linkText("Profissionais Envolvidos")).click();
		
		//Seleciona menu superior Tarefas - Criar Tarefas
		Actions actionC = new Actions(driver);
		actionC.moveToElement(driver.findElement(By.linkText("Tarefas"))).click().perform();
		driver.findElement(By.linkText("Criar Tarefa")).click();
		
		//Volta Pagina Inicial
		driver.findElement(By.cssSelector("[class='brand logo-oi-internet']")).click();
	
	}

}
