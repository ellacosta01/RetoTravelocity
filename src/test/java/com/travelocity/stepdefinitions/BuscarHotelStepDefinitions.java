package com.travelocity.stepdefinitions;

import com.travelocity.models.CiudadDeEstadia;
import com.travelocity.models.HabitacionesEstadia;
import com.travelocity.pageobjects.HomeConsultaHotelPageObject;
import com.travelocity.questions.HayUnError;
import com.travelocity.questions.LaUbicacionDelHotel;
import com.travelocity.tasks.AgregarHabitacionYViajeros;
import com.travelocity.tasks.AjustarHabitacionesYViajeros;
import com.travelocity.tasks.SeleccionarDestino;
import com.travelocity.tasks.SeleccionarFecha;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class BuscarHotelStepDefinitions {

    @Cuando("^ingreso los datos basicos para buscar un hotel$")
    public void ingresoLosDatosBasicosParaBuscarUnHotel(List<CiudadDeEstadia> listaCiudadDeEstadia) {
        theActorInTheSpotlight().attemptsTo(
                SeleccionarDestino.deHoteleria(listaCiudadDeEstadia.get(0).getDestino()));
        theActorInTheSpotlight().attemptsTo(
                SeleccionarFecha.deCheckIn(
                        listaCiudadDeEstadia.get(0).getCheckInDia(),
                        listaCiudadDeEstadia.get(0).getCheckInMes(),
                        listaCiudadDeEstadia.get(0).getCheckInYear()));
        theActorInTheSpotlight().attemptsTo(
                SeleccionarFecha.deCheckOut(
                        listaCiudadDeEstadia.get(0).getCheckOutDia(),
                        listaCiudadDeEstadia.get(0).getCheckOutMes(),
                        listaCiudadDeEstadia.get(0).getCheckOutYear()));

    }

    @Cuando("^ingreso las habitaciones que necesito y viajeros que van conmigo$")
    public void ingresoLasHabitacionesQueNecesitoYViajerosQueVanConmigo(List<HabitacionesEstadia> listaHabitacionesEstadia) {
        theActorInTheSpotlight().attemptsTo(
                AgregarHabitacionYViajeros.deHotel(listaHabitacionesEstadia));
    }

    @Cuando("^ajusto el formulario de viajeros$")
    public void ajustoElFormularioDeViajeros(List<HabitacionesEstadia> listaHabitacionesEstadia) {
        theActorInTheSpotlight().attemptsTo(
                AjustarHabitacionesYViajeros.deHotel(listaHabitacionesEstadia));
    }

    @Cuando("^ejecuto la busqueda$")
    public void ejecutoLaBusqueda() {
        theActorInTheSpotlight().attemptsTo(Click.on(HomeConsultaHotelPageObject.BTN_BUSCAR_HOTEL));
    }

    @Cuando("^ingreso el destino \"([^\"]*)\"$")
    public void ingresoElDestino(String destino) {
        theActorInTheSpotlight().attemptsTo(SeleccionarDestino.deHoteleria(destino));
    }

    @Entonces("^deberia ver al menos un hotel de resultado en \"([^\"]*)\"$")
    public void deberiaVerAlMenosUnHotelDeResultadoEn(String destino) {
        theActorInTheSpotlight().should(seeThat(LaUbicacionDelHotel.apareceEnAlMenosUnResultado(destino), equalTo(true)));
    }

    @Entonces("^deberia ver un mensaje de error en el formulario de viajeros$")
    public void deberiaVerUnMensajeDeErrorEnElFormularioDeViajeros() {
        theActorInTheSpotlight().should(seeThat(HayUnError.enElFormularioDeViajeros(), equalTo(true)));
    }

    @Entonces("^el mensaje de error deberia tener el siguiente texto:$")
    public void elMensajeDeErrorDeberiaTenerElSiguienteTexto(List<String> listaMensajeError) {
        theActorInTheSpotlight().should(seeThat(HayUnError.conElMensaje(), equalTo(listaMensajeError.get(0))));
    }

    @Entonces("^deberia ver un mensaje de error en el formulario de busqueda de Hotel$")
    public void deberiaVerUnMensajeDeErrorEnElFormularioDeBusquedaDeHotel() {
        theActorInTheSpotlight().should(seeThat(HayUnError.enElFormularioDeBusquedaDeHotel(), equalTo(true)));
    }

}
