package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

import org.firstinspires.ftc.teamcode.Mechanisms.TestBench;

@TeleOp
@Disabled
public class DcMotorPractice extends OpMode {
TestBench bench = new TestBench();

boolean touchSensor = bench.isTouchSensorPressed();
    @Override
    public void init() {
        bench.init(hardwareMap);
    }

    @Override
    public void loop() {
        double motorSpeed = gamepad2.left_stick_y;
       /* if (touchSensor) {
            bench.setMotorSpeed(0.5);
        } else {
            bench.setMotorSpeed((0.0)); // stops the motor
        }

        */

        if (touchSensor) {
            bench.setMotorSpeedOutake(0.5);
        } else {
            bench.setMotorSpeedOutake((0.0)); // stops the motor
        }

        bench.setMotorSpeed(motorSpeed);

         if (gamepad1.a) {
             bench.setMotorZeroBehaviour(DcMotor.ZeroPowerBehavior.BRAKE);
         } else if (gamepad1.b) {
             bench.setMotorZeroBehaviour(DcMotor.ZeroPowerBehavior.FLOAT);
         }


        telemetry.addData("Revolutions", bench.getTicksPerRev());
    }

}
