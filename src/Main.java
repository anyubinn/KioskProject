import java.util.ArrayList;
import java.util.List;
import menu.Menu;
import menu.MenuItem;

public class Main {
    public static void main(String[] args) {
        List<Menu> menus = new ArrayList<>();
        List<MenuItem> burgersMenuItems = new ArrayList<>();
        List<MenuItem> drinksMenuItems = new ArrayList<>();
        List<MenuItem> dessertsMenuItems = new ArrayList<>();

        burgersMenuItems.add(new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgersMenuItems.add(new MenuItem("SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgersMenuItems.add(new MenuItem("Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgersMenuItems.add(new MenuItem("Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"));

        drinksMenuItems.add(new MenuItem("StrwaberryPeachTea", 5000, "레몬에이드에 아이스티와 상큼한 딸기, 복숭아 맛을 더한 시즈널 레몬에이드"));
        drinksMenuItems.add(new MenuItem("Lemonade", 4500, "매장에서 직접 만드는 상큼한 레몬에이드"));
        drinksMenuItems.add(new MenuItem("FountainSoda", 2900, "코카콜라, 코카콜라 제로, 스프라이트, 환타 오렌지, 환타 그레이프, 환타 파인애플"));
        drinksMenuItems.add(new MenuItem("ShackLatte", 4500, "에스프레소에 부드러운 우유를 더한 라떼"));

        dessertsMenuItems.add(new MenuItem("ClassicShakes", 6800, "쫀득하고 진한 커스터드가 들어간 클래식 쉐이크"));
        dessertsMenuItems.add(new MenuItem("ShackAttack", 6200, "초콜릿 커스터드에 퍼지 소스와 세 가지 초콜릿 토핑이 블렌딩된 콘크리트"));
        dessertsMenuItems.add(new MenuItem("HoneyButterCrunch", 6200, "바닐라 커스터드에 허니 버터 소스와 슈가콘이 블렌딩된 콘크리트"));

        menus.add(new Menu("Burgers", burgersMenuItems));
        menus.add(new Menu("Drinks", drinksMenuItems));
        menus.add(new Menu("Desserts", dessertsMenuItems));
        Kiosk kiosk = new Kiosk(menus);

        kiosk.start();
    }
}