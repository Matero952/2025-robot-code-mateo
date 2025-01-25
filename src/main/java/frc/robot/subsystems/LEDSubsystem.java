/* Black Knights Robotics (C) 2025 */
package frc.robot.subsystems;

import com.ctre.phoenix.led.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LEDSubsystem extends SubsystemBase {

    private final CANdle candle = new CANdle(1, "rio");

    private final int ledCount = 0;

    private int r = 0;
    private int g = 0;
    private int b = 0;

    private Animation animation = null;
}
