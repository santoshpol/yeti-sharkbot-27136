package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Mechanisms.TestBenchLED;


@TeleOp
@Disabled
public class LEDTest extends OpMode {

    TestBenchLED bench = new TestBenchLED();

    @Override
    public void init() {
        bench.init(hardwareMap);
    }

    @Override
    public void loop() {
       if (gamepad1.a) {
           bench.setRedLed(true);
           bench.setGreenLed(false);
      } else if (gamepad1.b) {
           bench.setRedLed(false);
           bench.setGreenLed(true);
       } else if (gamepad1.y) {
           bench.setRedLed(true);
           bench.setGreenLed(true);
       }


    }
}
