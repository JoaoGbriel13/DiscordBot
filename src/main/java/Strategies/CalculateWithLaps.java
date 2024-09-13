package Strategies;

import DTO.FuelResultResponse;
import Handler.IllegalDataException;
import Model.Calculator.LapData;
import Model.Calculator.RaceData;

public class CalculateWithLaps implements FuelStrategy{
    @Override
    public FuelResultResponse calculateFuel(RaceData data) {
        if (data instanceof LapData lapsData){
            double totalFuel = lapsData.getLaps() * lapsData.getConsumo();
            return new FuelResultResponse(totalFuel, lapsData.getLaps());
        }
        throw new IllegalDataException("Tipo de dado invalido");
    }
}
