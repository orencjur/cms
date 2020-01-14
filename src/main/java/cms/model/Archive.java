package cms.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQuery(name = "Archive.findAllRecords", query = "SELECT a FROM Archive a WHERE a.id IS NOT NULL ")
@DiscriminatorValue("ARCHIVE")
public class Archive implements Serializable {

  private String cargo;
  private String assignedvehicle;
  @Id
  @GeneratedValue
  private long id;
  private String status;
  private String destination;
  private String description;


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


  public long getId() {
    return id;
  }

  public void setId(long id) {
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


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
