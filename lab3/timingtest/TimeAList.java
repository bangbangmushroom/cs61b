package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        timeGetLast();
    }
    public static void timeGetLast() {
        Integer[] steps;
        steps = new Integer[]{1000, 2000, 4000, 8000, 16000, 32000};
        Double[] times = new Double[steps.length];

        for (int i = 0; i < steps.length; i++){
            AList item = new AList();
            times[i] = timeGetOneTime(steps[i], item);
        }

        AList<Integer>N = new AList<>();
        AList<Double> T = new AList<>();
        for (int i = 0; i < steps.length; i++){
            N.addLast(steps[i]);
            T.addLast(times[i]);
        }

        for(int i = 0; i < steps.length; i++){
            printTimingTable(N, T, N);
        }
    }
    private static double timeGetOneTime(int steps, AList item){
        Stopwatch sw = new Stopwatch();
        for (int i = 0; i < steps; i++){
            item.addLast(1);
        }
        double timeInSeconds = sw.elapsedTime();
        return timeInSeconds;
    }
}
