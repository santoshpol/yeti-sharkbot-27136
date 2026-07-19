package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Mechanisms.TurretMechanism;

@TeleOp
public class TurretAutoAlignOpmode extends OpMode {

    private Limelight3A limelight3A;
    private TurretMechanism turret = new TurretMechanism();



    @Override
    public void init() {
        limelight3A = hardwareMap.get(Limelight3A.class, "limelight3A");
        limelight3A.pipelineSwitch(8);
        turret.init(hardwareMap);

    }

    public void start() {
        turret.resetTimer();
       limelight3A.start();
    }



    @Override
    public void loop() {
        LLResult llresult = limelight3A.getLatestResult();

        turret.update(llresult);

        if (llresult != null && llresult.isValid()) {
            telemetry.addData("tx", llresult.getTx());
            telemetry.addData("ty", llresult.getTy());
            telemetry.addData("ta", llresult.getTa());
            telemetry.addLine("Target detected");
        } else {
            telemetry.addLine("No tag detected");
        }

        telemetry.update();
    }
}



