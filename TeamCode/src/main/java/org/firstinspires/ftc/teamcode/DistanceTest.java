package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Mechanisms.TestBenchDistance;

@TeleOp
@Disabled
public class DistanceTest extends OpMode {
TestBenchDistance bench = new TestBenchDistance();

    @Override
    public void init() {
         bench.init(hardwareMap);
    }

    @Override
    public void loop() {
        String distanceSensorState = "just right";
        if (bench.getDistance() < 10) {
           distanceSensorState = "too close!";
        } else {
            distanceSensorState = "just right";
        }

        telemetry.addData("DistanceGiven", bench.getDistance());
        telemetry.addLine(distanceSensorState);
    }
}
