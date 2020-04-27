package de.devabler.jco;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            Screen screen = new DefaultTerminalFactory().createScreen();
            screen.setCursorPosition(null);
            screen.startScreen();
            TextGraphics textGraphics = screen.newTextGraphics();
            try {
                new MyFirstFancyGame().runGame(screen, textGraphics);
            } finally {
                screen.stopScreen();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}