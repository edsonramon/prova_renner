package br.df.edsonramon.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/FazerComprasComUsuarioCadastrado.feature",
		glue = "br.df.edsonramon.steps",
		//tags = {},
		plugin = {"pretty"},
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		dryRun = false
		)
public class FazerComprasComUsuarioCadastradoRunner {

}