package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.MagneticLimitSwitchHelper;
import org.firstinspires.ftc.teamcode.mechanisms.TurretMechanismTutorial;
import org.firstinspires.ftc.teamcode.mechanisms.MecanumDriveRobotOrientedHelper;
@TeleOp
public class TurretAutoAlignOpModeTutorial extends OpMode {
    private Limelight3A limelight;
    private TurretMechanismTutorial turret = new TurretMechanismTutorial();
    private MecanumDriveRobotOrientedHelper drive = new MecanumDriveRobotOrientedHelper();

    private MagneticLimitSwitchHelper magneticSwitch = new MagneticLimitSwitchHelper();


    double[] stepSizes = {0.1,0.01,0.001,0.0001,0.00001};

    int ticksChange=10;

    int stepIndex=2;



    public void init(){
        limelight=hardwareMap.get(Limelight3A.class,"limelight");
        limelight.setPollRateHz(100);
        limelight.pipelineSwitch(8);
        limelight.start();
        turret.init(hardwareMap);
        //drivetrain
        drive.init(hardwareMap);
        //Magnetic Switch
        magneticSwitch.init(hardwareMap);
    }

    @Override
    public void start() {
        turret.resetTimer();

    }

    @Override
    public void loop() {
        // 1. Fetch the latest vision result from Limelight
        LLResult result = limelight.getLatestResult();
        if (result != null && result.isValid()) {
            double targetX = result.getTx();
            turret.update(targetX); // PID + Soft Encoder Limits
            telemetry.addData("Target Angle (tx)", targetX);
        } else {
            turret.update(0);
            telemetry.addLine("No tag detected");
        }

        //When the magnetic limit switch gets activated it resets the encoder

        if (magneticSwitch.getLimitSwitch()){
        turret.resetEncoder();
        telemetry.addLine("Encoder Reset");
        }
//intake
        turret.setPowerIntake(1);
        //ramp
        if (gamepad1.right_bumper){
            turret.setPowerRamp(0.5);
        }
        else{
            turret.setPowerRamp(0);
        }
        //outtake
        turret.setPowerOuttake(0.5);
        //flicker
        if(gamepad1.b){
            turret.pushBall(0);
        }
        else{
            turret.pushBall(100);
        }




        // Drivetrain controls (Driver 1 Left & Right Joysticks)
        double driveInput  = -gamepad1.left_stick_y;
        double strafeInput =  gamepad1.left_stick_x;
        double turnInput   =  gamepad1.right_stick_x;
        drive.driveRobotOriented(driveInput, strafeInput, turnInput);

        //update P and D on the fly
        //'B' button cycles through the different stp sizes for  tuning precision
        if (gamepad2.bWasPressed()) {
            stepIndex = (stepIndex + 1) % stepSizes.length;//Modula wraps the index back to 0
        }



        //D-Pad left/right adjusts the P gain
        if (gamepad2.dpadLeftWasPressed()){
            turret.setkP(turret.getkP()-stepSizes[stepIndex]);
        }
        if (gamepad2.dpadRightWasPressed()){
            turret.setkP(turret.getkP()+stepSizes[stepIndex]);
        }

        //D-Pad up/down adjusts the D gain
        if (gamepad2.dpadUpWasPressed()){
            turret.setkD(turret.getkD()+stepSizes[stepIndex]);
        }
        if (gamepad2.dpadDownWasPressed()){
            turret.setkD(turret.getkD()-stepSizes[stepIndex]);
        }

        telemetry.addData("Current Kp", turret.getkP());
        telemetry.addData("Current Kd", turret.getkD());
        telemetry.addData("Active Step Size", stepSizes[stepIndex]);
        telemetry.addData("Current Position",turret.turret.getCurrentPosition());
        telemetry.addData("Max Position",turret.ticks);
        telemetry.addData("Limit Switch State",magneticSwitch.getLimitSwitch());


        if (turret.turret.getCurrentPosition() > turret.ticks) {

            telemetry.addLine("Over Limit");


        } else if (turret.turret.getCurrentPosition() < -turret.ticks) {
            telemetry.addLine("Over Limit");
        }


        telemetry.update();


        //update tick values on the fly

        if (gamepad2.yWasPressed()){
            turret.ticks+=ticksChange;
        } else if (gamepad2.aWasPressed()) {
            turret.ticks-=ticksChange;
        }




    }
}
