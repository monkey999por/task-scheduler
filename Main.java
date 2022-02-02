import tool.Cmd;
import tool.Setting;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String args[]) {
        Setting.init(args[0]);
        String batch = Setting.getAsString("batch");
        Long period = Long.valueOf(Setting.getAsString("period") + "000");
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Cmd.execute(true, new String[]{batch});

            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 1000L, period);
    }
}