package com.travelocity.tasks;

import com.travelocity.pageobjects.HomeConsultaHotelPageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.travelocity.utils.UtilidadesFechas.estaLaFechaPresente;

public class SeleccionarFecha implements Task {

    private final String day;
    private final String month;
    private final String year;
    private final String operation;

    public SeleccionarFecha(String day, String month, String year, String operation) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.operation = operation;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        openCalendar(actor);
        goToTargetMonth(actor);
        selectDay(actor);
        applyDateSelection(actor);
    }

    private <T extends Actor> void openCalendar(T actor) {
        if ("checkin".equalsIgnoreCase(operation)) {
            actor.attemptsTo(Click.on(HomeConsultaHotelPageObject.BTN_CHECK_IN));
            return;
        }

        if ("checkout".equalsIgnoreCase(operation)) {
            actor.attemptsTo(Click.on(HomeConsultaHotelPageObject.BTN_CHECK_OUT));
            return;
        }

        throw new IllegalArgumentException("Unsupported operation: " + operation);
    }

    private <T extends Actor> void goToTargetMonth(T actor) {
        String targetMonthYear = month + " " + year;

        while (!estaLaFechaPresente(
                HomeConsultaHotelPageObject.LBL_MES_YEAR_EN_CALENDARIO.resolveAllFor(actor),
                targetMonthYear)) {
            actor.attemptsTo(Click.on(HomeConsultaHotelPageObject.BTN_SIGUIENTE_MES));
        }
    }

    private <T extends Actor> void selectDay(T actor) {
        String dayAriaLabel = buildDayAriaLabel();
        actor.attemptsTo(Click.on(HomeConsultaHotelPageObject.BTN_DIA_EN_CALENDARIO.of(dayAriaLabel)));
    }

    private <T extends Actor> void applyDateSelection(T actor) {
        actor.attemptsTo(Click.on(HomeConsultaHotelPageObject.BTN_CALENDARIO_DONE));
    }

    private String buildDayAriaLabel() {
        String monthAbbreviation = month.substring(0, 3);
        return monthAbbreviation + " " + day + ", " + year;
    }

    public static SeleccionarFecha deCheckIn(String day, String month, String year) {
        return Tasks.instrumented(SeleccionarFecha.class, day, month, year, "checkin");
    }

    public static Performable deCheckOut(String day, String month, String year) {
        return Tasks.instrumented(SeleccionarFecha.class, day, month, year, "checkout");
    }
}