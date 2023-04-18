import java.io.*;
import java.lang.invoke.StringConcatFactory;
import java.net.*;
import java.util.concurrent.*;
import java.util.Random;

public class UDPServer {
    static ExecutorService exec = null;
    static Random random = new Random();
    static String[] quotes = new String[] {
        "Please consider me as an alternative to suicide.",
        "Fear is a tool […] They think I am hiding in the shadows. But I am the shadows.",
        "The greatest glory in living lies not in never falling, but in rising every time we fall.",
        "The way to get started is to quit talking and begin doing",
        "Your time is limited, so don't waste it living someone else's life. Don't be trapped by dogma  which is living with the results of other people's thinking",
        "If life were predictable it would cease to be life, and be without flavor",
        "If you look at what you have in life, you'll always have more. If you look at what you don't have in life, you'll never have enough",
        "If you set your goals ridiculously high and it's a failure, you will fail above everyone else's success. -James Cameron",
        "Life is what happens when you're busy making other plans. -John Lennon",
        "Spread love everywhere you go. Let no one ever come to you without leaving happier. -Mother Teresa",
        "When you reach the end of your rope, tie a knot in it and hang on. -Franklin D. Roosevelt",
        "Always remember that you are absolutely unique. Just like everyone else. -Margaret Mead",
        "Don't judge each day by the harvest you reap but by the seeds that you plant.",
        "The future belongs to those who believe in the beauty of their dreams.",
        "Tell me and I forget. Teach me and I remember. Involve me and I learn. ",
        "The best and most beautiful things in the world cannot be seen or even touched — they must be felt with the heart.",
        "It is during our darkest moments that we must focus to see the light.",
        "Do not go where the path may lead, go instead where there is no path and leave a trail. -Ralph Waldo Emerson",
        "Spread love everywhere you go. Let no one ever come to you without leaving happier.",
        "When you reach the end of your rope, tie a knot in it and hang on.",
        "Always remember that you are absolutely unique. Just like everyone else.",
        "Don't judge each day by the harvest you reap but by the seeds that you plant.",
        "The future belongs to those who believe in the beauty of their dreams.",
        "Tell me and I forget. Teach me and I remember. Involve me and I learn.",
        "The best and most beautiful things in the world cannot be seen or even touched - they must be felt with the heart.",
        "It is during our darkest moments that we must focus to see the light.",
        "Whoever is happy will make others happy too.",
        "Do not go where the path may lead, go instead where there is no path and leave a trail."
    };
    public static void main(String[] args) {
        try {
            byte[] receiveData = new byte[1024];
            while (true) {
                DatagramSocket serverSocket = new DatagramSocket(17);
                int number = random.nextInt(28);
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                String quote = quotes[number];
                byte[] sendData = quote.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                serverSocket.send(sendPacket);
                serverSocket.close();
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } 
    }
}
