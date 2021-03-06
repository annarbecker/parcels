import java.util.HashMap;
import java.text.*;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("parcel", request.session().attribute("parcel"));

      model.put("template", "templates/parcel.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/parcel", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Double length = Double.parseDouble(request.queryParams("length"));
      Double width = Double.parseDouble(request.queryParams("width"));
      Double height = Double.parseDouble(request.queryParams("height"));
      Double weight = Double.parseDouble(request.queryParams("weight"));
      Parcel newParcel = new Parcel(length, width, height, weight);
      request.session().attribute("parcel", newParcel);
      model.put("parcel", newParcel);
      model.put("template", "templates/parcel.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/shipping", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int speed = Integer.parseInt(request.queryParams("speed"));
      int distance = Integer.parseInt(request.queryParams("distance"));
      double shipmentCost = ((Parcel) request.session().attribute("parcel")).costToShip(speed, distance);
      request.session().attribute("shipmentCost", shipmentCost);
      String cost = NumberFormat.getCurrencyInstance().format(shipmentCost);
      String volume = String.format("%.4f", ((Parcel) request.session().attribute("parcel")).volume());
      model.put("parcel", request.session().attribute("parcel"));
      model.put("volume", volume);
      model.put("cost", cost);
      model.put("speed", speed);
      model.put("distance", distance);
      model.put("template", "templates/parcel.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/gift", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int giftType = Integer.parseInt(request.queryParams("gift"));
      String giftCost = NumberFormat.getCurrencyInstance().format(((Parcel) request.session().attribute("parcel")).giftWrap(giftType));
      double shipmentCost = (double) request.session().attribute("shipmentCost");
      double totalCost =  shipmentCost + ((Parcel) request.session().attribute("parcel")).giftWrap(giftType);
      model.put("totalCost", NumberFormat.getCurrencyInstance().format(totalCost));
      model.put("parcel", request.session().attribute("parcel"));
      model.put("giftType", giftType);
      model.put("giftCost", giftCost);
      model.put("template", "templates/parcel.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
