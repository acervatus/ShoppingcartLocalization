import java.util.ResourceBundle;
import java.util.Locale;
import java.util.Scanner;
public class ShoppingLocalized {
    public static String GetLocalizedMessage(String key, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("MessagesBundle", locale);
        return bundle.getString(key);
    }
    public static class ShoppingInstance {
        private Locale language;
        private float cartPrice;
        public ShoppingInstance(Locale language) {
            this.language = language;
            cartPrice = 0;
        }
        public float CalculatePrice(int quantity, float price) {
            return quantity * price;
        }
        public void ShoppingActivity() {
            Scanner scanner = new Scanner(System.in);
            System.out.println(GetLocalizedMessage("PurchaseItemCountQuery", language));
            int itemCount = scanner.nextInt();
            for(int a = 0; a < itemCount; a++) {
                System.out.println(GetLocalizedMessage("PurchasePriceQuery", language));
                float price = scanner.nextFloat();
                System.out.println(GetLocalizedMessage("PurchaseQuantityQuery", language));
                int quantity = scanner.nextInt();
                cartPrice += CalculatePrice(quantity, price);
            }
            System.out.println(GetLocalizedMessage("PurchaseCost", language) + " " + cartPrice);
        }
    }
    public void StartWithLanguage() {
        Locale language;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose Language: \n0: English \n1: Finnish \n2: Swedish \n3: Japanese");
        language = switch(scanner.nextInt()) {
            case 0 -> new Locale("en", "US");
            case 1 -> new Locale("fi", "FI");
            case 2 -> new Locale("sv", "SE");
            case 3 -> new Locale("ja", "JP");
            default -> new Locale("en", "US");
        };
        ShoppingInstance shoppingInstance = new ShoppingInstance(language);
        shoppingInstance.ShoppingActivity();
    }
    public static void main(String[] args) {
        ShoppingLocalized shoppingLocalized = new ShoppingLocalized();
        shoppingLocalized.StartWithLanguage();
    }
}