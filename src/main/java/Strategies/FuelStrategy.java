package Strategies;

import DTO.FuelResultResponse;
import Model.Calculator.RaceData;

public interface FuelStrategy {
    FuelResultResponse calculateFuel(RaceData data);
}
