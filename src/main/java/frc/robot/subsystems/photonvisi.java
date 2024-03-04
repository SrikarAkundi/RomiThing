// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import java.util.List;

// import photonlib.json;
import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;
import org.photonvision.targeting.TargetCorner;

import edu.wpi.first.math.geometry.Transform2d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.Drivetrain;

public class photonvisi extends SubsystemBase {
  PhotonCamera camera = new PhotonCamera("Microsoft_LifeCam_HD-3000");
  double yaw;
  double pitch;
  double area;
  double skew;
  Transform3d posea;

  /** Creates a new photonvisi. */
  public photonvisi() {}
  public PhotonPipelineResult cameraresult(Drivetrain m_drivetrain){
    var result = camera.getLatestResult();
    boolean hasTargets = result.hasTargets();
    List<PhotonTrackedTarget> targets = result.getTargets();
    PhotonTrackedTarget target = result.getBestTarget();
    if(hasTargets == true){
          yaw = target.getYaw();
          // pitch = target.getPitch();
          area = target.getArea();
          // skew = target.getSkew();
          // // posea = target.getAlternateCameraToTarget();
          // // List<TargetCorner> corners = target.getCorners();
          System.out.println(yaw);
          // System.out.println(pitch);
          if(area > 4.5){
            m_drivetrain.arcadeDrive(-0.5,0);
          }
          if(area < 3.5){
            m_drivetrain.arcadeDrive(0.5,0);
          }

          if(yaw<-3){
            // System
          }
          if(yaw>3){
            m_drivetrain.arcadeDrive(0.5,0);
          }
          // System.out.println(skew);
          // System.out.println(posea);
    }
    // System.out.println(posea);

    // System.out.println(result);
    System.out.println(hasTargets);
    return result;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
