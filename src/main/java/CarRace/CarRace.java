package CarRace;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarRace {

    public int generateRandom0to9() {
        return (int) (Math.random() * 10);
    }

    public int goOrStop(int move) {
        if (move <= 0 || move > 9) throw new RuntimeException("move 값이 적절한 범위를 벗어남.");
        if (move >= 4) return 1;
        if (move <= 3) return 0;
        throw new RuntimeException("move 값이 적절하지 않음.");
    }

    public void playRound(int[] carscores) {
        for (int i = 0; i < carscores.length; i++) {
            carscores[i] += goOrStop(generateRandom0to9());
        }
    }

    public String getWinner(int[] carscores, String[] carnames) {
        int maxScore = IntStream.of(carscores).max().orElse(0);
        return IntStream.range(0, carscores.length)
                .filter(i -> carscores[i] == maxScore)
                .mapToObj(i -> carnames[i])
                .collect(Collectors.joining(", "));
    }

    public void printStatus(int[] carscores, String[] carnames) {
        for (int i = 0; i < carscores.length; i++) {
            System.out.println(carnames[i] + " : " + getTrace(carscores[i]));
        }
        System.out.println();
    }

    public String getTrace(int carscore) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < carscore; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public void validateCarNames(String[] carnames) {
        for (String name : carnames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다: " + name);
            }
        }
    }

    public static void main(String[] args) {
        CarRace game = new CarRace();
        game.run();
    }

    public void run() {
        Scanner input = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carnames = input.nextLine().split(",");
        validateCarNames(carnames);

        System.out.println("시도할 회수는 몇회인가요?");
        int n = input.nextInt();
        int[] carscores = new int[carnames.length];

        System.out.println("\n실행 결과");
        for (int i = 0; i < n; i++) {
            playRound(carscores);
            printStatus(carscores, carnames);
        }
        System.out.println(getWinner(carscores, carnames) + "가 최종 우승했습니다.");
    }
}
