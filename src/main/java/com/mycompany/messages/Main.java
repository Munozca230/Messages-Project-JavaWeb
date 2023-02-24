
package com.mycompany.messages;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        ConnectionSql.getConnection();
//        System.out.println("Succesful connection");
        
        MessageDao messageDao = new MessageDao();
        
//        Message msm = new Message("I'm doing some tests here", "The Coder");
//        int entry = messageDao.insert(msm);
//        System.out.println("Inserted "+entry+" message");
        
//        Message msm = new Message(1,"Hi from Java Main, I'm editing the first message!", "The Coder");
//        int entry = messageDao.update(msm);
//        System.out.println("Edited "+entry+" message");

//        for (int i = 3; i < 13; i++) {         
//            Message msm = new Message(i);
//            int entry = messageDao.delete(msm);
//            System.out.println("Deleted "+entry+" message");
//        }
        
        List<Message> messages = messageDao.select();       
        
        for (Message message : messages) {
            System.out.println(message);
        }

        
        

            
        
        
    }
}
