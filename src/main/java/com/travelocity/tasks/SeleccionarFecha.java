package com.travelocity.tasks;

import com.travelocity.pageobjects.HomeConsultaHotelPageObject;
import com.travelocity.utils.UtilidadesFechas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.travelocity.utils.UtilidadesFechas.estaLaFechaPresente;

public class SeleccionarFecha implements Task {

    String dia;
    String mes;
    String year;
    String operacion;

    public SeleccionarFecha(String dia, String mes, String year, String operacion) {
        this.dia = dia;
        this.mes = mes;
        this.year = year;
        this.operacion = operacion;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String mesYear = mes + " " + year;
        // Click al botn de seleccionar fecha en el formulario
        switch (operacion.toLowerCase()) {
            case "checkin":
                actor.attemptsTo(Click.on(HomeConsultaHotelPageObject.BTN_CHECK_IN));
                break;
            case "checkout":
                actor.attemptsTo(Click.on(HomeConsultaHotelPageObject.BTN_CHECK_OUT));
                break;
        }
        // Click n veces al boton de avanzar fecha
        while (!estaLaFechaPresente(
                HomeConsultaHotelPageObject.LBL_MES_YEAR_EN_CALENDARIO.resolveAllFor(actor),
                mesYear)) {
            actor.attemptsTo(Click.on(HomeConsultaHotelPageObject.BTN_SIGUIENTE_MES));
        }
        // Click en el numero de dia
        String inicialesMes = mes.substring(0, 3);
        String localizador = inicialesMes + " " + dia + ", " + year;
        actor.attemptsTo(Click.on(HomeConsultaHotelPageObject.BTN_DIA_EN_CALENDARIO.of(localizador)));
        actor.attemptsTo(Click.on(HomeConsultaHotelPageObject.BTN_CALENDARIO_DONE));
    }

    public static SeleccionarFecha deCheckIn(String checkInDia, String checkInMes, String checkInYear) {
        return Tasks.instrumented(SeleccionarFecha.class, checkInDia, checkInMes, checkInYear, "CheckIn");
    }

    public static Performable deCheckOut(String checkOutDia, String checkOutMes, String checkOutYear) {
        return Tasks.instrumented(SeleccionarFecha.class, checkOutDia, checkOutMes, checkOutYear, "CheckOut");
    }
}
