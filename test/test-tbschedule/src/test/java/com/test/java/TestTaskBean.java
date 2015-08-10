//package com.test.java;
//
//public class TestTaskBean implements IScheduleTaskDealSingle<PassportModel> {
//    /**
//     * 选择任务. 从DB中读取数据, 将取出的数据返回
//     * @param taskParameter
//     * @param ownSign
//     * @param taskItemNum
//     * @param taskItemList
//     * @param eachFetchDataNum
//     * @return
//     * @throws Exception
//     */
//    public List<PassportModel> selectTasks(String taskParameter, String ownSign,
//                                         int taskItemNum, List<TaskItemDefine> taskItemList,
//                                         int eachFetchDataNum) throws Exception {
//
//        List<PassportModel> list = new ArrayList<PassportModel>(1);
//        list.add(new PassportModel());
//        return list;
//    }
//
//    /**
//     * 向目标表中插入数据
//     * @param model
//     * @param ownSign
//     * @return
//     * @throws Exception
//     */
//    public boolean execute(PassportModel model, String ownSign)
//            throws Exception {
//        try {
//            //insertData(model);
//            System.out.println("执行任务");
//
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//    public static void main(String[] args) {
//    	ApplicationContext ctx = new ClassPathXmlApplicationContext(
//                "spring-config.xml");
//
//        TBScheduleManagerFactory scheduleManagerFactory = new TBScheduleManagerFactory();
//
//        Properties p = new Properties();
//        p.put("zkConnectString", "192.168.3.117:2181");
//        p.put("rootPath", "/home/platform/data");
//        p.put("zkSessionTimeout", "60000");
//        p.put("userName", "ScheduleAdmin");
//        p.put("password", "password");
//        p.put("isCheckParentPath", "true");
//        scheduleManagerFactory.setApplicationContext(ctx);
//        scheduleManagerFactory.init(p);
//        scheduleManagerFactory.setZkConfig(convert(p));
//	}
//}