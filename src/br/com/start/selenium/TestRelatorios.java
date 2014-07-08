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

public class TestRelatorios {
	
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
	public void testTelaRelatorios01() {
		//Seleciona menu superior Relatórios / Mapa de Projetos
		Actions actionMP = new Actions(driver);
		actionMP.moveToElement(driver.findElement(By.linkText("Relatórios"))).click().perform();
		driver.findElement(By.linkText("Mapa de Projetos")).click();
		
		//Seleciona Projeto Menu Lateral
		//Seleciona projeto menu esquerdo
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Business Game")).click();
	
		//Navega menu superior do Projeto
		driver.findElement(By.linkText("Dashboard")).click(); 
		driver.findElement(By.linkText("Ordem de Grandeza")).click();
		driver.findElement(By.linkText("Visão Geral")).click();
		driver.findElement(By.linkText("Planejamento")).click();
		driver.findElement(By.linkText("Diário de Bordo")).click();
		driver.findElement(By.linkText("Profissionais")).click();
		driver.findElement(By.linkText("Kanban")).click();
		driver.findElement(By.linkText("Kanban QA")).click();
		driver.findElement(By.linkText("Comentários")).click();
	}
	
	@Test
	public void testTelaRelatorios02() {
		//Seleciona menu superior Relatórios / Projetos por Fases
		Actions actionPF = new Actions(driver);
		actionPF.moveToElement(driver.findElement(By.linkText("Relatórios"))).click().perform();
		driver.findElement(By.linkText("Projetos por Fases")).click();
	}
	
	@Test
	public void testTelaRelatorios03() {
		//Seleciona Menu esquerdo de projetos
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Business Game")).click();
	}
	
	@Test
	public void testTelaRelatorios04() {
		//Seleciona menu superior Relatórios / Projetos por Profissionais
		Actions actionPP = new Actions(driver);
		actionPP.moveToElement(driver.findElement(By.linkText("Relatórios"))).click().perform();
		driver.findElement(By.linkText("Projetos por Profissionais")).click();
	
		//Seleciona o Profissional
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Tabajara Moura")).click();
	}
	
	@Test
	public void testTelaRelatorios05() {
		//Seleciona menu superior Relatórios / Profissionais por Projetos
		Actions actionPP2 = new Actions(driver);
		actionPP2.moveToElement(driver.findElement(By.linkText("Relatórios"))).click().perform();
		driver.findElement(By.linkText("Profissionais por Projetos")).click();
	}
	
	@Test
	public void testTelaRelatorios06() {
		//Seleciona o Projeto
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Business Game")).click();
	}
	
	@Test
	public void testTelaRelatorios07() {
		//Seleciona menu superior Relatórios / Horas Executadas
		Actions actionHE = new Actions(driver);
		actionHE.moveToElement(driver.findElement(By.linkText("Relatórios"))).click().perform();
		driver.findElement(By.linkText("Horas Executadas")).click();
				
		//Seleciona Periodo para filtro
		driver.findElement(By.name("dt_ini")).clear();
		driver.findElement(By.name("dt_ini")).sendKeys("01/01/2014");
		driver.findElement(By.name("dt_end")).clear();
		driver.findElement(By.name("dt_end")).sendKeys("30/04/2014");
		driver.findElement(By.cssSelector("input[class='btn btn-primary btn-well']")).click();
		
		//Selecionando numero de Registros para Exibir
		Select ano = new Select(driver.findElement(By.name("DataTables_Table_0_length")));
		ano.selectByVisibleText("25");
		
		//Proxima pagina de Registros
		driver.findElement(By.id("DataTables_Table_0_next")).click();
		
		//Selecionando Funcionario
		driver.findElement(By.linkText("Tabajara Dos Reis Moura")).click();
		
		//Volta Pagina Inicial
		driver.findElement(By.cssSelector("[class='brand logo-oi-internet']")).click();
	}

}
