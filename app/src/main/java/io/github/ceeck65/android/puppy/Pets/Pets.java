package io.github.ceeck65.android.puppy.Pets;

/**
 * Created by mariofernandez on 5/8/16.
 */

public class Pets {

    private  String imgPetUrl;
    private  String namePet;
    private  String pointPet;
    private  Boolean favorite;

    public Pets(String imgPetUrl, String namePet, String pointPet, boolean favorite) {
        this.imgPetUrl = imgPetUrl;
        this.namePet = namePet;
        this.pointPet = pointPet;
        this.favorite = favorite;
    }

    public String getImgPetUrl() {
        return imgPetUrl;
    }

    public String getNamePet() {
        return namePet;
    }

    public String getPointPet() {
        return pointPet;
    }

    public boolean getFavorite() {
        return favorite;
    }
}
