package CarRace;

public class CarRace {
    public String name = "CCar";
    public int GenerateRandom0to9(){
        int move = (int) (Math.random() * 10);
        return move;
    }

    public String GoOrStop(int move) {

        if (move >= 4) {
            System.out.println(name + " Go");
            return name + " Go";
        }
        if (move <= 3) {
            System.out.println(name + " Stop");
            return name + " Stop";
        }
        throw new RuntimeException();
    }

    public String Racing() {
        int move = GenerateRandom0to9();
        return GoOrStop(move);
    }
}
