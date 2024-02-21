package com.oguzhanotles.service;

import com.oguzhanotles.model.Home;

import java.util.List;

public interface HomeService{
    List<Home> getHouseList();
    List<Home> getVillaList();
    List<Home> getCottageList();

    int getAllHousePrices();

    int getAllVillaPrices();

    int getAllCottagePrices();

    int getAllPricesForAllType();

    double getAllHousesAverageSquareMeter();
    double getAllVillasAverageSquareMeter();
    double getAllCottagesAverageSquareMeter();
    double getAllAverageSquareMeterForAllType();

    List<Home> filterByRoomAndLounges(int numberOfRooms, int numberOfLounges);

}
