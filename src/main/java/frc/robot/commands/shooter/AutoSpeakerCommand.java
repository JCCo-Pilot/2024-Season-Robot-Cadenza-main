package frc.robot.commands.shooter;

import frc.robot.constants.RobotInfo.ShooterInfo.ShootingMode;
import frc.robot.led.LEDStrip;
import frc.robot.subsystems.hopper.IHopperSubsystem;
import frc.robot.subsystems.shooter.IShooterSubsystem;

public class AutoSpeakerCommand extends ShootCommand {
  public AutoSpeakerCommand(IShooterSubsystem shooter, IHopperSubsystem hopper, LEDStrip ledStrip) {
    super(shooter, hopper, ledStrip, ShootingMode.AUTO_SPEAKER, false);
  }
}
