package BirdMountain;

public class BirdMountain {
    public static int peakHeight(char[][] mountain) {
        return calculatePeakHeight(mountain);
    }

    public static int[][] calculateHeightArray(char[][] mountain) {
        int heightArray[][] = initHeightArray(mountain);
        
        int currentHeight = -1;
        while (contains(heightArray, -1)) {
            currentHeight++;
            
            updateCellsOfCurrentHeight(heightArray, currentHeight);
        }

        return heightArray;
    }

    private static int calculatePeakHeight(char[][] mountain) {
        return max(calculateHeightArray(mountain));
    }

    private static int max(int[][] heightArray) {
        int maxValue = -1;

        for (int[] heightRow: heightArray) {
            for (int heightCell: heightRow) {
                if (heightCell > maxValue) {
                    maxValue = heightCell;
                }
            }
        }

        return maxValue;
    }

    private static void updateCellsOfCurrentHeight(int[][] heightArray, int currentHeight) {
        for (int i = 0; i < heightArray.length; i++) {
            for (int j = 0; j < heightArray[i].length; j++) {
                if (heightArray[i][j] == -1) {
                    if (neighboursContainCurrentHeight(heightArray, currentHeight, i, j)) {
                        heightArray[i][j] = currentHeight + 1;
                    }
                }
            }
        }
    }

    private static int[][] initHeightArray(char[][] mountain) {
        int heightArray[][] = new int[mountain.length][mountain[0].length];
        
        for (int i = 0; i < heightArray.length; i++) {
            for (int j = 0; j < heightArray[i].length; j++) {
                heightArray[i][j] = mountain[i][j] == '^' ? -1 : 0;
            }
        }

        return heightArray;
    }

    private static boolean neighboursContainCurrentHeight(int[][] heightArray, int currentHeight, int rowPos, int colPos) {
        for (int i = -1; i < 2; i +=2) {
            boolean hasPotentialYNeighbour = isYNeighbourOnBoard(heightArray, rowPos, i);
            boolean hasPotentialXNeighbour = isXNeighbourOnBoard(heightArray, colPos, i);

            if (hasPotentialYNeighbour) {
                if (heightArray[rowPos + i][colPos] == currentHeight) {
                    return true;
                }
            }

            if (hasPotentialXNeighbour) {
                if (heightArray[rowPos][colPos + i] == currentHeight) {
                    return true;
                }
            }

            if (!(hasPotentialYNeighbour && hasPotentialXNeighbour)) {
                if (currentHeight == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isXNeighbourOnBoard(int[][] heightArray, int colPos, int i) {
        return colPos + i < heightArray[0].length && colPos + i > -1;
    }

    private static boolean isYNeighbourOnBoard(int[][] heightArray, int rowPos, int i) {
        return rowPos + i < heightArray.length && rowPos + i > -1;
    }

    private static boolean contains(int[][] heightArray, int testValue) {
        for (int[] heightRow: heightArray) {
            for (int heightCell: heightRow) {
                if (heightCell == testValue) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
