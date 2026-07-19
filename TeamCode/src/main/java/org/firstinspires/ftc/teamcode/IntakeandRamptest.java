package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp(name="Intake and Ramp Test")
@Disabled
public class IntakeandRamptest extends LinearOpMode {

    DcMotor intakeMotor;
    DcMotor rampMotor;
    DcMotor backRight;
    DcMotor backLeft;
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor rotateMotor;
    DcMotorEx outakeMotor;



    @Override
    public void runOpMode() {

        intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");
        rampMotor = hardwareMap.get(DcMotor.class, "rampMotor");

        waitForStart();

        while (opModeIsActive()) {

            // Intake motor with left bumper
            if (gamepad1.left_bumper) {
                intakeMotor.setPower(-1);
            } else {
                intakeMotor.setPower(0);
            }

            // Ramp motor with right bumper
            if (gamepad1.right_bumper) {
                rampMotor.setPower(-1);
            } else {
                rampMotor.setPower(0);
            }
        }
    }

}