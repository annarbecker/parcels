import org.junit.*;
import static org.junit.Assert.*;

public class ParcelTest {

  @Test
  public void createNewParcel_instantiatesCorrectly() {
    Parcel testParcel = new Parcel(3.0, 3.0, 3.0, 7.0);
    assertEquals(true, testParcel instanceof Parcel);
  }

  @Test
  public void volume_calculateVolumeWithGivenDimensions_parcelVolume() {
    Parcel testParcel = new Parcel(3.0, 4.0, 5.0, 12.5);
    assertEquals(60.0, testParcel.volume());
  }
}
