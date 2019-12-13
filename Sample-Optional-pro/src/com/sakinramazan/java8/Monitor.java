package com.sakinramazan.java8;

import java.util.Optional;

public class Monitor {

    private String inch;
    private Optional<Screen> screen;

    public Monitor(String inch, Optional<Screen> screen) {
        this.inch = inch;
        this.screen = screen;
    }

    public String getInch() {
        return inch;
    }

    public void setInch(String inch) {
        this.inch = inch;
    }

    public Optional<Screen> getScreen() {
        return screen;
    }

    public void setScreen(Optional<Screen> screen) {
        this.screen = screen;
    }
}
