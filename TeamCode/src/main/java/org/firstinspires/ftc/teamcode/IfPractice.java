package org.firstinspires.ftc.teamcode;



import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
@Disabled

public class IfPractice extends OpMode {

    @Override
    public void init() {

    }

    @Override
    public void loop() {
        boolean aButton = gamepad1.a; // If pressed, true, if not, false
         double motorSpeed = gamepad1.left_stick_y;
        if (aButton) {
            telemetry.addData( " A Button", "Pressed!");
        }
        else { //otherwise
            telemetry.addData("A Button", "NOT pressed");
        }
        telemetry.addData("A button state", aButton);
         // diddy seperation area
        if (!gamepad1.a) {
           motorSpeed *= 0.5;
        }

     telemetry.addData("Left Stick Value", motorSpeed);
    }
}

/*
COMBINATIONS:
 AND - && if (leftY < 0.5 && leftY > 0) {
 OR - || if (lefY < 0 || rightY < 0) {
 NOT - ! if (!clawClosed) {
 */