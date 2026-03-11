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
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class BuscarHotelStepDefinitions {

    @Cuando("ingreso los datos basicos para buscar un hotel")
    public void ingresoLosDatosBasicosParaBuscarUnHotel(List<CiudadDeEstadia> listaCiudadDeEstadia) {
        Actor actor = theActorInTheSpotlight();
        CiudadDeEstadia ciudadDeEstadia = listaCiudadDeEstadia.get(0);

        actor.attemptsTo(
                SeleccionarDestino.deHoteleria(ciudadDeEstadia.getDestino()),
                SeleccionarFecha.deCheckIn(
                        ciudadDeEstadia.getCheckInDia(),
                        ciudadDeEstadia.getCheckInMes(),
                        ciudadDeEstadia.getCheckInYear()
                ),
                SeleccionarFecha.deCheckOut(
                        ciudadDeEstadia.getCheckOutDia(),
                        ciudadDeEstadia.getCheckOutMes(),
                        ciudadDeEstadia.getCheckOutYear()
                )
        );
    }

    @Cuando("ingreso las habitaciones que necesito y viajeros que van conmigo")
    public void ingresoLasHabitacionesQueNecesitoYViajerosQueVanConmigo(List<HabitacionesEstadia> listaHabitacionesEstadia) {
        Actor actor = theActorInTheSpotlight();

        actor.attemptsTo(
                AgregarHabitacionYViajeros.deHotel(listaHabitacionesEstadia)
        );
    }

    @Cuando("ajusto el formulario de viajeros")
    public void ajustoElFormularioDeViajeros(List<HabitacionesEstadia> listaHabitacionesEstadia) {
        Actor actor = theActorInTheSpotlight();

        actor.attemptsTo(
                AjustarHabitacionesYViajeros.deHotel(listaHabitacionesEstadia)
        );
    }

    @Cuando("ejecuto la busqueda")
    public void ejecutoLaBusqueda() {
        Actor actor = theActorInTheSpotlight();

        actor.attemptsTo(
                Click.on(HomeConsultaHotelPageObject.BTN_BUSCAR_HOTEL)
        );
    }

    @Cuando("ingreso el destino {string}")
    public void ingresoElDestino(String destino) {
        Actor actor = theActorInTheSpotlight();

        actor.attemptsTo(
                SeleccionarDestino.deHoteleria(destino)
        );
    }

    @Entonces("deberia ver al menos un hotel de resultado en {string}")
    public void deberiaVerAlMenosUnHotelDeResultadoEn(String destino) {
        Actor actor = theActorInTheSpotlight();

        actor.should(
                seeThat(LaUbicacionDelHotel.apareceEnAlMenosUnResultado(destino), equalTo(true))
        );
    }

    @Entonces("deberia ver un mensaje de error en el formulario de viajeros")
    public void deberiaVerUnMensajeDeErrorEnElFormularioDeViajeros() {
        Actor actor = theActorInTheSpotlight();

        actor.should(
                seeThat(HayUnError.enElFormularioDeViajeros(), equalTo(true))
        );
    }

    @Entonces("el mensaje de error deberia tener el siguiente texto:")
    public void elMensajeDeErrorDeberiaTenerElSiguienteTexto(List<String> listaMensajeError) {
        Actor actor = theActorInTheSpotlight();
        String mensajeEsperado = listaMensajeError.get(0);

        actor.should(
                seeThat(HayUnError.conElMensaje(), equalTo(mensajeEsperado))
        );
    }

    @Entonces("deberia ver un mensaje de error en el formulario de busqueda de Hotel")
    public void deberiaVerUnMensajeDeErrorEnElFormularioDeBusquedaDeHotel() {
        Actor actor = theActorInTheSpotlight();

        actor.should(
                seeThat(HayUnError.enElFormularioDeBusquedaDeHotel(), equalTo(true))
        );
    }
}