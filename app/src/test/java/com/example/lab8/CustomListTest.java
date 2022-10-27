package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * adds city to list
     * checks if city added is in the list
     * check if another city that wasn't added is in the list
     */
    @Test
    public void hasCityTest() {
        list = MockCityList();
        City city = new City("Edmonton", "Alberta");
        list.addCity(city);
        City fakeCity = new City("Toronto", "Ontario");
        assertTrue(list.hasCity(city));
        assertFalse(list.hasCity(fakeCity));
    }

    /**
     * adds city to empty list
     * get list size
     * deletes city from list
     * check if our current size matches the previous list size minus one
     * deletes a city not in the list
     * check if exception thrown
     */
    @Test
    public void deleteCityTest() {
        list = MockCityList();
        City city = new City("Edmonton", "Alberta");
        list.addCity(city);
        int listSize = list.getCount();

        list.deleteCity(city);
        assertEquals(list.getCount(), listSize - 1);

        City fakeCity = new City("Toronto", "Ontario");
        assertThrows(IllegalArgumentException.class, () -> {list.deleteCity(fakeCity);});
    }


}
