package socket;

import java.io.Serializable;
import java.util.Date;

public class SensorData implements Serializable {

    private final Date date;
    private final int temperature;
    private final int humidity;
    private final int pressure;

    public SensorData(Date date, int temperature, int humidity, int pressure, int light) {
        this.date = date;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    @Override
    public String toString() {
        return """
                SensorData {
                    date: %s,
                    temperature: %d,
                    humidity: %d,
                    pressure: %d
                }
                """.formatted(date, temperature, humidity, pressure);
    }
}
