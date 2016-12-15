package net.smc;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Arrays;
import java.util.Properties;

/**
 * Created by 念梓  on 2016/12/15.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public class KafkaTest {

    public static void main(String[] args) {
        KafkaTest kafkaTest = new KafkaTest();
//        kafkaTest.createData();
        kafkaTest.getData();
    }
    public void createData() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "1551sp9557.imwork.net:5555");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("request.timeout.ms",1000000000);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");


//        KafkaProducer kafkaProducer = new KafkaProducer(props);
//        ProducerRecord<String,String> producerRecord = new ProducerRecord<>("mytest","hello","mybaby");
//        kafkaProducer.send(producerRecord);

        Producer<String, String> producer = new KafkaProducer<>(props);
        for(int i = 0; i < 100; i++)
            producer.send(new ProducerRecord<String, String>("myp", Integer.toString(i), Integer.toString(i)));

        producer.close();

        System.out.println("=======成功发送======");
//        kafkaProducer.close();
//        kafkaProducer.send();

    }


    public void getData(){
        Properties props = new Properties();
        props.put("bootstrap.servers", "1551sp9557.imwork.net:5555");
        props.put("group.id", "ttt");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("test"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records)
                System.out.printf("offset = %d, key = %s, value = %s", record.offset(), record.key(), record.value());
        }
    }

}
