package com.oguzhanotles;

import com.oguzhanotles.model.Home;
import com.oguzhanotles.service.HomeService;
import com.oguzhanotles.service.HomeServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class N11BootcampCohortsOdev1Application {

	public static void main(String[] args) {

		HomeServiceImpl homeService = new HomeServiceImpl();

		getHouses(homeService);
		getVillas(homeService);
		getCottages(homeService);
		getTotalPrices(homeService);
		getAverageSquareMeters(homeService);
		getFilteredHomes(homeService);
	}

	private static void getHouses(HomeServiceImpl homeService) {
		System.out.println("Home List => ");
		List<Home> homeList = homeService.getHouseList();
		homeList.forEach(home->System.out.println(home.toString()));
		System.out.println();
	}

	private static void getVillas(HomeServiceImpl homeService) {
		System.out.println("Villa List => ");
		List<Home> villaList = homeService.getVillaList();
		villaList.forEach(villa->System.out.println(villa.toString()));
		System.out.println();
	}

	private static void getCottages(HomeServiceImpl homeService) {
		System.out.println("Cottage List => ");
		List<Home> cottageList = homeService.getCottageList();
		cottageList.forEach(cottage->System.out.println(cottage.toString()));
		System.out.println();
	}

	private static void getTotalPrices(HomeServiceImpl homeService) {
		System.out.println("Total Price of Houses: " + homeService.getAllHousePrices());
		System.out.println("Total Price of Villas: " + homeService.getAllVillaPrices());
		System.out.println("Total Price of Cottages: " + homeService.getAllCottagePrices());
		System.out.println("Total Price of All Type: " + homeService.getAllPricesForAllType());
		System.out.println();
	}

	private static void getAverageSquareMeters(HomeServiceImpl homeService) {
		System.out.println("Average Square Meters of Houses: " +String.format("%.2f",homeService.getAllHousesAverageSquareMeter()) );
		System.out.println("Average Square Meters of Villas: " +String.format("%.2f",homeService.getAllVillasAverageSquareMeter()) );
		System.out.println("Average Square Meters of Cottages: " +String.format("%.2f",homeService.getAllCottagesAverageSquareMeter()) );
		System.out.println("Average Square Meters of All Types: " +String.format("%.2f",homeService.getAllAverageSquareMeterForAllType()));
		System.out.println();
	}

	private static void getFilteredHomes(HomeServiceImpl homeService) {
		System.out.println("Filtered Houses");
		List<Home> filteredHouses = homeService.filterByRoomAndLounges(4,1);
		filteredHouses.forEach(filter -> System.out.println(filter.toString()));
	}
}
