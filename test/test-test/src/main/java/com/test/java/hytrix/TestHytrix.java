package com.test.java.hytrix;

import com.alibaba.dubbo.common.json.JSONObject;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import com.test.java.encode.User;
import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;
import rx.Observable;
import rx.Subscriber;
import rx.internal.util.InternalObservableUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created by Micheal on 2019/4/17.
 */
public class TestHytrix extends HystrixObservableCommand {

    //    private RestTemplate restTemplate;
    private Long id;

    public TestHytrix(Long id) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.id = id;
        System.out.println("执行构造方法");
    }

    @Override
    protected Observable<User> construct() {
        System.out.println("执行 construct 方法");
        return Observable.create(new Observable.OnSubscribe<User>() {

            @Override
            public void call(Subscriber<? super User> observer) {

                try {
                    System.out.println("测试开始");
                    if (!observer.isUnsubscribed()) {
                        System.out.println("确认订阅");
                        //User user = restTemplate.getForObject("http://hello-service/users/{1}", User.class,id);
                        User user = new User();
//                        user.setId(1L);
                        user.setName("lixia");
                        observer.onNext(user);

                        User user2 = new User();
//                        user2.setId(2L);
                        user2.setName("caocao");
                        observer.onNext(user2);
                        observer.onCompleted();
                    }
                } catch (Exception e) {
                    observer.onError(e);
                }
            }
        });

    }


    public static void main(String[] args) {
        TestHytrix userObservableCommand = new TestHytrix(1L);
        Observable<User> user = userObservableCommand.construct();

	    /*在下面的 Lambda 表达式中自动设置参数 user2 设置为 USER类型，因为 subscribe 方法提取的是Observable<User>
         * 的元素，所以参数 user2 的类型为 USER。
	     *
	     * */
        user.subscribe(user2 -> {
            System.out.println("名字:" + user2.getName());
//            System.out.println("ID:" + user2.getId());
        });
    }
}
