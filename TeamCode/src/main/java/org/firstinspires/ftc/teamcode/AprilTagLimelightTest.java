package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class AprilTagLimelightTest extends OpMode {

    private Limelight3A limelight3A;


    @Override
    public void init() {
        limelight3A = hardwareMap.get(Limelight3A.class, "limelight3A");

        // Switch to your AprilTag pipeline
        limelight3A.pipelineSwitch(8);

        limelight3A.start();
    }

    @Override
    public void loop() {

        LLResult llResult = limelight3A.getLatestResult();

        if (llResult != null && llResult.isValid()) {

            telemetry.addData("Tx", llResult.getTx());   // Horizontal offset
            telemetry.addData("Ty", llResult.getTy());   // Vertical offset
            telemetry.addData("Ta", llResult.getTa());   // Target area

        } else {
            telemetry.addLine("No AprilTag Detected");
        }

        telemetry.update();
    }
}