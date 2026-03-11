package com.travelocity.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private static final String ACTOR = "El usuario";

    @Managed
    private WebDriver driver;

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled(ACTOR)
                .can(BrowseTheWeb.with(driver));
    }

    @Dado("que ingreso al portal travelocity.com")
    public void queIngresoAlPortalTravelocityCom() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Open.url("https://www.travelocity.com/")
        );
    }
}