package de.devabler.jco;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

/**
 * Mein erstes krasses Spiel!
 */
public class MyFirstFancyGame {

    void runGame(Screen screen, TextGraphics textGraphics) throws Exception {
        textGraphics.putString(0,0, "Hallo Welt!");
        screen.refresh();
        Thread.sleep(2000);
    }
}
