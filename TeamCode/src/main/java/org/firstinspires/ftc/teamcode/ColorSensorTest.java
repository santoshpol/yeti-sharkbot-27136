package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Mechanisms.TestBenchColor;

@TeleOp
@Disabled
public class ColorSensorTest extends OpMode {

    TestBenchColor bench = new TestBenchColor();
    TestBenchColor.DetectedColor detectedColor;

    public DcMotor outakeMotor;

    @Override
    public void init() {
        bench.init(hardwareMap);
    }

    @Override
    public void loop() {
        detectedColor = bench.getDetectedColor(telemetry);
        telemetry.addData("Color Detected", detectedColor);
        // tells which color is detected depending on values from the TestBenchColor


        if (detectedColor == TestBenchColor.DetectedColor.RED) {
            // stop the motor
            outakeMotor.setPower(0); //example
        }
    }

}

