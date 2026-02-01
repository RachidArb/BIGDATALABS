package edu.supmit.hadoop;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

public class WriteHDFS {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Usage: WriteHDFS <file_path> <content>");
            System.exit(1);
        }
        
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(conf);
        Path filePath = new Path(args[0]);
        
        if (fs.exists(filePath)) {
            System.out.println("File already exists: " + args[0]);
            System.exit(1);
        }
        
        FSDataOutputStream outStream = fs.create(filePath);
        outStream.writeUTF("Bonjour tout le monde !\n");
        outStream.writeUTF(args[1] + "\n");
        outStream.close();
        fs.close();
        
        System.out.println("File created successfully: " + args[0]);
    }
}