package chris.dream.io.nio;

import java.io.*;
import java.nio.Buffer;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 3:53 2018-12-27
 */
public class MappedIO {
    private static final int numOfInts = 4000000;
    private static final int numOfUbuffInts = 200000;

    private static final String filename = "nio_MappedIO.txt";

    private abstract static class Testr {
        private String name;

        public Testr(String name) {
            this.name = name;
        }

        public void runTest() {
            System.out.print(name + ":");
            try {
                long start = System.nanoTime();
                test();
                double duration = System.nanoTime() - start;
                System.out.format("%.2f\n", duration / 1.0e9);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public abstract void test() throws IOException;
    }

    private static Testr[] tests = {
            new Testr("Stream write") {
                @Override
                public void test() throws IOException {
                    DataOutputStream dataOutputStream = new DataOutputStream(
                            new BufferedOutputStream(
                                    new FileOutputStream(filename)
                            )
                    );
                    for (int i = 0; i < numOfInts; i++) {
                        dataOutputStream.write(i);
                    }
                    dataOutputStream.close();
                }
            },
            new Testr("Mapped write") {
                @Override
                public void test() throws IOException {
                    FileChannel fileChannel = new RandomAccessFile(filename, "rw")
                            .getChannel();
                    IntBuffer intBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE,
                            0, fileChannel.size())
                            .asIntBuffer();
                    for (int i = 0; i < numOfInts; i++) {
                        intBuffer.put(i);
                    }
                    fileChannel.close();
                }
            },
            new Testr("Stream read") {
                @Override
                public void test() throws IOException {
                    DataInputStream dataInputStream = new DataInputStream(
                            new BufferedInputStream(
                                    new FileInputStream(filename)
                            )
                    );
                    for (int i = 0; i < numOfInts; i++) {
                        dataInputStream.readInt();
                    }
                    dataInputStream.close();
                }
            },
            new Testr("Mapped read") {
                @Override
                public void test() throws IOException {
                    FileChannel fileChannel = new RandomAccessFile(filename, "rw")
                            .getChannel();
                    IntBuffer intBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE,
                            0, fileChannel.size())
                            .asIntBuffer();
                    intBuffer.flip();
                    while (intBuffer.hasRemaining()) {
                        intBuffer.get();
                    }
                    fileChannel.close();
                }
            },
            new Testr("Stream read/write") {
                @Override
                public void test() throws IOException {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(filename, "rw");
                    randomAccessFile.writeInt(1);
                    for (int i = 0; i < numOfUbuffInts; i++) {
                        randomAccessFile.seek(randomAccessFile.length() - 4);
                        randomAccessFile.writeInt(randomAccessFile.readInt());
                    }
                    randomAccessFile.close();
                }
            },
            new Testr("Mapped read/write") {
                @Override
                public void test() throws IOException {
                    FileChannel fileChannel = new RandomAccessFile(filename, "wr")
                            .getChannel();
                    IntBuffer intBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE,
                            0, fileChannel.size()).asIntBuffer();
                    intBuffer.put(0);
                    for (int i = 1; i < numOfUbuffInts; i++) {
                        intBuffer.put(intBuffer.get(i - 1));
                    }
                    fileChannel.close();
                }
            }
    };

    public static void main(String[] args) {
        for(Testr test : tests){
            test.runTest();
        }
    }
}
