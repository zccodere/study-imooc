module com.myimooc.sms.runtime {
    requires com.myimooc.sms.service;
    requires com.myimooc.sms.filestore;

    uses com.myimooc.sms.service.StudentService;

}