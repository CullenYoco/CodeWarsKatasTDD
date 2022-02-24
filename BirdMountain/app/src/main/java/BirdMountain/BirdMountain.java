package BirdMountain;

public class BirdMountain {
    public int peakHeight(char[][] mountain) {
        return contains(mountain, '^') ? calculatePeakHeight(mountain): 0;
    }

    public int[][] calculateHeightArray(char[][] mountain) {
        int heightArray[][] = new int[mountain.length][mountain[0].length];
        initHeightArray(mountain, heightArray);
        
        int currentHeight = -1;
        while (contains(mountain, '^')) {
            currentHeight++;
            
            updateCellsOfCurrentHeight(mountain, heightArray, currentHeight);
        }

        return heightArray;
    }

    private int calculatePeakHeight(char[][] mountain) {
        int heightArray[][] = calculateHeightArray(mountain);

        return max(heightArray);
    }

    private int max(int[][] heightArray) {
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

    private void updateCellsOfCurrentHeight(char[][] mountain, int[][] heightArray, int currentHeight) {
        for (int i = 0; i < mountain.length; i++) {
            for (int j = 0; j < mountain[i].length; j++) {
                if (mountain[i][j] == '^') {
                    if (neighboursContainCurrentHeight(heightArray, currentHeight, i, j)) {
                        mountain[i][j] = '@'; // Arbitrary Replacement
                        heightArray[i][j] = currentHeight + 1;
                    }
                }
            }
        }
    }

    private void initHeightArray(char[][] mountain, int[][] heightArray) {
        for (int i = 0; i < heightArray.length; i++) {
            for (int j = 0; j < heightArray[i].length; j++) {
                heightArray[i][j] = mountain[i][j] == '^' ? -1 : 0;
            }
        }
    }

    private boolean neighboursContainCurrentHeight(int[][] heightArray, int currentHeight, int rowPos, int colPos) {
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

    private boolean isXNeighbourOnBoard(int[][] heightArray, int colPos, int i) {
        return colPos + i < heightArray[0].length && colPos + i > -1;
    }

    private boolean isYNeighbourOnBoard(int[][] heightArray, int rowPos, int i) {
        return rowPos + i < heightArray.length && rowPos + i > -1;
    }

    private boolean contains(char[][] mountain, char testChar) {
        for (char[] mountainRow: mountain) {
            for (char mountainCell: mountainRow) {
                if (mountainCell == testChar) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
