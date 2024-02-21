package com.oguzhanotles.service;

import com.oguzhanotles.model.Home;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class HomeServiceImpl implements HomeService{

    private final List<Home> homeList;

    public HomeServiceImpl(){
        homeList = new ArrayList<>();
        homeList.add(new Home("house",197850,135,3,1));
        homeList.add(new Home("house",325650,254,4,1));
        homeList.add(new Home("house",145750,112,1,0));

        homeList.add(new Home("villa",725500,375,6,2));
        homeList.add(new Home("villa",545000,287,5,1));
        homeList.add(new Home("villa",925750,500,8,3));

        homeList.add(new Home("cottage",295500,211,4,1));
        homeList.add(new Home("cottage",375850,248,4,2));
        homeList.add(new Home("cottage",115650,115,2,0));

    }

    @Override
    public List<Home> getHouseList() {
        List<Home> houseList = new ArrayList<>();

        for(Home home : homeList){
            if(Objects.equals(home.getType(), "house")){
                houseList.add(home);
            }
        }
    return houseList;
    }

    @Override
    public List<Home> getVillaList() {
        List<Home> villaList = new ArrayList<>();

        for(Home villa : homeList){
            if(Objects.equals(villa.getType(), "villa")){
                villaList.add(villa);
            }
        }
        return villaList;
    }

    @Override
    public List<Home> getCottageList() {
        List<Home> cottageList = new ArrayList<>();

        for(Home cottage : homeList){
            if(Objects.equals(cottage.getType(), "cottage")){
                cottageList.add(cottage);
            }
        }
        return cottageList;
    }

    @Override
    public int getAllHousePrices() {
        List<Home> houseList = getHouseList();
        return houseList.stream().mapToInt(Home::getPrice).sum();
    }

    @Override
    public int getAllVillaPrices() {
        List<Home> villaList = getVillaList();
        return villaList.stream().mapToInt(Home::getPrice).sum();
    }

    @Override
    public int getAllCottagePrices() {
        List<Home> cottageList = getCottageList();
        return cottageList.stream().mapToInt(Home::getPrice).sum();
    }

    @Override
    public int getAllPricesForAllType() {
        List<Home> allTypes = new ArrayList<>();
        allTypes.addAll(getHouseList());
        allTypes.addAll(getVillaList());
        allTypes.addAll(getCottageList());
        return allTypes.stream().mapToInt(Home::getPrice).sum();
    }

    @Override
    public double getAllHousesAverageSquareMeter() {
        List<Home> houseList = getHouseList();
        return houseList.stream().mapToDouble(Home::getSquareMeter).sum() / (long) houseList.size();
    }

    @Override
    public double getAllVillasAverageSquareMeter() {
        List<Home> villaList = getVillaList();
        return villaList.stream().mapToDouble(Home::getSquareMeter).sum() / (long) villaList.size();
    }

    @Override
    public double getAllCottagesAverageSquareMeter() {
        List<Home> cottageList = getCottageList();
        return cottageList.stream().mapToDouble(Home::getSquareMeter).sum() / (long) cottageList.size();
    }

    @Override
    public double getAllAverageSquareMeterForAllType() {
        List<Home> allTypes = new ArrayList<>();
        allTypes.addAll(getHouseList());
        allTypes.addAll(getVillaList());
        allTypes.addAll(getCottageList());
        return allTypes.stream().mapToDouble(Home::getSquareMeter).sum() / (long) allTypes.size();
    }

    @Override
    public List<Home> filterByRoomAndLounges(int numberOfRooms, int numberOfLounges) {
        List<Home> filteredHouses = new ArrayList<>();
        for(Home home : homeList){
            if(home.getNumberOfRooms() == numberOfRooms && home.getNumberOfLounges() == numberOfLounges){
                filteredHouses.add(home);
            }
        }
        return filteredHouses;
    }
}
