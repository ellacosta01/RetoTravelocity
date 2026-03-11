package com.travelocity.runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.travelocity.stepdefinitions",
        snippets = SnippetType.CAMELCASE,
        tags = "@buscarHotel",
        publish = false
)
public class BuscarHotelRunner {
}