package com.melayer.recyclerview;

/**
 * Created by root on 9/2/15.
 */
public class MeRecyclerItem {

    private String nameImage;
    private Integer idImage;

    public MeRecyclerItem(String nameImage, Integer idImage){

        this.nameImage = nameImage;
        this.idImage = idImage;
    }

    @Override
    public String toString() {
        return "MeRecyclerItem{" +
                "nameImage='" + nameImage + '\'' +
                ", idImage=" + idImage +
                '}';
    }

    public String getNameImage() {
        return nameImage;
    }

    public void setNameImage(String nameImage) {
        this.nameImage = nameImage;
    }

    public Integer getIdImage() {
        return idImage;
    }

    public void setIdImage(Integer idImage) {
        this.idImage = idImage;
    }
}
