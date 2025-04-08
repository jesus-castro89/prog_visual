package com.example.sensor;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

public class SensorData implements Serializable {

    private final double temperature;
    private final double humidity;
    private final double atmosphericPressure;
    private final double windSpeed;
    private final Date timestamp;

    public SensorData() {

        this.timestamp = new Date();
        this.temperature = getRandomTemperature();
        this.humidity = getRandomHumidity();
        this.atmosphericPressure = getRandomAtmosphericPressure();
        this.windSpeed = getRandomWindSpeed();
    }

    private double getRandomTemperature() {
        return 15 + (35 - 15) * Math.random();
    }

    private double getRandomHumidity() {
        return 30 + (90 - 30) * Math.random();
    }

    private double getRandomAtmosphericPressure() {
        return 950 + (1050 - 950) * Math.random();
    }

    private double getRandomWindSpeed() {
        return 0 + (20) * Math.random();
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getAtmosphericPressure() {
        return atmosphericPressure;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return """
                Temperatura: %.2f °C
                Porcentaje de Humedad: %.2f %%
                Presión Atmosférica: %.2f hPa
                Velocidad del Viento: %.2f m/s
                Timestamp: %s
                """.formatted(temperature, humidity,
                atmosphericPressure, windSpeed, timestamp);
    }

    public static void main(String[] args) {
        // Generar datos de sensor aleatorios
        SensorData sensorData = new SensorData();
        System.out.println(sensorData);
    }
}
