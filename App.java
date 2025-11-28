class Runner {

  volatile boolean running = true;
}

public class App {
  public static void main(String[] args) throws Exception {
    Runner r = new Runner();
    Thread t = new Thread(
        () -> {
          while (r.running) {
            System.out.println("tick");
            try {
              Thread.sleep(1000);
            } catch (InterruptedException e) {
              // TODO Auto-generated catch block
                r.running = false;
              e.printStackTrace();
            }
          }
          System.out.println("stopped");
        });
        t.start();
        Thread.sleep(5000);
        r.running = false;
  }
}
