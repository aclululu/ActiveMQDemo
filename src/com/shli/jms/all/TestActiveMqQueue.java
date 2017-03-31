package com.shli.jms.all;

import javax.jms.JMSException;

public class TestActiveMqQueue {
	 public static void main(String[] args) throws InterruptedException, JMSException
	 {
	     ActivemqQueueProducer producer = new ActivemqQueueProducer();
	     ActivemqQueueConsumer consumer = new ActivemqQueueConsumer("1");
	     ActivemqQueueConsumerAsyn consumer1 = new ActivemqQueueConsumerAsyn("2");
	         producer.initialize();


	         Thread.sleep(500);   
	         for(int i=0;i<5;i++)
	         {
	             producer.sendText("Hello, world!"+i); 
	         }

	         //producer.submit();//�������������ʹ��
	        // producer.close();
	         System.out.println("consumer1��ʼ����");
	         //consumer.recive();
	         //consumer.close();
	         System.out.println("consumer1������ϣ�");


	         for(int i=0;i<10;i++)
	         {
	             producer.sendText("Hello, world!"+i); 
	         }
	         //producer.submit();//�������������ʹ��
	         System.out.println("consumer2��ʼ����");
	         consumer1.recive();
	         System.out.println("consumer2������ϣ�");

	     }
}
