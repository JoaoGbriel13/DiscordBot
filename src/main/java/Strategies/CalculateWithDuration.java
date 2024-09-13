package Strategies;

import DTO.FuelResultResponse;
import Handler.IllegalDataException;
import Model.Calculator.RaceData;
import Model.Calculator.TimedRaceData;

public class CalculateWithDuration implements FuelStrategy{
    @Override
    public FuelResultResponse calculateFuel(RaceData data) {
        if (data instanceof TimedRaceData timedRaceData){
            double totalLaps = timedRaceData.getRaceDuration() / timedRaceData.getLapTime();
            double totalFuel = totalLaps * timedRaceData.getConsumo();
            return new FuelResultResponse((totalFuel),(totalLaps));
        }
        throw new IllegalDataException("Tipo de dado invalido");
    }
}
