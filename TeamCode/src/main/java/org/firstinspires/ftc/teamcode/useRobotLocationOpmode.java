package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
@Disabled


public class useRobotLocationOpmode extends OpMode {

    RobotLocationPractice robotLocationPractice = new RobotLocationPractice(0);


    @Override
    public void init(){
     robotLocationPractice.setAngle(0);
     robotLocationPractice.setX(0);
     robotLocationPractice.setY(0);
    }

    @Override
    public void loop() {
        if (gamepad1.a) {
            robotLocationPractice.turnRobot(0.1);
        } else if (gamepad1.b) {
            robotLocationPractice.turnRobot(-0.1);
        }

        if (gamepad1.dpad_left) {
            robotLocationPractice.changeX(0.1);
        } else if (gamepad1.dpad_right) {
            robotLocationPractice.changeX(-0.1);
        }

        if (gamepad1.dpad_up) {
            robotLocationPractice.changeY(-0.1);

        } else if (gamepad1.dpad_down) {
            robotLocationPractice.changeY(0.1);
        }
        telemetry.addData("Y Value", robotLocationPractice.getY());
        telemetry.addData("x Value", robotLocationPractice.getX());
        telemetry.addData("Heading", robotLocationPractice.getHeading());
        telemetry.addData("Angle", robotLocationPractice.getAngle());
    }

}
/*This file displays values because it is an Opmode, and getX/y has the final
value just like I said in the helper class which is called RobotLocationPractice.
 */


