package Testes;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:functionalTests", tags = "@codigopostal",
        glue = "Testes.passos", monochrome = true, dryRun = false)
public class teste1 {
}



/*
@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:caracteristicas", tags = "@ContaTeste",
        glue = "cucumber.teste.passos", monochrome = true, dryRun = false)
public class ContaTeste {
}

 */

