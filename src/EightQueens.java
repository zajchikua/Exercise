import java.io.*;
import java.util.*;
    /* https://3.bp.blogspot.com/-mwy6pHZ_x3k/XGPk1G94pSI/AAAAAAAAI7M/Uu47kwElvyEY9035hrq_Vp_4q4nhPyyAgCLcBGAs/s1600/8queens.PNG
    How can you place N queens on an NxN chessboard so that they cannot"attack"
    each other? (Queens can move horizontally, verticallly
    and diagonally.)
    The Eight Queens problem is a classic problem in chess and
    computerscience. Rather than develop a solution,
    we would like to test a solution.
    So given a list of coordinates, we want to check if
    itis a valid solution to the N-queens problem.
    [ x coordinate ; y coordinate (0,4), (1,2), (2,0), (3,6), ...] */

/*public class EightQueens {

    class Pair { int x; int y;
        public Pair(int a, int b) { x = a; y = b; }
        public int x() { return x; }
        public int y() { return y; }
    }
    //class Solution { public static void main()
   public static boolean solution(List<Pair> coordinates)
    {
        for (int i = 0; coordinates.size() -1; i++){ for(int j = 1; coordinates.size() -2; j++){
        } // Pair p1 = coordinates.get(0); // Pair p2 = coordinates.get(1);
            if(coordinates[i].x == coordinates[j].x){ return false; } else if(p1.y == p2.y){ return false; }
            //diagonal for a5 -> c7 || c3 //slope of general
            int diagonal = 0; int p1Diagonal = 0; if((p1.x - p2.x) == (p1.y - p2.y) || (p1.x - p2.x) == -(p1.y - p2.y) || -(p1.x - p2.x) == (p1.y - p2.y)) { return false; } }//if they share x coord //if
        ArrayList<String> strings = new ArrayList<String>(); strings.add("Hello, World!"); strings.add("Welcome to CoderPad."); strings.add("This pad is running Java " + Runtime.version().feature());
        for (String string : strings) { System.out.println(string);
        }
        return true;
    }
}
*/