/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author SIMJA
 */
public class Model {
    private Double moneda;
    private Double cantidad;
    private Double resultado;
    private String exchangeRate;

    public Model() {
        mapCantides();
    }
    
    
    
    private Map<String, Double> mapCant = new HashMap<>();

    public void mapCantides() {
        mapCant.put("USD-MX", 17.84);
        mapCant.put("MX-EUR", 0.052);
        mapCant.put("EUR-USD", 1.07);
        
        mapCant.put("MX-USD", (1 / mapCant.get("USD-MX")));
        mapCant.put("EUR-MX", (1 / mapCant.get("MX-EUR")));
        mapCant.put("USD-EUR",(1 / mapCant.get("EUR-USD")));
    }

    public void setExchangeRate(String cb1, String cb2) {
        this.exchangeRate = cb1.concat("-".concat(cb2));
    }
    
    public void setMoneda() {
        this.moneda = mapCant.get(exchangeRate);
    }

    public void setMoneda(Double moneda) {
        this.moneda = moneda;
    }
    
    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getMoneda() {
        return moneda;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }
    
    
    public String getResultado() {
        DecimalFormat formato = new DecimalFormat("#.00");
        return formato.format(this.resultado);
    }
    public void convetirMoneda() {
        resultado = cantidad * moneda;
    }

}
