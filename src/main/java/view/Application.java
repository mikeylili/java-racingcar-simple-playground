package view;

import java.util.Scanner;
import domain.CarRace;

public class Application {
    private final CarRace carrace = new CarRace();
    public void run() {
        Scanner input = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carnames = input.nextLine().split(",");
        carrace.validateCarNames(carnames);

        System.out.println("시도할 회수는 몇회인가요?");
        int n = input.nextInt();
        int[] carscores = new int[carnames.length];

        System.out.println("\n실행 결과");
        for (int i = 0; i < n; i++) {
            carrace.playRound(carscores);
            printStatus(carscores, carnames);
        }
        System.out.println(carrace.getWinner(carscores, carnames) + "가 최종 우승했습니다.");
    }
    public void printStatus(int[] carscores, String[] carnames) {
        for (int i = 0; i < carscores.length; i++) {
            System.out.println(carnames[i] + " : " + carrace.getTrace(carscores[i]));
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Application game = new Application();
        game.run();
    }
}
