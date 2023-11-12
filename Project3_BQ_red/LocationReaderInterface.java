import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface LocationReaderInterface{
  public List<LocationInterface> readLocationsFromFile(String filename) throws FileNotFoundException;
  public List<LocationInterface> getLocations();
}
