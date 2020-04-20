package Testes.passos;

import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class buscaCepPassos {
    private final WebDriver driver;
    private String dados;

    public buscaCepPassos() {
        @Dado("^que esteja na página de busca Cep Endereço no site dos correios$")
        public void que_esteja_na_página_de_busca_Cep_Endereço_no_site_dos_correios() {

        }
        @Before
        public void setUp() throws Exception {
            System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        @After
        public void tearDown() throws Exception {
            driver.quit();
        }

        @Quando("^busco um \"([^\"]*)\" válido$")
        public void busco_um_cep_válido (int cep ) {
            //@Test
            public void test () throws Exception {
                driver.get("http://www.buscacep.correios.com.br/sistemas/buscacep/BuscaCepEndereco.cfm");

                driver.findElement(By.xpath("//*[@id=\"Geral\"]/div/div/span[2]/label/input")).sendKeys(cep);
                driver.findElement(By.xpath("//*[@id=\"Geral\"]/div/div/div[6]/input")).click();
            }
        }

        @Entao("^o site apresenta o resultado da busca realizada$")
        public void o_site_apresenta_o_resultado_da_busca_realizada() throws Throwable {
            //@Test

            System.out.println("Logradouro/Nome | Bairro/Distrito | Localidade/UF | Cep");

            while (driver.findElement(By.name("Proxima")).isDisplayed() == true) {
                WebElement tabela = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/table"));

                List<WebElement> linhas_tabela = tabela.findElements(By.tagName("tr"));

                int linha_cont = linhas_tabela.size();
                for (int row = 0; row < linha_cont; row++) {

                    List<WebElement> Colunas_linha = linhas_tabela.get(row).findElements(By.tagName("td"));

                    int colunas_cont = Colunas_linha.size();

                    for (int column = 0; column < colunas_cont; column++) {
                        String celtexto = Colunas_linha.get(column).getText();

                        if (column < 3) {
                            System.out.print(celtexto + " | ");
                        } else {
                            System.out.println(celtexto + " | ");
                        }
                    }
                }
                driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/a")).click();
            }
        }
    }
}

