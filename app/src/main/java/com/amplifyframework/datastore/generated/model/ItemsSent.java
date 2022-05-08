package com.amplifyframework.datastore.generated.model;

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

/** This is an auto generated class representing the ItemsSent type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "ItemsSents", authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
@Index(name = "byFlights", fields = {"flightsID"})
public final class ItemsSent implements Model {
  public static final QueryField ID = field("ItemsSent", "id");
  public static final QueryField ITEM_SENT = field("ItemsSent", "itemSent");
  public static final QueryField FLIGHTS_ID = field("ItemsSent", "flightsID");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String") List<String> itemSent;
  private final @ModelField(targetType="ID", isRequired = true) String flightsID;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public List<String> getItemSent() {
      return itemSent;
  }
  
  public String getFlightsId() {
      return flightsID;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private ItemsSent(String id, List<String> itemSent, String flightsID) {
    this.id = id;
    this.itemSent = itemSent;
    this.flightsID = flightsID;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      ItemsSent itemsSent = (ItemsSent) obj;
      return ObjectsCompat.equals(getId(), itemsSent.getId()) &&
              ObjectsCompat.equals(getItemSent(), itemsSent.getItemSent()) &&
              ObjectsCompat.equals(getFlightsId(), itemsSent.getFlightsId()) &&
              ObjectsCompat.equals(getCreatedAt(), itemsSent.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), itemsSent.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getItemSent())
      .append(getFlightsId())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("ItemsSent {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("itemSent=" + String.valueOf(getItemSent()) + ", ")
      .append("flightsID=" + String.valueOf(getFlightsId()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static Builder builder() {
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
  public static ItemsSent justId(String id) {
    return new ItemsSent(
      id,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      itemSent,
      flightsID);
  }
  public interface FlightsIdStep {
    BuildStep flightsId(String flightsId);
  }
  

  public interface BuildStep {
    ItemsSent build();
    BuildStep id(String id);
    BuildStep itemSent(List<String> itemSent);
  }
  

  public static class Builder implements FlightsIdStep, BuildStep {
    private String id;
    private String flightsID;
    private List<String> itemSent;
    @Override
     public ItemsSent build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new ItemsSent(
          id,
          itemSent,
          flightsID);
    }
    
    @Override
     public BuildStep flightsId(String flightsId) {
        Objects.requireNonNull(flightsId);
        this.flightsID = flightsId;
        return this;
    }
    
    @Override
     public BuildStep itemSent(List<String> itemSent) {
        this.itemSent = itemSent;
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
    private CopyOfBuilder(String id, List<String> itemSent, String flightsId) {
      super.id(id);
      super.itemSent(itemSent);
      super.flightsId(flightsId);
    }
    
    @Override
     public CopyOfBuilder itemSent(List<String> itemSent) {
      return (CopyOfBuilder) super.itemSent(itemSent);
    }
    
    @Override
     public CopyOfBuilder flightsId(String flightsId) {
      return (CopyOfBuilder) super.flightsId(flightsId);
    }
  }
  
}
