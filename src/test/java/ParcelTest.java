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

  @Test
  public void costToShip_returnsPriceWithGivenDimensions_dollarAmount() {
    Parcel testParcel = new Parcel(3.1, 4.0, 6.0, 12.5);
    assertEquals(23.36, testParcel.costToShip(2, 25), 0);
  }

  @Test
  public void costToShip_returnsHigherPriceWithGivenDimensions_dollarAmount() {
    Parcel testParcel = new Parcel(3.1, 24.0, 6.0, 55);
    assertEquals(89.97, testParcel.costToShip(3, 999), 0);
  }

  @Test
  public void surfaceArea_calculateSurfaceWithGivenDimensions_parcelSurface() {
    Parcel testParcel = new Parcel(3, 4, 5, 12.5);
    assertEquals(94, testParcel.surfaceArea(), 0);
  }

  @Test
  public void giftWrap_calculateGiftWrapWithGivenDimensions_wrapCost() {
    Parcel testParcel = new Parcel(3, 4, 5, 12.5);
    assertEquals(9.4, testParcel.giftWrap(1), 0);
  }

}
