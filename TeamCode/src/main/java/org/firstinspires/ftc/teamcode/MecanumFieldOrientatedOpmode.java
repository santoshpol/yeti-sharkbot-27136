package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Mechanisms.MecanumDrive;
@Disabled
@TeleOp
public class MecanumFieldOrientatedOpmode extends OpMode {

    double forward, strafe, rotate;
    MecanumDrive drive = new MecanumDrive();

    @Override
    public void init() {
        drive.init(hardwareMap);
    }

    @Override
    public void loop() {
        forward = -gamepad1.left_stick_y;
        strafe = gamepad1.left_stick_x;
        rotate = gamepad1.right_stick_x;

        if (Math.abs(rotate) < 0.085) {
            rotate = 0;
        }

        if (Math.abs(strafe) < 0.1256) {
            strafe = 0;
        }
        drive.driveFieldRelative(forward, strafe, rotate);

    }

}

