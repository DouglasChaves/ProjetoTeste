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

public class TestProjetos {
	
	WebDriver driver;
	WebDriverWait wait;
	

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver,15);
		//AcessaURL
		driver.get("https://start.oiinternet.com.br/login.php?l=auth");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testeTelaProjeto() {
		//Login Site
		driver.findElement(By.id("oi_id")).sendKeys("oi307525");
		driver.findElement(By.id("passwd")).sendKeys("Oi#2013");
		driver.findElement(By.id("btn-do-login")).click();
		
		//Seleciona menu superior Projetos - Todos os Projetos
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("Projetos"))).click().perform();
		driver.findElement(By.linkText("Todos os Projetos")).click();
		
		//Seleciona Projetos em Backlog 
		Select projetoBacklog = new Select(driver.findElement(By.id("classification-list")));
		projetoBacklog.selectByVisibleText("Em Backlog");

		//Seleciona Projetos Em Backlog Priorizado
		Select projetoBacklogP = new Select(driver.findElement(By.id("classification-list")));
		projetoBacklogP.selectByVisibleText("Em Backlog Priorizado");
		
		//Seleciona Projetos Em Execução
		Select projetoExecucao = new Select(driver.findElement(By.id("classification-list")));
		projetoExecucao.selectByVisibleText("Em Execução");
		
		//Seleciona Projetos Pausado
		Select projetoPausado = new Select(driver.findElement(By.id("classification-list")));
		projetoPausado.selectByVisibleText("Pausado");
		
		//Seleciona Projetos Finalizado
		Select projetoFinalizado = new Select(driver.findElement(By.id("classification-list")));
		projetoFinalizado.selectByVisibleText("Finalizado");
		
		//Seleciona Todos os Projetos
		Select projetoTodos = new Select(driver.findElement(By.id("classification-list")));
		projetoTodos.selectByVisibleText("- - Todos - -");
		
		//Seleciona projeto menu esquerdo
		Actions actionProjeto = new Actions(driver);
		actionProjeto.moveToElement(driver.findElement(By.cssSelector("[class='project-name overpast']"))).click().perform();
		
		//Navega no Projeto Selecionado
		//Navega menu superior do Projeto
		driver.findElement(By.linkText("Dashboard")).click(); //Seleção da aba superior do projeto DashBoard
		driver.findElement(By.linkText("Ordem de Grandeza")).click();//Seleção da aba superior do projeto Ordem de Grandeza
		driver.findElement(By.linkText("Visão Geral")).click();//Seleção da aba superior do projeto Visão Geral
		driver.findElement(By.linkText("Planejamento")).click();//Seleção da aba superior do projeto Planejamento
		//Navegando na tela de planejamentos 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class='sprint-link ']")));
		driver.findElement(By.cssSelector("[class='sprint-link ']")).click();
		driver.findElement(By.cssSelector("[class='icon fa fa-pencil']")).click();
		//Navegando menu superior Projeto
		driver.findElement(By.linkText("Diário de Bordo")).click();//Selecao aba superior do projeto Diário de Bordo
		//Navegando na tela Diario de Bordo
		driver.findElement(By.cssSelector("[class='fa fa-angle-right']")).click();;
		driver.findElement(By.linkText("Status Report")).click();
		//Navegando menu superior Projeto
		driver.findElement(By.linkText("Profissionais")).click();//Selecao aba superior do projeto Profissionais
		driver.findElement(By.linkText("Kanban")).click();//Selecao aba superior do projeto Kanban
		//Navegando na Tela Kanban
		driver.findElement(By.cssSelector("[class='tip']")).click();
		//Navegando menu superior Projeto
		driver.findElement(By.linkText("Kanban QA")).click();//Selecao aba superior do projeto Kanban QA
		driver.findElement(By.linkText("Comentários")).click();//Selecao aba superior do projeto Comentários
		
		//Seleciona menu superior Projetos - Modelos de Fases
		Actions action2 = new Actions(driver);
		action2.moveToElement(driver.findElement(By.linkText("Projetos"))).click().perform();
		driver.findElement(By.linkText("Modelos de Fases")).click();
		
		driver.findElement(By.linkText("Modelo Hosting (6)")).click();
		
		//Seleciona menu superior Projetos - Modelos de Fases
		Actions action3 = new Actions(driver);
		action3.moveToElement(driver.findElement(By.linkText("Projetos"))).click().perform();
		driver.findElement(By.linkText("Criar Projeto")).click();
		
		//Volta Pagina Inicial
		driver.findElement(By.cssSelector("[class='brand logo-oi-internet']")).click();
	}

}
