package com.interfaces;

public class nicecar {
    private engine engine;
    private media player=new cdplayer();

    public nicecar(){
        engine=new powerengine();
    }

    public nicecar(engine engine){
        this.engine=engine;
    }

    public void start(){
        engine.start();
    }

    public void stop(){
        engine.stop();
    }

    public void startmusic(){
        engine.start();
    }

    public void stopmusic(){
        engine.stop();
    }

    public void upgradeengine(){
        this.engine=new electricengine();
    }
}
