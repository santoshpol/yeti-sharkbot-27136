package org.firstinspires.ftc.teamcode.Mechanisms;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Disabled
public class TestBench {



    private DigitalChannel touchSensor; //touchSensorIntake for example

    private DcMotor motor;//linearSlideMotor, etc

    private DcMotor outakeMotor;

    private double ticksPerRev;//Revolution


    public void init(HardwareMap hwMap) {
        //Touch Sensor
      touchSensor = hwMap.get(DigitalChannel.class, "touch_sensor");
       touchSensor.setMode(DigitalChannel.Mode.INPUT);
        //DcMotor Code
        motor = hwMap.get(DcMotor.class, "motor");
        outakeMotor = hwMap.get(DcMotor.class, "outakeMotor");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ticksPerRev = motor.getMotorType().getTicksPerRev();
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        motor.setDirection(DcMotorSimple.Direction.REVERSE);

    }
     //--------Touch Sensor-----------
    public boolean isTouchSensorPressed() {
        return !touchSensor.getState();
    }

    public boolean isTouchSensorReleased() {
    return touchSensor.getState();
    }
      //---------DC Motor-------
    public void setMotorSpeed(double speed) {
        // accepts values from -1.0 to 1.0
        motor.setPower(speed);

    }

    public void setMotorSpeedOutake(double speed) {
        outakeMotor.setPower(speed);
    }

    public double getTicksPerRev() {
        return motor.getCurrentPosition() / ticksPerRev; //normalizing ticks to revolutions
    }

     public void setMotorZeroBehaviour(DcMotor.ZeroPowerBehavior zeroBehaviour) {
       motor.setZeroPowerBehavior(zeroBehaviour);
     }
}



