/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.HashMap;

/**
 *
 * @author user
 */
public class StandardSensor implements Sensor {

    private HashMap<Boolean, Integer> on;

    public StandardSensor(int num) {
        this.on = new HashMap<>();
        this.on.put(true, num);
    }

    @Override
    public boolean isOn() {
        return true;
    }

    @Override
    public void setOn() {

    }

    @Override
    public void setOff() {

    }
    
    @Override 
    public int read() {
        return this.on.get(true);
    }

}
