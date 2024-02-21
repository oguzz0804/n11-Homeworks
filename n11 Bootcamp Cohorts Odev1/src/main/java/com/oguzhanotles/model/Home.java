package com.oguzhanotles.model;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Home {

    private String type;

    private int price;

    private int  squareMeter;

    private int numberOfRooms;

    private int numberOfLounges;

    public Home(String type, int price, int squareMeter, int numberOfRooms, int numberOfLounges) {
        this.type = type;
        this.price = price;
        this.squareMeter = squareMeter;
        this.numberOfRooms = numberOfRooms;
        this.numberOfLounges = numberOfLounges;
    }

    public String toString() {
        return "type='" + type + '\'' +
                ", price=" + price +
                ", squareMeter=" + squareMeter +
                ", numberOfRooms=" + numberOfRooms +
                ", numberOfLounges=" + numberOfLounges;
    }
}
