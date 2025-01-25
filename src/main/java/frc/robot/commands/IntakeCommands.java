/* Black Knights Robotics (C) 2025 */
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.constants.ArmConstants;
import frc.robot.subsystems.ArmSubsystem;

import java.util.Timer;
import java.util.function.BooleanSupplier;

public class IntakeCommands extends Command {
    private final ArmSubsystem armSubsystem;
    private BooleanSupplier lineBreakHit;
    private final Timer timer = new Timer();

    public IntakeCommands(ArmSubsystem armSubsystem, BooleanSupplier lineBreakHit) {
        this.armSubsystem = armSubsystem;
        this.lineBreakHit = lineBreakHit;
        addRequirements(armSubsystem);
    }

    @Override
    public void execute() {
        if (!this.lineBreakHit.getAsBoolean()) {
            armSubsystem.setHandSpeed(ArmConstants.INTAKE_SPEED);
        } else {
            armSubsystem.setHandSpeed(0);
        }
    }

    @Override
    public void end(boolean interrupted) {
        armSubsystem.setHandSpeed(0);
    }

    @Override
    public void initialize() {}
}
