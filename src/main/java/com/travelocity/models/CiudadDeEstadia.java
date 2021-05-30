package com.travelocity.models;

public class CiudadDeEstadia {
    String destino;
    String checkInDia;
    String checkInMes;
    String checkInYear;
    String checkOutDia;
    String checkOutMes;
    String checkOutYear;

    public CiudadDeEstadia(
            String destino,
            String checkInDia,
            String checkInMes,
            String checkInYear,
            String checkOutDia,
            String checkOutMes,
            String checkOutYear) {
        this.destino = destino;
        this.checkInDia = checkInDia;
        this.checkInMes = checkInMes;
        this.checkInYear = checkInYear;
        this.checkOutDia = checkOutDia;
        this.checkOutMes = checkOutMes;
        this.checkOutYear = checkOutYear;
    }

    public String getDestino() {
        return destino;
    }

    public String getCheckInDia() {
        return checkInDia;
    }

    public String getCheckInMes() {
        return checkInMes;
    }

    public String getCheckInYear() {
        return checkInYear;
    }

    public String getCheckOutDia() {
        return checkOutDia;
    }

    public String getCheckOutMes() {
        return checkOutMes;
    }

    public String getCheckOutYear() {
        return checkOutYear;
    }
}
