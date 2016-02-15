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

  public double costToShip(int speed, int distance) {
    int cost = 1000;
    if (distance > 1000) {
      cost += distance * 0.5;
    } else {
      cost += distance * 0.75;
    }

    if (mWeight < 5) {
      cost += 200;
    } else if (mWeight < 20) {
      cost += 300;
    } else if (mWeight < 50) {
      cost += 550;
    } else {
      cost += 900;
    }

    if (mLength + mWidth + mHeight <= 18) {
      cost -= 150;
    } else if (mLength >= 24 || mWidth >= 24 || mHeight >= 24) {
      cost += 350;
    }
    cost *= speed;
    return (double) cost / 100;
  }

  public double surfaceArea() {
    return ((mLength * mWidth) + (mLength * mHeight) + (mWidth * mHeight)) * 2;
  }

  public double giftWrap(int paper) {
    int cost = 0;
    cost += surfaceArea() * 10 * paper;

    return (double) cost / 100;
  }
}
