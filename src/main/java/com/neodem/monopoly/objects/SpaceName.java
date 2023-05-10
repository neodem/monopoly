package com.neodem.monopoly.objects;

/**
 * Created by : Vincent Fumo (vincent_fumo@cable.comcast.com)
 * Created on : 5/10/23
 */
public enum SpaceName {
    Go("go"),
    Mediterranean("Mediterranean"),
    CommunityChest1("Community Chest 1"),
    Baltic("Baltic"),
    IncomeTax("Income Tax"),
    ReadingRR("Reading RR"),
    Oriental("Oriental"),
    Chance1("Chance 1"),
    Vermont("Vermont"),
    Connecticut("Connecticut"),
    Jail("Jail"),
    StCharles("St. Charles"),
    ElectricCompany("Electric Company"),
    States("States"),
    Virginia("Virginia"),
    PennsylvaniaRR("Pennsylvania RR"),
    StJames("St. James"),
    CommunityChest2("Community Chest 2"),
    Tennessee("Tennessee"),
    NewYork("New York"),
    FreeParking("Free Parking"),
    Kentucky("Kentucky"),
    Chance2("Chance 2"),
    Indiana("Indiana"),
    Illinois("Illinois"),
    BORR("BO RR"),
    Atlantic("Atlantic"),
    Ventnor("Ventnor"),
    WaterWorks("Water Works"),
    MarvinGardens("Marvin Gardens"),
    GotoJail("Go to Jail"),
    Pacific("Pacific"),
    NCarolina("N. Carolina"),
    CommunityChest3("Community Chest 3"),
    Pennsylvania("Pennsylvania"),
    ShortLineRR("Short Line RR"),
    Chance3("Chance 3"),
    ParkPlace("Park Place"),
    LuxuryTax("Luxury Tax"),
    Boardwalk("Boardwalk");

    private final String userName;

    SpaceName(String userName) {
        this.userName = userName;
    }

    public static SpaceName of(String userName) {
        for (SpaceName s : SpaceName.values()) {
            if (s.userName.equalsIgnoreCase(userName)) return s;
        }
        throw new IllegalArgumentException("Could not find SpaceName from: '" + userName + "'");
    }
}
