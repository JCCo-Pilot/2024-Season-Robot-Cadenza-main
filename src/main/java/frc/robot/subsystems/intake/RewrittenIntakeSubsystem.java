package frc.robot.subsystems.intake;

import static frc.robot.constants.RobotInfo.IntakeInfo;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants;
import frc.robot.constants.IDs;


public class RewrittenIntakeSubsystem extends SubsystemBase implements IIntakeSubsystem{
    private final CANSparkMax pivotMotorLeft;
    private final CANSparkMax pivotMotorRight;
    private final CANSparkMax intakeMotor;

    private final PIDController pivotPID;
    private final DutyCycleEncoder encoder;
    public RewrittenIntakeSubsystem(int pivotMotorLeftID, int pivotMotorRightID, int intakeMotorID, int encoderID){
        pivotMotorLeft = new CANSparkMax(pivotMotorLeftID, CANSparkMax.MotorType.kBrushless);
        pivotMotorRight = new CANSparkMax(pivotMotorRightID, CANSparkMax.MotorType.kBrushless);
        intakeMotor = new CANSparkMax(intakeMotorID, CANSparkMax.MotorType.kBrushless);

        pivotPID = IntakeInfo.INTAKE_PIVOT_PID_CONSTANTS.create();
        //different code
        pivotMotorLeft.restoreFactoryDefaults();
        pivotMotorRight.restoreFactoryDefaults();
        intakeMotor.restoreFactoryDefaults();

        pivotMotorLeft.setIdleMode(CANSparkBase.IdleMode.kBrake);
        pivotMotorRight.setIdleMode(CANSparkBase.IdleMode.kBrake);

        pivotMotorLeft.setInverted(false);
        pivotMotorRight.follow(pivotMotorLeft,true);
        //different code
        pivotMotorLeft.setSmartCurrentLimit(35);
        pivotMotorRight.setSmartCurrentLimit(35);
        intakeMotor.setSmartCurrentLimit(35);

        encoder = new DutyCycleEncoder(IDs.INTAKE_ENCODER_DIO_PORT);
        setExtended(ExtensionState.RETRACTED);
    }

    @Override
    public void setExtended(ExtensionState extended) {
        pivotPID.setSetpoint(
            switch (extended){
                case EXTENDED-> IntakeInfo.INTAKE_PIVOT_EXTENDED_SETPOINT;
                case RETRACTED-> IntakeInfo.INTAKE_PIVOT_DEFAULT_SETPOINT;
            }
        );
    }

    @Override
    public void outtake() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'outtake'");
    }

    @Override
    public void stopIntake() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stopIntake'");
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stop'");
    }

    @Override
    public void intake() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'intake'");
    }


}
