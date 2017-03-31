package com.shli.jms.p2p;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class P2pReceiver {
	public static void main(String[] args) throws JMSException, InterruptedException {
		 //�������ӹ���  
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");  
        //��������  
        Connection connection = connectionFactory.createConnection();
        connection.start();  
         //����һ���Ự  
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE); 
        Destination destination = session.createQueue("JOBS.1");  
        MessageConsumer messageConsumer = session.createConsumer(destination); 
        messageConsumer.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message arg0) {
				 try {  
					    Thread.sleep(2000);
			            System.out.println("1" + " id:" + ((ObjectMessage)arg0).getObject());  
			        } catch (Exception e) {  
			            e.printStackTrace();  
			        }  
			}
		});
        //session.close();
        //connection.close();
	}
}
