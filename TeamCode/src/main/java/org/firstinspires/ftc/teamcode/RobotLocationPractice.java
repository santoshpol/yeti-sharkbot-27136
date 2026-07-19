package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@Disabled
public class RobotLocationPractice {

    double angle;
    double x;
    double y;

    //constructor method
    public RobotLocationPractice(double angle) {
        this.angle = angle;
    }

    public double getHeading() {
        //this method normalizes robot angle between -180 and 180.
        //this is useful for calculating turn angles, especially when crossing 0,360 boundary.
        double angle = this.angle; //copy of angle imu
        while (angle > 180) {
            angle -= 360;  //subtract until in target range
        }
        while (angle <= 180) { // add until in target range
            angle += 360;
        }
        return angle; //return normalized value
    }

    public void turnRobot(double angleChange)  {
        angle += angleChange;
    }


   public void setAngle(double angle) {
        this.angle = angle;
   }

public void setX(double x) {
        this.x = x;
}

    public void setY(double y) {
        this.y = y;
    }

    public void changeY(double changeAmount) {
        y += changeAmount;
    }
    public void changeX(double changeAmount) {
        x += changeAmount;
}

    public double getAngle() {
        return this.angle;
      }

      public double getX() {
         return this.x;
      }
      public double getY() {
        return this.y;
      }
}
/*
 you first set the function which renames it then you use a get function to actually get the function.
 the turn and change functions allow the double to change value, which will change the get function value. in useRobotLocationOpmode,
 the control functions get the values from RobotLocationPractice from specifically the get function
 because thats where you get your final value.
 Then you can use telemetry to display those values on your driver hub. This specific file gets the values
 and is also a helper class for opmodes.
 */
