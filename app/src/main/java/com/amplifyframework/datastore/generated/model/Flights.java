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

/** This is an auto generated class representing the Flights type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Flights", authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
@Index(name = "byFlyer", fields = {"flyerID"})
@Index(name = "bySender", fields = {"senderID"})
public final class Flights implements Model {
  public static final QueryField ID = field("Flights", "id");
  public static final QueryField FROM_DESTINATION = field("Flights", "from_destination");
  public static final QueryField TO_DESTINATION = field("Flights", "to_destination");
  public static final QueryField FLYER_ID = field("Flights", "flyerID");
  public static final QueryField SENDER_ID = field("Flights", "senderID");
  public static final QueryField FLIGHT_NUMBER = field("Flights", "flight_number");
  public static final QueryField FLIGHT_START_DATE = field("Flights", "flight_start_date");
  public static final QueryField FLIGHT_END_DATE = field("Flights", "flight_end_date");
  public static final QueryField NUMBER_OF_LUGGAGE_SENT = field("Flights", "number_of_luggage_sent");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String from_destination;
  private final @ModelField(targetType="String", isRequired = true) String to_destination;
  private final @ModelField(targetType="ID", isRequired = true) String flyerID;
  private final @ModelField(targetType="ID", isRequired = true) String senderID;
  private final @ModelField(targetType="String", isRequired = true) String flight_number;
  private final @ModelField(targetType="ItemsSent") @HasMany(associatedWith = "flightsID", type = ItemsSent.class) List<ItemsSent> ItemsSentsOnFlights = null;
  private final @ModelField(targetType="AWSDateTime", isRequired = true) Temporal.DateTime flight_start_date;
  private final @ModelField(targetType="AWSDateTime", isRequired = true) Temporal.DateTime flight_end_date;
  private final @ModelField(targetType="Int", isRequired = true) Integer number_of_luggage_sent;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public String getFromDestination() {
      return from_destination;
  }
  
  public String getToDestination() {
      return to_destination;
  }
  
  public String getFlyerId() {
      return flyerID;
  }
  
  public String getSenderId() {
      return senderID;
  }
  
  public String getFlightNumber() {
      return flight_number;
  }
  
  public List<ItemsSent> getItemsSentsOnFlights() {
      return ItemsSentsOnFlights;
  }
  
  public Temporal.DateTime getFlightStartDate() {
      return flight_start_date;
  }
  
  public Temporal.DateTime getFlightEndDate() {
      return flight_end_date;
  }
  
  public Integer getNumberOfLuggageSent() {
      return number_of_luggage_sent;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Flights(String id, String from_destination, String to_destination, String flyerID, String senderID, String flight_number, Temporal.DateTime flight_start_date, Temporal.DateTime flight_end_date, Integer number_of_luggage_sent) {
    this.id = id;
    this.from_destination = from_destination;
    this.to_destination = to_destination;
    this.flyerID = flyerID;
    this.senderID = senderID;
    this.flight_number = flight_number;
    this.flight_start_date = flight_start_date;
    this.flight_end_date = flight_end_date;
    this.number_of_luggage_sent = number_of_luggage_sent;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Flights flights = (Flights) obj;
      return ObjectsCompat.equals(getId(), flights.getId()) &&
              ObjectsCompat.equals(getFromDestination(), flights.getFromDestination()) &&
              ObjectsCompat.equals(getToDestination(), flights.getToDestination()) &&
              ObjectsCompat.equals(getFlyerId(), flights.getFlyerId()) &&
              ObjectsCompat.equals(getSenderId(), flights.getSenderId()) &&
              ObjectsCompat.equals(getFlightNumber(), flights.getFlightNumber()) &&
              ObjectsCompat.equals(getFlightStartDate(), flights.getFlightStartDate()) &&
              ObjectsCompat.equals(getFlightEndDate(), flights.getFlightEndDate()) &&
              ObjectsCompat.equals(getNumberOfLuggageSent(), flights.getNumberOfLuggageSent()) &&
              ObjectsCompat.equals(getCreatedAt(), flights.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), flights.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getFromDestination())
      .append(getToDestination())
      .append(getFlyerId())
      .append(getSenderId())
      .append(getFlightNumber())
      .append(getFlightStartDate())
      .append(getFlightEndDate())
      .append(getNumberOfLuggageSent())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Flights {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("from_destination=" + String.valueOf(getFromDestination()) + ", ")
      .append("to_destination=" + String.valueOf(getToDestination()) + ", ")
      .append("flyerID=" + String.valueOf(getFlyerId()) + ", ")
      .append("senderID=" + String.valueOf(getSenderId()) + ", ")
      .append("flight_number=" + String.valueOf(getFlightNumber()) + ", ")
      .append("flight_start_date=" + String.valueOf(getFlightStartDate()) + ", ")
      .append("flight_end_date=" + String.valueOf(getFlightEndDate()) + ", ")
      .append("number_of_luggage_sent=" + String.valueOf(getNumberOfLuggageSent()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static FromDestinationStep builder() {
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
  public static Flights justId(String id) {
    return new Flights(
      id,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      from_destination,
      to_destination,
      flyerID,
      senderID,
      flight_number,
      flight_start_date,
      flight_end_date,
      number_of_luggage_sent);
  }
  public interface FromDestinationStep {
    ToDestinationStep fromDestination(String fromDestination);
  }
  

  public interface ToDestinationStep {
    FlyerIdStep toDestination(String toDestination);
  }
  

  public interface FlyerIdStep {
    SenderIdStep flyerId(String flyerId);
  }
  

  public interface SenderIdStep {
    FlightNumberStep senderId(String senderId);
  }
  

  public interface FlightNumberStep {
    FlightStartDateStep flightNumber(String flightNumber);
  }
  

  public interface FlightStartDateStep {
    FlightEndDateStep flightStartDate(Temporal.DateTime flightStartDate);
  }
  

  public interface FlightEndDateStep {
    NumberOfLuggageSentStep flightEndDate(Temporal.DateTime flightEndDate);
  }
  

  public interface NumberOfLuggageSentStep {
    BuildStep numberOfLuggageSent(Integer numberOfLuggageSent);
  }
  

  public interface BuildStep {
    Flights build();
    BuildStep id(String id);
  }
  

  public static class Builder implements FromDestinationStep, ToDestinationStep, FlyerIdStep, SenderIdStep, FlightNumberStep, FlightStartDateStep, FlightEndDateStep, NumberOfLuggageSentStep, BuildStep {
    private String id;
    private String from_destination;
    private String to_destination;
    private String flyerID;
    private String senderID;
    private String flight_number;
    private Temporal.DateTime flight_start_date;
    private Temporal.DateTime flight_end_date;
    private Integer number_of_luggage_sent;
    @Override
     public Flights build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Flights(
          id,
          from_destination,
          to_destination,
          flyerID,
          senderID,
          flight_number,
          flight_start_date,
          flight_end_date,
          number_of_luggage_sent);
    }
    
    @Override
     public ToDestinationStep fromDestination(String fromDestination) {
        Objects.requireNonNull(fromDestination);
        this.from_destination = fromDestination;
        return this;
    }
    
    @Override
     public FlyerIdStep toDestination(String toDestination) {
        Objects.requireNonNull(toDestination);
        this.to_destination = toDestination;
        return this;
    }
    
    @Override
     public SenderIdStep flyerId(String flyerId) {
        Objects.requireNonNull(flyerId);
        this.flyerID = flyerId;
        return this;
    }
    
    @Override
     public FlightNumberStep senderId(String senderId) {
        Objects.requireNonNull(senderId);
        this.senderID = senderId;
        return this;
    }
    
    @Override
     public FlightStartDateStep flightNumber(String flightNumber) {
        Objects.requireNonNull(flightNumber);
        this.flight_number = flightNumber;
        return this;
    }
    
    @Override
     public FlightEndDateStep flightStartDate(Temporal.DateTime flightStartDate) {
        Objects.requireNonNull(flightStartDate);
        this.flight_start_date = flightStartDate;
        return this;
    }
    
    @Override
     public NumberOfLuggageSentStep flightEndDate(Temporal.DateTime flightEndDate) {
        Objects.requireNonNull(flightEndDate);
        this.flight_end_date = flightEndDate;
        return this;
    }
    
    @Override
     public BuildStep numberOfLuggageSent(Integer numberOfLuggageSent) {
        Objects.requireNonNull(numberOfLuggageSent);
        this.number_of_luggage_sent = numberOfLuggageSent;
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
    private CopyOfBuilder(String id, String fromDestination, String toDestination, String flyerId, String senderId, String flightNumber, Temporal.DateTime flightStartDate, Temporal.DateTime flightEndDate, Integer numberOfLuggageSent) {
      super.id(id);
      super.fromDestination(fromDestination)
        .toDestination(toDestination)
        .flyerId(flyerId)
        .senderId(senderId)
        .flightNumber(flightNumber)
        .flightStartDate(flightStartDate)
        .flightEndDate(flightEndDate)
        .numberOfLuggageSent(numberOfLuggageSent);
    }
    
    @Override
     public CopyOfBuilder fromDestination(String fromDestination) {
      return (CopyOfBuilder) super.fromDestination(fromDestination);
    }
    
    @Override
     public CopyOfBuilder toDestination(String toDestination) {
      return (CopyOfBuilder) super.toDestination(toDestination);
    }
    
    @Override
     public CopyOfBuilder flyerId(String flyerId) {
      return (CopyOfBuilder) super.flyerId(flyerId);
    }
    
    @Override
     public CopyOfBuilder senderId(String senderId) {
      return (CopyOfBuilder) super.senderId(senderId);
    }
    
    @Override
     public CopyOfBuilder flightNumber(String flightNumber) {
      return (CopyOfBuilder) super.flightNumber(flightNumber);
    }
    
    @Override
     public CopyOfBuilder flightStartDate(Temporal.DateTime flightStartDate) {
      return (CopyOfBuilder) super.flightStartDate(flightStartDate);
    }
    
    @Override
     public CopyOfBuilder flightEndDate(Temporal.DateTime flightEndDate) {
      return (CopyOfBuilder) super.flightEndDate(flightEndDate);
    }
    
    @Override
     public CopyOfBuilder numberOfLuggageSent(Integer numberOfLuggageSent) {
      return (CopyOfBuilder) super.numberOfLuggageSent(numberOfLuggageSent);
    }
  }
  
}
