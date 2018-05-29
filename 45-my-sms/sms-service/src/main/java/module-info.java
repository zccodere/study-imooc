module com.myimooc.sms.service {
    exports com.myimooc.sms.service;
    exports com.myimooc.sms.service.impl;
    requires com.myimooc.sms.model;
    requires com.myimooc.sms.persistence;
    uses com.myimooc.sms.persistence.PersistenceService;
    provides com.myimooc.sms.service.StudentService with com.myimooc.sms.service.impl.StudentServiceImpl;
}
