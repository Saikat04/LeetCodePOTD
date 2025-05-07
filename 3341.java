class Triplate {
    int row;
    int col;
    int time;
    Triplate(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class Solution {    
public int minTimeToReach(int[][] moveTime) {
    int m = moveTime.length;
    int n = moveTime[0].length;
    boolean[][] visited = new boolean[m][n];
    PriorityQueue<Triplate> pq = new PriorityQueue<>((a,b)->Integer.compare(a.time, b.time));
    pq.offer(new Triplate(0, 0, 0));
    int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    visited[0][0] = true;
    while(!pq.isEmpty()) {
        int row = pq.peek().row;
        int col = pq.peek().col;
        int time = pq.peek().time;
        pq.poll();            
        if(row == m - 1 && col == n - 1) return time;
        for (int[] d : dir) {
            int aR = d[0] + row;
            int aC = d[1] + col;
            if (aR >= 0 && aR < m && aC >= 0 && aC < n && !visited[aR][aC]) {
                visited[aR][aC] = true;
                int t = Math.max(time, moveTime[aR][aC]) + 1;
                pq.offer(new Triplate(aR, aC, t));
            }
        }
    }
    return -1;
}
}