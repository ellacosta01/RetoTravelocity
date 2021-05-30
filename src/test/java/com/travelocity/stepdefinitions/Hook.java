package com.travelocity.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.es.Dado;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class Hook {

    @Managed
    private WebDriver hisBrowser;

    @Before
    public void setUp(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("El usuario").can(BrowseTheWeb.with(hisBrowser));
    }

    @Dado("^que ingreso al portal travelocity\\.com$")
    public void queIngresoAlPortalTravelocityCom() {
        OnStage.theActorInTheSpotlight().attemptsTo(Open.url("https://www.travelocity.com/"));
    }
}
