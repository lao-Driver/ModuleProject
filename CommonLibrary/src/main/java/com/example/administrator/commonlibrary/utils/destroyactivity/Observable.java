package com.example.administrator.commonlibrary.utils.destroyactivity;



public interface Observable {

    void addObserver(Observer obj);

    void deleteObserver(Observer obj);

    void notifyObserver(Object object);
}
