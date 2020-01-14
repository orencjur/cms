package cms.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "VEHICLE")
public class Vehicle implements Serializable {

  @OneToOne( cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
  private Shipment shipment;

  @Column(name = "availability")
  @Basic(optional = true)
  private boolean availability;

  @Id
  @Column(name = "licenseplate")
  private String licenseplate;


  public Shipment getShipment() {
    return shipment;
  }

  public void setShipment(Shipment shipment) {
    this.shipment = shipment;
  }


  public boolean getAvailability() {
    return availability;
  }

  public void setAvailability(boolean availability) {
    this.availability = availability;
  }


  public String getLicenseplate() {
    return licenseplate;
  }

  public void setLicenseplate(String licenseplate) {
    this.licenseplate = licenseplate;
  }

}
