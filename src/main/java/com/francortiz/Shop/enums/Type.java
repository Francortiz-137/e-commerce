package com.francortiz.Shop.enums;

public enum Type {
    ELECTRONICOS("Electrónicos"),HOGAR("Hogar"),ZAPATERIA("Zapatería"),
    ROPA_HOMBRE("Ropa Hombre"),ROPA_MUJER("Ropa Mujer"),
    ROPA_NINO("Ropa niño"),DEPORTES("Deportes"),JUGETERIA("Jugeteria");

    private String name;
    private Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
