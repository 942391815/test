package com.test.java.test;

import java.math.BigDecimal;

/**
 * Created by qiaogu on 2017/11/11.
 */
public class TestSize {
    public static void main(String[] args) {
        StringBuilder content = new StringBuilder("[2017-11-11 21:59:33,455][INFO ][index.indexing.slowlog.index] [d_172.28.140.153:30000] [dms_package_site][12] took[652.5ms], took_millis[652], type[dms_package_site], id[VC37805445576-1-1-|56880], routing[], source[{\"waybill_code\":\"VC37805445576\",\"dms_site_id\":56880,\"package_barcode\":\"VC37805445576-1-1-\",\"is_main_package\":1,\"inpect_time\":1510407179000,\"inspect_user_id\":20111144,\"dms_site_type\":64,\"dms_site_subtype\":64,\"dms_org_id\":10,\"waybill_flag\":1,\"send_user_id\":127139,\"send_canceled\":0,\"send_package_num\":1,\"site_third_type\":2,\"sendd_status\":0,\"send_dest_site_id\":74123,\"send_time\":1510409166000,\"send_code\":\"56880-74123-20171111204500182\",\"send_dest_site_subtype\":64,\"send_dest_org_id\":10,\"send_box_code\":\"BC595F002898F00200157087\",\"send_dest_site_type\":64,\"sorting_time\":1510407354000,\"sorting_dest_site_id\":231305,\"sorting_dest_site_type\":64,\"sorting_dest_org_id\":10,\"sorting_user_id\":127139,\"sorting_dest_site_subtype\":64,\"waybill_type\":\"10000\"}]\n" +
                "[2017-11-11 21:59:33,511][INFO ][index.indexing.slowlog.index] [d_172.28.140.153:30000] [dms_package_site][12] took[546.4ms], took_millis[546], type[dms_package_site], id[VC37497504726-1-1-|2531], routing[], source[{\"is_main_package\":1,\"sorting_name\":\"苏州接货仓\",\"pack_time\":1510407878000,\"package_barcode\":\"VC37497504726-1-1-\",\"store_id\":41,\"cky2\":3,\"store_org_id\":3,\"dms_site_id\":2531,\"dms_site_type\":64,\"dms_org_id\":3,\"sorting_time\":1510409169000,\"waybill_flag\":1,\"waybill_code\":\"VC37497504726\",\"sorting_dest_site_id\":598440,\"sorting_dest_site_type\":64,\"sorting_dest_org_id\":3,\"sorting_user_id\":142992,\"sorting_dest_site_subtype\":64,\"waybill_type\":\"10000\",\"dms_site_subtype\":64,\"send_user_id\":142992,\"send_canceled\":0,\"send_package_num\":1,\"site_third_type\":4,\"sendd_status\":0,\"send_dest_site_id\":598440,\"send_time\":1510409199000,\"send_code\":\"2531-598440-20171106075804882\",\"send_dest_site_subtype\":64,\"send_dest_org_id\":3,\"send_box_code\":\"VC37497504726-1-1-\",\"send_dest_site_type\":64}]");
        System.out.println(bytes2kb((long) content.length()));
    }

    public static String bytes2kb(long bytes) {
        BigDecimal filesize = new BigDecimal(bytes);
        BigDecimal megabyte = new BigDecimal(1024 * 1024);
        float returnValue = filesize.divide(megabyte, 5, BigDecimal.ROUND_UP)
                .floatValue();
        return (returnValue + "MB");
    }
}
