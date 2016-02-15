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
    Parcel testParcel = new Parcel(3.1, 4.0, 6.0, 12.5);
    assertEquals(74.4, testParcel.volume(), 0);
  }
}
