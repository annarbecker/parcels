import java.util.HashMap;

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
  }
}
