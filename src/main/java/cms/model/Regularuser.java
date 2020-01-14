package cms.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("RUSER")
public class Regularuser extends Userbase{

  @Id
  private String username;

  private String fullname;
  private String password;
  private String vehicleid;
  private String licensenumber;


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getVehicleid() {
    return vehicleid;
  }

  public void setVehicleid(String vehicleid) {
    this.vehicleid = vehicleid;
  }


  public String getLicensenumber() {
    return licensenumber;
  }

  public void setLicensenumber(String licensenumber) {
    this.licensenumber = licensenumber;
  }

}
