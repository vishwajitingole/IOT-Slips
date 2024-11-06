// Pizza base class jo har type of Pizza ka blueprint hai
public abstract class Pizza {
    String name;

    // Prepare method jo pizza prepare kar raha hai
    public void prepare() {
        System.out.println("Preparing " + name);
    }

    // Bake method jo pizza ko bake kar raha hai
    public void bake() {
        System.out.println("Baking " + name);
    }

    // Cut method jo pizza ko cut kar raha hai
    public void cut() {
        System.out.println("Cutting " + name);
    }

    // Box method jo pizza ko box me pack kar raha hai
    public void box() {
        System.out.println("Boxing " + name);
    }

    // Getter method for pizza name
    public String getName() {
        return name;
    }
}
