package Model.Calculator;

public class TimedRaceData extends RaceData {
    private double consumo;
    private double lapTime;
    private double raceDuration;

    public TimedRaceData(double consumo, double lapTime, double raceDuration) {
        this.consumo = consumo;
        this.lapTime = lapTime;
        this.raceDuration = raceDuration * 60;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public double getLapTime() {
        return lapTime;
    }

    public void setLapTime(double lapTime) {
        this.lapTime = lapTime;
    }

    public double getRaceDuration() {
        return raceDuration;
    }

    public void setRaceDuration(double raceDuration) {
        this.raceDuration = raceDuration;
    }
}
