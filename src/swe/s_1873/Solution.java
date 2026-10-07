package swe.s_1873;

import java.util.Scanner;

public class Solution {
    static Scanner sc = new Scanner(System.in);

    static final char LAND = '.';
    static final char WALL = '*';
    static final char IRON = '#';
    static final char UP = '^';
    static final char DOWN = 'v';
    static final char LEFT = '<';
    static final char RIGHT = '>';

    static final int[] U = new int[]{0, -1};
    static final int[] D = new int[]{0, 1};
    static final int[] L = new int[]{-1, 0};
    static final int[] R = new int[]{1, 0};

    static char[][] map;
    static int H, W;
    static char[] order;

    static int tankX, tankY;

    public static void main(String args[]) throws Exception {
        int T;
        T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            createMap();
            createOrder();
            play();

            System.out.print("#" + tc + " ");
            for (int i = 0; i < H; i++) {
                System.out.println(map[i]);
            }
        }
    }

    private static void play() {
        for (char o : order) {
            switch (o) {
                case 'U':
                case 'D':
                case 'L':
                case 'R': {
                    move(o);
                    break;
                }
                case 'S': {
                    shoot();
                    break;
                }
            }
        }
    }

    private static void shoot() {
        int[] direction = getDirection();

        int x = tankX;
        int y = tankY;
        while (true) {
            x += direction[0];
            y += direction[1];

            if (x < 0 || y < 0 || x >= W || y >= H) return;

            char target = map[y][x];

            if (target == IRON) return;

            if (target == WALL) {
                map[y][x] = LAND;
                return;
            }

        }
    }

    private static void move(char o) {
        int[] direction = new int[2];

        switch (o) {
            case 'U': {
                map[tankY][tankX] = UP;
                direction = U;
                break;
            }
            case 'D': {
                map[tankY][tankX] = DOWN;
                direction = D;
                break;
            }
            case 'L': {
                map[tankY][tankX] = LEFT;
                direction = L;
                break;
            }
            case 'R': {
                map[tankY][tankX] = RIGHT;
                direction = R;
                break;
            }
        }

        int x = tankX + direction[0];
        int y = tankY + direction[1];

        if (x < 0 || y < 0 || x >= W || y >= H) return;

        char next = map[y][x];

        if (next != LAND) return;

        map[y][x] = map[tankY][tankX];
        map[tankY][tankX] = LAND;
        tankX = x;
        tankY = y;
    }

    private static int[] getDirection() {
        char tank = map[tankY][tankX];

        int[] direction = new int[2];

        switch (tank) {          // tank가 Dir 타입
            case UP: {
                direction = U;
                break;
            }
            case DOWN: {
                direction = D;
                break;
            }
            case LEFT: {
                direction = L;
                break;
            }
            case RIGHT: {
                direction = R;
                break;
            }
        }

        return direction;
    }

    private static void createMap() {
        H = sc.nextInt();
        W = sc.nextInt();

        map = new char[H][W];

        for (int i = 0; i < H; i++) {
            char[] input = sc.next().toCharArray();

            for (int j = 0; j < W; j++) {
                char value = input[j];

                if (value == UP || value == DOWN || value == LEFT || value == RIGHT) {
                    tankX = j;
                    tankY = i;
                }
                map[i][j] = value;
            }
        }
    }

    private static void createOrder() {
        int n = sc.nextInt();

        order = new char[n];

        char[] input = sc.next().toCharArray();
        for (int i = 0; i < n; i++) {
            order[i] = input[i];
        }
    }
}
