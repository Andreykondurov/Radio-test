package ru.netology.statistic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

    @Test
    public void testSetCurrentStationRegularFlow() {

        Radio radio = new Radio();
        radio.setCurrentStation(8);
        int actual = radio.getCurrentStation();
        int expected = 8;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testSetCurrentStationOverMax() {

        Radio radio = new Radio();
        radio.setCurrentStation(8);
        radio.setCurrentStation((14));
        int actual = radio.getCurrentStation();
        int expected = 8;

        Assertions.assertEquals(actual, expected);

    }

    @Test
    public void testCurrentStationLessMin() {
        Radio radio = new Radio();
        radio.setCurrentStation(8);
        radio.setCurrentStation(-14);
        int actual = radio.getCurrentStation();
        int expected = 8;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testNextOver() {
        Radio radio = new Radio();
        radio.setCurrentStation(8);
        radio.next();
        int actual = radio.getCurrentStation();
        int expected = 9;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testNextLess() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.next();
        int actual = radio.getCurrentStation();
        int expected = 0;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testPrevOver() {
        Radio radio = new Radio();
        radio.setCurrentStation(8);
        radio.prev();
        int actual = radio.getCurrentStation();
        int expected = 7;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testPrevLess() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.prev();
        int actual = radio.getCurrentStation();
        int expected = 9;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testIncreaseVolume() {
        Radio radio = new Radio();
        for (int i = 0; i < 3; i++) {
            radio.increaseVolume();
        }
        int actual = radio.getCurrentVolume();
        int expected = 3;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testIncreaseVolumeMax() {
        Radio radio = new Radio();
        for (int i = 0; i < 300; i++) {
            radio.increaseVolume();
        }
        int actual = radio.getCurrentVolume();
        int expected = 100;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testDecreaseVolume() {
        Radio radio = new Radio();
        for (int i = 0; i < 3; i++) {
            radio.decreaseVolume();
        }
        int actual = radio.getCurrentVolume();
        int expected = 0;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testDecreaseVolume2() {
        Radio radio = new Radio();
        for (int i = 0; i < 50; i++) {
            radio.increaseVolume();
        }
        for (int i = 0; i < 10; i++) {
            radio.decreaseVolume();
        }
        int actual = radio.getCurrentVolume();
        int expected = 40;

        Assertions.assertEquals(actual, expected);
    }

}