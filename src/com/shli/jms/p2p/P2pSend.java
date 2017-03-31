package com.shli.jms.p2p;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class P2pSend {
	public static void main(String[] args) throws JMSException, InterruptedException {
		 //�������ӹ���  
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");  
        //��������  
        Connection connection = connectionFactory.createConnection();
        connection.start();  
         //����һ���Ự  
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE); 
        //���������� ������Ϣ����  
        MessageProducer producer = session.createProducer(null);
        Destination destination = session.createQueue("JOBS.1");  
        Message message = session.createObjectMessage(123);  
        System.out.println("Sending: id: " + ((ObjectMessage)message).getObject() + " on queue: " + destination);  
        producer.send(destination, message);
        
        producer.close();
        session.close();
        connection.close();
	}
}
