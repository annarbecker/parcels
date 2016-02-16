import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();
  // Unit testing

  //Integration testing
  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Calculate shipping costs");
  }

  @Test
  public void createParcelTest() {
    goTo("http://localhost:4567/");
    fill("#length").with("8.5");
    fill("#width").with("5.5");
    fill("#height").with("6.7");
    fill("#weight").with("15");
    submit("#parcelSubmit");
    assertThat(pageSource()).contains("8.5 inches by 5.5 inches by 6.7 inches");
  }

  @Test
  public void estimateShipping() {
    goTo("http://localhost:4567/");
    fill("#length").with("8.5");
    fill("#width").with("5.5");
    fill("#height").with("6.7");
    fill("#weight").with("15");
    submit("#parcelSubmit");
    fill("#distance").with("2000");
    click("#ground");
    submit("#shippingSubmit");
    assertThat(pageSource()).contains("volume is 313.2");
  }

  @Test
  public void addGiftWrap() {
    goTo("http://localhost:4567/");
    fill("#length").with("8.5");
    fill("#width").with("5.5");
    fill("#height").with("6.7");
    fill("#weight").with("15");
    submit("#parcelSubmit");
    fill("#distance").with("2000");
    click("#ground");
    submit("#shippingSubmit");
    click("#discount");
    submit("#giftSubmit");
    assertThat(pageSource()).contains("28.11");
  }
}
