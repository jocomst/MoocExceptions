/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;

/**
 *
 * @author user
 */
public class TemperatureSensor implements Sensor {

    private boolean isOn;

    public TemperatureSensor() {
        this.isOn = false;
    }
    
    @Override
    public boolean isOn() {
        return this.isOn;
    }
    
    @Override
    public void setOn() {
        this.isOn = true;
    }
    
    @Override
    public void setOff() {
        this.isOn = false;
    }

    @Override
    public int read() {
        if (!this.isOn) throw new IllegalStateException();
        return new Random().nextInt(61) - 30;
    }

}
