class Runner {

  volatile boolean running = true;
}

public class App {
  public static void main(String[] args) throws Exception {
    Runner r = new Runner();
    Thread t = new Thread(
        () -> {
          while (r.running) {
            System.out.println(System.currentTimeMillis() + " tick");
            try {
              long now = System.currentTimeMillis();
              long next = ((now / 1000) + 1) * 1000;
              Thread.sleep(next - now);
            } catch (InterruptedException e) {
              r.running = false;
              e.printStackTrace();
            }
          }
          System.out.println("stopped");
        });
    t.start();
    Thread.sleep(5000);
    r.running = false;
    t.join();
  }
}
