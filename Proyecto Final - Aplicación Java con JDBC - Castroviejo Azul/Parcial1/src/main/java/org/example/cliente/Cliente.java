package org.example.cliente;

import org.example.auto.Auto;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int id;
    private String nombre;
    private int auto_id;

    public Cliente() {
    }

    public Cliente(String nombre, int auto_id) {
        this.nombre = nombre;
        this.auto_id = auto_id;
    }

    public Cliente(int id, String nombre, int auto_id) {
        this.id = id;
        this.nombre = nombre;
        this.auto_id = auto_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAuto_id() {
        return auto_id;
    }

    public void setAuto_id(int auto_id) {
        this.auto_id = auto_id;
    }

    @Override
    public String toString() {
        return "Es un cliente";
    }
}
