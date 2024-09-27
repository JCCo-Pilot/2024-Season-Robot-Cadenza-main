package frc.robot.subsystems.hopper;

import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.sensors.IRSensor;

public interface IHopperSubsystem extends Subsystem {
  void run(boolean checkNote, double speed);

  void runBackwards(double speed);

  void stop();

  IRSensor getIR();

  void run(boolean checkNOte, double speed, boolean reversed);
}
