package com.agoodkissapp.mvpdaggertesting;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

/**
 * Created by doktor on 7/22/2015.
 */
public class Movie {

    public transient Bitmap imgCover;
    public String title;
    public String link;
    public String cover;

    public Movie(){};


    public Movie(String cover, String title, String link){
        this.cover = cover;
        this.title = title;
        this.link = link;

        this.imgCover = convertBase64ToBitmap(cover);
    }

    public Bitmap convertBase64ToBitmap(String base64Image){
        byte[] decodedString = Base64.decode(base64Image, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        return decodedByte;
    }

    public void setCoverImg(){
        this.imgCover = convertBase64ToBitmap(this.cover);
    }

}
