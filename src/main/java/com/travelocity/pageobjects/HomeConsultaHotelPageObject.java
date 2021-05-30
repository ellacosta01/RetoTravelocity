package com.travelocity.pageobjects;

import net.serenitybdd.screenplay.targets.Target;

public class HomeConsultaHotelPageObject {
    public static final Target BTN_GOING_TO = Target.the("Boton Going to").locatedBy("//button[@data-stid='location-field-destination-menu-trigger']");
    public static final Target TXT_DESTINO = Target.the("Campo Destino").locatedBy("//input[@id='location-field-destination']");
    public static final Target LBL_MES_YEAR_EN_CALENDARIO = Target.the("Etiqueta Mes y Año en Calendario").locatedBy("//h2[@class='uitk-date-picker-month-name uitk-type-medium']");
    public static final Target BTN_DIA_EN_CALENDARIO = Target.the("Dia en Calendario").locatedBy("//button[@aria-label='{0}']");
    public static final Target BTN_CHECK_IN = Target.the("Boton Check-In").locatedBy("//button[@id='d1-btn']");
    public static final Target BTN_CHECK_OUT = Target.the("Boton Check-Out").locatedBy("//button[@id='d2-btn']");
    public static final Target BTN_SIGUIENTE_MES = Target.the("Boton siguiente mes").locatedBy("//button[@data-stid='date-picker-paging'][2]");
    public static final Target BTN_CALENDARIO_DONE = Target.the("Boton aplicar seleccion en Calendario").locatedBy("//button[@data-stid='apply-date-picker']");
    public static final Target BTN_VIAJEROS = Target.the("Boton Viajeros de Hotel").locatedBy("//button[@data-testid='travelers-field-trigger']");
    public static final Target DIV_HABITACION = Target.the("Espacio de Habitacion").locatedBy("//div[contains(@data-testid,'room-{0}')]");
    public static final Target BTN_AGREGAR_HABITACION = Target.the("Boton Agregar Habitacion").locatedBy("//button[@data-testid='add-room-button']");
    public static final Target LBL_ADULTOS = Target.the("Etiqueta Adultos").locatedBy("//input[@id='adult-input-{0}']");
    public static final Target LBL_JOVENES = Target.the("Etiqueta Jovenes").locatedBy("//input[@id='child-input-{0}']");
    public static final Target BTN_AGREGAR_ADULTO = Target.the("Boton Agregar Adulto").locatedBy("//label[contains(@for,'adult-input-{0}')]/following-sibling::div/button[2]");
    public static final Target BTN_RETIRAR_ADULTO = Target.the("Boton Retirar Adulto").locatedBy("//label[contains(@for,'adult-input-{0}')]/following-sibling::div/button[1]");
    public static final Target BTN_AGREGAR_JOVEN = Target.the("Boton Agregar Joven").locatedBy("//label[contains(@for,'child-input-{0}')]/following-sibling::div/button[2]");
    public static final Target BTN_RETIRAR_JOVEN = Target.the("Boton Retirar Joven").locatedBy("//label[contains(@for,'child-input-{0}')]/following-sibling::div/button[1]");
    public static final Target BTN_VIAJEROS_DONE = Target.the("Boton Aceptar Viajeros").locatedBy("//button[@data-testid='guests-done-button']");
    public static final Target BTN_BUSCAR_HOTEL = Target.the("Boton Buscar Hotel").locatedBy("//button[@data-testid='submit-button']");
    public static final Target LBL_UBICACION_DE_HOTEL = Target.the("Etiqueta Ubicacion de Hotel").locatedBy("//div[@data-test-id='content-hotel-neighborhood']");
    public static final Target DIV_ERROR_FORMULARIO_VIAJERO = Target.the("Espacio de mensaje de error del formulario de viajeros").locatedBy("//div[contains(@aria-label,'Traveler')]/descendant::div[@data-testid='lob-error-summary']");
    public static final Target LBL_ERROR_FORMULARIO_GENERICO = Target.the("Mensaje en los espacios de error de los formularios").locatedBy("//div[@data-testid='lob-error-summary']/descendant::h3");
    public static final Target DIV_ERROR_FORMULARIO_BUSQUEDA_HOTEL = Target.the("Espacio de mensaje de error del formulario de busqueda de hotel").locatedBy("//form[contains(@id,'wizard-hotel-pwa-v2-1')]/descendant::div[@data-testid='lob-error-summary']");

}
