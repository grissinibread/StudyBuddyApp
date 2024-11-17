package mongodb;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertManyResult;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Mongo {

  //Test Data List inputted into StudyBuddy DB
  public static List<Recipe> recipes = Arrays.asList(
      new Recipe("elotes",
              Arrays.asList("corn", "mayonnaise", "cotija cheese", "sour cream", "lime" ),
              35),
      new Recipe("loco moco",
              Arrays.asList("ground beef", "butter", "onion", "egg", "bread bun", "mushrooms" ),
              54),
      new Recipe("patatas bravas",
              Arrays.asList("potato", "tomato", "olive oil", "onion", "garlic", "paprika" ),
              80),
      new Recipe("fried rice",
              Arrays.asList("rice", "soy sauce", "egg", "onion", "pea", "carrot", "sesame oil" ),
              40)
  );

  public static void main(String[] args) {
    Logger.getLogger( "org.mongodb.driver" ).setLevel(Level.WARNING);
    String url = "mongodb+srv://chris:da_dawg@studybuddydbs.daex9.mongodb.net/?retryWrites=true&w=majority&appName=studybuddydbs";
    ConnectionString mongoUri = new ConnectionString(url); //Connection with Mongo

    String dbName = "StudyBuddy"; //Accessing Database
    String collectionName = "updawgg"; //Accessing Users collection/database

    // CodecRegistry tells JavaDriver how to move data betw Java POJOs (Plain Old Java Objects) and MongoDB documents
    CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
            fromProviders(PojoCodecProvider.builder().automatic(true).build()));

    // MongoClient defines the connection to our MongoDB datastore instance (Atlas) using MongoClientSettings
    MongoClientSettings settings = MongoClientSettings.builder()
            .codecRegistry(pojoCodecRegistry)
            .applyConnectionString(mongoUri).build();

    MongoClient mongoClient = null;
    try {
       mongoClient = MongoClients.create(settings);
    } catch (MongoException me) {
      System.err.println("Unable to connect to the MongoDB instance due to an error: " + me);
      System.exit(1);
    }

    // MongoDatabase defines a connection StudyBuddy MongoDB database
    MongoDatabase database = mongoClient.getDatabase(dbName);
    // MongoCollection defines a connection to a specific collection of documents in a specific database
    MongoCollection<Recipe> collection = database.getCollection(collectionName, Recipe.class);

    try { //Will create 4 documents & insert all at once
      // recipes is a static variable defined above
      InsertManyResult result = collection.insertMany(recipes); //recipes is the List Test Data
      System.out.println("Inserted " + result.getInsertedIds().size() + " documents.\n");
    } catch (MongoException me) {
      System.err.println("Unable to insert any User Data into MongoDB due to an error: " + me);
      System.exit(1);
    }

    mongoClient.close(); //Close connection with client once done
  }

  // POJO (Plain Old Java Object) class defining a recipe. This class is a POJO because it contains getters and
  // setters for every member variable as well as an empty constructor.
  public static class Recipe {
    private String name;
    private List<String> ingredients;
    private int prepTimeInMinutes;

    public Recipe(String name, List<String> ingredients, int prepTimeInMinutes) {
      this.name = name;
      this.ingredients = ingredients;
      this.prepTimeInMinutes = prepTimeInMinutes;
    }

    // empty constructor required when data is fetched from the database
    // getters and setters are later used to set values for member variables
    public Recipe() {
      ingredients = new ArrayList<String>();
      name = "";
    }

    @Override
    public String toString() {
      final StringBuffer sb = new StringBuffer("Recipe{");
      sb.append("name=").append(name);
      sb.append(", ingredients=").append(ingredients);
      sb.append(", prepTimeInMinutes=").append(prepTimeInMinutes);
      sb.append('}');
      return sb.toString();
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public List<String> getIngredients() {
      return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
      this.ingredients = ingredients;
    }

    public int getPrepTimeInMinutes() {
      return prepTimeInMinutes;
    }

    public void setPrepTimeInMinutes(int prepTimeInMinutes) {
      this.prepTimeInMinutes = prepTimeInMinutes;
    }
  }
}
