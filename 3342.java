class Quad {
    int row;
    int col;
    int time;
    int comingFrom;
    Quad(int row, int col, int time, int comingFrom) {
        this.row = row;
        this.col = col;
        this.time = time;
        this.comingFrom = comingFrom;
    }
}
class Solution {    
public int minTimeToReach(int[][] moveTime) {
    int m = moveTime.length;
    int n = moveTime[0].length;
    boolean[][] visited = new boolean[m][n];
    PriorityQueue<Quad> pq = new PriorityQueue<>((a,b)->Integer.compare(a.time, b.time));
    pq.offer(new Quad(0, 0, 0, 2));
    int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    visited[0][0] = true;
    while(!pq.isEmpty()) {
        int row = pq.peek().row;
        int col = pq.peek().col;
        int time = pq.peek().time;
        int comingFrom = pq.peek().comingFrom;
        pq.poll();            
        if(row == m - 1 && col == n - 1) return time;
        for (int[] d : dir) {
            int aR = d[0] + row;
            int aC = d[1] + col;
            if (aR >= 0 && aR < m && aC >= 0 && aC < n && !visited[aR][aC]) {
                visited[aR][aC] = true;
                int s = 3 - comingFrom;
                int t = Math.max(time, moveTime[aR][aC]) + s;
                pq.offer(new Quad(aR, aC, t, s));
            }
        }
    }
    return -1;
}
}