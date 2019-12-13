package com.sakinramazan.java8;

import java.util.Optional;

public class Service {

    public Integer getMobileScreenWidth(Optional<Phone> phone) {
        // we can write it just one line while controlling all
        // whether one of them is null or not !
        return phone.flatMap(Phone::getMonitor)
                .flatMap(Monitor::getScreen)
                .map(Screen::getWidth)
                .orElse(0);
    }

//    Equal Java7- code -> but we need to define another class for phone because of Optional
//    You can try it out yourself
//    public int getMobileScreenWidth(Phone phone){
//
//        if(phone != null){
//            Monitor monitor = phone.getMonitor();
//            if(monitor != null){
//                Screen screen = monitor.getScreen();
//                if(screen != null){
//                    return screen.getWidth();
//                }
//            }
//        }
//        return 0;
//    }

}
