package com.upsjb.services;

import com.upsjb.entity.TemperaturaE;
import com.upsjb.repository.TemperaturaR;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TemperaturaS {
    
    public boolean validar(TemperaturaE entity){
        boolean status = true;   
        if(entity.getCodigoSensor().equals("")){
            status = false;
        }else if(entity.getUbicacionSensor().equals("")){
            status = false;
        }else if(entity.getValorTemperatura() == 0){
            status = false;
        }
        return status;
    }
    
    public void insertar(TemperaturaE entidad) {
        try {
            TemperaturaR repository;
            try {
                repository = new TemperaturaR();
                if(validar(entidad)){
                    repository.insert(entidad);
                }
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }

        } catch (SQLException ex) {
            Logger.getLogger(TemperaturaS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<TemperaturaE> listar(String fecha) throws ClassNotFoundException, SQLException{
        TemperaturaR repository = new TemperaturaR();
        return repository.list(fecha);    
    }          
}
