// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Timer;

public class ExampleSubsystem extends SubsystemBase {
  private final CANSparkMax motor1;
  private final CANSparkMax motor2;
  private final XboxController controller;
  private final Timer stopWatch;

  /** Creates a new ExampleSubsystem. */
  public ExampleSubsystem() {
    motor1 = new CANSparkMax(3, MotorType.kBrushless);
    motor2 = new CANSparkMax(4, MotorType.kBrushless);
    controller = new XboxController(0);
    stopWatch = new Timer();
    motor2.follow(motor1);
  }
  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }
 
  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  boolean toggle = false;
  @Override
  public void periodic() {
    // // This method will be called once per scheduler run
    // // Trigger
    // motor.set(controller.getLeftTriggerAxis());
    // // left/right trigger returns double values and can be directly set to motor

    // // Button press
    // if (controller.getAButton()) {
    //   motor.set(0.2);
    // }
    // // Button status is true on press and stays true until release

    // // Joystick
    // motor.set(controller.getLeftY() * 0.8);

    // // Triggering with button press
    // if (controller.getAButtonPressed()) {
    //   toggle = !toggle;
    // }
    // motor.set(toggle ? 0.5 : 0);

    // 2 motors
    // boolean a = controller.getAButton();
    // motor1.set(a ? 0.2 : 0);
    
    // if (timer.get() > 1) {
    //   motor1.set(controller.getLeftY());
    // }
    // System.out.println(stopWatch.get());

    // Ramp Up-Down
    // double startTime = 0;
    // if (controller.getAButtonPressed()) {
    //   stopWatch.start();
    //   toggle = !toggle;
    //   startTime = stopWatch.get();
    // }

    // double deltaTime = stopWatch.get() - startTime;
    // if (deltaTime < 4.0) {
    //   motor1.set(0.1 * deltaTime);
    // } else if (deltaTime < 6.0) {
    //   motor1.set(0.4);
    // } else {
    //   motor1.set(1 - (0.1 * deltaTime));
    // }
  } 

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
