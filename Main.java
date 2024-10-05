public class Main {
    public static void main(String[] args) {
        Egg egg = new Egg();
        Chicken chicken = new Chicken();
        boolean chickenFirst = false;

        egg.start();
        chicken.start();

        for (int i = 0; i < 10; i++) {
            if (!chickenFirst) {
                chickenFirst = true;
            } else {
                chickenFirst = false;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            egg.join();
            chicken.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (egg.isAlive()) {
            System.out.println("Первым появилось яйцо");
        } else if (chicken.isAlive()) {
            System.out.println("Первой появилась курица");
        } else {
            System.out.println("Неизвестно, что появилось первым");
        }
    }
}

class Egg extends Thread {
    String eggMessage = "Первым появилось яйцо!";

    @Override
    public void run() {
        System.out.println(eggMessage);
    }
}

class Chicken extends Thread {
    String chickenMessage = "Первой появилась курица!";

    @Override
    public void run() {
        System.out.println(chickenMessage);
    }
}
