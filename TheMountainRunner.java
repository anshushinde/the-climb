import java.io.IOException;
public class TheMountainRunner {
    public static void main(String[] args) throws IOException {
        TheMountain x = new TheMountain(480,844,"elevation_values.dat");

        int[] testTwo = x.singlyPathway(1);
        System.out.println("This is singly pathway");
        for(int i = 0; i < testTwo.length; i++) {
            System.out.print(testTwo[i] + " ");
        }

        System.out.println();
        System.out.println("This is doubly pathway:");
        int[] test = x.doublyPathway(2,1);
        for(int i = 0; i < test.length; i++) {
            System.out.print(test[i] + " ");
        }

        System.out.println();
        System.out.println("This is the row that has the minimum value of in column two: " + x.minRowIndex(2));
        System.out.println("This is the minimum value of the whole file: " + x.findMin());
        System.out.println("This is the maximum value of the whole file: " + x.findMax());
        System.out.println("This is the total elevation change in row 2: " + x.lowestElevPathway(2));
        System.out.println("This is the index with the row that has the least elevation change: " + x.lowestElevPathwayIndex());
        System.out.println(x.getMapData()[479][843]);



    }
}
