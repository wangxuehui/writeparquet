package org.parquet.WriteParquet;
import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.ql.io.parquet.read.DataWritableReadSupport;
import org.apache.hadoop.io.ArrayWritable;

import parquet.example.data.Group;
import parquet.example.data.simple.SimpleGroup;
import parquet.hadoop.ParquetReader;

public class ReadCord {

    public static void main(String[] args) throws IOException {
        Path path = new Path("hdfs://192.168.0.80//user/hive/warehouse/parquet_example/part_20150716103149");
        ParquetReader<ArrayWritable> reader = ReadCord.getReader(path);
        ArrayWritable content= null;
        int i=0;
        do{
            i++;
            content = reader.read();
            System.out.println(content);
        }while(content != null);
        System.out.println("i counter:"+--i);
        Group group = new SimpleGroup(null);
        group.getGroup("", 0);
    }

    public static ParquetReader<ArrayWritable> getReader(Path path) throws IOException{
        ParquetReader<ArrayWritable> reader = new ParquetReader<ArrayWritable>(path,new DataWritableReadSupport());
        return reader;
        
    }
}
