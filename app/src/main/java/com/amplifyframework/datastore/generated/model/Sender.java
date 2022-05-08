package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.HasMany;
import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Sender type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Senders", authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class Sender implements Model {
  public static final QueryField ID = field("Sender", "id");
  public static final QueryField FIRST_NAME = field("Sender", "firstName");
  public static final QueryField ADDRESS = field("Sender", "Address");
  public static final QueryField KNOWN_TRAVELER_NUMBER = field("Sender", "KnownTravelerNumber");
  public static final QueryField LAST_NAME = field("Sender", "lastName");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String firstName;
  private final @ModelField(targetType="String", isRequired = true) String Address;
  private final @ModelField(targetType="String") String KnownTravelerNumber;
  private final @ModelField(targetType="Flights") @HasMany(associatedWith = "senderID", type = Flights.class) List<Flights> Sender_to_flights = null;
  private final @ModelField(targetType="String", isRequired = true) String lastName;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public String getFirstName() {
      return firstName;
  }
  
  public String getAddress() {
      return Address;
  }
  
  public String getKnownTravelerNumber() {
      return KnownTravelerNumber;
  }
  
  public List<Flights> getSenderToFlights() {
      return Sender_to_flights;
  }
  
  public String getLastName() {
      return lastName;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Sender(String id, String firstName, String Address, String KnownTravelerNumber, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.Address = Address;
    this.KnownTravelerNumber = KnownTravelerNumber;
    this.lastName = lastName;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Sender sender = (Sender) obj;
      return ObjectsCompat.equals(getId(), sender.getId()) &&
              ObjectsCompat.equals(getFirstName(), sender.getFirstName()) &&
              ObjectsCompat.equals(getAddress(), sender.getAddress()) &&
              ObjectsCompat.equals(getKnownTravelerNumber(), sender.getKnownTravelerNumber()) &&
              ObjectsCompat.equals(getLastName(), sender.getLastName()) &&
              ObjectsCompat.equals(getCreatedAt(), sender.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), sender.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getFirstName())
      .append(getAddress())
      .append(getKnownTravelerNumber())
      .append(getLastName())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Sender {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("firstName=" + String.valueOf(getFirstName()) + ", ")
      .append("Address=" + String.valueOf(getAddress()) + ", ")
      .append("KnownTravelerNumber=" + String.valueOf(getKnownTravelerNumber()) + ", ")
      .append("lastName=" + String.valueOf(getLastName()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static FirstNameStep builder() {
      return new Builder();
  }
  
  /** 
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static Sender justId(String id) {
    return new Sender(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      firstName,
      Address,
      KnownTravelerNumber,
      lastName);
  }
  public interface FirstNameStep {
    AddressStep firstName(String firstName);
  }
  

  public interface AddressStep {
    LastNameStep address(String address);
  }
  

  public interface LastNameStep {
    BuildStep lastName(String lastName);
  }
  

  public interface BuildStep {
    Sender build();
    BuildStep id(String id);
    BuildStep knownTravelerNumber(String knownTravelerNumber);
  }
  

  public static class Builder implements FirstNameStep, AddressStep, LastNameStep, BuildStep {
    private String id;
    private String firstName;
    private String Address;
    private String lastName;
    private String KnownTravelerNumber;
    @Override
     public Sender build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Sender(
          id,
          firstName,
          Address,
          KnownTravelerNumber,
          lastName);
    }
    
    @Override
     public AddressStep firstName(String firstName) {
        Objects.requireNonNull(firstName);
        this.firstName = firstName;
        return this;
    }
    
    @Override
     public LastNameStep address(String address) {
        Objects.requireNonNull(address);
        this.Address = address;
        return this;
    }
    
    @Override
     public BuildStep lastName(String lastName) {
        Objects.requireNonNull(lastName);
        this.lastName = lastName;
        return this;
    }
    
    @Override
     public BuildStep knownTravelerNumber(String knownTravelerNumber) {
        this.KnownTravelerNumber = knownTravelerNumber;
        return this;
    }
    
    /** 
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String firstName, String address, String knownTravelerNumber, String lastName) {
      super.id(id);
      super.firstName(firstName)
        .address(address)
        .lastName(lastName)
        .knownTravelerNumber(knownTravelerNumber);
    }
    
    @Override
     public CopyOfBuilder firstName(String firstName) {
      return (CopyOfBuilder) super.firstName(firstName);
    }
    
    @Override
     public CopyOfBuilder address(String address) {
      return (CopyOfBuilder) super.address(address);
    }
    
    @Override
     public CopyOfBuilder lastName(String lastName) {
      return (CopyOfBuilder) super.lastName(lastName);
    }
    
    @Override
     public CopyOfBuilder knownTravelerNumber(String knownTravelerNumber) {
      return (CopyOfBuilder) super.knownTravelerNumber(knownTravelerNumber);
    }
  }
  
}
