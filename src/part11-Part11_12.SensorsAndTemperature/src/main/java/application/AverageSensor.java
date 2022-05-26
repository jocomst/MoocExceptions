/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class AverageSensor implements Sensor {

    private ArrayList<Sensor> list;
    private List<Integer> readings;

    public AverageSensor() {
        this.list = new ArrayList<>();
        this.readings = new ArrayList<>();
    }

    @Override
    public boolean isOn() {
        boolean b = true;
        for (Sensor s : this.list) {
            if (!s.isOn()) {
                b = false;
            }
        }
        return b;
    }

    @Override
    public void setOn() {
        for (Sensor s : this.list) {
            s.setOn();
        }

    }

    @Override
    public void setOff() {
        for (Sensor s : this.list) {
            s.setOff();
        }

    }

    @Override
    public int read() {
        if (!(this.isOn()) || this.list.size() == 0) {
            throw new IllegalStateException();
        }
        int sum = this.list.stream()
                .filter(m -> m.isOn())
                .mapToInt(m -> m.read())
                .reduce(0, Integer::sum);
        this.readings.add(sum / this.list.size());
        return sum / this.list.size();
    }

    public void addSensor(Sensor toAdd) {
        this.list.add(toAdd);
        if (toAdd.isOn()) {
            this.setOn();
        }
    }

    public List<Integer> readings() {
        return this.readings;
    }
}
