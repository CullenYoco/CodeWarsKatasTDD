package BirdMountain;

public class BirdMountain {
    public int peakHeight(char[][] mountain) {
        if (contains(mountain, '^')) {
            return calculatePeakHeight(mountain);
        }

        return 0;
    }

    private int calculatePeakHeight(char[][] mountain) {
        int heightArray[][] = new int[mountain.length][mountain[0].length];
        for (int i = 0; i < heightArray.length; i++) {
            for (int j = 0; j < heightArray[i].length; j++) {
                if (mountain[i][j] != '^') {
                    heightArray[i][j] = 0;
                } else {                
                    heightArray[i][j] = -1;
                }
            }
        }
        
        int currentHeight = -1;
        while (contains(mountain, '^')) {
            currentHeight++;
            
            
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


        return currentHeight + 1;
    }

    private boolean neighboursContainCurrentHeight(int[][] heightArray, int currentHeight, int rowPos, int colPos) {
        for (int i = -1; i < 2; i +=2) {
            if (rowPos + i < heightArray.length && rowPos + i > -1) {
                if (heightArray[rowPos + i][colPos] == currentHeight) {
                    return true;
                }
            } else {
                if (currentHeight == 0) {
                    return true;
                }
            }

            if (colPos + i < heightArray[0].length && colPos + i > -1) {
                if (heightArray[rowPos][colPos + i] == currentHeight) {
                    return true;
                }
            } else {
                if (currentHeight == 0) {
                    return true;
                }
            }
        }

        return false;
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
