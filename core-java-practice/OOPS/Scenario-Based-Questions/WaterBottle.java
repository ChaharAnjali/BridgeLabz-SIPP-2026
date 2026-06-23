class WaterBottle {
    String ownerName;
    int dailyTarget;

    WaterBottle(String ownerName, int dailyTarget) {
       this.ownerName = ownerName;
       this.dailyTarget = dailyTarget;
    }
    void displayBottleInfo() {
       System.out.println("Owner Name:" + ownerName);
       System.out.println("DailyTarget:" + dailyTarget + "ml");
    }
    public static void main(String[] args) {
        WaterBottle bottleb1 = new WaterBottle("AC", 5000);
        WaterBottle bottleb2 = new WaterBottle("Anu", 6000);

        System.out.println("Bottle 1 Details:");
        bottleb1.displayBottleInfo();
        System.out.println();
        System.out.println("Bottle 2 Deatils:");
        bottleb2.displayBottleInfo();
    }
}