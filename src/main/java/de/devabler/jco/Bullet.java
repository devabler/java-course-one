package de.devabler.jco;

import com.googlecode.lanterna.graphics.TextGraphics;

public class Bullet {
    int column;
    int row;

    Bullet(int column, int row) {
        this.column = column;
        this.row = row;
    }

    void drawBullet(TextGraphics textGraphics) {
        textGraphics.putString(column, row, "I");
        textGraphics.putString(column, row + 1, " ");
        row -= 1;
    }

    public boolean hasHit(Spaceship opponent) {
        return row + 1 == opponent.row && column > opponent.col && column < opponent.col + opponent.avatar.length() - 1;
    }
}