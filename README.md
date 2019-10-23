# Distributed-Application-Practical-Work- 💻 📡

This Repository is a practical work which show us how to use two concepts using in the distributed applications.

❗️ PS: the programs are executed on the cmd .

## Sockets 🔌

In this part we have two scenarios to realize:

   ✅ Send an integer 🔢
   
   ✅ Send a string 🔠
   
In both of the mentionned scenarios we did the same steps with a small modification, which is: 

  * Changing the value of the variable "scenarion" in classes "*Client.java*" & "*Server.java*" , which takes 1 if we want to execute the string scenarion , else in case of integer scenario.  
  
## RMI 🔍

In order to send a string from two devices using RMI java class, we followed the steps bellow:

 1. Create an interface named "RmiRemoteServiceInterface" of remote object which contains the needed methods (*in our case the method "sendedMsg"*).
 
 2. Create a class named "ImplementationRmiRemoteService" as an implementation of the interface and extends "UnicastRemoteObject" class, and *Override sendedMsg* method.
 
 3. Create the class *Server.java* , where we associate the local object with a synonyme in the RMI Register via a service name (in our case "TestRMI") by using *Naming.rebind* method.
 
 4. Create the class *Client.java* , and use the method lookup() which allow us to have a reference of a remote object.
 
### Execution 🔧💯

Lunch three cmd: 

1. First one for *rmiregistry*.
2. Second one for *Server*.
3. Third one for *Client*.
 
 
 
 
