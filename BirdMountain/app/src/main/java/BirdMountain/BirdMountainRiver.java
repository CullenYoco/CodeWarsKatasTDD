package BirdMountain;

public class BirdMountainRiver {
    public static int[] dryGround(char[][] terrain) {
        int heightArray[][] = BirdMountain.calculateHeightArray(terrain);

        double currentWaterHeight = -0.5;
        int dryValues[] = new int[4];
        for (int day = 0; day < 4; day++) {
            dryValues[day] = calculateDrySpots(terrain, heightArray, currentWaterHeight);

            if (containsWater(terrain)) {
                currentWaterHeight++;
            }
        }

        return dryValues;
    }

    private static boolean containsWater(char[][] terrain) {
        for (char[] terrainRow: terrain) {
            for (char terrainCell: terrainRow) {
                if (terrainCell == '-') {
                    return true;
                }
            }
        }
        
        return false;
    }

    private static int calculateDrySpots(char[][] terrain, int[][] heightArray, double currentWaterHeight) {
        int count = 0;
        for (int i = 0; i < terrain.length; i++) {
            for (int j = 0; j < terrain[i].length; j++) {
                if (terrain[i][j] != '-' && heightArray[i][j] > currentWaterHeight) {
                    count++;
                } else {
                    terrain[i][j] = '-';
                }
            }
        }

        return count;
    }
}
