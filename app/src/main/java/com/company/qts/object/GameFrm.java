package com.company.qts.object;

/**
 * Created by MyPC on 17/08/2017.
 */
public class GameFrm {
    int img_game;
    String namegame;

    public GameFrm() {
    }

    public GameFrm(int img_game, String namegame) {
        this.img_game = img_game;
        this.namegame = namegame;
    }

    public int getImg_game() {
        return img_game;
    }

    public void setImg_game(int img_game) {
        this.img_game = img_game;
    }

    public String getNamegame() {
        return namegame;
    }

    public void setNamegame(String namegame) {
        this.namegame = namegame;
    }
}
