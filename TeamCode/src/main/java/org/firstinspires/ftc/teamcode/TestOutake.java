package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name="Outake Test")
@Disabled
public class TestOutake extends LinearOpMode {

    DcMotor motorOutake;



    @Override public void runOpMode() {

        motorOutake = hardwareMap.get(DcMotor.class,"motorOutake");

        waitForStart();

        while (opModeIsActive()) {

            if (gamepad1.right_bumper) {
                motorOutake.setPower(1);
            } else {
                motorOutake.setPower(0);
            }
        }
    }
}





