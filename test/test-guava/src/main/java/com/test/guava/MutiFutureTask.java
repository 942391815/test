//package com.test.guava;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.Callable;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.Executors;
//
//import org.apache.commons.collections.CollectionUtils;
//import com.google.common.util.concurrent.FutureCallback;
//import com.google.common.util.concurrent.Futures;
//import com.google.common.util.concurrent.ListenableFuture;
//import com.google.common.util.concurrent.ListeningExecutorService;
//import com.google.common.util.concurrent.MoreExecutors;
//
///**
// * @param <T>
// * @param <V>
// * @author liqqc
// */
//public class MutiFutureTask<T, V> {
//    private static final int PoolSize = 20;
//
//    //带有回调机制的线程池
//    private static final ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(PoolSize));
//
//    public static <T, V> List<V> batchExec(List<T> params, BatchFuture<T, V> batchFuture) {
//        if (CollectionUtils.isEmpty(params)) {
//            return null;
//        }
//        final List<V> value = new ArrayList<V>();
//        try {
//            List<ListenableFuture<V>> futures = new ArrayList<ListenableFuture<V>>();
//            for (T t : params) {
//                //将实现了Callable的任务提交到线程池中，得到一个带有回调机制的ListenableFuture实例
//                ListenableFuture<V> sfuture = service.submit(new SingleTask<T, V>(t, batchFuture));
//                Futures.addCallback(sfuture, new FutureCallback<V>() {
//                    @Override
//                    public void onSuccess(V result) {
//                        value.add(result);
//                    }
//
//                    @Override
//                    public void onFailure(Throwable t) {
//                        throw new RuntimeException(t);
//                    }
//                });
//                futures.add(sfuture);
//            }
//            ListenableFuture<List<V>> allAsList = Futures.allAsList(futures);
//            allAsList.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//
//        return value;
//    }
//
//    /**
//     * 业务实现类
//     *
//     * @param <T>
//     * @param <V>
//     */
//
//    private static class SingleTask<T, V> implements Callable<V> {
//        private T param;
//        private BatchFuture<T, V> batchFuture;
//
//        public SingleTask(T param, BatchFuture<T, V> batchFuture) {
//            this.param = param;
//            this.batchFuture = batchFuture;
//        }
//
//        @Override
//        public V call() throws Exception {
//            return batchFuture.callback(param);
//        }
//    }
//
//    public interface BatchFuture<T, V> {
//        V callback(T param);
//    }
//}
//
//class MutiFutureTaskTest {
//
//    private static final Map<Integer, Person> persons = new HashMap<Integer, Person>();
//
//    static {
//        persons.put(1, new Person(1, "test1", 1, "aaa", 8888888888l));
//        persons.put(2, new Person(2, "test2", 2, "bbb", 8888888888l));
//        persons.put(3, new Person(3, "test3", 3, "ccc", 8888888888l));
//        persons.put(4, new Person(4, "test4", 4, "ddd", 8888888888l));
//        persons.put(5, new Person(5, "test5", 5, "eee", 8888888888l));
//    }
//
//    public static void main(String[] args) {
//        List<Integer> param = new ArrayList<Integer>();
//        param.add(1);
//        param.add(2);
//        param.add(3);
//        param.add(4);
//        param.add(5);
//        List<Person> result = MutiFutureTask.batchExec(param, new MutiFutureTask.BatchFuture<Integer, Person>() {
//            @Override
//            public Person callback(Integer param) {
//                return persons.get(param);
//            }
//        });
//        System.out.println(result.size());
//    }
//}
//
////数据库中的实体bean
//class Person {
//    private int id;
//    private String name;
//    private int age;
//    private String address;
//    private long telephone;
//
//
//    public Person() {
//    }
//
//    public Person(int id, String name, int age, String address, long tel) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//        this.address = address;
//        this.telephone = tel;
//    }
//
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public long getTelephone() {
//        return telephone;
//    }
//
//    public void setTelephone(long telephone) {
//        this.telephone = telephone;
//    }
//}