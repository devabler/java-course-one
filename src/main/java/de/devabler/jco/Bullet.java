package de.devabler.jco;

import com.googlecode.lanterna.graphics.TextGraphics;

public class Bullet {
    int column;
    int row;
    int direction;

    Bullet(int column, int row, int direction) {
        this.column = column;
        this.row = row;
        this.direction = direction;
    }

    void drawBullet(TextGraphics textGraphics) {
        textGraphics.putString(column, row, "I");
        textGraphics.putString(column, row - direction, " ");
        row += direction;
    }

    public boolean hasHit(Spaceship opponent) {
        return row - direction == opponent.row && column > opponent.col && column < opponent.col + opponent.avatar.length() - 1;
    }
}