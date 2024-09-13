package Strategies;

import DTO.FuelResultResponse;
import Model.Calculator.LapData;
import Model.Calculator.RaceData;
import Model.Calculator.TimedRaceData;

public class RaceBot {
    private FuelStrategy fuelStrategy;

    public RaceBot() {
    }

    public void setFuelStrategy(RaceData raceData) {
        if (raceData instanceof LapData lapData){
            this.fuelStrategy = new CalculateWithLaps();
        } else if (raceData instanceof TimedRaceData timedRace) {
            this.fuelStrategy = new CalculateWithDuration();
        }
    }

    public String calculateAndReport(RaceData data){
        setFuelStrategy(data);
        FuelResultResponse fuelResultResponse = fuelStrategy.calculateFuel(data);
        return "Combustivel necessário: " + fuelResultResponse.getFuel() + "\n" +
                "Total de voltas na corrida: " + fuelResultResponse.getLaps();
    }
}
