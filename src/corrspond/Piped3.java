package corrspond;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
//经过思考，我认为管道流应用的经典场景应该是将某个输入流从一个线程通过管道发送到另一个线程进行处理，从而提升程
//序效率。例如：线程A负责从网络上持续读取信息，线程B负责处理信息，那么线程A就会将读取的信息通过管道流发送至线程B，从而确保线程A的读取性能。
//下面的例子中，Sender线程从文件中读取未知长度的字节流，然后交给Reciever线程，Reciever线程将此字节流存入另一个文件：
public class Piped3 {
    public static void main(String[] args) {
        try {
            PipedInputStream pis = new PipedInputStream();
            PipedOutputStream pos = new PipedOutputStream(pis);

            Sender sender = new Sender(pos);
            Reciever reciever = new Reciever(pis);

            ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.execute(sender);
            executorService.execute(reciever);

            executorService.shutdown();
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Sender extends Thread {
        private PipedOutputStream pos = null;

        public Sender(PipedOutputStream pos) {
            this.pos = pos;
        }

        @Override
        public void run() {
            try {
                FileInputStream fis = new FileInputStream("d:\\input.txt");
                byte[] buf = new byte[1024];
                int len = 0;
                while ((len = fis.read(buf)) != -1) {
                    pos.write(buf, 0, len);
                }
                pos.flush();
                pos.close();
                fis.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class Reciever extends Thread {
        private PipedInputStream pis = null;

        public Reciever(PipedInputStream pis) {
            this.pis = pis;
        }

        @Override
        public void run() {
            try {
                FileOutputStream fos = new FileOutputStream("d:\\output.txt");
                byte[] buf = new byte[1024];
                int len = 0;
                while ((len = pis.read(buf)) != -1) {
                    fos.write(buf, 0, len);
                }
                fos.flush();
                fos.close();
                pis.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
