module com.myimooc.java.sms.service {
    exports com.myimooc.java.sms.service;
    exports com.myimooc.java.sms.service.impl;
    requires com.myimooc.java.sms.model;
    requires com.myimooc.java.sms.persistence;
    uses com.myimooc.java.sms.persistence.PersistenceService;
    provides com.myimooc.java.sms.service.StudentService with com.myimooc.java.sms.service.impl.StudentServiceImpl;
}
