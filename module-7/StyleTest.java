public class StyleTest {

    public static void main(String[] args) {

        // Test that CSS is loading
        try {
            String css = StyleCircleDemo.class.getResource("mystyle.css").toExternalForm();
            if (css != null && css.endsWith("mystyle.css")) {
                System.out.println("✓ CSS loaded successfully.");
            } else {
                System.out.println("✗ CSS not found.");
            }
        } catch (Exception e) {
            System.out.println("✗ Error loading CSS: " + e.getMessage());
        }

        // Launch GUI manually to visually confirm
        System.out.println("Launching JavaFX window...");
        StyleCircleDemo.main(null);
    }
}
