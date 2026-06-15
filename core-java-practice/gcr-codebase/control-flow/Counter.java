class Counter {
    public static void main(String[] args) {                
        // create the counter variable
        int counter = 0;        

        // print the counter if odd
        while (counter <= 10) {
            counter = counter + 1;
            if (counter % 2 == 0) continue;
            if (counter % 7 == 0) break;
            System.out.println("Counter = " + counter);
        }
    }
}
