/* Black Knights Robotics (C) 2025 */
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.utils.Controller;

public class ClimberCommand extends Command {
    public Controller controller;
    public ClimberSubsystem climberSubsystem;

    public ClimberCommand(ClimberSubsystem climberSubsystem, Controller controller) {
        this.climberSubsystem = climberSubsystem;
        this.controller = controller;
        addRequirements(climberSubsystem);
    }

    @Override
    public void execute() {
        if (controller.dpadDown.getAsBoolean()) {
            climberSubsystem.setJoint(0.8);
        }
        if (controller.dpadUp.getAsBoolean()) {
            climberSubsystem.setJoint(-0.8);
        }
        if (controller.dpadLeft.getAsBoolean()) {
            climberSubsystem.setRotary(0.2);
        }
        if (controller.dpadRight.getAsBoolean()) {
            climberSubsystem.setRotary(-0.2);
        }
    }

    @Override
    public void end(boolean interrupted) {
        climberSubsystem.setJoint(0);
        climberSubsystem.setRotary(0);
    }
}
