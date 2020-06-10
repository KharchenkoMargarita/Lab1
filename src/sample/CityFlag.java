package sample;

import javafx.scene.image.Image;

public class CityFlag {

    private String nameCountry;
    private String nameCapital;
    private Image flag;

    public CityFlag(String nameCountry, String nameCapital, Image flag) {
        this.nameCountry = nameCountry;
        this.nameCapital = nameCapital;
        this.flag = flag;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public String getNameCapital() {
        return nameCapital;
    }

    public Image getFlag() {
        return flag;
    }
}