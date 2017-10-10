package canvas;

import java.util.Scanner;

class Canvas {
    char[][] canvasArray;
    int w, h;


    public Canvas(int w, int h) {
        h+=2;
        w+=2;
        this.w = w;
        this.h = h;
        canvasArray = new char[h][w];
        drawLine(0, 0, this.w-1, 0, '-');
        drawLine(0, this.h-1, this.w-1, this.h-1, '-');
        drawLine(0, 1, 0, this.h-2, '|');
        drawLine(this.w-1, 1, this.w-1, this.h-2, '|');
    }

    public void render() {
        for(int i=0;i<this.h;i++) {
            for(int j=0;j<this.w;j++) {
                System.out.print(canvasArray[i][j]);
            }
            System.out.println();
        }
    }

    public void drawLine(int x1, int y1, int x2, int y2, char mchar) {
        for(int i=y1; i<=y2; i++) {
            for(int j=x1; j<=x2; j++) {
                canvasArray[i][j] = mchar;
            }
        }
    }

    public void drawRectangle(int x1, int y1, int x2, int y2, char mchar) {
        drawLine(x1,y1, x2, y1, mchar);
        drawLine(x1,y1, x1, y2, mchar);
        drawLine(x2,y1, x2, y2, mchar);
        drawLine(x1,y2, x2, y2, mchar);
    }

    public void bucketFill(int x, int y, char mchar) throws InterruptedException {
        if((int)canvasArray[y][x] != 0) {
            return;
        }

        if(x > 0 || x < this.h || y > 0 || y  < this.w) {
            if((int)canvasArray[y][x] == 0)
                canvasArray[y][x] = mchar;
            bucketFill(x+1,y, mchar);
            bucketFill(x-1,y, mchar);
            bucketFill(x,y-1, mchar);
            bucketFill(x,y+1, mchar);
        }
    }
}

