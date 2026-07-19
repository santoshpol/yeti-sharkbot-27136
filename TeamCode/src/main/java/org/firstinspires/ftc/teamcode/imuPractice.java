package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.Mechanisms.TestBenchIMU;
@Disabled
@TeleOp
public class imuPractice extends OpMode {

    TestBenchIMU bench = new TestBenchIMU();

    public DcMotor motor;

    double heading;

    @Override
    public void init() {
     bench.init(hardwareMap);
     motor = hardwareMap.get(DcMotor.class, "motor");
    }

    @Override
    public void loop() {
        heading = bench.getHeading(AngleUnit.DEGREES);
        telemetry.addData("imu thing",bench.getHeading(AngleUnit.DEGREES));
        //Radians or Degrees
         if (heading < 0.5 && heading > -0.5) {
             motor.setPower(0);
         } else if (heading > 0.5) {
             motor.setPower(-1);
         } else if (heading < -0.5) {
             motor.setPower(1);
         }


    }
}
