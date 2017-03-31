package com.shli.jms.pub;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class PubSend {
	public static void main(String[] args) throws JMSException {
		 //�������ӹ���  
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");  
        //��������  
        Connection connection = connectionFactory.createConnection();
        connection.start();  
         //����һ���Ự  
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE); 
        //���������� ������Ϣ����  
        MessageProducer producer = session.createProducer(null);
        Destination destination = session.createTopic("JOB01");
        MapMessage message = session.createMapMessage();  
        message.setString("name", "shli");  
        message.setDouble("price", 1.00);  
        message.setBoolean("up", true);  
        producer.send(destination, message); 
        producer.close();
        session.close();
        connection.close();
	}
}
