import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {
    public int swimInWater(int[][] grid) {

        PriorityQueue<Cell> priorityQueue = new PriorityQueue<>(Comparator.comparing(a -> a.weight));

        priorityQueue.offer(new Cell(0, 0, grid[0][0]));

        Set<String> visited = new HashSet<>();

        int result = 0;

        int[][] directions = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };

        while (!priorityQueue.isEmpty()){
            Cell current = priorityQueue.poll();

            int currentI = current.i;
            int currentJ = current.j;
            int currentWeight = current.weight;

            result = Math.max(result, currentWeight);

            if (currentI == grid.length - 1 && currentJ == grid.length - 1) {
                break;
            }

            if(visited.contains(currentI + " " + currentJ)){
                continue;
            }
            visited.add(currentI + " " + currentJ);

            for (int[] direction : directions) {
                int nextI = currentI + direction[0];
                int nextJ = currentJ + direction[1];
                if(nextI >= 0 && nextI < grid.length
                        && nextJ >= 0 && nextJ < grid.length
                        && !visited.contains(nextI + " " + nextJ)){
                    priorityQueue.offer(new Cell(nextI, nextJ, Math.max(currentWeight, grid[nextI][nextJ])));
                }
            }
        }

        return result;
    }
}

class Cell{
    int i;
    int j;
    int weight;

    public Cell(int i, int j, int weight) {
        this.i = i;
        this.j = j;
        this.weight = weight;
    }
}