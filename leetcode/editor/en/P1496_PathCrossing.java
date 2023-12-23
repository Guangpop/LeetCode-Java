//Java：Path Crossing

//Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing 
//moving one unit north, south, east, or west, respectively. You start at the 
//origin (0, 0) on a 2D plane and walk on the path specified by path. 
//
// Return true if the path crosses itself at any point, that is, if at any time 
//you are on a location you have previously visited. Return false otherwise. 
//
// 
// Example 1: 
// 
// 
//Input: path = "NES"
//Output: false 
//Explanation: Notice that the path doesn't cross any point more than once.
// 
//
// Example 2: 
// 
// 
//Input: path = "NESWW"
//Output: true
//Explanation: Notice that the path visits the origin twice. 
//
// 
// Constraints: 
//
// 
// 1 <= path.length <= 10⁴ 
// path[i] is either 'N', 'S', 'E', or 'W'. 
// 
//
// Related Topics Hash Table String 👍 1234 👎 35


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class P1496_PathCrossing{
    public static void main(String[] args) {
        Solution solution = new P1496_PathCrossing().new Solution();
        // TO TEST
        solution.isPathCrossing("NESWW");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    static class Path {
        int x;
        int y;

        Path(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Path step(Path p) {
            this.x += p.x;
            this.y += p.y;

            return new Path(this.x, this.y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Path path = (Path) o;
            if(x == 0 && y == 0) return true; //start at (0, 0)
            return x == path.x && y == path.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    enum Dir {
        N(0, 1),
        S(0, -1),
        W(-1, 0),
        E(1, 0);

        Path p;
        Dir(int x, int y) {
            this.p = new Path(x, y);
        }

        Path getPath() {return p;}
    }

    public boolean isPathCrossing(String path) {

        List<Path> record = new ArrayList<>();
        Path currentPoint = new Path(0, 0);
        for(int i = 0 ; i < path.length() ; ++i) {
            Dir d = Dir.valueOf(String.valueOf(path.charAt(i)));
            Path next = currentPoint.step(d.getPath());
            if (!record.contains(next)) {
                record.add(next);
            } else {
                return true;
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}