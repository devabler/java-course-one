package de.devabler.jco;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;

class Spaceship {
    TerminalSize terminalSize;
    int row;
    int col;
    String avatar;

    Spaceship(TerminalSize terminalSize, int row, String avatar) {
        this.row = row;
        this.col = terminalSize.getColumns() / 2 - avatar.length() / 2;
        this.avatar = avatar;
        this.terminalSize = terminalSize;
    }

    void draw(TextGraphics textGraphics) {
        textGraphics.putString(col, row, avatar);
    }

    void move(int direction) {
        col += direction;
        col = Math.min(terminalSize.getColumns() - avatar.length() + 1, Math.max(-1, col));
    }

	public void explode(TextGraphics textGraphics) {
        String explosion = "";
        for(int i = 0; i < avatar.length() - 2; i++) {
            explosion = explosion + "X";
        }
        textGraphics.putString(col + 1, row, explosion);
	}
}