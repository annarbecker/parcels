public class Parcel {

  private double mLength;
  private double mWidth;
  private double mHeight;
  private double mWeight;

  public Parcel(double length, double width, double height, double weight) {
    mLength = length;
    mWidth = width;
    mHeight = height;
    mWeight = weight;
  }

  public double volume() {
    return mLength * mWidth * mHeight;
  }
}
