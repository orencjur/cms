package cms.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DiscriminatorValue("SHIPMENT")
public class Shipment implements Serializable {

  private String cargo;
  private String assignedvehicle;
  @Id
  @GeneratedValue
  private Integer id;
  private String status;
  private String destination;


  public String getCargo() {
    return cargo;
  }

  public void setCargo(String cargo) {
    this.cargo = cargo;
  }


  public String getAssignedvehicle() {
    return assignedvehicle;
  }

  public void setAssignedvehicle(String assignedvehicle) {
    this.assignedvehicle = assignedvehicle;
  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }



}
