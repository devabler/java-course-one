package de.devabler.jco;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

/**
 * Mein erstes krasses Spiel!
 */
public class MyFirstFancyGame {

    void runGame(Screen screen, TextGraphics textGraphics) throws Exception {
        TerminalSize terminalSize = screen.getTerminalSize();

        int playerCol = terminalSize.getColumns() / 2 - 3;
        int playerRow = terminalSize.getRows() - 1;

        while (true) {

            textGraphics.putString(playerCol, playerRow, " -/\\- ");

            KeyStroke input = screen.pollInput();
            if (input != null) {
                switch (input.getKeyType()) {
                    case ArrowLeft:
                        playerCol = playerCol - 1;
                        break;
                    case ArrowRight:
                        playerCol = playerCol + 1;
                        break;
                    default:
                        break;
                }
            }
            if(input != null && input.getKeyType() == KeyType.Escape) {
                break;
            }

            while(screen.pollInput() != null);
            screen.refresh();
            Thread.sleep(1000 / 10);
        }
    }
}
