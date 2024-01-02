import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class TheMountain {

    public int[][] getMapData() {
        return mapData;
    }

    public void setMapData(int[][] mapData) {
        this.mapData = mapData;
    }

    private int[][] mapData;
    private int lastRow;

    public String getName() {
        return name;
    }

    //private int cols;
    private String name;

    public int getMoves() {
        return moves;
    }

    private int moves;

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    private int numRows;
    private int numCols;

    public TheMountain(int rows, int cols, String name) throws IOException {
        mapData = new int[rows][cols];
        numRows = rows;
        numCols = cols;
        this.name = name;

        File file = new File(name);
        try{
            Scanner input = new Scanner(file);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    mapData[i][j] = input.nextInt();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public int[][] returnArray() {
        return mapData;
    }

    public int findMin(){
        int min = 0;

        for(int i = 0; i < mapData.length; i++) {
            for(int j = 0; j < mapData[0].length; j++) {
                if(mapData[i][j] < min) {
                    min = mapData[i][j];
                }
            }
        }

        return min;

    }

    public int findMax() {
        int max = 0;

        for(int i = 0; i < mapData.length; i++) {
            for(int j = 0; j < mapData[0].length; j++) {
                if(mapData[i][j] > max) {
                    max = mapData[i][j];
                }
            }
        }

        return max;
    }

    public int returnMin() {
        return findMin();
    }

    public int returnMax() {
        return findMax();
    }

    public int minRowIndex(int col) { //should this be column index or actual column number
        int min = 0;

        for(int r = 0; r < mapData.length - 1; r++) {

            if(mapData[r][col] < mapData[r+1][col]){
                min = r;
            }
        }
        return min;
    }
    int[] singlyPathway(int row) {

        int[] temp = new int[mapData[0].length];
        int num = mapData[row][0];
        temp[0] = num;
        int index = 1;

        int diff1 = 0;
        int diff2 = 0;
        int diff3 = 0;

        for(int c = 0; c < temp.length -1; c++) {

            if (row - 1 < 0) { //when pathway is at top of array
                diff1 = Math.abs(mapData[row][c + 1] - num);
                diff2 = Math.abs(mapData[row + 1][c + 1] - num);

                if (diff1 < diff2) {
                    temp[index] = mapData[row][c + 1];
                    num = mapData[row][c + 1];
                    index++;
                    lastRow = row;

                } else if (diff2 < diff1) {
                    temp[index] = mapData[row + 1][c + 1];
                    num = mapData[row + 1][c + 1];
                    index++;
                    row+=1;
                    lastRow = row;
                } else {
                    temp[index] = mapData[row][c+1];
                    num = mapData[row][c+1];
                    index++;
                    lastRow = row;
                }

            } else if (row + 1 >= mapData.length) { //when pathway is at bottom of array
                diff1 = Math.abs(mapData[row][c + 1] - num);
                diff2 = Math.abs(mapData[row - 1][c + 1] - num);

                if (diff1 < diff2) {
                    temp[index] = mapData[row][c + 1];
                    num = mapData[row][c + 1];
                    index++;
                    lastRow = row;
                } else if (diff2 < diff1) {
                    temp[index] = mapData[row - 1][c + 1];
                    num = mapData[row - 1][c + 1];
                    index++;
                    row-=1;
                    lastRow = row;
                } else {
                    temp[index] = mapData[row][c+1];
                    num = mapData[row][c+1];
                    index++;
                    lastRow = row;
                }
            } else {

                diff1 = Math.abs(mapData[row-1][c+1] - num);
                diff2 = Math.abs(mapData[row][c+1] - num);
                diff3 = Math.abs(mapData[row+1][c+1] - num);

                if( (diff1 < diff2) && (diff1 < diff3)) {
                    temp[index] = mapData[row-1][c+1];
                    num = mapData[row -1][c+1];
                    index++;
                    row-=1;
                    lastRow = row;
                }
                else if( (diff2 < diff3) && (diff2 < diff1)) {
                    temp[index] = mapData[row][c+1];
                    num = mapData[row][c+1];
                    index++;
                }
                else if( (diff3 < diff1) && (diff3 < diff2)) {
                    temp[index] = mapData[row+1][c+1];
                    num = mapData[row+1][c+1];
                    index++;
                    row+=1;
                    lastRow = row;
                }
                else if((diff1 == diff2) && (diff1 < diff3)) {

                    temp[index] = mapData[row][c+1];
                    num = mapData[row][c+1];
                    index++;
                    lastRow = row;

                }
                else if((diff1 == diff3) && (diff1 < diff2)) {
                    int random = (int) (2 * Math.random());

                    if (random == 0) {
                        temp[index] = mapData[row - 1][c + 1];
                        num = mapData[row - 1][c + 1];
                        index++;
                        row-=1;
                        lastRow = row;
                    } else {
                        temp[index] = mapData[row + 1][c + 1];
                        num = mapData[row + 1][c + 1];
                        index++;
                        row+=1;
                        lastRow = row;
                    }
                }

                else if( (diff2 == diff3) && (diff2 < diff1)) {

                    temp[index] = mapData[row][c+1];
                    num = mapData[row][c+1];
                    index++;
                    lastRow = row;

                }

                else if((diff1 == diff2) && (diff1== diff3) && (diff2 == diff3)) {//checks if all differences in numbers are equal

                    temp[index] = mapData[row][c+1];
                    num = mapData[row][c+1];
                    index++;
                    lastRow = row;
                }



            }

        }
        //lastRow = row;
        return temp;
        }





        public int getLastRow(){
        return lastRow;
        }

        public int lowestElevPathway(int row){

        int[] path = singlyPathway(row);

        int total = 0;
        int change;

        for (int i = 0; i < path.length -1; i++) {
            change = Math.abs(path[i] - path[i+1]);
            total +=change;
        }

        return total;
        }

        public int lowestElevPathwayIndex() {
            int minRow = 0;

            for (int i = 1; i < mapData.length; i++) {
                if (lowestElevPathway(minRow) > lowestElevPathway(i)) {
                    minRow = i;
                }
            }
            return minRow;
        }

        public int[] doublyPathway(int row, int movement) throws IOException {
       // System.out.println("this is the last row from singly one" + lastRow);
        moves = movement;
        int thisRow = row;

            TheMountain newObject = new TheMountain(getNumRows(),getNumCols(), getName());
            int[][] temper = newObject.getMapData();
            int[][] newArr = new int[temper.length][temper[0].length];
            for(int i = 0; i < newArr.length; i++) {
                for(int j = 0; j < newArr[0].length; j++) {
                    newArr[i][j] = temper[i][temper[0].length - j - 1];
                }
            }

            newObject.setMapData(newArr);

            int random = (int) (Math.random() * 2);

            if(random ==0) {
                row = row + movement;
                lastRow = thisRow;

            }
            else {
                row = row - movement;
                lastRow = thisRow;
            }
//            System.out.println("This is the last row: " + getLastRow());
//            System.out.println("This is the row that will start doubly: " + row);
            return newObject.singlyPathway(row);


        }

}
