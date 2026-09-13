package TP13;

import java.io.*;
import java.time.Instant;

public class Chat implements Externalizable {

    String user;
    String message;
    Instant timestamp;
    transient int length;

    public Chat() {
    }

    public Chat(String user, String message) {
        this.user = user;
        this.message = message;
        this.timestamp = Instant.now();
        this.length = message.length();
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(user);
        out.writeUTF(message);
        out.writeLong(timestamp.toEpochMilli());
    }

    public void readExternal(ObjectInput in) throws IOException {
        user = in.readUTF();
        message = in.readUTF();
        timestamp = Instant.ofEpochMilli(in.readLong());
        length = message.length();
    }

    public int getLength() {
        return length;
    }

    public String toString() {
        return "[" + user + "]: " + message;
    }

}
