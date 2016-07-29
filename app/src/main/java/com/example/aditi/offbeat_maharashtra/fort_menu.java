package com.example.aditi.offbeat_maharashtra;

import java.io.Serializable;

/**
 * Created by Aditi on 25-07-2016.
 */
public class fort_menu implements Serializable {
   String name,accomodation,map,location,how_to_reach,places_of_interest,pre_shivaji,post_shivaji,
    shivaji_era,height,forts_in_vicinity,base_village;


    public fort_menu()
    {

    }
    public String getName() {
        return name;
    }

    public String getAccomodation() {
        return accomodation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccomodation(String accomodation) {
        this.accomodation = accomodation;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setHow_to_reach(String how_to_reach) {
        this.how_to_reach = how_to_reach;
    }

    public void setPlaces_of_interest(String places_of_interest) {
        this.places_of_interest = places_of_interest;
    }

    public void setPre_shivaji(String pre_shivaji) {
        this.pre_shivaji = pre_shivaji;
    }

    public void setPost_shivaji(String post_shivaji) {
        this.post_shivaji = post_shivaji;
    }

    public void setShivaji_era(String shivaji_era) {
        this.shivaji_era = shivaji_era;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setForts_in_vicinity(String forts_in_vicinity) {
        this.forts_in_vicinity = forts_in_vicinity;
    }

    public void setBase_village(String base_village) {
        this.base_village = base_village;
    }

    public String getMap() {

        return map;
    }

    public String getLocation() {
        return location;
    }

    public String getHow_to_reach() {
        return how_to_reach;
    }

    public String getPlaces_of_interest() {
        return places_of_interest;
    }

    public String getPre_shivaji() {
        return pre_shivaji;
    }

    public String getPost_shivaji() {
        return post_shivaji;
    }

    public String getShivaji_era() {
        return shivaji_era;
    }

    public String getHeight() {
        return height;
    }

    public String getForts_in_vicinity() {
        return forts_in_vicinity;
    }

    public String getBase_village() {
        return base_village;
    }

    public fort_menu(String name, String accomodation, String map, String location,
                     String how_to_reach, String places_of_interest, String pre_shivaji,
                     String post_shivaji, String shivaji_era, String height,
                     String forts_in_vicinity, String base_village)
    {
        this.name = name;
        this.accomodation = accomodation;
        this.map = map;
        this.location = location;
        this.how_to_reach = how_to_reach;

        this.places_of_interest = places_of_interest;
        this.pre_shivaji = pre_shivaji;
        this.post_shivaji = post_shivaji;
        this.shivaji_era = shivaji_era;
        this.height = height;
        this.forts_in_vicinity = forts_in_vicinity;
        this.base_village = base_village;
    }
}
