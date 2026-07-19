package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Mechanisms.TestBenchServo;


@TeleOp
@Disabled
public class ServoExamples extends OpMode {

    TestBenchServo bench = new TestBenchServo();

    public void init() {
      bench.init(hardwareMap);
    }

    @Override
    public void loop() {
     /*
        if (gamepad1.a) {
            bench.setServoPos(0.5);
        } else {
            bench.setServoPos(1.0);
        }
        if (gamepad1.b) {
            bench.setServoRot(1.0);
        } else {
            bench.setServoRot(0.0);
        }

      */
        if (gamepad1.left_trigger > 0 && gamepad1.right_trigger <= 0.95) {
            bench.setServoPos(0);
        } else if (gamepad1.left_trigger <= 0 && gamepad1.right_trigger > 0.01) {
            bench.setServoPos(1);
        }


    }
}
