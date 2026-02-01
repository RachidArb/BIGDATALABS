package edu.supmit.hadoop;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

public class HadoopFileStatus {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: HadoopFileStatus <file_path> <file_name> <new_file_name>");
            System.exit(1);
        }
        
        Configuration conf = new Configuration();
        FileSystem fs;
        try {
            fs = FileSystem.get(conf);
            Path filepath = new Path(args[0], args[1]);
            FileStatus status = fs.getFileStatus(filepath);
            
            if(!fs.exists(filepath)){
                System.out.println("File does not exists");
                System.exit(1);
            }
            
            System.out.println("File Name: " + filepath.getName());
            System.out.println("File Size: " + status.getLen() + " bytes");
            System.out.println("File owner: " + status.getOwner());
            System.out.println("File permission: " + status.getPermission());
            System.out.println("File Replication: " + status.getReplication());
            System.out.println("File Block Size: " + status.getBlockSize());
            
            BlockLocation[] blockLocations = fs.getFileBlockLocations(status, 0, status.getLen());
            for(BlockLocation blockLocation : blockLocations) {
                String[] hosts = blockLocation.getHosts();
                System.out.println("Block offset: " + blockLocation.getOffset());
                System.out.println("Block length: " + blockLocation.getLength());
                System.out.print("Block hosts: ");
                for (String host : hosts) {
                    System.out.print(host + " ");
                }
                System.out.println();
            }
            
            // Rename file
            Path newPath = new Path(args[0], args[2]);
            fs.rename(filepath, newPath);
            System.out.println("File renamed to: " + args[2]);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}