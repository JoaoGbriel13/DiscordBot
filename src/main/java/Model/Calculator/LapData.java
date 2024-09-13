package Model.Calculator;

public class LapData extends RaceData {
    private double consumo;
    private double laps;

    public LapData(double consumo, double laps) {
        this.consumo = consumo;
        this.laps = laps;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public double getLaps() {
        return laps;
    }

    public void setLaps(double laps) {
        this.laps = laps;
    }
}
