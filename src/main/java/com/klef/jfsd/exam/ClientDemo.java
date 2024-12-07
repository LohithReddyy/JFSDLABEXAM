package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        // Inserting a Device record
        Device device = new Device();
        device.setBrand("Samsung");
        device.setModel("BasicModel");
        device.setPrice(20000);
        session.save(device);

        // Inserting a Smartphone record
        SmartPhone smartphone = new SmartPhone();
        smartphone.setBrand("Apple");
        smartphone.setModel("iPhone 14");
        smartphone.setPrice(120000);
        smartphone.setOperatingSystem("iOS");
        smartphone.setCameraResolution("48 MP");
        session.save(smartphone);

        // Inserting a Tablet record
        Tablet tablet = new Tablet();
        tablet.setBrand("Lenovo");
        tablet.setModel("YogaTab");
        tablet.setPrice(30000);
        tablet.setScreenSize("10 inches");
        tablet.setBatteryLife("12 hours");
        session.save(tablet);

        transaction.commit();
        session.close();
        sessionFactory.close();

        System.out.println("Records inserted successfully!");
    }
}
