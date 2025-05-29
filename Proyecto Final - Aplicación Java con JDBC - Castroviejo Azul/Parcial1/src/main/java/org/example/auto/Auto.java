package org.example.auto;


public class Auto {
    private int id;

    private String modelo;
    private String marca;
    private String color;
    private String patente;

    private int numeroSerie;
    private Double precio;

    public Auto() {
    }

    public Auto(String modelo, String marca, String color, String patente, int numeroSerie, Double precio) {
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.patente = patente;
        this.numeroSerie = numeroSerie;
        this.precio = precio;
    }

    public Auto(int id, String modelo, String marca, String color, String patente, int numeroSerie, Double precio) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.patente = patente;
        this.numeroSerie = numeroSerie;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(int numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {

        return  "ES un auto";
    }
}
