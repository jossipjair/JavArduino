package com.upsjb.entity;

public class TemperaturaE {
    
    private Integer idTemperatura;
    private String codigoSensor;
    private String ubicacionSensor;
    private String fecha;
    private String fechaHora;
    private String hora;
    private Double valorTemperatura;

    public TemperaturaE() {
    }

    public TemperaturaE(Integer idTemperatura, String codigoSensor, String ubicacionSensor, String fecha, String fechaHora, String hora, Double valorTemperatura) {
        this.idTemperatura = idTemperatura;
        this.codigoSensor = codigoSensor;
        this.ubicacionSensor = ubicacionSensor;
        this.fecha = fecha;
        this.fechaHora = fechaHora;
        this.hora = hora;
        this.valorTemperatura = valorTemperatura;
    }

    public Integer getIdTemperatura() {
        return idTemperatura;
    }

    public void setIdTemperatura(Integer idTemperatura) {
        this.idTemperatura = idTemperatura;
    }

    public String getCodigoSensor() {
        return codigoSensor;
    }

    public void setCodigoSensor(String codigoSensor) {
        this.codigoSensor = codigoSensor;
    }

    public String getUbicacionSensor() {
        return ubicacionSensor;
    }

    public void setUbicacionSensor(String ubicacionSensor) {
        this.ubicacionSensor = ubicacionSensor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Double getValorTemperatura() {
        return valorTemperatura;
    }

    public void setValorTemperatura(Double valorTemperatura) {
        this.valorTemperatura = valorTemperatura;
    }

    
}
