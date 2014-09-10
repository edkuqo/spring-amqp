=============
=spring-amqp=
=============

A Simple Pub/Sub Spring AMQP project

Tools:

Java 7,
Spring 4.x,
Embeded Spring AMQP,
Maven 3.x,
Jstl,
Tomcat 7.x,
Bootstrap 3.2.x

******************************

Run: mvn clean package and copy the war to the Tomcat /webapp directory

******************************

1) you can add a message
2) you can delete a message
3) you can reset the list that is holding the messages (Used for simulating a persistence mechanism)

******************************

A little background about this simple project. A Message is submitted, which then is published to the Topic. A Topic Listener receives the message and pushes the received message into a Queue. There are two Queue listeners with a Thread.Sleep(5000) to simulate a blocking call. 

Example:

If you send more than one message within 5 seconds, first message will be randomly picked up by the one of the two queue listeners and the listener that is first receiving the message is slept for 5 seconds, the second listerner will pull the second message. If more than 2 messages are sent, the queue listeners will pop the messages once they have completed their execution.

******************************
TODO:: I still have to write the Unit Tests!
******************************

WARNING!!!

This is a draft project, anyone is more than welcome to checkout the code, improve it or use it at their own risk.

Thank you, and hope it helps someone.
