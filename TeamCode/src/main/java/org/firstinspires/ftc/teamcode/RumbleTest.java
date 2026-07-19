package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
@Disabled
public class RumbleTest extends OpMode {

   // boolean wasA, isA;
   double endGameStart;

   boolean isEndGame;

    @Override
    public void init() {

    }

    public void start() {
        endGameStart = getRuntime() + 90;
    }

    @Override
    public void loop() {
    /* isA = gamepad1.a;
        if (isA && !wasA) {
            gamepad1.rumbleBlips(3);
        }
        wasA = isA; */
       if (endGameStart >= getRuntime() && !isEndGame) {
           gamepad1.rumble(200);
           isEndGame = true;
       }

    }
}
