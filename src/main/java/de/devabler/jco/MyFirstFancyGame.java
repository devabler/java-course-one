package de.devabler.jco;

import java.util.Random;

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

        
        Spaceship player = new Spaceship(terminalSize, terminalSize.getRows() - 1, " -/\\- ");

        int opponentDirection = 0;
        Spaceship opponent = new Spaceship(terminalSize, 0, " >-\\/-< ");

        Bullet playerBullet = null;

        while (true) {

            player.draw(textGraphics);
            opponent.draw(textGraphics);

            KeyStroke input = screen.pollInput();
            
            player.move(getPlayerMovement(input));
            
            opponentDirection = getOpponentDirection(opponentDirection);
            opponent.move(opponentDirection);


            if(input != null && input.getKeyType() == KeyType.ArrowUp && playerBullet == null) {
                playerBullet = new Bullet(player.col + 3, player.row - 1);
            }

            if(playerBullet != null) {
                playerBullet.drawBullet(textGraphics);
                if(playerBullet.row < -1) {
                    playerBullet = null;
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

    private int getOpponentDirection(int opponentDirection) {
        Random random = new Random();
        int nextInt = random.nextInt(100);
        if(nextInt < 10) {
            return 0;
        } else if(nextInt < 15) {
            return (int) Math.pow(-1.0, (double) random.nextInt(2));
        }
        return opponentDirection;
    }

    int getPlayerMovement(KeyStroke input) {
        if (input != null) {
            switch (input.getKeyType()) {
                case ArrowLeft:
                    return - 1;
                case ArrowRight:
                    return + 1;
                default:
                    break;
            }
        }
        return 0;
    }
}
