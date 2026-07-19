package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Robot Centric Mecanum", group = "Drive")
public class MecanumDriveTest1 extends LinearOpMode {

    // Motors
    private DcMotor frontLeft;
    private DcMotor backLeft;
    private DcMotor frontRight;
    private DcMotor backRight;

    @Override
    public void runOpMode() {

        // Hardware map
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backRight = hardwareMap.get(DcMotor.class, "backRight");

        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Reverse right side motors if needed
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addLine("Ready!");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            /*
             * Left stick:
             *   X = strafe
             *   Y = forward/back
             *
             * Right stick X:
             *   rotation
             */

            double x = -gamepad1.left_stick_x;
            double y = gamepad1.left_stick_y; // invert because FTC sticks are reversed
            double turn = gamepad1.right_stick_x;

            // Convert joystick into angle + power
            double translationPower = Math.hypot(x, y);

            // atan2 gives angle in radians
            double translationAngle = Math.atan2(y, x);

            // Mecanum calculations
            double ADPower =
                    translationPower * Math.sqrt(2) * 0.5 *
                            (Math.sin(translationAngle) + Math.cos(translationAngle));

            double BCPower =
                    translationPower * Math.sqrt(2) * 0.5 *
                            (Math.sin(translationAngle) - Math.cos(translationAngle));

            // Add turning while preserving translation direction
            double turningScale = Math.max(
                    Math.abs(ADPower + turn),
                    Math.abs(ADPower - turn)
            );

            turningScale = Math.max(
                    turningScale,
                    Math.max(
                            Math.abs(BCPower + turn),
                            Math.abs(BCPower - turn)
                    )
            );

            if (turningScale < 1.0) {
                turningScale = 1.0;
            }

            // Final motor powers
            double frontLeftPower  = (ADPower - turn) / turningScale;
            double backLeftPower   = (BCPower - turn) / turningScale;
            double frontRightPower = (BCPower + turn) / turningScale;
            double backRightPower  = (ADPower + turn) / turningScale;

            // Set motor powers
            frontLeft.setPower(frontLeftPower);
            backLeft.setPower(backLeftPower);
            frontRight.setPower(frontRightPower);
            backRight.setPower(backRightPower);

            // Telemetry
            telemetry.addData("FL", frontLeftPower);
            telemetry.addData("BL", backLeftPower);
            telemetry.addData("FR", frontRightPower);
            telemetry.addData("BR", backRightPower);
            telemetry.update();
        }
    }
}

