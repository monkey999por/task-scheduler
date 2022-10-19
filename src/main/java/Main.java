
import monkey999.tools.Cmd;
import monkey999.tools.Setting;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String args[]) {
        Setting.init(args[0]);
        Long period = Long.valueOf(Setting.getAsString("period") + "000");
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Arrays.stream(Setting.getAsString("batch")
                        .split(","))
                        .forEach(x -> {
                            try {
                                Cmd.execute(true, new String[]{x});
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        });
                ;
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 1000L, period);
    }
}