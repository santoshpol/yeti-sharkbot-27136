package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Disabled
public class TestBench1  {

    private DcMotor motor; //linearSlideMotor, etc

    private double ticksPerRev; //Revolution

    public void init(HardwareMap hwMap) {


        //DcMotor Code
        motor = hwMap.get(DcMotor.class, "motor");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ticksPerRev = motor.getMotorType().getTicksPerRev();

    }

    public void setMotorSpeed(double speed) {
        // accepts values from -1.0 to 1.0
        motor.setPower(speed);
    }

    public double getTicksPerRev() {
        return motor.getCurrentPosition() / ticksPerRev; //normalizing ticks to revolutions
    }
}
