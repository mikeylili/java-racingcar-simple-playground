package CarRace;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarRace {

    public int GenerateRandom0to9() {
        int move = (int) (Math.random() * 10);
        return move;
    }

    public int GoOrStop(int move) {

        if (move >= 4) {
            //System.out.println(" Go");
            return 1;
        }
        if (move <= 3) {
            //System.out.println(" Stop");
            return 0;
        }
        throw new RuntimeException("배열에 3초과 4미만인 수가 들어있습니다.");
    }

    public int[] Racing(int n) {
        int[] carscores = new int[n];
        int maxScore = 0;
        for (int i = 0; i < n; i++) {
            String name = "CCar" + i;
            int move = GenerateRandom0to9();
            carscores[i] += GoOrStop(move);
        }
        return carscores;
    }

    public String GetWinner(int[] carscores) {
        int maxScore = IntStream.of(carscores).max().orElse(0);
        String maxIndexes = IntStream.range(0, carscores.length)
                .filter(i -> carscores[i] == maxScore)
                .mapToObj(i -> "CCar" + i)
                .collect(Collectors.joining(", "));
        return maxIndexes;
    }
}
