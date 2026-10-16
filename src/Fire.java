import java.util.*;

public class Fire {
    /**
     * Returns how long it takes for all vulnerable trees to be set on fire if a
     * match is lit at a given location.
     * 
     * The forest is represented via a rectangular 2d char array where t represents a tree
     * and . represents an empty space.
     * 
     * At time 0, the tree at location [matchR, matchC] is set on fire. At every subsequent
     * time step, any tree that is adjacent (up/down/left/right) to a burning tree is also
     * set on fire. 
     * 
     * 
     * EXAMPLE 
     * forest:
     * 
     * t..tttt.t
     * ..tt....t
     * ..ttttttt
     * tttt.....
     * 
     * matchR: 2
     * matchC: 6
     * 
     * Result: 8
     * 
     * Explanation:
     * At time 0, the tree at (2, 6) is set on fire. At time 1, its adjacent trees also catch on fire
     * At time 2, the trees adjacent to those catch as well. At time 8, the last tree to catch is at
     * (0,6). In this example, there is one tree that never burns, so it is not included in the time calculation.
     * 
     * 
     * @param forest a 2d array where t represents a tree and . represents the ground
     * @param matchR The row the match is lit at
     * @param matchC The column the match is lit at
     * @return the time at which the final tree to be incinerated starts burning
     */
    public static int timeToBurn(char[][] forest, int matchR, int matchC) {

        if(forest[matchR][matchC] == '.'){
            return 0;
        }
        // HINT: when adding to your BFS queue, you can include more information than
        // just a location. What other information might be useful?
        
        Queue<Point> queue = new LinkedList<>();
        HashSet<Point> visited = new HashSet<>();
        int[][] dirs  = new int[][]{
            {-1,0}, //up
            {1,0}, //down
            {0,-1}, //left
            {0,1}, //right
        };

        Point start = new Point(matchR, matchC);

        queue.add(start);
        visited.add(start);

        int depth=0;

        while(!queue.isEmpty()){

            int level = queue.size(); // cool algorithim since it is BFS ques every neighbor added represents all nodes at that depth and this lets the following loop know how many points to process before incrementing the "Depth" for the next level.

            for(int i = 0; i< level; i++){

                Point cur = queue.remove();


                for(int[] d : dirs){
                    if( cur.row() + d[0] >= 0 &&
                        cur.row() + d[0] < forest.length &&
                        cur.col() + d[1] >= 0 &&
                        cur.col() + d[1] < forest[0].length )
                    {

                        Point curN = new Point(cur.row() + d[0], cur.col() + d[1]);
    
                        if(forest[curN.row()][curN.col()] == '.'){
                            continue;
                        }
                        if(visited.add(curN)){
                            queue.add(curN);
                        }
                    }
                }
            }
            depth +=1; // increment depth now that the previous level has been processed and the current que represents the next level
        }

        return depth - 1;
    }

    public static void main(String[] args){

        char[][] forest = {
            {'t','.','.','t','t','t','t','.','t'},
            {'.','.','t','t','.','.','.','.','t'},
            {'.','.','t','t','t','t','t','t','t'},
            {'t','t','t','t','.','.','.','.','.'}
        };

        int matchR = 2;
        int matchC = 6;

        System.out.println(timeToBurn(forest,matchR,matchC));
    }
    
    public record Point(int row, int col){};
}
